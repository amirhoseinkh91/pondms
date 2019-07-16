package ir.viratech.pond_ms.ui.cli;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by justro on 2/7/18.
 */
public class NumberCurrency {
    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguageTag("fa").build());
        System.out.println(NumberFormat.getNumberInstance().format(10000));

        String currency = format.format(10000);
        System.out.println(currency);
    }
}
