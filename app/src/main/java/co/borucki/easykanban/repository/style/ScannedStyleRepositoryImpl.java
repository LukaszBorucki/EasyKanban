package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.ScannedStyleSharedPreference;

public class ScannedStyleRepositoryImpl implements ScannedStyleRepository {
    private static ScannedStyleRepositoryImpl mInstance = new ScannedStyleRepositoryImpl();
    private final ScannedStyleSharedPreference mSharedPref;

    private ScannedStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getScannedStyleSharedPreferences();
    }

    public static ScannedStyleRepositoryImpl getInstance() {
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
    public String getSingleRowTextColor() {
        return mSharedPref.getSingleRowTextColor();
    }

    @Override
    public void setSingleRowTextColor(String color) {
        mSharedPref.setSingleRowTextColor(color);
    }

    @Override
    public String getSingleRowDelButtonImage() {
        return mSharedPref.getSingleRowDelButtonImage();
    }

    @Override
    public void setSingleRowDelButtonImage(String image) {
        mSharedPref.setSingleRowDelButtonImage(image);
    }

    @Override
    public String getSendButtonColor() {
        return mSharedPref.getSendButtonColor();
    }

    @Override
    public void setSendButtonColor(String color) {
        mSharedPref.setSendButtonColor(color);
    }

    @Override
    public String getSendButtonTextColor() {
        return mSharedPref.getSendButtonTextColor();
    }

    @Override
    public void setSendButtonTextColor(String color) {
        mSharedPref.setSendButtonTextColor(color);
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
    public void setLogoVisible(boolean isVisible) {
        mSharedPref.setLogoVisible(isVisible);
    }

    @Override
    public String getFabTintColor() {
        return mSharedPref.getFabBackgroundColor();
    }

    @Override
    public void setFabTintColor(String color) {
        mSharedPref.setFabBackgroundColor(color);
    }

    @Override
    public String getFabRippleColor() {
        return mSharedPref.getFabRippleColor();
    }

    @Override
    public void setFabRippleColor(String color) {
        mSharedPref.setFabRippleColor(color);
    }

    @Override
    public String getFabLogo() {
        return mSharedPref.getFabLogo();
    }

    @Override
    public void setFabLogo(String logo) {
        mSharedPref.setFabLogo(logo);
    }
}
