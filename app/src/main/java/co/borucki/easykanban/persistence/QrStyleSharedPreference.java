package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class QrStyleSharedPreference {
    private static final String QR_STYLE_SHARED_PREFERENCE = "Shared preferences QR style";
    private static final String QR_STATUS_BAR_COLOR = "QR status bar color";
    private static final String QR_BACKGROUND_COLOR = "QR background color";
    private static final String QR_BACKGROUND_TEXT_COLOR = "QR background text color";
    private static final String QR_LOGO_ALPHA = "QR logo alpha";
    private static final String QR_LOGO_VISIBLE = "QR logo visible";
    private final SharedPreferences mSharedPreferences;
    private Context context;

    public QrStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(QR_STYLE_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }
    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, QR_STATUS_BAR_COLOR, "#303F9F");
    }

    public void setQrStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, QR_STATUS_BAR_COLOR, color, "String");
    }

    public String getBackgroundColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, QR_BACKGROUND_COLOR, "#FFFFFF");
    }

    public void setBackgroundColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, QR_BACKGROUND_COLOR, color, "String");
    }

    public String getBackgroundTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, QR_BACKGROUND_TEXT_COLOR, "#000000");
    }

    public void setBackgroundTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, QR_BACKGROUND_TEXT_COLOR, color, "String");
    }

    public float getLogoAlpha() {
        return mSharedPreferences.getFloat(QR_LOGO_ALPHA, 0.2f);
    }

    public void setLogoAlpha(float alpha) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, QR_LOGO_ALPHA, alpha, "float");
    }

    public boolean isLogoVisible() {
        return mSharedPreferences.getBoolean(QR_LOGO_VISIBLE, true);
    }

    public void setLogoVisible(boolean visible) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, QR_LOGO_VISIBLE, visible, "boolean");
    }
}
