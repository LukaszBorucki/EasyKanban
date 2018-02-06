package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class SingleMailStyleSharedPreference {
    private static final String SINGLE_MAIL_SHARED_PREFERENCE = "Shared preferences single mail style";
    private static final String SINGLE_MAIL_STATUS_BAR_COLOR = "single mail status bar color";
    private static final String SINGLE_MAIL_BACKGROUND_COLOR = "single mail background color";
    private static final String SINGLE_MAIL_BACKGROUND_TEXT_COLOR = "single mail background text color";
    private static final String SINGLE_MAIL_DEL_BUTTON_COLOR = "single mail del button color";
    private static final String SINGLE_MAIL_DEL_BUTTON_TEXT_COLOR = "single mail del button text color";
    private static final String SINGLE_MAIL_LOGO_VISIBLE = "single mail logo visible";
    private static final String SINGLE_MAIL_LOGO_ALPHA = "single mail logo alpha";
    private final SharedPreferences mSharedPreferences;
    private Context context;

    public SingleMailStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(SINGLE_MAIL_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SINGLE_MAIL_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_STATUS_BAR_COLOR, color, "String");
    }

    public String getBackgroundColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SINGLE_MAIL_BACKGROUND_COLOR, "#FFFFFF");
    }

    public void setBackgroundColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_BACKGROUND_COLOR, color, "String");
    }

    public String getBackgroundTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SINGLE_MAIL_BACKGROUND_TEXT_COLOR, "#000000");
    }

    public void setBackgroundTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_BACKGROUND_TEXT_COLOR, color, "String");
    }

    public String getDelButtonColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SINGLE_MAIL_DEL_BUTTON_COLOR, "#cccccc");
    }

    public void setDelButtonColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_DEL_BUTTON_COLOR, color, "String");
    }

    public String getDelButtonTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SINGLE_MAIL_DEL_BUTTON_TEXT_COLOR, "#000000");
    }

    public void setDelButtonTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_DEL_BUTTON_TEXT_COLOR, color, "String");
    }

    public float getLogoAlpha() {
        return mSharedPreferences.getFloat(SINGLE_MAIL_LOGO_ALPHA, 0.2f);
    }

    public void setLogoAlpha(float alpha) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_LOGO_ALPHA, alpha, "float");
    }

    public boolean isLogoVisible() {
        return mSharedPreferences.getBoolean(SINGLE_MAIL_LOGO_VISIBLE, true);
    }

    public void setLogoVisible(boolean visible) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SINGLE_MAIL_LOGO_VISIBLE, visible, "boolean");
    }
}
