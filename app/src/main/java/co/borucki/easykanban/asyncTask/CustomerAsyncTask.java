package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.borucki.easykanban.dto.CustomerDTO;
import co.borucki.easykanban.dto.mapper.Mapper;
import co.borucki.easykanban.model.Customer;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;

public class CustomerAsyncTask extends AsyncTask<Void, Void, CustomerDTO> {
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();

    @Override
    protected CustomerDTO doInBackground(Void... voids) {

        String link = "http://www.borucki.co/api_v2/kanban/getCustomerData?id="
                + mCustomRepo.getIMEI();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        return restTemplate.getForObject(link, CustomerDTO.class);
    }

    @Override
    protected void onPostExecute(CustomerDTO customerDTO) {
        Customer customer = Mapper.fromCustomerDTOToCustomer(customerDTO);
        mCustomRepo.setCustomerName(customer.getName());
        mCustomRepo.setMailAddress(customer.getMailAddress());
        mCustomRepo.setMailPassword(customer.getMailPassword());
        mCustomRepo.setMailHost(customer.getMailHost());
        mCustomRepo.setMailSMTPPort(customer.getMailSMTPPort());
        mCustomRepo.setMailTo(customer.getMailTo());
    }
}
