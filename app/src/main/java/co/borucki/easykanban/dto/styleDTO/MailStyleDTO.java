package co.borucki.easykanban.dto.styleDTO;

public class MailStyleDTO {
    private String statusBarColor;
    private String backgroundColor;
    private String backgroundTextColor;
    private float logoAlpha;
    private int logoVisible;
    private String singleRowColor;
    private String singleRowTextColor;
    private String singleRowUnreadColor;
    private String singleRowUnreadTextColor;

    public MailStyleDTO() {
    }

    public MailStyleDTO(String statusBarColor
            , String backgroundColor
            , String backgroundTextColor
            , float logoAlpha
            , int logoVisible
            , String singleRowColor
            , String singleRowTextColor
            , String singleRowUnreadColor
            , String singleRowUnreadTextColor) {
        this.statusBarColor = statusBarColor;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.logoAlpha = logoAlpha;
        this.logoVisible = logoVisible;
        this.singleRowColor = singleRowColor;
        this.singleRowTextColor = singleRowTextColor;
        this.singleRowUnreadColor = singleRowUnreadColor;
        this.singleRowUnreadTextColor = singleRowUnreadTextColor;
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

    public String getSingleRowColor() {
        return singleRowColor;
    }

    public void setSingleRowColor(String singleRowColor) {
        this.singleRowColor = singleRowColor;
    }

    public String getSingleRowTextColor() {
        return singleRowTextColor;
    }

    public void setSingleRowTextColor(String singleRowTextColor) {
        this.singleRowTextColor = singleRowTextColor;
    }

    public String getSingleRowUnreadColor() {
        return singleRowUnreadColor;
    }

    public void setSingleRowUnreadColor(String singleRowUnreadColor) {
        this.singleRowUnreadColor = singleRowUnreadColor;
    }

    public String getSingleRowUnreadTextColor() {
        return singleRowUnreadTextColor;
    }

    public void setSingleRowUnreadTextColor(String singleRowUnreadTextColor) {
        this.singleRowUnreadTextColor = singleRowUnreadTextColor;
    }
}
