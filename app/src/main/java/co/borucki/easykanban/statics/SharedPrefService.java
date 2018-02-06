package co.borucki.easykanban.statics;


import android.content.SharedPreferences;
import android.support.annotation.NonNull;

public class SharedPrefService {
    public static String getSharedPreferencesString(SharedPreferences mSharedPreferences, String key, String defaultValue) {
        String string = mSharedPreferences.getString(key, defaultValue);
        return string.equals("") ? defaultValue : string;
    }

    public static void setSharedPreferences(SharedPreferences mSharedPreferences, String key, @NonNull Object value, String type) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        switch (type) {
            case "String":
                editor.putString(key, (String) value);
                break;
            case "int":
                editor.putInt(key, (int) value);
                break;
            case "long":
                editor.putLong(key, (long) value);
                break;
            case "float":
                editor.putFloat(key, (float) value);
                break;
            case "boolean":
                editor.putBoolean(key, (boolean) value);
                break;
        }
        editor.apply();
    }
}
