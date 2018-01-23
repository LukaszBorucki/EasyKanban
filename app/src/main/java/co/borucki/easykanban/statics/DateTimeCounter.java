package co.borucki.easykanban.statics;


import android.os.Build;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class DateTimeCounter {
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

    public static String dateOrTime(String date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateToReturn = new Date();


        try {
            if (!dateFormat.format(new Date()).equals(dateFormat.format(dateFormat.parse(date)))) {
                return dateFormat.format(dateToReturn);

            } else {
                long time = dateTimeFormat.parse(date).getTime();
                final Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(time);
                return new SimpleDateFormat("HH:mm").format(cal.getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    return "";

//        return String.valueOf(time);
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//        String formatCurrentDate = dateFormat.format(new Date());
//        String formatMessageDate = "";
//        String formatMessageTime = "";

//        try {
//            formatMessageDate = dateFormat.format(dateFormat.parse(date));
//            formatMessageTime = timeFormat.format(timeFormat.parse(date));
//        } catch (ParseException e) {
//        }
//
//        if(formatCurrentDate.equals(formatMessageDate)){
//            return formatMessageTime;
//        }
//        return formatMessageDate;

//        return "";
    }

}
