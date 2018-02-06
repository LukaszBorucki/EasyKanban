package co.borucki.easykanban.model;


public class AppConfiguration {
    private boolean commercialLicence;
    private boolean refreshProducts;
    private boolean refreshUsers;
    private boolean refreshStyle;
    private boolean delAllData;
    private int codeType;
    private boolean sendLog;

    public AppConfiguration() {
    }

    public AppConfiguration(boolean commercialLicence
            , boolean refreshProducts
            , boolean refreshUsers
            , boolean refreshStyle
            , boolean delAllData
            , int codeType
            , boolean sendLog) {
        this.commercialLicence = commercialLicence;
        this.refreshProducts = refreshProducts;
        this.refreshUsers = refreshUsers;
        this.refreshStyle = refreshStyle;
        this.delAllData = delAllData;
        this.codeType = codeType;
        this.sendLog = sendLog;
    }

    public boolean isCommercialLicence() {
        return commercialLicence;
    }

    public void setCommercialLicence(boolean commercialLicence) {
        this.commercialLicence = commercialLicence;
    }

    public boolean isRefreshProducts() {
        return refreshProducts;
    }

    public void setRefreshProducts(boolean refreshProducts) {
        this.refreshProducts = refreshProducts;
    }

    public boolean isRefreshUsers() {
        return refreshUsers;
    }

    public void setRefreshUsers(boolean refreshUsers) {
        this.refreshUsers = refreshUsers;
    }

    public boolean isRefreshStyle() {
        return refreshStyle;
    }

    public void setRefreshStyle(boolean refreshStyle) {
        this.refreshStyle = refreshStyle;
    }

    public boolean isDelAllData() {
        return delAllData;
    }

    public void setDelAllData(boolean delAllData) {
        this.delAllData = delAllData;
    }

    public int getCodeType() {
        return codeType;
    }

    public void setCodeType(int codeType) {
        this.codeType = codeType;
    }

    public boolean isSendLog() {
        return sendLog;
    }

    public void setSendLog(boolean sendLog) {
        this.sendLog = sendLog;
    }
}
