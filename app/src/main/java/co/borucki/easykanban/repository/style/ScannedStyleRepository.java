package co.borucki.easykanban.repository.style;

public interface ScannedStyleRepository {

    String getStatusBarColor();

    void setStatusBarColor(String color);

    String getToolBarColor();

    void setToolBarColor(String color);

    String getToolBarTextColor();

    void setToolBarTextColor(String color);

    String getToolBarIcon();

    void setToolBarIcon(String icon);

    String getLayoutColor();

    void setLayoutColor(String color);

    String getLayoutTextColor();

    void setLayoutTextColor(String color);

    String getSingleRowTextColor();

    void setSingleRowTextColor(String color);

    String getSingleRowDelButtonImage();

    void setSingleRowDelButtonImage(String image);

    String getSendButtonColor();

    void setSendButtonColor(String color);

    String getSendButtonTextColor();

    void setSendButtonTextColor(String color);

    float getLogoAlpha();

    void setLogoAlpha(float alpha);

    boolean isLogoVisible();

    void setLogoVisible(boolean isVisible);

    String getFabTintColor();

    void setFabTintColor(String color);

    String getFabRippleColor();

    void setFabRippleColor(String color);

    String getFabLogo();

    void setFabLogo(String logo);

}
