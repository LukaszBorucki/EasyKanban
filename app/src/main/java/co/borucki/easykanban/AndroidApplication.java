package co.borucki.easykanban;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import co.borucki.easykanban.database.Database;
import co.borucki.easykanban.database.DatabaseOrmImpl;
import co.borucki.easykanban.persistence.EasyKanbanSharedPreference;
import co.borucki.easykanban.persistence.LoginStyleSharedPreference;
import co.borucki.easykanban.persistence.MailStyleSharedPreference;
import co.borucki.easykanban.persistence.MainStyleSharedPreference;
import co.borucki.easykanban.persistence.QrStyleSharedPreference;
import co.borucki.easykanban.persistence.ScannedStyleSharedPreference;
import co.borucki.easykanban.persistence.SingleMailStyleSharedPreference;
import co.borucki.easykanban.persistence.SplashStyleSharedPreference;

public class AndroidApplication extends Application {

    private static EasyKanbanSharedPreference mSharedPreferences;
    private static LoginStyleSharedPreference mLoginStyleSharedPreferences;
    private static SplashStyleSharedPreference mSplashStyleSharedPreferences;
    private static MainStyleSharedPreference mMainStyleSharedPreferences;
    private static MailStyleSharedPreference mMailStyleSharedPreferences;
    private static SingleMailStyleSharedPreference mSingleMailStyleSharedPreferences;
    private static ScannedStyleSharedPreference mScannedStyleSharedPreferences;
    private static QrStyleSharedPreference mQrStyleSharedPreferences;
    private static Database mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = OpenHelperManager.getHelper(this, DatabaseOrmImpl.class);
        mSharedPreferences = new EasyKanbanSharedPreference(this);
        mLoginStyleSharedPreferences = new LoginStyleSharedPreference(this);
        mSplashStyleSharedPreferences = new SplashStyleSharedPreference(this);
        mMainStyleSharedPreferences = new MainStyleSharedPreference(this);
        mMailStyleSharedPreferences = new MailStyleSharedPreference(this);
        mSingleMailStyleSharedPreferences = new SingleMailStyleSharedPreference(this);
        mScannedStyleSharedPreferences = new ScannedStyleSharedPreference(this);
        mQrStyleSharedPreferences = new QrStyleSharedPreference(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public static EasyKanbanSharedPreference getSharedPreferences() {
        return mSharedPreferences;
    }

    public static LoginStyleSharedPreference getLoginStyleSharedPreferences() {
        return mLoginStyleSharedPreferences;
    }

    public static SplashStyleSharedPreference getSplashStyleSharedPreferences() {
        return mSplashStyleSharedPreferences;
    }

    public static Database getDatabase() {
        return mDatabase;
    }

    public static MainStyleSharedPreference getMainStyleSharedPreferences() {
        return mMainStyleSharedPreferences;
    }

    public static ScannedStyleSharedPreference getScannedStyleSharedPreferences() {
        return mScannedStyleSharedPreferences;
    }

    public static MailStyleSharedPreference getMailStyleSharedPreferences() {
        return mMailStyleSharedPreferences;
    }

    public static SingleMailStyleSharedPreference getSingleMailStyleSharedPreferences() {
        return mSingleMailStyleSharedPreferences;
    }

    public static QrStyleSharedPreference getQrStyleSharedPreferences() {
        return mQrStyleSharedPreferences;
    }
}
