package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class MailStyleSharedPreference {
    private static final String MAIL_STYLE_SHARED_PREFERENCE = "Shared preferences mail style";
    private static final String MAIL_STATUS_BAR_COLOR = "mail status bar color";
    private static final String MAIL_BACKGROUND_COLOR = "mail background color";
    private static final String MAIL_TEXT_COLOR = "mail text color";
    private static final String MAIL_LOGO_ALPHA = "mail logo alpha";
    private static final String MAIL_LOGO_VISIBLE = "mail logo visible";
    private static final String MAIL_SINGLE_ROW_COLOR = "mail single row color";
    private static final String MAIL_SINGLE_ROW_TEXT_COLOR = "mail single row text color";
    private static final String MAIL_SINGLE_ROW_UNREAD_COLOR = "mail single row unread color";
    private static final String MAIL_SINGLE_ROW_UNREAD_TEXT_COLOR = "mail single row unread text color";
    private final SharedPreferences mSharedPreferences;
    private Context context;

    public MailStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(MAIL_STYLE_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_STATUS_BAR_COLOR, color, "String");
    }

    public String getBackgroundColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_BACKGROUND_COLOR, "#FFFFFF");
    }

    public void setBackgroundColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_BACKGROUND_COLOR, color, "String");
    }

    public String getTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_TEXT_COLOR, "#000000");
    }

    public void setTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_TEXT_COLOR, color, "String");
    }

    public float getLogoAlpha() {
        return mSharedPreferences.getFloat(MAIL_LOGO_ALPHA, 0.2f);
    }

    public void setLogoAlpha(float alpha) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_LOGO_ALPHA, alpha, "float");
    }

    public boolean isLogoVisible() {
        return mSharedPreferences.getBoolean(MAIL_LOGO_VISIBLE, true);
    }

    public void setLogoVisible(boolean visible) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_LOGO_VISIBLE, visible, "boolean");
    }

    public String getSingleRowColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_SINGLE_ROW_COLOR, "#003F51B5");
    }

    public void setSingleRowColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_SINGLE_ROW_COLOR, color, "String");
    }

    public String getSingleRowTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_SINGLE_ROW_TEXT_COLOR, "#000000");
    }

    public void setSingleRowTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_SINGLE_ROW_TEXT_COLOR, color, "String");
    }

    public String getSingleRowUnreadColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_SINGLE_ROW_UNREAD_COLOR, "#F03F51B5");
    }

    public void setSingleRowUnreadColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_SINGLE_ROW_UNREAD_COLOR, color, "String");
    }

    public String getSingleRowUnreadTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIL_SINGLE_ROW_UNREAD_TEXT_COLOR, "#ffffff");
    }

    public void setSingleRowUnreadTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIL_SINGLE_ROW_UNREAD_TEXT_COLOR, color, "String");
    }
}
