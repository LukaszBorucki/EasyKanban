package co.borucki.easykanban.repository.style;

import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.QrStyleSharedPreference;

public class QrStyleRepositoryImpl implements QrStyleRepository {
    private static QrStyleRepositoryImpl mInstance = new QrStyleRepositoryImpl();
    private final QrStyleSharedPreference mSharedPref;

    private QrStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getQrStyleSharedPreferences();
    }

    public static QrStyleRepositoryImpl getInstance() {
        return mInstance;
    }

    @Override
    public String getStatusBarColor() {
        return mSharedPref.getStatusBarColor();
    }

    @Override
    public void setStatusBarColor(String color) {
        mSharedPref.setQrStatusBarColor(color);
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
