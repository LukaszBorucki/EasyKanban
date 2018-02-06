package co.borucki.easykanban.repository;



public interface CustomDataRepository {
    String getLogo();

    void setLogo(String logo);

    String getIMEI();

    void setIMEI(String imei);

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

    void setCommercialLicence(boolean isCommercial);

    boolean isCommercialLicence();

    void setCodeType(int codeType);

    int getCodeType();

}
