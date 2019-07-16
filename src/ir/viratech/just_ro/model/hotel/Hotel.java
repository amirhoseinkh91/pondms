package ir.viratech.just_ro.model.hotel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

import ir.viratech.just_ro.model.lowestprice.LowestPrice;


@XmlRootElement
public class Hotel implements Comparable<Hotel> {

	@JsonProperty
	private String name;

	private int stars;
	private List<LowestPrice> lowestPrices;
	private String id;

	@JsonProperty
	private String webUrl;
	private String lowestPrice;

	public static final String UNKNOWN_PRICE_FA = "قیمت نامشخص";

	@JsonProperty
	private double lowestPriceValue;
	private transient String description;
	private transient String location;
	private transient String email;
	@JsonProperty
	private String host;
	private double rating;
	private List<Room> rooms = new ArrayList<Room>();
	// key: Website, value: link
	private Map<String, String> urls = new HashMap<>();

	private String link;

	// default constructor
	public Hotel() {

	}

	public Hotel(String name, String webUrl, double lowestPriceValue, String link) {
		this.name = name;
		this.webUrl = link;
		this.host = webUrl;
		this.setLowestPriceValue(lowestPriceValue);
	}

	public Hotel(String id, String name, List<LowestPrice> lowestPrices) {
		this.id = id;
		this.name = name;
		this.lowestPrices = lowestPrices;
	}
	
	public Hotel(String id, String name, String webUrl, String link, String lowestPrice, int stars) {
		this.name = name;
		this.webUrl = webUrl;
		this.link = link;
		this.lowestPrice = lowestPrice;
		this.id = id;
		this.stars = stars;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	// setter getter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlTransient
	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	@XmlTransient
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlTransient
	public String getLowestPrice() {
		return lowestPrice;
	}

	public void setLowestPrice(String lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	@XmlTransient
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<LowestPrice> getLowestPrices() {
		return lowestPrices;
	}

	public void setLowestPrices(List<LowestPrice> lowestPrices) {
		this.lowestPrices = lowestPrices;
	}

	@XmlTransient
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@XmlTransient
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@XmlTransient
	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	@XmlTransient
	public Map<String, String> getUrls() {
		return urls;
	}

	@XmlTransient
	public void setUrls(Map<String, String> urls) {
		this.urls = urls;
	}

	// toString
	@Override
	public String toString() {
		return "نام= " + name + ", id= " + id + "لینک=" + link;
	}

	// toJson
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((webUrl == null) ? 0 : webUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Hotel other = (Hotel) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		if (webUrl == null) {
			if (other.webUrl != null) {
				return false;
			}
		} else if (!webUrl.equals(other.webUrl)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Hotel h) {

		int priceCompare = Integer.parseInt(h.lowestPrice);
		return Integer.parseInt(this.getLowestPrice()) - priceCompare;
	}

	public double getLowestPriceValue() {
		return lowestPriceValue;
	}

	public void setLowestPriceValue(double lowestPriceValue) {
		this.lowestPriceValue = lowestPriceValue;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

}
