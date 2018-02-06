package co.borucki.easykanban.model.style;

public class LoginStyle {
    private String backgroundColor;
    private String backgroundTextColor;
    private String toolBarColor;
    private String toolBarTextColor;
    private String statusBarColor;
    private String toolBarIcon;

    public LoginStyle() {
    }

    public LoginStyle(String backgroundColor
            , String backgroundTextColor
            , String toolBarColor
            , String toolBarTextColor
            , String statusBarColor
            , String toolBarIcon) {
        this.backgroundColor = backgroundColor;
        this.backgroundTextColor = backgroundTextColor;
        this.toolBarColor = toolBarColor;
        this.toolBarTextColor = toolBarTextColor;
        this.statusBarColor = statusBarColor;
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

    public String getStatusBarColor() {
        return statusBarColor;
    }

    public void setStatusBarColor(String statusBarColor) {
        this.statusBarColor = statusBarColor;
    }

    public String getToolBarIcon() {
        return toolBarIcon;
    }

    public void setToolBarIcon(String toolBarIcon) {
        this.toolBarIcon = toolBarIcon;
    }
}
