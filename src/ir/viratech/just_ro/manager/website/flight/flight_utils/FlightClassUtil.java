package ir.viratech.just_ro.manager.website.flight.flight_utils;

import ir.viratech.base.SuppressWarningsOption;
import ir.viratech.just_ro.model.flight.Flight;

/**
 * Created by justro on 2/8/18.
 */
@SuppressWarnings({SuppressWarningsOption.SPELL_CHECKING_INSPECTION, SuppressWarningsOption.UNUSED})
public class FlightClassUtil {
    public static final String BUISNESS_CLASS_FA = "بیزنس کلاس";
    public static final String ECONOMY_CLASS_FA = "اکونومی";
    public static final String FIRST_CLASS_FA = "فرست کلاس";
    public static final String ALL_FLIGHT_CLASSES = "همه";
    public static final String UNKNOWN_CLASS_FA = "نامشخص";
    public static final String UNKNOWN_CAPACIY_FA = "ظرفیت نامشخص";
    public static final String CHARTER_TRUE = "چارتر";
    public static final String CHARTER_FALSE = "سیستمی";

    private static String flightClassFinder(String flightClass) {
        if (flightClass.contains("اکونومی"))
            return ECONOMY_CLASS_FA;
        if (flightClass.contains("بیزنس") || flightClass.contains("بیزینس"))
            return BUISNESS_CLASS_FA;
        if (flightClass.contains("فرست"))
            return FIRST_CLASS_FA;
        if (flightClass.contains(ALL_FLIGHT_CLASSES))
            return ALL_FLIGHT_CLASSES;
        else
            return UNKNOWN_CLASS_FA;
    }

    public static String alibabaFlightClass(String flightClass) {
        return flightClassFinder(flightClass);
    }

    public static String ghasedak24FlightClass(String flightClass) {
        return flightClassFinder(flightClass);
    }

    public static String convertCodeToPersianClass(String classCode) {
        final String[] buisnessClassCodes = {"C", "D", "J", "Z", "c", "d", "j", "z"};
        final String[] firstClassCodes = {"A", "F", "P", "R", "a", "f", "p", "r"};
        final String[] economyClassCodes = {"B", "E", "H", "K", "L", "M", "N", "Q", "S", "T", "V", "W", "X", "Y", "b",
                "e", "h", "k", "l", "m", "n", "q", "s", "t", "v", "w", "x", "y"};
        for (String code : buisnessClassCodes)
            if (classCode.contains(code))
                return Flight.BUISNESS_CLASS_FA;

        for (String code : economyClassCodes)
            if (classCode.contains(code))
                return Flight.ECONOMY_CLASS_FA;

        for (String code : firstClassCodes)
            if (classCode.contains(code))
                return Flight.FIRST_CLASS_FA;
        return Flight.UNKNOWN_CLASS_FA;
    }

}
