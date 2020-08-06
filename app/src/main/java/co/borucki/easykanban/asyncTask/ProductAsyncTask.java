package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
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
//        return Arrays.asList(restTemplate.getForObject(link, ProductDTO[].class));
        return getProducts();
    }

    private List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId("100 1216_100");// 110 1216_500
        productDTO.setDescription("Push-in M16x1,5 / fi 12x9");
        productDTO.setRackNo(1);
        productDTO.setRackShelfNo(2);
        productDTO.setRackShelfRowNo(3);
        productDTO.setPhoto("");
        productDTO.setProducer("Camozzi");
        productDTO.setUnit("szt");
        productDTOList.add(productDTO);

        ProductDTO productDTO1 = new ProductDTO();
        productDTO1.setProductId("110 1216_100");// 110 1216_500
        productDTO1.setDescription("elbow fi12x9 / M16x1,5 box 100 pcs");
        productDTO1.setRackNo(1);
        productDTO1.setRackShelfNo(2);
        productDTO1.setRackShelfRowNo(2);
        productDTO1.setPhoto("");
        productDTO1.setProducer("Camozzi");
        productDTO1.setUnit("pcs");
        productDTOList.add(productDTO1);
        ProductDTO productDTO2 = new ProductDTO();
        productDTO2.setProductId("110 1216_500");//
        productDTO2.setDescription("elbow fi12x9 / M16x1,5 box 500 pcs");
        productDTO2.setRackNo(1);
        productDTO2.setRackShelfNo(2);
        productDTO2.setRackShelfRowNo(1);
        productDTO2.setPhoto("");
        productDTO2.setProducer("Camozzi");
        productDTO2.setUnit("pcs");
        productDTOList.add(productDTO2);


        return productDTOList;
    }

    @Override
    protected void onPostExecute(List<ProductDTO> productDTOS) {
        mProductRepo.saveProduct(Mapper.fromProductDTOToProduct(productDTOS));
        if (background) {
            new AppConfigurationConfirmAsyncTask().execute("products");
        }
    }
}
