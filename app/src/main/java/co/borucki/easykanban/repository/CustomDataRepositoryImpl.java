package co.borucki.easykanban.repository;


import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.EasyKanbanSharedPreference;

public class CustomDataRepositoryImpl implements CustomDataRepository {
    private static CustomDataRepositoryImpl mInstance = new CustomDataRepositoryImpl();
    private final EasyKanbanSharedPreference mSharedPref;

    private CustomDataRepositoryImpl() {
        mSharedPref = AndroidApplication.getSharedPreferences();

    }

    public static CustomDataRepositoryImpl getInstance() {
        return mInstance;

    }

    @Override
    public String getLogo() {
        return mSharedPref.getLogo();
    }

    @Override
    public void setLogo(String logo) {
        mSharedPref.setLogo(logo);
    }

    @Override
    public String getIMEI() {
        return mSharedPref.getIMEI();
    }

    @Override
    public void setIMEI(String imei) {
        mSharedPref.setIMEI(imei);
    }

    @Override
    public long getSplashScreenTime() {
        return mSharedPref.getSplashScreenTime();
    }

    @Override
    public void setSplashScreenTime(long seconds) {
        mSharedPref.setSplashScreenTime(seconds);
    }
}
