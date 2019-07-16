package ir.viratech.commons.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unused")
public class MyDateUtils {

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.parse(date);
    }

    public static boolean isBetween(Date firstDate, Date lastDate, Date middleDate) {
        return firstDate.before(middleDate) && lastDate.after(middleDate);
    }

    public static int dayDifference(Date firstDate, Date secondDate) {
        long diffInMillis = Math.abs(secondDate.getTime() - firstDate.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return (int) diff;
    }

    public static int dayDifferenceWithoutAbs(Date firstDate, Date secondDate) {
        long diffInMillis =secondDate.getTime() - firstDate.getTime();
        long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
        return (int) diff;
    }

    public static int monthDifference(Date firstDate, Date secondDate) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(firstDate);
        calendar2.setTime(secondDate);
        int diffYear = Math.abs(calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR));
        int diffMonth = diffYear * 12 + Math.abs(calendar1.get(Calendar.MONTH) - calendar2.get(Calendar.MONTH));
        return diffMonth;

    }

    public static int yearDifference(Date firstDate, Date secondDate) {
        // Creating Calendar class instance
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        // Converting Date to Calendar
        calendar1.setTime(firstDate);
        calendar2.setTime(secondDate);
        int diffYear = Math.abs(calendar1.get(Calendar.YEAR) - calendar2.get(Calendar.YEAR));
        return diffYear;

    }

    public static Date dateFormat(DateFormat format, Date date) {
        String newFormat = format.format(date);
        Date d = null;
        try {
            d = format.parse(newFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    public static Date now() {
        return new Date();
    }

    public static Date tomarow() {
        return nextDay(1);
    }

    public static Date nextDay(int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(now());
        c.add(Calendar.DATE, days);
        return c.getTime();
    }

    public static Date yesterday() {
        return previousDay(1);
    }

    public static Date previousDay(int days) {
        return nextDay(-1 * days);
    }

    public static boolean passedDate(Date endDate, Date date) {
        return date.after(endDate);
    }
}
