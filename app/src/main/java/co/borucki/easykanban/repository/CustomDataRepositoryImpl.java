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

    @Override
    public void setCommercialLicence(boolean isCommercial) {
        mSharedPref.setCommercialLicence(isCommercial);
    }

    @Override
    public boolean isCommercialLicence() {
        return mSharedPref.isCommercialLicence();
    }

    @Override
    public void setCodeType(int codeType) {
        mSharedPref.setCodeType(codeType);
    }

    @Override
    public int getCodeType() {
        return mSharedPref.getCodeType();
    }
}
