package co.borucki.easykanban.persistence;


import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class EasyKanbanSharedPreference {
    private static final String EASY_KANBAN_SHARED_PREFERENCE = "Shared preferences";
    private static final String CUSTOM_LOGO = "Customized logo";
    private static final String DEVICE_IMEI = "IMEI number";
    private static final String CUSTOMER_NAME = "Customer name";
    private static final String CUSTOMER_MAIL_ADDRESS = "Customer_mail_address";
    private static final String CUSTOMER_MAIL_PASSWORD = "Customer mail password";
    private static final String CUSTOMER_MAIL_HOST = "Customer mail host";
    private static final String CUSTOMER_MAIL_SMTPPORT = "Customer mail SMTP port";
    private static final String CUSTOMER_MAIL_RECEIVER_LIST = "Customer receiver lists";
    private static final String LICENCE_TYPE = "application licence type";
    private static final String ACCEPTABLE_CODE_TYPE = "acceptable code type";
    private static final String LOGIN_TIME_STAMP = "time from last login";
    private static final String SEND_LOGS = "send app logs by mail";
    private static final String LICENCE_OWNER = "licence owner";
    private final SharedPreferences mSharedPreferences;
    private Context context;

    public EasyKanbanSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(EASY_KANBAN_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public String getLogo() {
        return mSharedPreferences.getString(CUSTOM_LOGO, "");
    }

    public void setLogo(String logo) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOM_LOGO, logo, "String");
    }

    public String getIMEI() {
        return mSharedPreferences.getString(DEVICE_IMEI, "");
    }

    public void setIMEI(String imei) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, DEVICE_IMEI, imei, "String");
    }

    public void setCustomerName(String name) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_NAME, name, "String");
    }

    public String getCustomerName() {
        return mSharedPreferences.getString(CUSTOMER_NAME, "");
    }

    public void setMailAddress(String mailAddress) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_MAIL_ADDRESS, mailAddress, "String");
    }

    public String getMailAddress() {
        return mSharedPreferences.getString(CUSTOMER_MAIL_ADDRESS, "");
    }

    public void setMailPassword(String mailPassword) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_MAIL_PASSWORD, mailPassword, "String");
    }

    public String getMailPassword() {
        return mSharedPreferences.getString(CUSTOMER_MAIL_PASSWORD, "");
    }

    public void setMailHost(String mailHost) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_MAIL_HOST, mailHost, "String");
    }

    public String getMailHost() {
        return mSharedPreferences.getString(CUSTOMER_MAIL_HOST, "");
    }

    public void setMailSMTPPort(int mailSMTPPort) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_MAIL_SMTPPORT, mailSMTPPort, "int");
    }

    public int getMailSMTPPort() {
        return mSharedPreferences.getInt(CUSTOMER_MAIL_SMTPPORT, -1);
    }

    public void setMailTo(String mailTo) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOMER_MAIL_RECEIVER_LIST, mailTo, "String");
    }

    public String getMailTo() {
        return mSharedPreferences.getString(CUSTOMER_MAIL_RECEIVER_LIST, "");
    }

    public void setCommercialLicence(boolean isCommercial) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LICENCE_TYPE, isCommercial, "boolean");
    }

    public boolean isCommercialLicence() {
        return mSharedPreferences.getBoolean(LICENCE_TYPE, false);
    }

    public void setCodeType(int codeType) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, ACCEPTABLE_CODE_TYPE, codeType, "int");
    }

    public int getCodeType() {
        return mSharedPreferences.getInt(ACCEPTABLE_CODE_TYPE, 256);
    }

    public void setLoginTimestamp(String timestamp) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_TIME_STAMP, timestamp, "String");
    }

    public String getLoginTimestamp() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_TIME_STAMP, "2017/11/10 10:00:00");
    }

    public void setSendLog(boolean sendLog) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SEND_LOGS, sendLog, "boolean");
    }

    public boolean isSendLog() {
        return mSharedPreferences.getBoolean(SEND_LOGS, false);
    }

    public void setLicenceOwner(String licenceOwner) {
        SharedPrefService.setSharedPreferences(mSharedPreferences,LICENCE_OWNER,licenceOwner,"String");
    }

    public String getLicenceOwner() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences,LICENCE_OWNER,"No license to use this application");
    }
}
