package co.borucki.easykanban.repository.style;

public interface MainStyleRepository {

    String getStatusBarColor();

    void setStatusBarColor(String color);

    String getLayoutColor();

    void setLayoutColor(String color);

    String getLayoutTextColor();

    void setLayoutTextColor(String color);

    boolean getLayoutLogoShow();

    void setLayoutLogoShow(boolean logoShow);

    float getLayoutLogoAlpha();

    void setLayoutLogoAlpha(float alpha);

    String getButtonColor();

    void setButtonColor(String color);

    String getButtonTextColor();

    void setButtonTextColor(String color);

    String getBadgeColor();

    void setBadgeColor(String color);

    String getBadgeTextColor();

    void setBadgeTextColor(String color);

    String getToolBarColor();

    void setToolBarColor(String color);

    String getToolBarTextColor();

    void setToolBarTextColor(String color);

    String getToolBarIcon();

    void setToolBarIcon(String icon);
}
