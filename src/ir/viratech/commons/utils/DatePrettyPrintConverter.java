package ir.viratech.commons.utils;

import java.util.Date;

import ir.viratech.pond_ms.core.i18n.MessageService;

public class DatePrettyPrintConverter {

    public static String convertToPrerttyString(Date creationDate) {
        int diffDate = MyDateUtils.dayDifference(MyDateUtils.now(), creationDate);
        String todayMessage = MessageService.getMessage("date.today");
        String dayAgoMessage = MessageService.getMessage("date.dayAgo");
        String weekAgoMessage = MessageService.getMessage("date.weekAgo");
        String monthAgoMessage = MessageService.getMessage("date.monthAgo");
        String yearAgoMessage = MessageService.getMessage("date.yearAgo");

        DatePrettyPrintConverter datePrettyPrintConverter = new DatePrettyPrintConverter();

        if (diffDate == 0)
            return todayMessage;
        else if (diffDate < 7)
            return datePrettyPrintConverter.changePersianNumbers(diffDate + "") + " " + dayAgoMessage;
        else if (diffDate < 29) {
            int week = diffDate / 7;
            return datePrettyPrintConverter.changePersianNumbers(week + "") + " " + weekAgoMessage;
        } else if (diffDate < 360) {
            int month = diffDate / 29;
            return datePrettyPrintConverter.changePersianNumbers(month + "") + " " + monthAgoMessage;
        } else {
            int year = diffDate / 360;
            return datePrettyPrintConverter.changePersianNumbers(year + "") + " " + yearAgoMessage;
        }
    }

    public String changePersianNumbers(String englishNumber) {

        char[] arabicChars = {'٠', '١', '٢', '٣', '٤', '٥', '٦', '٧', '٨', '٩'};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < englishNumber.length(); i++) {
            try {
                if (Character.isDigit(englishNumber.charAt(i))) {
                    builder.append(arabicChars[(int) (englishNumber.charAt(i)) - 48]);
                } else {
                    builder.append(englishNumber.charAt(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (builder.toString().equals("")) {
            builder.append(englishNumber);
        }

        return builder.toString();
    }
}
