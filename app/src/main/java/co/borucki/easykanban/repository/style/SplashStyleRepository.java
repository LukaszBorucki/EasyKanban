package co.borucki.easykanban.repository.style;

public interface SplashStyleRepository {

    long getScreenTime();

    void setScreenTime(long seconds);

    void setScreenTextVisible(int number);

    int getScreenTextVisible();

    void setScreenCustomText(String text);

    String getScreenCustomText();

    void setScreenThanksText(String text);

    String getScreenThanksText();

    void setScreenCustomTextSize(float textSize);

    float getScreenCustomTextSize();

    void setScreenThanksTextSize(float textSize);

    float getScreenThanksTextSize();

    void setLayoutColor(String color);

    String getLayoutColor();

    void setTextColor(String textColor);

    String getTextColor();

    String getStatusBarColor();

    void setStatusBarColor(String color);
}
