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

    @Override
    public void setLoginLayoutColor(String color) {
        mSharedPref.setLoginLayoutColor(color);
    }

    @Override
    public String getLoginLayoutColor() {
        return mSharedPref.getLoginLayoutColor();
    }

    @Override
    public void setLoginTextColor(String textColor) {
        mSharedPref.setLoginTextColor(textColor);
    }

    @Override
    public String getLoginTextColor() {
        return mSharedPref.getLoginTextColor();
    }

    @Override
    public void setLoginToolBarColor(String color) {
        mSharedPref.setLoginToolBarColor(color);
    }

    @Override
    public String getLoginToolBarColor() {
        return mSharedPref.getLoginToolBarColor();
    }

    @Override
    public void setLoginToolBarTextColor(String color) {
        mSharedPref.setLoginToolBarTextColor(color);
    }

    @Override
    public String getLoginToolBarTextColor() {
        return mSharedPref.getLoginToolBarTextColor();
    }

    @Override
    public void setLoginStatusBarColor(String color) {
        mSharedPref.setLoginStatusBarColor(color);
    }

    @Override
    public String getLoginStatusBarColor() {
        return mSharedPref.getLoginStatusBarColor();
    }

    @Override
    public void setLoginToolBarIcon(String icon) {
        mSharedPref.setLoginToolBarIcon(icon);
    }

    @Override
    public String getLoginToolBarIcon() {
        return mSharedPref.getLoginToolBarIcon();
    }

    @Override
    public void setCustomerName(String name) {
        mSharedPref.setCustomerName(name);
    }

    @Override
    public String getCustomerName() {
        return mSharedPref.getCustomerName();
    }

    @Override
    public void setMailAddress(String mailAddress) {
        mSharedPref.setMailAddress(mailAddress);
    }

    @Override
    public String getMailAddress() {
        return mSharedPref.getMailAddress();
    }

    @Override
    public void setMailPassword(String mailPassword) {
        mSharedPref.setMailPassword(mailPassword);
    }

    @Override
    public String getMailPassword() {
        return mSharedPref.getMailPassword();
    }

    @Override
    public void setMailHost(String mailHost) {
        mSharedPref.setMailHost(mailHost);
    }

    @Override
    public String getMailHost() {
        return mSharedPref.getMailHost();
    }

    @Override
    public void setMailSMTPPort(int mailSMTPPort) {
        mSharedPref.setMailSMTPPort(mailSMTPPort);
    }

    @Override
    public int getMailSMTPPort() {
        return mSharedPref.getMailSMTPPort();
    }

    @Override
    public void setMailTo(String mailTo) {
        mSharedPref.setMailTo(mailTo);
    }

    @Override
    public String getMailTo() {
        return mSharedPref.getMailTo();
    }
}
