package co.borucki.easykanban.statics;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;


public class Device {
    public static String getDeviceID(Activity activity) {
        TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);


        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            return "";
        }
        String id = telephonyManager.getDeviceId();
            if (id == null) {
                id = "";
            }

            int phoneType = telephonyManager.getPhoneType();
            switch (phoneType) {
                case TelephonyManager.PHONE_TYPE_NONE:
                    return id;

                case TelephonyManager.PHONE_TYPE_GSM:
                    return id;

                case TelephonyManager.PHONE_TYPE_CDMA:
                    return id;

                default:
                    return id;
            }

    }

}
