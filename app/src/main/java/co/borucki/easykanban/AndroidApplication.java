package co.borucki.easykanban;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
