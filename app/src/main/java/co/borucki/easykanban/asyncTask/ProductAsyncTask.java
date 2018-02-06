package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import co.borucki.easykanban.dto.ProductDTO;
import co.borucki.easykanban.dto.mapper.Mapper;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.ProductRepository;
import co.borucki.easykanban.repository.ProductRepositoryImpl;

public class ProductAsyncTask extends AsyncTask<Void, Void, List<ProductDTO>> {
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private final ProductRepository mProductRepo = ProductRepositoryImpl.getInstance();
    private boolean background;

    public ProductAsyncTask(boolean background) {
        this.background = background;
    }

    @Override
    protected List<ProductDTO> doInBackground(Void... voids) {
        String id = mCustomRepo.isCommercialLicence() ? String.valueOf(mCustomRepo.getIMEI()) : "demo";
        String link = "http://www.borucki.co/api_v2/kanban/getAllProducts?id=" + id;

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return Arrays.asList(restTemplate.getForObject(link, ProductDTO[].class));
    }

    @Override
    protected void onPostExecute(List<ProductDTO> productDTOS) {
        mProductRepo.saveProduct(Mapper.fromProductDTOToProduct(productDTOS));
        if (background) {
            new AppConfigurationConfirmAsyncTask().execute("products");
        }
    }
}
