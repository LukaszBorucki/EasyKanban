package co.borucki.easykanban.dto.styleDTO;

public class SingleMailStyleDTO {
    private String statusBarColor;
    private String backgroundColor;
    private String backgroundTextColor;
    private String delButtonColor;
    private String delButtonTextColor;
    private float logoAlpha;
    private int logoVisible;

    public SingleMailStyleDTO() {
    }

    public SingleMailStyleDTO(String statusBarColor
            , String backgroundColor
            , String backgroundTextColor
            , String delButtonColor
            , String delButtonTextColor
            , float logoAlpha
            , int logoVisible) {
        this.statusBarColor = statusBarColor;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.delButtonColor = delButtonColor;
        this.delButtonTextColor = delButtonTextColor;
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

    public String getDelButtonColor() {
        return delButtonColor;
    }

    public void setDelButtonColor(String delButtonColor) {
        this.delButtonColor = delButtonColor;
    }

    public String getDelButtonTextColor() {
        return delButtonTextColor;
    }

    public void setDelButtonTextColor(String delButtonTextColor) {
        this.delButtonTextColor = delButtonTextColor;
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
