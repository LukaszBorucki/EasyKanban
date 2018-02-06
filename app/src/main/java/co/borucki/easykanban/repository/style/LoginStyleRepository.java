package co.borucki.easykanban.repository.style;

public interface LoginStyleRepository {
    void setLayoutColor(String color);

    String getLayoutColor();

    void setTextColor(String textColor);

    String getTextColor();

    void setToolBarColor(String color);

    String getToolBarColor();

    void setToolBarTextColor(String color);

    String getToolBarTextColor();

    void setStatusBarColor(String color);

    String getStatusBarColor();

    void setToolBarIcon(String icon);

    String getToolBarIcon();

}
