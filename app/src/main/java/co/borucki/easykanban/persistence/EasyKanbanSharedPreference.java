package co.borucki.easykanban.persistence;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import co.borucki.easykanban.R;

public class EasyKanbanSharedPreference {
    private static final String EASY_KANBAN_SHARED_PREFERENCE = "Shared preferences";
    private static final String CUSTOM_LOGO = "Customized logo";
    private static final String DEVICE_IMEI = "IMEI number";
    private static final String CUSTOM_SPLASH_TIME = "Display time of splash activity";
    private static final String CUSTOM_SPLASH_TEXT_VISIBILITY = "Splash screen text visibility";
    private static final String CUSTOM_SPLASH_TEXT = "Custom text on splash screen";
    private static final String THANKS_SPLASH_TEXT = "Thanks text on splash screen";
    private static final String CUSTOM_SPLASH_TEXT_SIZE = "size of custom text on splash screen";
    private static final String THANKS_SPLASH_TEXT_SIZE = "size of thanks text on splash screen";
    private static final String SPLASH_LAYOUT_COLOR = "Splash layout background color";
    private static final String SPLASH_LAYOUT_TEXT_COLOR = "Splash layout text color";
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
        setSharedPreferencesString(CUSTOM_LOGO, logo, "String");
    }

    public String getIMEI() {
        return mSharedPreferences.getString(DEVICE_IMEI, "");
    }

    public void setIMEI(String imei) {
        setSharedPreferencesString(DEVICE_IMEI, imei, "String");
    }

    public long getSplashScreenTime() {
        return mSharedPreferences.getLong(CUSTOM_SPLASH_TIME, 20);
    }

    public void setSplashScreenTime(long seconds) {
        setSharedPreferencesString(CUSTOM_SPLASH_TIME, seconds, "long");
    }

    public void setSplashScreenTextVisible(int number) {
        setSharedPreferencesString(CUSTOM_SPLASH_TEXT_VISIBILITY, number, "int");
    }

    public int getSplashScreenTextVisible() {
        return mSharedPreferences.getInt(CUSTOM_SPLASH_TEXT_VISIBILITY, 7);
    }

    public void setSplashScreenCustomText(String text) {
        setSharedPreferencesString(CUSTOM_SPLASH_TEXT, text, "String");
    }

    public String getSplashScreenCustomText() {
        return mSharedPreferences.getString(CUSTOM_SPLASH_TEXT, context.getString(R.string.splash_activity_customized_text));
    }

    public void setSplashScreenThanksText(String text) {
        setSharedPreferencesString(THANKS_SPLASH_TEXT, text, "String");
    }

    public String getSplashScreenThanksText() {
        return mSharedPreferences.getString(THANKS_SPLASH_TEXT, context.getString(R.string.splash_activity_thanks_text));
    }

    public void setSplashScreenCustomTextSize(float textSize) {
        setSharedPreferencesString(CUSTOM_SPLASH_TEXT_SIZE, textSize, "float");
    }

    public float getSplashScreenCustomTextSize() {
        return mSharedPreferences.getFloat(CUSTOM_SPLASH_TEXT_SIZE, 15);
    }

    public void setSplashScreenThanksTextSize(float textSize) {
        setSharedPreferencesString(THANKS_SPLASH_TEXT_SIZE, textSize, "float");
    }

    public float getSplashScreenThanksTextSize() {
        return mSharedPreferences.getFloat(THANKS_SPLASH_TEXT_SIZE, 15);
    }

    public void setSplashLayoutColor(String color) {
        setSharedPreferencesString(SPLASH_LAYOUT_COLOR, color, "String");
    }

    public String getSplashLayoutColor() {
        return mSharedPreferences.getString(SPLASH_LAYOUT_COLOR, "#FFFFFF");
    }

    public void setSplashTextColor(String textColor) {
        setSharedPreferencesString(SPLASH_LAYOUT_TEXT_COLOR, textColor, "String");
    }

    public String getSplashTextColor() {
        return mSharedPreferences.getString(SPLASH_LAYOUT_TEXT_COLOR, "#000000");
    }

    private void setSharedPreferencesString(String key, @NonNull Object value, String type) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        switch (type) {
            case "String":
                editor.putString(key, (String) value);
                break;
            case "int":
                editor.putInt(key, (Integer) value);
                break;
            case "long":
                editor.putLong(key, (Long) value);
                break;
            case "float":
                editor.putFloat(key, (Float) value);
                break;
        }
        editor.apply();
    }
}
