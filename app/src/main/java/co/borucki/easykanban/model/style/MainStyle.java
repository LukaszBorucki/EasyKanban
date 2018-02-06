package co.borucki.easykanban.model.style;

public class MainStyle {
    private String statusBarColor;
    private String backgroundColor;
    private String backgroundTextColor;
    private boolean layoutLogoShow;
    private float layoutLogoAlpha;
    private String buttonColor;
    private String buttonTextColor;
    private String badgeColor;
    private String badgeTextColor;
    private String toolBarColor;
    private String toolBarTextColor;
    private String toolBarIcon;


    public MainStyle() {
    }

    public MainStyle(String statusBarColor
            , String backgroundColor
            , String backgroundTextColor
            , boolean layoutLogoShow
            , float layoutLogoAlpha
            , String buttonColor
            , String buttonTextColor
            , String badgeColor
            , String badgeTextColor
            , String toolBarColor
            , String toolBarTextColor
            , String toolBarIcon) {
        this.statusBarColor = statusBarColor;
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.layoutLogoShow = layoutLogoShow;
        this.layoutLogoAlpha = layoutLogoAlpha;
        this.buttonColor = buttonColor;
        this.buttonTextColor = buttonTextColor;
        this.badgeColor = badgeColor;
        this.badgeTextColor = badgeTextColor;
        this.toolBarColor = toolBarColor;
        this.toolBarTextColor = toolBarTextColor;
        this.toolBarIcon = toolBarIcon;
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

    public boolean isLayoutLogoShow() {
        return layoutLogoShow;
    }

    public void setLayoutLogoShow(boolean layoutLogoShow) {
        this.layoutLogoShow = layoutLogoShow;
    }

    public float getLayoutLogoAlpha() {
        return layoutLogoAlpha;
    }

    public void setLayoutLogoAlpha(float layoutLogoAlpha) {
        this.layoutLogoAlpha = layoutLogoAlpha;
    }

    public String getButtonColor() {
        return buttonColor;
    }

    public void setButtonColor(String buttonColor) {
        this.buttonColor = buttonColor;
    }

    public String getButtonTextColor() {
        return buttonTextColor;
    }

    public void setButtonTextColor(String buttonTextColor) {
        this.buttonTextColor = buttonTextColor;
    }

    public String getBadgeColor() {
        return badgeColor;
    }

    public void setBadgeColor(String badgeColor) {
        this.badgeColor = badgeColor;
    }

    public String getBadgeTextColor() {
        return badgeTextColor;
    }

    public void setBadgeTextColor(String badgeTextColor) {
        this.badgeTextColor = badgeTextColor;
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
}
