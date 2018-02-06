package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.SingleMailStyleSharedPreference;

public class SingleMailStyleRepositoryImpl implements SingleMailStyleRepository {
    private static SingleMailStyleRepositoryImpl mInstance = new SingleMailStyleRepositoryImpl();
    private final SingleMailStyleSharedPreference mSharedPref;

    private SingleMailStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getSingleMailStyleSharedPreferences();
    }

    public static SingleMailStyleRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public String getStatusBarColor() {
        return mSharedPref.getStatusBarColor();
    }

    @Override
    public void setStatusBarColor(String color) {
        mSharedPref.setStatusBarColor(color);
    }

    @Override
    public String getBackgroundColor() {
        return mSharedPref.getBackgroundColor();
    }

    @Override
    public void setBackgroundColor(String color) {
        mSharedPref.setBackgroundColor(color);
    }

    @Override
    public String getBackgroundTextColor() {
        return mSharedPref.getBackgroundTextColor();
    }

    @Override
    public void setBackgroundTextColor(String color) {
        mSharedPref.setBackgroundTextColor(color);
    }

    @Override
    public String getDelButtonColor() {
        return mSharedPref.getDelButtonColor();
    }

    @Override
    public void setDelButtonColor(String color) {
        mSharedPref.setDelButtonColor(color);
    }

    @Override
    public String getDelButtonTextColor() {
        return mSharedPref.getDelButtonTextColor();
    }

    @Override
    public void setDelButtonTextColor(String color) {
        mSharedPref.setDelButtonTextColor(color);
    }

    @Override
    public float getLogoAlpha() {
        return mSharedPref.getLogoAlpha();
    }

    @Override
    public void setLogoAlpha(float alpha) {
        mSharedPref.setLogoAlpha(alpha);
    }

    @Override
    public boolean isLogoVisible() {
        return mSharedPref.isLogoVisible();
    }

    @Override
    public void setLogoVisible(boolean visible) {
        mSharedPref.setLogoVisible(visible);
    }
}
