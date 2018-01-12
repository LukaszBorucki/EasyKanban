package co.borucki.easykanban.repository;


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


}
