package ir.viratech.commons.persiantool;

import java.util.Date;
import java.util.GregorianCalendar;

public class PersianCalendar {
	
	/**
	 * MOON_EARTH_RATIO shows the ration of moon rounding around earth on the earth 
	 * rounding around son . 
	 **/
	final double  MOON_EARTH_RATIO = 492632.7462;
	
	private Date date;
	
	private int shamsiYear;
	private int shamsiMonthOfYear;
	private int shamsiDayOfMonth;
	private int shamsiDayOfYear;
	
	private int hour;
	private int minute;
	private int second;
	
	private GregorianCalendar gregorianCalendar;
	
	public PersianCalendar(){
		setDate(new Date());
	}
	
	public PersianCalendar(Date date){
		setDate(date);
	}

	public void setDate(Date date) {
		this.date = date;
		calculateShamsiDate();
	}
	
	public int getShamsiYear() {
		return shamsiYear;
	}

	public void setShamsiYear(int shamsiYear) {
		this.shamsiYear = shamsiYear;
	}

	public int getShamsiMonthOfYear() {
		return shamsiMonthOfYear;
	}

	public void setShamsiMonthOfYear(int shamsiMonthOfYear) {
		this.shamsiMonthOfYear = shamsiMonthOfYear;
	}

	public int getShamsiDayOfMonth() {
		return shamsiDayOfMonth;
	}

	public void setShamsiDayOfMonth(int shamsiDayOfMonth) {
		this.shamsiDayOfMonth = shamsiDayOfMonth;
	}

	public int getShamsiDayOfYear() {
		return shamsiDayOfYear;
	}

	public void setShamsiDayOfYear(int shamsiDayOfYear) {
		this.shamsiDayOfYear = shamsiDayOfYear;
	}

	private void calculateShamsiDate(){
		gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(this.date);
		
		this.hour = gregorianCalendar.get(GregorianCalendar.HOUR);
		this.minute = gregorianCalendar.get(GregorianCalendar.MINUTE);
		this.second = gregorianCalendar.get(GregorianCalendar.SECOND);
		
		long dateTimeZoneOffset = new GregorianCalendar().getTimeZone().getOffset(new Date().getTime());
		
		/**
		 * unixDays shows the number of days elapsed from UnixTime
		 **/
		int unixDays = (int)((this.date.getTime() + dateTimeZoneOffset) / (double)86400000);
		
		
		this.shamsiYear = (int)((unixDays + MOON_EARTH_RATIO + 0.5) / 365.24235 );
		
		/**
		 * firstDayOfTheYearUnixTime shows the number of days elahttps://accounts.youtube.com/accounts/SetSID?ssdc=1&sidt=ALWU2cuM9pd7Y44LoURuGSJ8TkY3d8XGoetSRzfv1530rSifhBayGXERM5hsxHsaMmf1LmT4xUh38TT1NwG5MsIM%2BKLCUC8lITd%2FhxyMPY1vNd6WxVcMiHDoDQfOqSGR7LWidhoaM6rI0WC73BozqxwuI8yZdrifaxocFA%2BJqifXMJbeV8KkiC1FKKtgaLJ7p57ZsmaLN75EPSktUJIqEydz0sAKWpuZdiKR7rQ8G8%2BPoGEEaM9p38ZsO5DbUfOA3rP5Yqy7Fv7S99Dv9cH53nJ9gsOW%2BHeKb0qniLUYPNVI1mpLdITT%2BWT8Lu%2Bc2tep88Fn36%2FSqUiLPN5GNNKO4trJOMTAC2Cf8lOAwyzxjNKsVLJyqg8RLe0%2Fa1eurYeozJ5oVudyU9J8%2FgAf1N2RIIaIbHwrukvkVnXiVmN6wPGZvD0x0WbDvm0%3D&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Fui%3D2psed from unixTime to this Shamsi year first day
		 */
		int firstDayOfTheYearUnixday = (int)(Math.round(this.shamsiYear * 365.24235 - MOON_EARTH_RATIO));
		
		this.shamsiDayOfYear = (unixDays - firstDayOfTheYearUnixday) + 1 ;
		
		/**
		 * yearsHalfIndicator indicate if shamsi Day is with half of year (186 = 6*31: days of first half of the year)
		 */
		int yearsHalfIndicator = (int)((this.shamsiDayOfYear -1 ) / 186);
		
		this.shamsiMonthOfYear = (int)((this.shamsiDayOfYear - 1 - yearsHalfIndicator * 6) / (31 - yearsHalfIndicator)) + 1;
		this.shamsiDayOfMonth = ((this.shamsiDayOfYear - 1 - (yearsHalfIndicator * 6 * 31)) % (31 - yearsHalfIndicator)) + 1;
		
		
	}
	
	private GregorianCalendar calculateGregorianDate(int shYear , int shMonth , int shDay , int hour , int minutes , int second ){
		/**
		 * long gregorianTimeValue = ((shYear.hour * 60 + shYear.minute) * 60 + shYear.second) * 1000;
		 * long gregorianTimeValue = ((hour * 60 + minute) * 60 + second) * 1000;;
		 */
		
		long gregorianTimeValue = 0;
		
		/**
		 * The real Julian Day of the 1st Farvardin of shYear
		 */
		
		long firsDayOfYearJulianDay = Math.round(shYear * 365.24235 - MOON_EARTH_RATIO);
		
		/**
		 * yearsHalfIndicator indicate if shMonth is greater than 6
		 */
		int yearsHalfIndicator = (int)(shMonth / 7);
		
		long julianDay = firsDayOfYearJulianDay + shDay - 1 + (shMonth - 1) * 31 - yearsHalfIndicator * (shMonth - 1 - 6);
		
		Date date = new Date();
		
		date.setTime(julianDay * 24 * 60 * 60 * 1000 + gregorianTimeValue);
		
		long datetime = date.getTime() - new GregorianCalendar().getTimeZone().getOffset(new Date().getTime());
		
		date.setTime(datetime);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(GregorianCalendar.HOUR, hour);
		calendar.set(GregorianCalendar.MINUTE, minutes);
		calendar.set(GregorianCalendar.SECOND, second);
		return calendar;
	}
	
	public Date getGregorianDate(int shamsiYear , int shamsiMonth , int shamsiDay , int hour , int minute , int second){
		return calculateGregorianDate(shamsiYear, shamsiMonth, shamsiDay, hour, minute, second).getTime();
	}
	
	public Date getGregorianDate(int shamsiYear , int shamsiMonth , int shamsiDay){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return calculateGregorianDate(shamsiYear, shamsiMonth, shamsiDay , this.hour , this.minute , this.second).getTime();
	}
	
	public Date getGregorianDate(){
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		return calculateGregorianDate(this.shamsiYear, this.shamsiMonthOfYear,
				this.shamsiDayOfMonth , this.hour , this.minute , this.second ).getTime();
	}
	
	public void plusShamsiDay(int days){
		//GregorianCalendar calendar = calculateGregorianDate(this.shamsiYear, this.shamsiMonthOfYear, this.shamsiDayOfMonth);
		//calendar.add(GregorianCalendar.DAY_OF_MONTH, days);
		gregorianCalendar.setTime(getGregorianDate());
		gregorianCalendar.add(GregorianCalendar.DAY_OF_YEAR, days);
		this.date = gregorianCalendar.getTime();
		calculateShamsiDate();
	}
	
	
	public void plusShamsiYear(int years){
		this.shamsiYear += years;
	}
	
	public void plusShamsiMonth(int months){
		/*if(this.shamsiMonthOfYear == 12)
			this.shamsiMonthOfYear = 0 ;
		
		this.shamsiMonthOfYear += months;*/
		for(int i = 1 ; i <= months ; i++){
			if(this.shamsiMonthOfYear == 12)
			{
				this.shamsiYear++;
				this.shamsiMonthOfYear = 0;
			}
			shamsiMonthOfYear += i;
		}
	}
	
	public Date getLastDayOfMonth(){
		int lastDayOfMonth = getMonthDays(this.shamsiMonthOfYear);
		return getGregorianDate(this.shamsiYear, this.shamsiMonthOfYear, lastDayOfMonth);
	}
	
	public Date getLastDayOfMonth(int hour , int minute , int second){
		int lastDayOfMonth = getMonthDays(this.shamsiMonthOfYear);
		return getGregorianDate(this.shamsiYear, this.shamsiMonthOfYear, lastDayOfMonth , hour , minute , second);
	}
	
	public Date getFirstDayOfMonth(){
		return getGregorianDate(this.shamsiYear, this.shamsiMonthOfYear, 1);
	}
	
	public Date getFirstDayOfYear(){
		return getGregorianDate(this.shamsiYear, 1, 1); 
	}
	
	public void plusShamsiWeekOfYear(int weeks){
		gregorianCalendar.setTime(getGregorianDate());
		gregorianCalendar.add(GregorianCalendar.WEEK_OF_YEAR , weeks);
		this.date = gregorianCalendar.getTime();
		calculateShamsiDate();
	}	
	
	
	private int getMonthDays(int month){
		if(month / 7 == 0)
			return 31;
		if(month == 12 && !isJalaliLeapYear(this.shamsiYear))
			return 29;
		return 30;
		
	}
	
	public Date getGregorianNextWeek(){
		gregorianCalendar.setTime(getGregorianDate());
		gregorianCalendar.add(GregorianCalendar.WEEK_OF_YEAR, 1);
		return gregorianCalendar.getTime();
	}
	
	public Date getShamsiNextMonth(){
		int month = this.shamsiMonthOfYear;
		int year = this.shamsiYear;
		int day = this.shamsiDayOfMonth;
		
		month++;
		
		if(month > 12){
			month = 1;
			year++;
		}
		
		
		gregorianCalendar.setTime(getGregorianDate(year , month , day));
		return gregorianCalendar.getTime();
	}
	
	
	public int getShamsiDayOfWeek(){
		gregorianCalendar.setTime(getGregorianDate());
		int gregorianWeekDay = gregorianCalendar.get(GregorianCalendar.DAY_OF_WEEK);
		if(gregorianWeekDay == 7)
			return 1;
		
		return gregorianWeekDay +1;
		
	}
	
	/**
	 * this method has been tested from 1100 - 1600;
	 * @param year
	 * @return boolean is Leap Year
	 */
	public boolean isJalaliLeapYear(int year)
    {
	
		// Iranian years starting the 33-year rule
		int Breaks[]=
		{-61, 9, 38, 199, 426, 686, 756, 818,1111,1181,
		1210,1635,2060,2097,2192,2262,2324,2394,2456,3178}  ;
		
		int jump , jm;
		int jp = Breaks[0];
		// Find the limiting years for the Iranian year 'irYear'
		int j=1;
		do{
			jm=Breaks[j];
			jump = jm-jp;
			if (year >= jm)
				jp = jm;
			
			j++;
		} while ((j<20) && (year >= jm));
		
		int N = year - jp;
		
		// Find how many years have passed since the last leap year
		if ( (jump - N) < 6 )
			N = N - jump + ((jump + 4)/33 * 33);
		
		int leap = (((N+1) % 33)-1) % 4;
		
		if (leap == -1)
			return false;
		
		if (leap==4 || leap==0)
		    return true;
		
		else 
		        return false;
		
    }

	
}
