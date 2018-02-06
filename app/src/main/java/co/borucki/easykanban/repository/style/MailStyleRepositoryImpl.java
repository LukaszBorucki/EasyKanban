package co.borucki.easykanban.repository.style;


import co.borucki.easykanban.AndroidApplication;
import co.borucki.easykanban.persistence.MailStyleSharedPreference;

public class MailStyleRepositoryImpl implements MailStyleRepository {
    private static MailStyleRepositoryImpl mInstance = new MailStyleRepositoryImpl();
    private final MailStyleSharedPreference mSharedPref;

    private MailStyleRepositoryImpl() {
        mSharedPref = AndroidApplication.getMailStyleSharedPreferences();
    }

    public static MailStyleRepositoryImpl getInstance() {
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
    public String getTextColor() {
        return mSharedPref.getTextColor();
    }

    @Override
    public void setTextColor(String color) {
        mSharedPref.setTextColor(color);
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

    @Override
    public String getSingleRowColor() {
        return mSharedPref.getSingleRowColor();
    }

    @Override
    public void setSingleRowColor(String color) {
        mSharedPref.setSingleRowColor(color);
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
    public String getSingleRowUnreadColor() {
        return mSharedPref.getSingleRowUnreadColor();
    }

    @Override
    public void setSingleRowUnreadColor(String color) {
        mSharedPref.setSingleRowUnreadColor(color);
    }

    @Override
    public String getSingleRowUnreadTextColor() {
        return mSharedPref.getSingleRowUnreadTextColor();
    }

    @Override
    public void setSingleRowUnreadTextColor(String color) {
        mSharedPref.setSingleRowUnreadTextColor(color);
    }
}
