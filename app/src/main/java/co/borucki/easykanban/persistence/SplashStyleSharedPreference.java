package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.R;
import co.borucki.easykanban.statics.SharedPrefService;

public class SplashStyleSharedPreference {
    private static final String SPLASH_SHARED_PREFERENCE = "Shared preferences splash screen style";
    private static final String CUSTOM_SPLASH_TIME = "Display time of splash activity";
    private static final String CUSTOM_SPLASH_TEXT_VISIBILITY = "Splash screen text visibility";
    private static final String CUSTOM_SPLASH_TEXT = "Custom text on splash screen";
    private static final String THANKS_SPLASH_TEXT = "Thanks text on splash screen";
    private static final String CUSTOM_SPLASH_TEXT_SIZE = "size of custom text on splash screen";
    private static final String THANKS_SPLASH_TEXT_SIZE = "size of thanks text on splash screen";
    private static final String SPLASH_LAYOUT_COLOR = "Splash layout background color";
    private static final String SPLASH_LAYOUT_TEXT_COLOR = "Splash layout text color";
    private static final String SPLASH_STATUS_BAR_COLOR = "Splash status bar color";
    private Context context;
    private final SharedPreferences mSharedPreferences;

    public SplashStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(SPLASH_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public long getScreenTime() {
        return mSharedPreferences.getLong(CUSTOM_SPLASH_TIME, 20);
    }

    public void setScreenTime(long seconds) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOM_SPLASH_TIME, seconds, "long");
    }

    public void setScreenTextVisible(int number) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOM_SPLASH_TEXT_VISIBILITY, number, "int");
    }

    public int getScreenTextVisible() {
        return mSharedPreferences.getInt(CUSTOM_SPLASH_TEXT_VISIBILITY, 7);
    }

    public void setScreenCustomText(String text) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOM_SPLASH_TEXT, text, "String");
    }

    public String getScreenCustomText() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, CUSTOM_SPLASH_TEXT, context.getString(R.string.splash_activity_customized_text));
    }

    public void setScreenThanksText(String text) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, THANKS_SPLASH_TEXT, text, "String");
    }

    public String getScreenThanksText() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, THANKS_SPLASH_TEXT, context.getString(R.string.splash_activity_thanks_text));
    }

    public void setScreenCustomTextSize(float textSize) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, CUSTOM_SPLASH_TEXT_SIZE, textSize, "float");
    }

    public float getScreenCustomTextSize() {
        return mSharedPreferences.getFloat(CUSTOM_SPLASH_TEXT_SIZE, 15);
    }

    public void setScreenThanksTextSize(float textSize) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, THANKS_SPLASH_TEXT_SIZE, textSize, "float");
    }

    public float getScreenThanksTextSize() {
        return mSharedPreferences.getFloat(THANKS_SPLASH_TEXT_SIZE, 15);
    }

    public void setLayoutColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SPLASH_LAYOUT_COLOR, color, "String");
    }

    public String getLayoutColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SPLASH_LAYOUT_COLOR, "#FFFFFF");
    }

    public void setTextColor(String textColor) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SPLASH_LAYOUT_TEXT_COLOR, textColor, "String");
    }

    public String getTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SPLASH_LAYOUT_TEXT_COLOR, "#000000");
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SPLASH_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SPLASH_STATUS_BAR_COLOR, color, "String");
    }
}
