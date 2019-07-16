package ir.viratech.just_ro.manager.cityChecker;

public class CityChecker {
	
	public static String flights(String cityName) {
		if (cityName.equals("سیر جان"))
			return "سیرجان";
		else if (cityName.equals("بندر عباس"))
			return "بندرعباس";
		else if (cityName.equals("خرم‌آباد") | cityName.equals("خرم اباد") | cityName.equals("خرم‌اباد"))
			return "خرم آباد";
		else if (cityName.equals("ایران شهر") | cityName.equals("ایران‌شهر"))
			return "ایرانشهر";
		else if (cityName.equals("پارس‌آباد") | cityName.equals("پارس‌اباد") | cityName.equals("پارس اباد"))
			return "پارس آباد";
		else if (cityName.equals("بندرلنگه"))
			return "بندر لنگه";
		else if (cityName.equals("شهرکرد"))
			return "شهر کرد";
		else
			return cityName;
	}

	public static String hotelyar(String cityName) {
		if (cityName.equals("عباس آباد") | cityName.equals("عباس اباد") | cityName.equals("عباس‌اباد"))
			return "عباس-آباد";
		else if (cityName.equals("محمود آباد") | cityName.equals("محمودآباد") | cityName.equals("محموداباد") | cityName.equals("محمود اباد"))
			return "محمود-آباد";
		else if (cityName.equals("بندر انزلی"))
			return "بندرانزلی";
		else if (cityName.equals("علی آباد کتول") | cityName.equals("علی‌آباد‌کتول") | cityName.equals("علی‌آباد کتول")
				| cityName.equals("علی آبادکتول") | cityName.equals("علی اباد کتول") | cityName.equals("علی‌اباد کتول")
				| cityName.equals("علی ابادکتول"))
			return "علی-آباد-گلستان";
		else if (cityName.equals("خور و بیابانک") | cityName.equals("خورو بیابانک") | cityName.equals("خور وبیابانک"))
			return "خوروبیابانک";
		else if (cityName.equals("فریدون کنار") | cityName.equals("فریدون‌کنار"))
			return "فریدونکنار";
		else if (cityName.equals("خرم آباد") | cityName.equals("خرم‌آباد") | cityName.equals("خرم اباد") | cityName.equals("خرم‌اباد"))
			return "خرم-آباد";
		else if (cityName.equals("مهدی‌شهر") | cityName.equals("مهدیشهر") | cityName.equals("مهدی شهر"))
			return "سمنان";
		else if (cityName.equals("شهر کرد"))
			return "شهرکرد";
		else
			return cityName;
	}
	
	public static String pintapin(String cityName) {
		if (cityName.equals("عباس آباد"))
			return "عباس-آباد";
		else if (cityName.equals("محمود آباد") | cityName.equals("محموداباد") | cityName.equals("محمود اباد"))
			return "محمودآباد";
		else if (cityName.equals("بندر انزلی") | cityName.equals("بندرانزلی"))
			return "بندر-انزلی";
		else if (cityName.equals("علی آباد کتول") | cityName.equals("علی‌آباد‌کتول") | cityName.equals("علی‌آباد کتول")
				| cityName.equals("علی آبادکتول") | cityName.equals("علی اباد کتول") | cityName.equals("علی‌اباد کتول")
				| cityName.equals("علی ابادکتول"))
			return "علی‌آباد-کتول";
		else if (cityName.equals("فریدون کنار") | cityName.equals("فریدونکنار"))
			return "فریدون‌کنار";
		else if (cityName.equals("گنبد کاووس") | cityName.equals("گنبدکاووس"))
			return "گنبد-کاووس";
		else if (cityName.equals("خرم آباد") | cityName.equals("خرم اباد") | cityName.equals("خرم‌اباد"))
			return "خرم‌آباد";
		else if (cityName.equals("مهدی‌شهر") | cityName.equals("مهدیشهر") | cityName.equals("مهدی شهر"))
			return "سنگسر";
		else if (cityName.equals("قائم شهر"))
			return "قائم‌شهر";
		else if (cityName.equals("شهر کرد"))
			return "شهرکرد";
		else
			return cityName;
	}
	
	public static String ariaBooking(String cityName) {
		if (cityName.equals("بندر انزلی"))
			return "بندرانزلی";
		else if (cityName.equals("علی آباد کتول") | cityName.equals("علی‌آباد‌کتول") | cityName.equals("علی‌آباد کتول")
				| cityName.equals("علی آبادکتول") | cityName.equals("علی اباد کتول") | cityName.equals("علی‌اباد کتول")
				| cityName.equals("علی ابادکتول"))
			return "علی+آباد+کتول";
		else if (cityName.equals("مهدی‌شهر") | cityName.equals("مهدیشهر"))
			return "مهدی شهر";
		else if (cityName.equals("شهر کرد"))
			return "شهرکرد";
		else
			return cityName;
	}
	
	public static int partsCounter(String string, String regex) {
		String[] parts = string.split(regex);
		return parts.length;
	}
	
	public static String part(int ithPart, String string, String regex) throws ArrayIndexOutOfBoundsException{
		String[] parts = string.split(regex);
		String message = string + " parts by " + regex + "is smaller than " + ithPart;
		if (parts.length > ithPart)
			throw new ArrayIndexOutOfBoundsException(message);
		else
			return parts[ithPart];
	}
}
