package ir.viratech.just_ro.manager.website.flight.flight_utils;

/**
 * Created by justro on 2/8/18.
 */
public class FlightCompanyUtil {

    public static final String ATA_AIRLINE = "هواپیمایی آتا";
    public static final String ATA_AIRLINE_EN = "Ata Airline";
    public static final String ATRAK_AIRLINE = "هواپیمایی اترک";
    public static final String ATRAK_AIRLINE_EN = "Atrak Airline";
    public static final String HOMA_AIRLINE = "هواپیمایی هما";
    public static final String HOMA_AIRLINE_EN = "Homa Airline";
    public static final String IRAN_ASEMAN_AIRLINE = "هواپیمایی ایران آسمان";
    public static final String IRAN_ASEMAN_AIRLINE_EN = "Aseman Airline";
    public static final String IRAN_AIR_AIRLINE = "هواپیمایی ایران ایر";
    public static final String IRAN_AIR_AIRLINE_EN = "Iran Air Airline";
    public static final String IRAN_AIR_TOUR_AIRLINE = "هواپیمایی ایران ایرتور";
    public static final String IRAN_AIR_TOUR_AIRLINE_EN = "Air Tour Airline";
    public static final String CASPIAN_AIRLINE = "هواپیمایی کاسپین";
    public static final String CASPIAN_AIRLINE_EN = "Caspian Airline";
    public static final String KISH_AIRLINE = "هواپیمایی کیش";
    public static final String KISH_AIRLINE_EN = "Kish Airline";
    public static final String MAHAN_AIRLINE = "هواپیمایی ماهان";
    public static final String MAHAN_AIRLINE_EN = "Mahan Airline";
    public static final String MERAJ_AIRLINE = "هواپیمایی معراج";
    public static final String MERAJ_AIRLINE_EN = "Meraj Airline";
    public static final String NAFT_AIRLINE = "هواپیمایی نفت";
    public static final String NAFT_AIRLINE_EN = "Naft Airline";
    public static final String SAHAND_AIRLINE = "هواپیمایی سهند";
    public static final String SAHAND_AIRLINE_EN = "Sahand Airline";
    public static final String GHESHM_AIRLINE = "هواپیمایی قشم";
    public static final String GHESHM_AIRLINE_EN = "Qeshm Airline";
    public static final String SAHA_AIRLINE = "هواپیمایی ساها";
    public static final String SAHA_AIRLINE_EN = "Saha Airline";
    public static final String SEPEHRAN_AIRLINE = "هواپیمایی سپهران";
    public static final String SEPEHRAN_AIRLINE_EN = "Sepehran Airline";
    public static final String TABAN_AIRLINE = "هواپیمایی تابان";
    public static final String TABAN_AIRLINE_EN = "Taban Airline";
    public static final String TAFTAN_AIRLINE = "هواپیمایی تفتان";
    public static final String TAFTAN_AIRLINE_EN = "Taftan Airline";
    public static final String ZAGROS_AIRLINE = "هواپیمایی زاگرس";
    public static final String ZAGROS_AIRLINE_EN = "Zagros Airline";

    public static Integer companyCode(String flightCompanyCode) {
        //meraj , kish , atrak , homa , naft , sahand , sepehran , taftan
        if (flightCompanyCode.equals("IR"))
            return 1;
        if (flightCompanyCode.equals("W5"))
            return 2;
        if (flightCompanyCode.equals("Y9"))
            return 3;
        if (flightCompanyCode.equals("QB"))
            return 4;
        if (flightCompanyCode.equals("B9"))
            return 5;
        if (flightCompanyCode.equals("IV"))
            return 6;
        if (flightCompanyCode.equals("HH"))
            return 7;
        if (flightCompanyCode.equals("EP"))
            return 8;
        if (flightCompanyCode.equals("I3"))
            return 9;
        if (flightCompanyCode.equals("ZV"))
            return 10;
        if (flightCompanyCode.equals("JI"))
            return 11;
        if (flightCompanyCode.equals("SA") || flightCompanyCode.equals("SH"))
            return 12;
        if (flightCompanyCode.equals("SP"))
            return 17;
        else
            return null;
    }

    public static Integer getFlightCompanyCode(String companyName) {
        if (companyName.contains("آتا"))
            return 9;
        if (companyName.contains("اترک"))
            return 13;
        if (companyName.contains("هما"))
            return 14;
        if (companyName.contains("آسمان"))
            return 8;
        if (companyName.contains("ایران ایر"))
            return 1;
        if (companyName.contains("ایرتور"))
            return 5;
        if (companyName.contains("کاسپین"))
            return 6;
        if (companyName.contains("کیش"))
            return 3;
        if (companyName.contains("ماهان"))
            return 2;
        if (companyName.contains("معراج"))
            return 11;
        if (companyName.contains("نفت"))
            return 15;
        if (companyName.contains("سهند"))
            return 16;
        if (companyName.contains("قشم"))
            return 4;
        if (companyName.contains("ساها"))
            return 12;
        if (companyName.contains("سپهران"))
            return 17;
        if (companyName.contains("تابان"))
            return 7;
        if (companyName.contains("تفتان"))
            return 18;
        if (companyName.contains("زاگرس"))
            return 10;
        else
            return null;
    }

    private static String checkAirLineFa(String companyName) {
        if (companyName == null)
            return "هواپیمایی نامشخص";
        if (companyName.contains("آتا"))
            return ATA_AIRLINE;
        if (companyName.contains("اترک"))
            return ATRAK_AIRLINE;
        if (companyName.contains("هما"))
            return HOMA_AIRLINE;
        if (companyName.contains("آسمان"))
            return IRAN_ASEMAN_AIRLINE;
        if (companyName.contains("ایران ایر"))
            return IRAN_AIR_AIRLINE;
        if (companyName.contains("ایرتور"))
            return IRAN_AIR_TOUR_AIRLINE;
        if (companyName.contains("کاسپین"))
            return CASPIAN_AIRLINE;
        if (companyName.contains("کیش"))
            return KISH_AIRLINE;
        if (companyName.contains("ماهان"))
            return MAHAN_AIRLINE;
        if (companyName.contains("معراج"))
            return MERAJ_AIRLINE;
        if (companyName.contains("نفت"))
            return NAFT_AIRLINE;
        if (companyName.contains("سهند"))
            return SAHAND_AIRLINE;
        if (companyName.contains("قشم"))
            return GHESHM_AIRLINE;
        if (companyName.contains("ساها"))
            return SAHA_AIRLINE;
        if (companyName.contains("قشم"))
            return GHESHM_AIRLINE;
        if (companyName.contains("سپهران"))
            return SEPEHRAN_AIRLINE;
        if (companyName.contains("تابان"))
            return TABAN_AIRLINE;
        if (companyName.contains("تفتان"))
            return TAFTAN_AIRLINE;
        if (companyName.contains("زاگرس"))
            return ZAGROS_AIRLINE;
        else
            return "هواپیمایی نامشخص";

    }

    private static String checkAirLineEn(String companyName) {
        //TODO change it to hashMap alan hesesh nist asln !!!!!
        if (companyName.equals("HH"))
            return "Taban";
        if (companyName.equals("ZV"))
            return "Zagros";
        if (companyName.equals("B9"))
            return "Airtour";
        if (companyName.equals("W5"))
            return "Mahan";
        if (companyName.equals("I3"))
            return "Ata";
        if (companyName.equals("JI"))
            return "Meraj";
        if (companyName.equals("IV"))
            return "Caspian";
        if (companyName.equals("IR"))
            return "Iran Air";
        if (companyName.equals("QB"))
            return "Qeshm Air";
        if (companyName.equals("SA"))
            return "Saha";
        if (companyName.equals("EP"))
            return "Aseman";
        if (companyName.equals("SP"))
            return "Sepehran";
        if (companyName.equals("Y9"))
            return "Kish";
        return "Unknown AirLine";
    }

    public static String flightCompanyNameFa(String companyName) {
        return checkAirLineFa(companyName);
    }

    public static String aliMrFlightCompanyNameEn(String companyName) {
        return checkAirLineEn(companyName);
    }

    public static String sepehr360EnglishName(String companyName) {
        if (companyName.contains("Ata"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Atrak"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Homa"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Aseman"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Iran Air") || companyName.contains("iranair") ||
                companyName.contains("iranAir") || companyName.contains("IranAir") || companyName.contains("Iranair"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Air Tour") || companyName.contains("air tour") || companyName.contains("Airtour"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Caspian"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Kish"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Mahan"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Meraj"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Naft"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Sahand"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Qeshm"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Saha"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Taban"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Taftan"))
            return ATA_AIRLINE_EN;
        if (companyName.contains("Zagros"))
            return ATA_AIRLINE_EN;
        //TODO complete
        return "Unknown AirLine";

    }

    public static String airplaneTicketFlightCompanyNameFa(String companyName) {

        return checkAirLineFa(companyName);
    }

    public static String airplaneTicketFlightCompanyNameEn(String companyName) {
        return checkAirLineEn(companyName);
    }
}