package ir.viratech.pond_ms.model.campaign.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.campaign.Campaign".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.CAMPAIGNS"
 */

public abstract class BaseCampaign  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "Campaign". */
	public static final String REF = "Campaign";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	/** The constant referring the property "extuid". */
	public static final String PROP_EXTUID = "extuid";
	
	/** The constant referring the property "useId". */
	public static final String PROP_USE_ID = "useId";
	
	/** The constant referring the property "phone_num". */
	public static final String PROP_PHONE_NUM = "phone_num";
	
	/** The constant referring the property "device_name". */
	public static final String PROP_DEVICE_NAME = "device_name";
	
	/** The constant referring the property "destination". */
	public static final String PROP_DESTINATION = "destination";
	
	/** The constant referring the property "day01". */
	public static final String PROP_DAY01 = "day01";
	
	/** The constant referring the property "day02". */
	public static final String PROP_DAY02 = "day02";
	
	/** The constant referring the property "day03". */
	public static final String PROP_DAY03 = "day03";
	
	/** The constant referring the property "day04". */
	public static final String PROP_DAY04 = "day04";
	
	/** The constant referring the property "day05". */
	public static final String PROP_DAY05 = "day05";
	
	/** The constant referring the property "day06". */
	public static final String PROP_DAY06 = "day06";
	
	/** The constant referring the property "day07". */
	public static final String PROP_DAY07 = "day07";
	
	/** The constant referring the property "day08". */
	public static final String PROP_DAY08 = "day08";
	
	/** The constant referring the property "day09". */
	public static final String PROP_DAY09 = "day09";
	
	/** The constant referring the property "day10". */
	public static final String PROP_DAY10 = "day10";
	
	/** The constant referring the property "day11". */
	public static final String PROP_DAY11 = "day11";
	
	/** The constant referring the property "day12". */
	public static final String PROP_DAY12 = "day12";
	
	/** The constant referring the property "day13". */
	public static final String PROP_DAY13 = "day13";
	
	/** The constant referring the property "day14". */
	public static final String PROP_DAY14 = "day14";
	
	/** The constant referring the property "day15". */
	public static final String PROP_DAY15 = "day15";
	
	/** The constant referring the property "day16". */
	public static final String PROP_DAY16 = "day16";
	
	/** The constant referring the property "day17". */
	public static final String PROP_DAY17 = "day17";
	
	/** The constant referring the property "day18". */
	public static final String PROP_DAY18 = "day18";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.CAMPAIGNS";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	/** Name of column referring the property "extuid". */
	public static final String PROPCOLUMN_EXTUID = "extuid";
	
	/** Name of column referring the property "useId". */
	public static final String PROPCOLUMN_USE_ID = "useId";
	
	/** Name of column referring the property "phone_num". */
	public static final String PROPCOLUMN_PHONE_NUM = "phone_num";
	
	/** Name of column referring the property "device_name". */
	public static final String PROPCOLUMN_DEVICE_NAME = "device_name";
	
	/** Name of column referring the property "destination". */
	public static final String PROPCOLUMN_DESTINATION = "destination";
	
	/** Name of column referring the property "day01". */
	public static final String PROPCOLUMN_DAY01 = "day01";
	
	/** Name of column referring the property "day02". */
	public static final String PROPCOLUMN_DAY02 = "day02";
	
	/** Name of column referring the property "day03". */
	public static final String PROPCOLUMN_DAY03 = "day03";
	
	/** Name of column referring the property "day04". */
	public static final String PROPCOLUMN_DAY04 = "day04";
	
	/** Name of column referring the property "day05". */
	public static final String PROPCOLUMN_DAY05 = "day05";
	
	/** Name of column referring the property "day06". */
	public static final String PROPCOLUMN_DAY06 = "day06";
	
	/** Name of column referring the property "day07". */
	public static final String PROPCOLUMN_DAY07 = "day07";
	
	/** Name of column referring the property "day08". */
	public static final String PROPCOLUMN_DAY08 = "day08";
	
	/** Name of column referring the property "day09". */
	public static final String PROPCOLUMN_DAY09 = "day09";
	
	/** Name of column referring the property "day10". */
	public static final String PROPCOLUMN_DAY10 = "day10";
	
	/** Name of column referring the property "day11". */
	public static final String PROPCOLUMN_DAY11 = "day11";
	
	/** Name of column referring the property "day12". */
	public static final String PROPCOLUMN_DAY12 = "day12";
	
	/** Name of column referring the property "day13". */
	public static final String PROPCOLUMN_DAY13 = "day13";
	
	/** Name of column referring the property "day14". */
	public static final String PROPCOLUMN_DAY14 = "day14";
	
	/** Name of column referring the property "day15". */
	public static final String PROPCOLUMN_DAY15 = "day15";
	
	/** Name of column referring the property "day16". */
	public static final String PROPCOLUMN_DAY16 = "day16";
	
	/** Name of column referring the property "day17". */
	public static final String PROPCOLUMN_DAY17 = "day17";
	
	/** Name of column referring the property "day18". */
	public static final String PROPCOLUMN_DAY18 = "day18";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;

	// primary key
	private java.lang.Long id;

	// fields
	private java.lang.String extuid;
	private java.lang.String useId;
	private java.lang.String phone_num;
	private java.lang.String device_name;
	private java.lang.String destination;
	private boolean day01;
	private boolean day02;
	private boolean day03;
	private boolean day04;
	private boolean day05;
	private boolean day06;
	private boolean day07;
	private boolean day08;
	private boolean day09;
	private boolean day10;
	private boolean day11;
	private boolean day12;
	private boolean day13;
	private boolean day14;
	private boolean day15;
	private boolean day16;
	private boolean day17;
	private boolean day18;



	/**
	 * Returns the identifier.
	 * 
	 * @return the value of id
     * @hibernate.id
     *  generator-class="increment"
     *  column="id"
     */
	public java.lang.Long getId() {
		return id;
	}

	/**
	 * Set the identifier.
	 * 
	 * @param id the new value of id
	 */
	public void setId(java.lang.Long id) {
		this.id = id;
		this.hashCode_ = Integer.MIN_VALUE;
	}




	/**
	 * Getter for "extuid".
	 * column= extuid
	 *
	 * @return the value of extuid
	 */
	public java.lang.String getExtuid() {
		return this.extuid;
	}

	/**
	 * Setter for property "extuid".
	 * column= extuid
	 *
	 * @param extuid the new value for extuid
	 */
	public void setExtuid(java.lang.String extuid) {
		this.extuid = extuid;
		this.hashCode_ = Integer.MIN_VALUE;
	}



	/**
	 * Getter for "useId".
	 * column= useId
	 *
	 * @return the value of useId
	 */
	public java.lang.String getUseId() {
		return this.useId;
	}

	/**
	 * Setter for property "useId".
	 * column= useId
	 *
	 * @param useId the new value for useId
	 */
	public void setUseId(java.lang.String useId) {
		this.useId = useId;
	}



	/**
	 * Getter for "phone_num".
	 * column= phone_num
	 *
	 * @return the value of phone_num
	 */
	public java.lang.String getPhone_num() {
		return this.phone_num;
	}

	/**
	 * Setter for property "phone_num".
	 * column= phone_num
	 *
	 * @param phone_num the new value for phone_num
	 */
	public void setPhone_num(java.lang.String phone_num) {
		this.phone_num = phone_num;
	}



	/**
	 * Getter for "device_name".
	 * column= device_name
	 *
	 * @return the value of device_name
	 */
	public java.lang.String getDevice_name() {
		return this.device_name;
	}

	/**
	 * Setter for property "device_name".
	 * column= device_name
	 *
	 * @param device_name the new value for device_name
	 */
	public void setDevice_name(java.lang.String device_name) {
		this.device_name = device_name;
	}



	/**
	 * Getter for "destination".
	 * column= destination
	 *
	 * @return the value of destination
	 */
	public java.lang.String getDestination() {
		return this.destination;
	}

	/**
	 * Setter for property "destination".
	 * column= destination
	 *
	 * @param destination the new value for destination
	 */
	public void setDestination(java.lang.String destination) {
		this.destination = destination;
	}



	/**
	 * Getter for "day01".
	 * column= day01
	 *
	 * @return the value of day01
	 */
	public boolean isDay01() {
		return this.day01;
	}

	/**
	 * Setter for property "day01".
	 * column= day01
	 *
	 * @param day01 the new value for day01
	 */
	public void setDay01(boolean day01) {
		this.day01 = day01;
	}



	/**
	 * Getter for "day02".
	 * column= day02
	 *
	 * @return the value of day02
	 */
	public boolean isDay02() {
		return this.day02;
	}

	/**
	 * Setter for property "day02".
	 * column= day02
	 *
	 * @param day02 the new value for day02
	 */
	public void setDay02(boolean day02) {
		this.day02 = day02;
	}



	/**
	 * Getter for "day03".
	 * column= day03
	 *
	 * @return the value of day03
	 */
	public boolean isDay03() {
		return this.day03;
	}

	/**
	 * Setter for property "day03".
	 * column= day03
	 *
	 * @param day03 the new value for day03
	 */
	public void setDay03(boolean day03) {
		this.day03 = day03;
	}



	/**
	 * Getter for "day04".
	 * column= day04
	 *
	 * @return the value of day04
	 */
	public boolean isDay04() {
		return this.day04;
	}

	/**
	 * Setter for property "day04".
	 * column= day04
	 *
	 * @param day04 the new value for day04
	 */
	public void setDay04(boolean day04) {
		this.day04 = day04;
	}



	/**
	 * Getter for "day05".
	 * column= day05
	 *
	 * @return the value of day05
	 */
	public boolean isDay05() {
		return this.day05;
	}

	/**
	 * Setter for property "day05".
	 * column= day05
	 *
	 * @param day05 the new value for day05
	 */
	public void setDay05(boolean day05) {
		this.day05 = day05;
	}



	/**
	 * Getter for "day06".
	 * column= day06
	 *
	 * @return the value of day06
	 */
	public boolean isDay06() {
		return this.day06;
	}

	/**
	 * Setter for property "day06".
	 * column= day06
	 *
	 * @param day06 the new value for day06
	 */
	public void setDay06(boolean day06) {
		this.day06 = day06;
	}



	/**
	 * Getter for "day07".
	 * column= day07
	 *
	 * @return the value of day07
	 */
	public boolean isDay07() {
		return this.day07;
	}

	/**
	 * Setter for property "day07".
	 * column= day07
	 *
	 * @param day07 the new value for day07
	 */
	public void setDay07(boolean day07) {
		this.day07 = day07;
	}



	/**
	 * Getter for "day08".
	 * column= day08
	 *
	 * @return the value of day08
	 */
	public boolean isDay08() {
		return this.day08;
	}

	/**
	 * Setter for property "day08".
	 * column= day08
	 *
	 * @param day08 the new value for day08
	 */
	public void setDay08(boolean day08) {
		this.day08 = day08;
	}



	/**
	 * Getter for "day09".
	 * column= day09
	 *
	 * @return the value of day09
	 */
	public boolean isDay09() {
		return this.day09;
	}

	/**
	 * Setter for property "day09".
	 * column= day09
	 *
	 * @param day09 the new value for day09
	 */
	public void setDay09(boolean day09) {
		this.day09 = day09;
	}



	/**
	 * Getter for "day10".
	 * column= day10
	 *
	 * @return the value of day10
	 */
	public boolean isDay10() {
		return this.day10;
	}

	/**
	 * Setter for property "day10".
	 * column= day10
	 *
	 * @param day10 the new value for day10
	 */
	public void setDay10(boolean day10) {
		this.day10 = day10;
	}



	/**
	 * Getter for "day11".
	 * column= day11
	 *
	 * @return the value of day11
	 */
	public boolean isDay11() {
		return this.day11;
	}

	/**
	 * Setter for property "day11".
	 * column= day11
	 *
	 * @param day11 the new value for day11
	 */
	public void setDay11(boolean day11) {
		this.day11 = day11;
	}



	/**
	 * Getter for "day12".
	 * column= day12
	 *
	 * @return the value of day12
	 */
	public boolean isDay12() {
		return this.day12;
	}

	/**
	 * Setter for property "day12".
	 * column= day12
	 *
	 * @param day12 the new value for day12
	 */
	public void setDay12(boolean day12) {
		this.day12 = day12;
	}



	/**
	 * Getter for "day13".
	 * column= day13
	 *
	 * @return the value of day13
	 */
	public boolean isDay13() {
		return this.day13;
	}

	/**
	 * Setter for property "day13".
	 * column= day13
	 *
	 * @param day13 the new value for day13
	 */
	public void setDay13(boolean day13) {
		this.day13 = day13;
	}



	/**
	 * Getter for "day14".
	 * column= day14
	 *
	 * @return the value of day14
	 */
	public boolean isDay14() {
		return this.day14;
	}

	/**
	 * Setter for property "day14".
	 * column= day14
	 *
	 * @param day14 the new value for day14
	 */
	public void setDay14(boolean day14) {
		this.day14 = day14;
	}



	/**
	 * Getter for "day15".
	 * column= day15
	 *
	 * @return the value of day15
	 */
	public boolean isDay15() {
		return this.day15;
	}

	/**
	 * Setter for property "day15".
	 * column= day15
	 *
	 * @param day15 the new value for day15
	 */
	public void setDay15(boolean day15) {
		this.day15 = day15;
	}



	/**
	 * Getter for "day16".
	 * column= day16
	 *
	 * @return the value of day16
	 */
	public boolean isDay16() {
		return this.day16;
	}

	/**
	 * Setter for property "day16".
	 * column= day16
	 *
	 * @param day16 the new value for day16
	 */
	public void setDay16(boolean day16) {
		this.day16 = day16;
	}



	/**
	 * Getter for "day17".
	 * column= day17
	 *
	 * @return the value of day17
	 */
	public boolean isDay17() {
		return this.day17;
	}

	/**
	 * Setter for property "day17".
	 * column= day17
	 *
	 * @param day17 the new value for day17
	 */
	public void setDay17(boolean day17) {
		this.day17 = day17;
	}



	/**
	 * Getter for "day18".
	 * column= day18
	 *
	 * @return the value of day18
	 */
	public boolean isDay18() {
		return this.day18;
	}

	/**
	 * Setter for property "day18".
	 * column= day18
	 *
	 * @param day18 the new value for day18
	 */
	public void setDay18(boolean day18) {
		this.day18 = day18;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.campaign.Campaign)) return false;
		else {
			ir.viratech.pond_ms.model.campaign.Campaign campaign = (ir.viratech.pond_ms.model.campaign.Campaign) obj;
			boolean isEqual = true;
			if (null == this.getExtuid() || null == campaign.getExtuid()) return false;
			else isEqual = isEqual && (this.getExtuid().equals(campaign.getExtuid()));
			return isEqual;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			StringBuilder hashStr = new StringBuilder();
			hashStr.append(this.getClass().getName() + ":");
			if (null == this.getExtuid()) return super.hashCode();
			else hashStr.append(this.getExtuid().toString() + ":");
			this.hashCode_ = hashStr.toString().hashCode();
		}
		return this.hashCode_;
	}


	
	protected String toStringData() {
		return "id: " + this.getId();
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "{" + this.toStringData() + "}";
	}



}