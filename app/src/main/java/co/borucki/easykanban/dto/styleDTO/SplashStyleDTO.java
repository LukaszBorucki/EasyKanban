package co.borucki.easykanban.dto.styleDTO;

public class SplashStyleDTO {
    private String logo;
    private long splashTime;
    private int textVisible;
    private String customText;
    private String thanksText;
    private float customTextSize;
    private float thanksTextSize;
    private String backgroundColor;
    private String backgroundTextColor;
    private String statusBarColor;

    public SplashStyleDTO() {
    }

    public SplashStyleDTO(String logo
            , long splashTime
            , int textVisible
            , String customText
            , String thanksText
            , float customTextSize
            , float thanksTextSize
            , String backgroundColor
            , String backgroundTextColor
            , String statusBarColor) {
        this.logo = logo;
        this.splashTime = splashTime;
        this.textVisible = textVisible;
        this.customText = customText;
        this.thanksText = thanksText;
        this.customTextSize = customTextSize;
        this.thanksTextSize = thanksTextSize;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.statusBarColor = statusBarColor;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public long getSplashTime() {
        return splashTime;
    }

    public void setSplashTime(long splashTime) {
        this.splashTime = splashTime;
    }

    public int getTextVisible() {
        return textVisible;
    }

    public void setTextVisible(int textVisible) {
        this.textVisible = textVisible;
    }

    public String getCustomText() {
        return customText;
    }

    public void setCustomText(String customText) {
        this.customText = customText;
    }

    public String getThanksText() {
        return thanksText;
    }

    public void setThanksText(String thanksText) {
        this.thanksText = thanksText;
    }

    public float getCustomTextSize() {
        return customTextSize;
    }

    public void setCustomTextSize(float customTextSize) {
        this.customTextSize = customTextSize;
    }

    public float getThanksTextSize() {
        return thanksTextSize;
    }

    public void setThanksTextSize(float thanksTextSize) {
        this.thanksTextSize = thanksTextSize;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundTextColor() {
        return backgroundTextColor;
    }

    public void setBackgroundTextColor(String backgroundTextColor) {
        this.backgroundTextColor = backgroundTextColor;
    }

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
    }
}
