package co.borucki.easykanban.dto.styleDTO;

public class QrStyleDTO {
    private String statusBarColor;
    private String backgroundColor;
    private String backgroundTextColor;
    private float logoAlpha;
    private int logoVisible;

    public QrStyleDTO() {
    }

    public QrStyleDTO(String statusBarColor
            , String backgroundColor
            , String backgroundTextColor
            , float logoAlpha
            , int logoVisible) {
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

    public int isLogoVisible() {
        return logoVisible;
    }

    public void setLogoVisible(int logoVisible) {
        this.logoVisible = logoVisible;
    }
}
