package co.borucki.easykanban.repository.style;


public interface MailStyleRepository {
    String getStatusBarColor();

    void setStatusBarColor(String color);

    String getBackgroundColor();

    void setBackgroundColor(String color);

    String getTextColor();

    void setTextColor(String color);

    float getLogoAlpha();

    void setLogoAlpha(float alpha);

    boolean isLogoVisible();

    void setLogoVisible(boolean visible);

    String getSingleRowColor();

    void setSingleRowColor(String color);

    String getSingleRowTextColor();

    void setSingleRowTextColor(String color);

    String getSingleRowUnreadColor();

    void setSingleRowUnreadColor(String color);

    String getSingleRowUnreadTextColor();

    void setSingleRowUnreadTextColor(String color);


}
