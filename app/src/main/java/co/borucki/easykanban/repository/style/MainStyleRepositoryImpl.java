package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.MainStyleSharedPreference;

public class MainStyleRepositoryImpl implements MainStyleRepository {
    private static MainStyleRepositoryImpl mInstance = new MainStyleRepositoryImpl();
    private final MainStyleSharedPreference mSharedPref;

    private MainStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getMainStyleSharedPreferences();
    }

    public static MainStyleRepositoryImpl getInstance() {
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
    public String getLayoutColor() {
        return mSharedPref.getLayoutColor();
    }

    @Override
    public void setLayoutColor(String color) {
        mSharedPref.setLayoutColor(color);
    }

    @Override
    public String getLayoutTextColor() {
        return mSharedPref.getLayoutTextColor();
    }

    @Override
    public void setLayoutTextColor(String color) {
        mSharedPref.setLayoutTextColor(color);
    }

    @Override
    public boolean getLayoutLogoShow() {
        return mSharedPref.getLayoutLogoShow();
    }

    @Override
    public void setLayoutLogoShow(boolean logoShow) {
        mSharedPref.setLayoutLogoShow(logoShow);
    }

    @Override
    public float getLayoutLogoAlpha() {
        return mSharedPref.getLayoutLogoAlpha();
    }

    @Override
    public void setLayoutLogoAlpha(float alpha) {
        mSharedPref.setLayoutLogoAlpha(alpha);
    }

    @Override
    public String getButtonColor() {
        return mSharedPref.getButtonColor();
    }

    @Override
    public void setButtonColor(String color) {
        mSharedPref.setButtonColor(color);
    }

    @Override
    public String getButtonTextColor() {
        return mSharedPref.getButtonTextColor();
    }

    @Override
    public void setButtonTextColor(String color) {
        mSharedPref.setButtonTextColor(color);
    }

    @Override
    public String getBadgeColor() {
        return mSharedPref.getBadgeColor();
    }

    @Override
    public void setBadgeColor(String color) {
        mSharedPref.setBadgeColor(color);
    }

    @Override
    public String getBadgeTextColor() {
        return mSharedPref.getBadgeTextColor();
    }

    @Override
    public void setBadgeTextColor(String color) {
        mSharedPref.setBadgeTextColor(color);
    }

    @Override
    public String getToolBarColor() {
        return mSharedPref.getToolBarColor();
    }

    @Override
    public void setToolBarColor(String color) {
        mSharedPref.setToolBarColor(color);
    }

    @Override
    public String getToolBarTextColor() {
        return mSharedPref.getToolBarTextColor();
    }

    @Override
    public void setToolBarTextColor(String color) {
        mSharedPref.setToolBarTextColor(color);
    }

    @Override
    public String getToolBarIcon() {
        return mSharedPref.getToolBarIcon();
    }

    @Override
    public void setToolBarIcon(String icon) {
        mSharedPref.setToolBarIcon(icon);
    }


}
