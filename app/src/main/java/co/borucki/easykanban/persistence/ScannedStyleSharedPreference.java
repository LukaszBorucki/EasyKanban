package co.borucki.easykanban.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import co.borucki.easykanban.statics.SharedPrefService;

public class ScannedStyleSharedPreference {
    private static final String SCANNED_PRODUCT_SHARED_PREFERENCE = "scanned product shared preference";
    private static final String SCANNED_PRODUCT_STATUS_BAR = "scanned product status bar color";
    private static final String SCANNED_PRODUCT_TOOL_BAR_COLOR = "scanned product tool bar color";
    private static final String SCANNED_PRODUCT_TOOL_BAR_TEXT_COLOR = "scanned product tool bar text color";
    private static final String SCANNED_PRODUCT_TOOL_BAR_ICON = "scanned product tool ba icon";
    private static final String SCANNED_PRODUCT_LAYOUT_COLOR = "scanned product layout color";
    private static final String SCANNED_PRODUCT_LAYOUT_TEXT_COLOR = "scanned product layout text color";
    private static final String SCANNED_PRODUCT_SINGLE_ROW_TEXT_COLOR = "scanned product single row text color";
    private static final String SCANNED_PRODUCT_SINGLE_ROW_DEL_BUTTON_IMAGE = "scanned product single row delete button image";
    private static final String SCANNED_PRODUCT_SEND_BUTTON_COLOR = "scanned product send button color";
    private static final String SCANNED_PRODUCT_SEND_BUTTON_TEXT_COLOR = "scanned product send button text color";
    private static final String SCANNED_PRODUCT_LOGO_ALPHA = "scanned product logo alpha";
    private static final String SCANNED_PRODUCT_LOGO_VISIBLE = "scanned product logo visible";
    private static final String FAB_TINT_COLOR = "Floating Action Button tint color";
    private static final String FAB_RIPPLE_COLOR = "Floating Action Button ripple color";
    private static final String FAB_LOGO = "Floating Action Button logo";
    private final SharedPreferences mSharedPreferences;
    private Context context;

    public ScannedStyleSharedPreference(Context context) {
        mSharedPreferences = context.getSharedPreferences(SCANNED_PRODUCT_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        this.context = context;
    }

    public String getStatusBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_STATUS_BAR, "#303F9F");
    }

    public void setStatusBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_STATUS_BAR, color, "String");
    }

    public String getToolBarColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_TOOL_BAR_COLOR, "#3F51B5");
    }

    public void setToolBarColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_TOOL_BAR_COLOR, color, "String");
    }

    public String getToolBarTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_TOOL_BAR_TEXT_COLOR, "#FFFFFF");
    }

    public void setToolBarTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_TOOL_BAR_TEXT_COLOR, color, "String");
    }

    public String getToolBarIcon() {
        return mSharedPreferences.getString(SCANNED_PRODUCT_TOOL_BAR_ICON, "");
    }

    public void setToolBarIcon(String icon) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_TOOL_BAR_ICON, icon, "String");
    }

    public String getLayoutColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_LAYOUT_COLOR, "#FFFFFF");
    }

    public void setLayoutColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_LAYOUT_COLOR, color, "String");
    }

    public String getLayoutTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_LAYOUT_TEXT_COLOR, "#000000");
    }

    public void setLayoutTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_LAYOUT_TEXT_COLOR, color, "String");
    }

    public String getSingleRowTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_SINGLE_ROW_TEXT_COLOR, "#000000");
    }

    public void setSingleRowTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_SINGLE_ROW_TEXT_COLOR, color, "String");
    }

    public String getSingleRowDelButtonImage() {
        return mSharedPreferences.getString(SCANNED_PRODUCT_SINGLE_ROW_DEL_BUTTON_IMAGE, "");
    }

    public void setSingleRowDelButtonImage(String image) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_SINGLE_ROW_DEL_BUTTON_IMAGE, image, "String");
    }

    public String getSendButtonColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_SEND_BUTTON_COLOR, "#cccccc");
    }

    public void setSendButtonColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_SEND_BUTTON_COLOR, color, "String");
    }

    public String getSendButtonTextColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, SCANNED_PRODUCT_SEND_BUTTON_TEXT_COLOR, "#000000");
    }

    public void setSendButtonTextColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_SEND_BUTTON_TEXT_COLOR, color, "String");
    }

    public float getLogoAlpha() {
        return mSharedPreferences.getFloat(SCANNED_PRODUCT_LOGO_ALPHA, 0.2f);
    }

    public void setLogoAlpha(float alpha) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_LOGO_ALPHA, alpha, "float");
    }

    public boolean isLogoVisible() {
        return mSharedPreferences.getBoolean(SCANNED_PRODUCT_LOGO_VISIBLE, true);
    }

    public void setLogoVisible(boolean isVisible) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, SCANNED_PRODUCT_LOGO_VISIBLE, isVisible, "boolean");
    }

    public String getFabBackgroundColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, FAB_TINT_COLOR, "#F0007f7f");
    }

    public void setFabBackgroundColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, FAB_TINT_COLOR, color, "String");
    }

    public String getFabRippleColor() {
        return SharedPrefService.getSharedPreferencesString(mSharedPreferences, FAB_RIPPLE_COLOR, "#F001d8d8");
    }

    public void setFabRippleColor(String color) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, FAB_RIPPLE_COLOR, color, "String");
    }

    public String getFabLogo() {
        return mSharedPreferences.getString(FAB_LOGO, "");
    }

    public void setFabLogo(String logo) {
        SharedPrefService.setSharedPreferences(mSharedPreferences, FAB_LOGO, logo, "String");
    }
}
