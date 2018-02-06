package co.borucki.easykanban.model.style;

public class ScannedStyle {
    private String statusBarColor;
    private String toolBarColor;
    private String toolBarTextColor;
    private String toolBarIcon;
    private String backgroundColor;
    private String backgroundTextColor;
    private String singleRowTextColor;
    private String singleRowDelButtonImage;
    private String sendButtonColor;
    private String sendButtonTextColor;
    private float logoAlpha;
    private boolean logoVisible;
    private String fabTintColor;
    private String fabRippleColor;
    private String fabLogo;

    public ScannedStyle() {
    }

    public ScannedStyle(String statusBarColor
            , String toolBarColor
            , String toolBarTextColor
            , String toolBarIcon
            , String backgroundColor
            , String backgroundTextColor
            , String singleRowTextColor
            , String singleRowDelButtonImage
            , String sendButtonColor
            , String sendButtonTextColor
            , float logoAlpha
            , boolean logoVisible
            , String fabTintColor
            , String fabRippleColor
            , String fabLogo) {
        this.statusBarColor = statusBarColor;
        this.toolBarColor = toolBarColor;
        this.toolBarTextColor = toolBarTextColor;
        this.toolBarIcon = toolBarIcon;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.singleRowTextColor = singleRowTextColor;
        this.singleRowDelButtonImage = singleRowDelButtonImage;
        this.sendButtonColor = sendButtonColor;
        this.sendButtonTextColor = sendButtonTextColor;
        this.logoAlpha = logoAlpha;
        this.logoVisible = logoVisible;
        this.fabTintColor = fabTintColor;
        this.fabRippleColor = fabRippleColor;
        this.fabLogo = fabLogo;
    }

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public String getToolBarColor() {
        return toolBarColor;
    }

    public void setToolBarColor(String toolBarColor) {
        this.toolBarColor = toolBarColor;
    }

    public String getToolBarTextColor() {
        return toolBarTextColor;
    }

    public void setToolBarTextColor(String toolBarTextColor) {
        this.toolBarTextColor = toolBarTextColor;
    }

    public String getToolBarIcon() {
        return toolBarIcon;
    }

    public void setToolBarIcon(String toolBarIcon) {
        this.toolBarIcon = toolBarIcon;
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

    public String getSingleRowTextColor() {
        return singleRowTextColor;
    }

    public void setSingleRowTextColor(String singleRowTextColor) {
        this.singleRowTextColor = singleRowTextColor;
    }

    public String getSingleRowDelButtonImage() {
        return singleRowDelButtonImage;
    }

    public void setSingleRowDelButtonImage(String singleRowDelButtonImage) {
        this.singleRowDelButtonImage = singleRowDelButtonImage;
    }

    public String getSendButtonColor() {
        return sendButtonColor;
    }

    public void setSendButtonColor(String sendButtonColor) {
        this.sendButtonColor = sendButtonColor;
    }

    public String getSendButtonTextColor() {
        return sendButtonTextColor;
    }

    public void setSendButtonTextColor(String sendButtonTextColor) {
        this.sendButtonTextColor = sendButtonTextColor;
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

    public String getFabTintColor() {
        return fabTintColor;
    }

    public void setFabTintColor(String fabTintColor) {
        this.fabTintColor = fabTintColor;
    }

    public String getFabRippleColor() {
        return fabRippleColor;
    }

    public void setFabRippleColor(String fabRippleColor) {
        this.fabRippleColor = fabRippleColor;
    }

    public String getFabLogo() {
        return fabLogo;
    }

    public void setFabLogo(String fabLogo) {
        this.fabLogo = fabLogo;
    }
}
