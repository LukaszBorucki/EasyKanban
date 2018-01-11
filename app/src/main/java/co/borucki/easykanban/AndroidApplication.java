package co.borucki.easykanban;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import co.borucki.easykanban.persistence.EasyKanbanSharedPreference;

public class AndroidApplication extends Application {

    //    private Database mDatabase;
    private static EasyKanbanSharedPreference mSharedPreferences;
//    private static Database mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mSharedPreferences = new EasyKanbanSharedPreference(this);
//        mDatabase = new DatabaseCache();
//        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static EasyKanbanSharedPreference getSharedPreferences() {
        return mSharedPreferences;
    }

//    public static Database getDatabase() {
//        return mDatabase;
//
//    }
}
