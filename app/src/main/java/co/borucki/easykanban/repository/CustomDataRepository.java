package co.borucki.easykanban.repository;


public interface CustomDataRepository {
    String getLogo();

    void setLogo(String logo);

    String getIMEI();

    void setIMEI(String imei);

    long getSplashScreenTime();

    void setSplashScreenTime(long seconds);

}
