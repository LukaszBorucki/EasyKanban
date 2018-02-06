package co.borucki.easykanban.repository.style;

public interface SingleMailStyleRepository {
    String getStatusBarColor();

    void setStatusBarColor(String color);

    String getBackgroundColor();

    void setBackgroundColor(String color);

    String getBackgroundTextColor();

    void setBackgroundTextColor(String color);

    String getDelButtonColor();

    void setDelButtonColor(String color);

    String getDelButtonTextColor();

    void setDelButtonTextColor(String color);

    float getLogoAlpha();

    void setLogoAlpha(float alpha);

    boolean isLogoVisible();

    void setLogoVisible(boolean visible);
}
