package co.borucki.easykanban.model.style;

public class QrStyle {
    private String statusBarColor;
    private String backgroundColor;
    private String backgroundTextColor;
    private float logoAlpha;
    private boolean logoVisible;

    public QrStyle() {
    }

    public QrStyle(String statusBarColor
            , String backgroundColor
            , String backgroundTextColor
            , float logoAlpha
            , boolean logoVisible) {
        this.statusBarColor = statusBarColor;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.logoAlpha = logoAlpha;
        this.logoVisible = logoVisible;
    }

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
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

    public float getLogoAlpha() {
        return logoAlpha;
    }

    public void setLogoAlpha(float logoAlpha) {
        this.logoAlpha = logoAlpha;
    }

    public boolean isLogoVisible() {
        return logoVisible;
    }

    public void setLogoVisible(boolean logoVisible) {
        this.logoVisible = logoVisible;
    }
}
