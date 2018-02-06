package co.borucki.easykanban.asyncTask;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import co.borucki.easykanban.repository.CustomDataRepository;
import co.borucki.easykanban.repository.CustomDataRepositoryImpl;

public class AppConfigurationConfirmAsyncTask extends AsyncTask<String, Void, Void> {
    private static final CustomDataRepository mCustomRepo = CustomDataRepositoryImpl.getInstance();

    @Override
    protected Void doInBackground(String... params) {
        String link = "http://www.borucki.co/api_v2/kanban/confirmation/?id="
                + mCustomRepo.getIMEI()
                + "&type="
                + params[0].toUpperCase();

        URL url = null;
        try {
            url = new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            connection.disconnect();
        }
        return null;
    }

}
