package co.borucki.easykanban.repository;


import android.content.pm.InstrumentationInfo;

public interface CustomDataRepository {
    String getLogo();

    void setLogo(String logo);

    String getIMEI();

    void setIMEI(String imei);

    long getSplashScreenTime();

    void setSplashScreenTime(long seconds);

    void setSplashScreenTextVisible(int number);

    int getSplashScreenTextVisible();

    void setSplashScreenCustomText(String text);

    String getSplashScreenCustomText();

    void setSplashScreenThanksText(String text);

    String getSplashScreenThanksText();

    void setSplashScreenCustomTextSize(float textSize);

    float getSplashScreenCustomTextSize();

    void setSplashScreenThanksTextSize(float textSize);

    float getSplashScreenThanksTextSize();

    void setSplashLayoutColor(String color);

    String getSplashLayoutColor();

    void setSplashTextColor(String textColor);

    String getSplashTextColor();

    void setLoginLayoutColor(String color);

    String getLoginLayoutColor();

    void setLoginTextColor(String textColor);

    String getLoginTextColor();

    void setLoginToolBarColor(String color);

    String getLoginToolBarColor();

    void setLoginToolBarTextColor(String color);

    String getLoginToolBarTextColor();

    void setLoginStatusBarColor(String color);

    String getLoginStatusBarColor();

    void setLoginToolBarIcon(String icon);

    String getLoginToolBarIcon();

    void setCustomerName(String name);

    String getCustomerName();

    void setMailAddress(String mailAddress);

    String getMailAddress();

    void setMailPassword(String mailPassword);

    String getMailPassword();

    void setMailHost(String mailHost);

    String getMailHost();

    void setMailSMTPPort(int mailSMTPPort);

    int getMailSMTPPort();

    void setMailTo(String mailTo);

    String getMailTo();
}
