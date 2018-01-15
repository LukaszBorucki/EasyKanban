package co.borucki.easykanban.statics;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTimeCounter {
    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static long getPeriodInSeconds(String dateTime) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        try {
            Date dateInDatabase = dateFormat.parse(dateTime);
            Date currentDate = new Date();
            return (currentDate.getTime() - dateInDatabase.getTime()) / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
