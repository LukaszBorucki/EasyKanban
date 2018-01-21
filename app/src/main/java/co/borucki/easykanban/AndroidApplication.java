package co.borucki.easykanban;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.database.DatabaseOrmImpl;
import co.borucki.easykanban.persistence.EasyKanbanSharedPreference;

public class AndroidApplication extends Application {

    private static EasyKanbanSharedPreference mSharedPreferences;
    private static Database mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = new EasyKanbanSharedPreference(this);
        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static EasyKanbanSharedPreference getSharedPreferences() {
        return mSharedPreferences;
    }

    public static Database getDatabase() {
        return mDatabase;
    }
}
