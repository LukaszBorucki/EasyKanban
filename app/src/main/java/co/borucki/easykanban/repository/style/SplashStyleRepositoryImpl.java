package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.SplashStyleSharedPreference;

public class SplashStyleRepositoryImpl implements SplashStyleRepository {
    private static SplashStyleRepositoryImpl mInstance = new SplashStyleRepositoryImpl();
    private final SplashStyleSharedPreference mSharedPref;

    private SplashStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getSplashStyleSharedPreferences();
    }

    public static SplashStyleRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public long getScreenTime() {
        return mSharedPref.getScreenTime();
    }

    @Override
    public void setScreenTime(long seconds) {
        mSharedPref.setScreenTime(seconds);
    }

    @Override
    public void setScreenTextVisible(int number) {
        mSharedPref.setScreenTextVisible(number);
    }

    @Override
    public int getScreenTextVisible() {
        return mSharedPref.getScreenTextVisible();
    }

    @Override
    public void setScreenCustomText(String text) {
        mSharedPref.setScreenCustomText(text);
    }

    @Override
    public String getScreenCustomText() {
        return mSharedPref.getScreenCustomText();
    }

    @Override
    public void setScreenThanksText(String text) {
        mSharedPref.setScreenThanksText(text);
    }

    @Override
    public String getScreenThanksText() {
        return mSharedPref.getScreenThanksText();
    }

    @Override
    public void setScreenCustomTextSize(float textSize) {
        mSharedPref.setScreenCustomTextSize(textSize);
    }

    @Override
    public float getScreenCustomTextSize() {
        return mSharedPref.getScreenCustomTextSize();
    }

    @Override
    public void setScreenThanksTextSize(float textSize) {
        mSharedPref.setScreenThanksTextSize(textSize);
    }

    @Override
    public float getScreenThanksTextSize() {
        return mSharedPref.getScreenThanksTextSize();
    }

    @Override
    public void setLayoutColor(String color) {
        mSharedPref.setLayoutColor(color);
    }

    @Override
    public String getLayoutColor() {
        return mSharedPref.getLayoutColor();
    }

    @Override
    public void setTextColor(String textColor) {
        mSharedPref.setTextColor(textColor);
    }

    @Override
    public String getTextColor() {
        return mSharedPref.getTextColor();
    }

    @Override
    public String getStatusBarColor() {
        return mSharedPref.getStatusBarColor();
    }

    @Override
    public void setStatusBarColor(String color) {
        mSharedPref.setStatusBarColor(color);
    }
}
