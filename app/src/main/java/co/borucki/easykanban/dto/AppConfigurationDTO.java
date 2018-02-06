package co.borucki.easykanban.dto;


public class AppConfigurationDTO {
    private int commercialLicence;
    private int refreshProducts;
    private int refreshUsers;
    private int refreshStyle;
    private int delAllData;
    private int codeType;
    private int sendLog;

    public AppConfigurationDTO() {
    }

    public AppConfigurationDTO(int commercialLicence
            , int refreshProducts
            , int refreshUsers
            , int refreshStyle
            , int delAllData
            , int codeType
            , int sendLog) {
        this.commercialLicence = commercialLicence;
        this.refreshProducts = refreshProducts;
        this.refreshUsers = refreshUsers;
        this.refreshStyle = refreshStyle;
        this.delAllData = delAllData;
        this.codeType = codeType;
        this.sendLog = sendLog;
    }

    public int getCommercialLicence() {
        return commercialLicence;
    }

    public void setCommercialLicence(int commercialLicence) {
        this.commercialLicence = commercialLicence;
    }

    public int getRefreshProducts() {
        return refreshProducts;
    }

    public void setRefreshProducts(int refreshProducts) {
        this.refreshProducts = refreshProducts;
    }

    public int getRefreshUsers() {
        return refreshUsers;
    }

    public void setRefreshUsers(int refreshUsers) {
        this.refreshUsers = refreshUsers;
    }

    public int getRefreshStyle() {
        return refreshStyle;
    }

    public void setRefreshStyle(int refreshStyle) {
        this.refreshStyle = refreshStyle;
    }

    public int getDelAllData() {
        return delAllData;
    }

    public void setDelAllData(int delAllData) {
        this.delAllData = delAllData;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public int getSendLog() {
        return sendLog;
    }

    public void setSendLog(int sendLog) {
        this.sendLog = sendLog;
    }
}
