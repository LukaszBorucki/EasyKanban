package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class MainStyleSharedPreference {
    private static final String MAIN_STYLE_SHARED_PREFERENCE = "Shared preferences main style";
    private static final String MAIN_STATUS_BAR_COLOR = "main status bar color";
    private static final String MAIN_LAYOUT_COLOR = "main layout color";
    private static final String MAIN_LAYOUT_TEXT_COLOR = "main layout text color";
    private static final String MAIN_BUTTON_COLOR = "main button color";
    private static final String MAIN_BUTTON_TEXT_COLOR = "main button text color";
    private static final String MAIN_BADGE_COLOR = "main badge color";
    private static final String MAIN_BADGE_TEXT_COLOR = "main badge text color";
    private static final String MAIN_LAYOUT_LOGO_SHOW = "main logo show";
    private static final String MAIN_LAYOUT_LOGO_ALPHA = "main logo alpha";
    private static final String MAIN_TOOL_BAR_COLOR = "main tool bar color";
    private static final String MAIN_TOOL_BAR_TEXT_COLOR = "main tool bat text color";
    private static final String MAIN_TOOL_BAR_ICON = "main tool bar icon";

    private final SharedPreferences mSharedPreferences;
    private Context context;

    public MainStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(MAIN_STYLE_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_STATUS_BAR_COLOR, color, "String");
    }

    public String getLayoutColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_LAYOUT_COLOR, "#FFFFFF");
    }

    public void setLayoutColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_LAYOUT_COLOR, color, "String");
    }

    public String getLayoutTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_LAYOUT_TEXT_COLOR, "#000000");
    }

    public void setLayoutTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_LAYOUT_TEXT_COLOR, color, "String");
    }

    public boolean getLayoutLogoShow() {
        return mSharedPreferences.getBoolean(MAIN_LAYOUT_LOGO_SHOW, true);
    }

    public void setLayoutLogoShow(boolean logoShow) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_LAYOUT_LOGO_SHOW, logoShow, "boolean");
    }

    public float getLayoutLogoAlpha() {
        return mSharedPreferences.getFloat(MAIN_LAYOUT_LOGO_ALPHA, 0.2f);
    }

    public void setLayoutLogoAlpha(float alpha) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_LAYOUT_LOGO_ALPHA, alpha, "float");
    }

    public String getButtonColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_BUTTON_COLOR, "#F03F51B5");
    }

    public void setButtonColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_BUTTON_COLOR, color, "String");
    }

    public String getButtonTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_BUTTON_TEXT_COLOR, "#FFFFFF");
    }

    public void setButtonTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_BUTTON_TEXT_COLOR, color, "String");
    }

    public String getBadgeColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_BADGE_COLOR, "#FF303F9F");
    }

    public void setBadgeColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_BADGE_COLOR, color, "String");
    }

    public String getBadgeTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_BADGE_TEXT_COLOR, "#ffffff");
    }

    public void setBadgeTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_BADGE_TEXT_COLOR, color, "String");
    }

    public String getToolBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_TOOL_BAR_COLOR, "#3F51B5");
    }

    public void setToolBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_TOOL_BAR_COLOR, color, "String");
    }

    public String getToolBarTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, MAIN_TOOL_BAR_TEXT_COLOR, "#FFFFFF");
    }

    public void setToolBarTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_TOOL_BAR_TEXT_COLOR, color, "String");
    }

    public String getToolBarIcon() {
        return mSharedPreferences.getString(MAIN_TOOL_BAR_ICON, "");
    }

    public void setToolBarIcon(String icon) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, MAIN_TOOL_BAR_ICON, icon, "String");
    }
}
