package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.LoginStyleSharedPreference;

public class LoginStyleRepositoryImpl implements LoginStyleRepository {
    private static LoginStyleRepositoryImpl mInstance = new LoginStyleRepositoryImpl();
    private final LoginStyleSharedPreference mSharedPref;

    private LoginStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getLoginStyleSharedPreferences();

    }

    public static LoginStyleRepositoryImpl getInstance() {
        return mInstance;

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
    public void setToolBarColor(String color) {
        mSharedPref.setToolBarColor(color);
    }

    @Override
    public String getToolBarColor() {
        return mSharedPref.getToolBarColor();
    }

    @Override
    public void setToolBarTextColor(String color) {
        mSharedPref.setToolBarTextColor(color);
    }

    @Override
    public String getToolBarTextColor() {
        return mSharedPref.getToolBarTextColor();
    }

    @Override
    public void setStatusBarColor(String color) {
        mSharedPref.setStatusBarColor(color);
    }

    @Override
    public String getStatusBarColor() {
        return mSharedPref.getStatusBarColor();
    }

    @Override
    public void setToolBarIcon(String icon) {
        mSharedPref.setToolBarIcon(icon);
    }

    @Override
    public String getToolBarIcon() {
        return mSharedPref.getToolBarIcon();
    }
}
