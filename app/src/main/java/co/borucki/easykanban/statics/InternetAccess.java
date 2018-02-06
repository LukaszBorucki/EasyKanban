package co.borucki.easykanban.statics;

import android.content.Context;
import android.net.ConnectivityManager;

public class InternetAccess {
    public static boolean isOnLine(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {
            try {
                Process p1 = Runtime.getRuntime().exec("ping -c 1 www.google.com");
                int returnVal = p1.waitFor();
                return (returnVal == 0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
