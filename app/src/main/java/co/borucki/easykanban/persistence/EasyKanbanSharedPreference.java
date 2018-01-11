package co.borucki.easykanban.persistence;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class EasyKanbanSharedPreference {
    private static final String EASY_KANBAN_SHARED_PREFERENCE = "Shared preferences";
    private static final String CUSTOM_LOGO = "Customized logo";
    private static final String DEVICE_IMEI = "IMEI number";
    private static final String CUSTOM_SPLASH_TIME = "Display time of splash activity";
    private final SharedPreferences mSharedPreferences;


    public EasyKanbanSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(EASY_KANBAN_SHARED_PREFERENCE, Context.MODE_PRIVATE);

    }


    public String getLogo() {
        return mSharedPreferences.getString(CUSTOM_LOGO, "");
    }

    public void setLogo(String logo) {
        setSharedPreferencesString(CUSTOM_LOGO, logo);
    }

    public String getIMEI() {
        return mSharedPreferences.getString(DEVICE_IMEI, "");
    }

    public void setIMEI(String imei) {
        setSharedPreferencesString(DEVICE_IMEI, imei);
    }

    private void  setSharedPreferencesString(String key, @NonNull String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public long getSplashScreenTime() {
        return mSharedPreferences.getLong(CUSTOM_SPLASH_TIME, 20);
    }

    public void setSplashScreenTime(long seconds) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(CUSTOM_SPLASH_TIME, seconds);
        editor.apply();
    }
}
