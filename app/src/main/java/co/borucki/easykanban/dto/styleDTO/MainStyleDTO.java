package co.borucki.easykanban.dto.styleDTO;

public class MainStyleDTO {
    private String statusBarColor;
    private String layoutColor;
    private String layoutTextColor;
    private int layoutLogoShow;
    private float layoutLogoAlpha;
    private String buttonColor;
    private String buttonTextColor;
    private String badgeColor;
    private String badgeTextColor;
    private String toolBarColor;
    private String toolBarTextColor;
    private String toolBarIcon;

    public MainStyleDTO() {
    }

    public MainStyleDTO(String statusBarColor
            , String layoutColor
            , String layoutTextColor
            , int layoutLogoShow
            , float layoutLogoAlpha
            , String buttonColor
            , String buttonTextColor
            , String badgeColor
            , String badgeTextColor
            , String toolBarColor
            , String toolBarTextColor
            , String toolBarIcon) {
        this.statusBarColor = statusBarColor;
        this.layoutColor = layoutColor;
        this.layoutTextColor = layoutTextColor;
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

    public String getLayoutColor() {
        return layoutColor;
    }

    public void setLayoutColor(String layoutColor) {
        this.layoutColor = layoutColor;
    }

    public String getLayoutTextColor() {
        return layoutTextColor;
    }

    public void setLayoutTextColor(String layoutTextColor) {
        this.layoutTextColor = layoutTextColor;
    }

    public int getLayoutLogoShow() {
        return layoutLogoShow;
    }

    public void setLayoutLogoShow(int layoutLogoShow) {
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
