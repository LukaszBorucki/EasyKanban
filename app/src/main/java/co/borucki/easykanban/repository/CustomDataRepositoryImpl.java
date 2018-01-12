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

    @Override
    public void setSplashScreenTextVisible(int number) {
        mSharedPref.setSplashScreenTextVisible(number);
    }

    @Override
    public int getSplashScreenTextVisible() {
        return mSharedPref.getSplashScreenTextVisible();
    }

    @Override
    public void setSplashScreenCustomText(String text) {
        mSharedPref.setSplashScreenCustomText(text);
    }

    @Override
    public String getSplashScreenCustomText() {
        return mSharedPref.getSplashScreenCustomText();
    }

    @Override
    public void setSplashScreenThanksText(String text) {
        mSharedPref.setSplashScreenThanksText(text);
    }

    @Override
    public String getSplashScreenThanksText() {
        return mSharedPref.getSplashScreenThanksText();
    }

    @Override
    public void setSplashScreenCustomTextSize(float textSize) {
        mSharedPref.setSplashScreenCustomTextSize(textSize);
    }

    @Override
    public float getSplashScreenCustomTextSize() {
        return mSharedPref.getSplashScreenCustomTextSize();
    }

    @Override
    public void setSplashScreenThanksTextSize(float textSize) {
        mSharedPref.setSplashScreenThanksTextSize(textSize);
    }

    @Override
    public float getSplashScreenThanksTextSize() {
        return mSharedPref.getSplashScreenThanksTextSize();
    }

    @Override
    public void setSplashLayoutColor(String color) {
        mSharedPref.setSplashLayoutColor(color);
    }

    @Override
    public String getSplashLayoutColor() {
        return mSharedPref.getSplashLayoutColor();
    }

    @Override
    public void setSplashTextColor(String textColor) {
        mSharedPref.setSplashTextColor(textColor);
    }

    @Override
    public String getSplashTextColor() {
        return mSharedPref.getSplashTextColor();
    }
}