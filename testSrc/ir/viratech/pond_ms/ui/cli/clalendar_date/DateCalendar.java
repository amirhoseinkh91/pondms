package ir.viratech.pond_ms.ui.cli.clalendar_date;

import java.util.Calendar;
import java.util.Date;

public class DateCalendar {

    public static void main(String[] args) {
        Calendar yesterdayCalendar = Calendar.getInstance();
        // yesterday !
        yesterdayCalendar.add(Calendar.DATE, -1);
        Date yesterday = yesterdayCalendar.getTime();

        Calendar nowCalendar = Calendar.getInstance();
        nowCalendar.setTime(new Date());

        System.out.println("day of now calendar:");
        System.out.println(nowCalendar.get(Calendar.DAY_OF_MONTH));

        System.out.println("day of yesterday calendar:");
        System.out.println(yesterdayCalendar.get(Calendar.DAY_OF_MONTH));

    }

}
