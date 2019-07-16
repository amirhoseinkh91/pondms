package ir.viratech.pond_ms.ui.cli.main_test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by justro on 2/13/18.
 */
public class TestTime {

    public static void main(String[] args) {
        String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        System.out.println(timeStamp);
    }
}
