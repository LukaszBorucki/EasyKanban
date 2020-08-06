package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import co.borucki.easykanban.Mail;
import co.borucki.easykanban.dto.AppConfigurationDTO;
import co.borucki.easykanban.dto.mapper.Mapper;
import co.borucki.easykanban.model.AppConfiguration;
import co.borucki.easykanban.model.EventLog;
import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;
import co.borucki.easykanban.repository.EventLogRepository;
import co.borucki.easykanban.repository.EventLogRepositoryImpl;
import co.borucki.easykanban.statics.DateTimeCounter;
import co.borucki.easykanban.statics.RemoveAllData;

public class AppConfigurationAsyncTask extends AsyncTask<Void, Void, AppConfigurationDTO> {
    private final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();
    private final EventLogRepository mLogRepo = EventLogRepositoryImpl.getInstance();

    @Override
    protected AppConfigurationDTO doInBackground(Void... voids) {

        String link = "http://www.borucki.co/api_v2/kanban/getConfiguration?id="
                + mCustomRepo.getIMEI();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        AppConfigurationDTO appConfigurationDTO = new AppConfigurationDTO();
        appConfigurationDTO.setCommercialLicence(1);
        appConfigurationDTO.setRefreshProducts(1);
        appConfigurationDTO.setRefreshUsers(0);
        appConfigurationDTO.setRefreshStyle(0);
        appConfigurationDTO.setDelAllData(0);
        appConfigurationDTO.setCodeType(0);
        appConfigurationDTO.setSendLog(1);
        return appConfigurationDTO;
//        return restTemplate.getForObject(link, AppConfigurationDTO.class);
    }

    @Override
    protected void onPostExecute(AppConfigurationDTO configurationDTO) {
        AppConfiguration configuration = Mapper.fromAppConfigurationDTOToAppConfiguration(configurationDTO);
        if (mCustomRepo.isCommercialLicence() != configuration.isCommercialLicence()) {
            RemoveAllData.removeAll();
            mCustomRepo.setCommercialLicence(configuration.isCommercialLicence());
            new CustomerAsyncTask().execute();
            new CustomStyleAsyncTask(false).execute();
            new ProductAsyncTask(false).execute();
            new UserAsyncTask(false, null, null, null).execute();
        }
        mCustomRepo.setCodeType(configuration.getCodeType());

        if (configuration.isDelAllData()) {
            RemoveAllData.removeAll();
            new AppConfigurationConfirmAsyncTask().execute("Dell_all");
        }

        if (configuration.isRefreshProducts()) {
            new ProductAsyncTask(true).execute();
        }

        if (configuration.isRefreshUsers()) {
            new UserAsyncTask(true, null, null, null).execute();
        }

        if (configuration.isRefreshStyle()) {
            new CustomerAsyncTask().execute();
            new CustomStyleAsyncTask(true).execute();
        }

        if (configuration.isSendLog()) {
            mCustomRepo.setSendLog(true);
        }
    }
}
