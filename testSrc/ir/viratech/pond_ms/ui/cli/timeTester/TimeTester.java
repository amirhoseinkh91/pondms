package ir.viratech.pond_ms.ui.cli.timeTester;

import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

import java.util.Collection;
import java.util.Date;

public class TimeTester {

    CalendarTool calendarTool = new CalendarTool();


    public static void main(String[] args) {
        new TimeTester().start();
    }

    private void start() {
        printProgramStarted();
        String date = "1395/07/17";
        print(testToday(date));
        date = "1396/07/06";
        print(testToday(date));
        printProgramFinished();
    }

    private boolean testToday(String tourStartDate) {
        String today = calendarTool.getIranianToday();
        print("TourStartDate: " + tourStartDate + "\t" + "today:" + today);
        if (Integer.parseInt(tourStartDate.replaceAll("/" , "")) >= Integer.parseInt(today.replaceAll("/", "")))
            return true;
        else
            return false;
    }


    private void print (Object message) {
        System.out.println(message);
    }

    private void print (Collection<Object> messages) {
        for (Object o : messages)
            print(o);
    }

    private void printProgramFinished() {
        print("=========================");
        print("=========================");
        print("    PROGRAM FINISHED");
        print("=========================");
        print("=========================");
    }

    private void printProgramStarted() {
        print("=========================");
        print("=========================");
        print("    PROGRAM STARTED");
        print("=========================");
        print("=========================");
    }

}
