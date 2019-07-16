package ir.viratech.just_ro.model.hotel;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {
	private String id;
	private String type;
	private boolean isAvailable;
	private String price;
	private boolean lunch;
	private boolean dinner;
	private boolean breakfast;
	private int peopleNumber;
	private int extraPeople;

	public Room(String id, String type, boolean isAvailable, String price, boolean lunch, boolean dinner , boolean breakfast,
			 int peopleNumber, int extraPeople) {
		this.id = id;
		this.type = type;
		this.isAvailable = isAvailable;
		this.price = price;
		this.lunch = lunch;
		this.dinner = dinner;
		this.breakfast = breakfast;
		this.peopleNumber = peopleNumber;
		this.extraPeople = extraPeople;
	}

	public Room() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean getisAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return this.price;
	}

	public boolean hasLunch() {
		return lunch;
	}

	public void setHasLunch(boolean lunch) {
		this.lunch = lunch;
	}

	public boolean getHasDinner()
	{
		return this.dinner;
	}

	public void setHasDinner(boolean dinner) {
		this.dinner = dinner;
	}

	public boolean isBreakfast() {
		return breakfast;
	}

	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public int getExtraPeople() {
		return extraPeople;
	}

	public void setExtraPeople(int extraPeople) {
		this.extraPeople = extraPeople;
	}
}
