package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class LoginStyleSharedPreference {
    private static final String LOGIN_STYLE_SHARED_PREFERENCE = "Shared preferences login style";
    private static final String LOGIN_ACTIVITY_TEXT_COLOR = "Login activity text color";
    private static final String LOGIN_ACTIVITY_BACKGROUND_COLOR = "Login activity background color";
    private static final String LOGIN_ACTIVITY_STATUS_BAR_COLOR = "Login activity status bar color";
    private static final String LOGIN_ACTIVITY_TOOL_BAR_TEXT_COLOR = "Login activity tool bar text color";
    private static final String LOGIN_ACTIVITY_TOOL_BAR_COLOR = "Login activity tool bar color";
    private static final String LOGIN_ACTIVITY_TOOL_BAR_ICON = "Login activity tool bar icon";
    private Context context;
    private final SharedPreferences mSharedPreferences;

    public LoginStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(LOGIN_STYLE_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public void setLayoutColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_BACKGROUND_COLOR, color, "String");
    }

    public String getLayoutColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_ACTIVITY_BACKGROUND_COLOR, "#FFFFFF");
    }

    public void setTextColor(String textColor) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_TEXT_COLOR, textColor, "String");
    }

    public String getTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_ACTIVITY_TEXT_COLOR, "#000000");
    }

    public void setToolBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_TOOL_BAR_COLOR, color, "String");
    }

    public String getToolBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_ACTIVITY_TOOL_BAR_COLOR, "#3F51B5");
    }

    public void setToolBarTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_TOOL_BAR_TEXT_COLOR, color, "String");
    }

    public String getToolBarTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_ACTIVITY_TOOL_BAR_TEXT_COLOR, "#FFFFFF");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_STATUS_BAR_COLOR, color, "String");
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, LOGIN_ACTIVITY_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setToolBarIcon(String icon) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, LOGIN_ACTIVITY_TOOL_BAR_ICON, icon, "String");
    }

    public String getToolBarIcon() {
        return mSharedPreferences.getString(LOGIN_ACTIVITY_TOOL_BAR_ICON, "");
    }

}
