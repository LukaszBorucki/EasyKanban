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
        return restTemplate.getForObject(link, AppConfigurationDTO.class);
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
            new CustomStyleAsyncTask(true).execute();
        }

        if (configuration.isSendLog()) {
            StringBuilder builder = new StringBuilder();
            builder.append(DateTimeCounter.getDateTime());
            builder.append("\n");
            for (EventLog eventLog : mLogRepo.getAll()) {
                builder.append(eventLog.toString());
                builder.append("\n");
            }
            String[] recipients = mCustomRepo.getMailTo().split(";");
            SendEmailAsyncTask email = new SendEmailAsyncTask();
            email.m = new Mail(mCustomRepo.getMailAddress(), mCustomRepo.getMailPassword());
            email.m.set_from(mCustomRepo.getMailAddress());
            email.m.setBody(builder.toString());
            email.m.set_to(recipients);
            email.m.set_host(mCustomRepo.getMailHost());
            email.m.set_port(String.valueOf(mCustomRepo.getMailSMTPPort()));
            email.m.set_sport(String.valueOf(mCustomRepo.getMailSMTPPort()));
            email.m.set_subject("Log from device >>"+mCustomRepo.getIMEI()+"<< Used by: >>"+mCustomRepo.getCustomerName()+"<<");
            email.execute();
            mLogRepo.removeAll();
            new AppConfigurationConfirmAsyncTask().execute("send_all");
        }
    }
}
