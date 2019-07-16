package ir.viratech.pond_ms.model.tour_relations.tour;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.pond_ms.model.tour_relations.base.model.ExtendedPointObject;
public class MainTourInformation extends ExtendedPointObject {

	
	public static final String PROP_IS_IRANIAN = "isIranian";
	public static final String PROP_DATE = "date";
	public static final String PROP_PRICE = "price";
	public static final String PROP_IMAGES = "images";
	public static final String PROP_DISCOUNTED_PRICE = "discountedPrice";
	public static final String PROP_SERVICES = "services";
	public static final String PROP_SIGNUP_RULES = "signupRules";
	public static final String PROP_REQUIRED_TOOLS = "requiredTools";
	public static final String PROP_RECOMENDED_TOOLS = "recommendedTools";
	public static final String PROP_SRC_CITY = "srcCity";
	public static final String PROP_DST_COUNTRIES = "dstCountries";
	public static final String PROP_DST_CITIES = "dstCities";
	
	private boolean isIranian;
	private String date;
	private long price;
	private long discountedPrice;
	private String services;
	private String signupRules;
	private String requiredTools;
	private String recommendedTools;
	private String srcCity;
	private List<String> dstCountries;
	private List<String> dstCities;

	/**
	 * @return the isIranian
	 */
	public boolean isIranian() {
		return isIranian;
	}

	/**
	 * @param isIranian
	 *            the isIranian to set
	 */
	public void setIranian(boolean isIranian) {
		this.isIranian = isIranian;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the price
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	/**
	 * @return the discountedPrice
	 */
	public long getDiscountedPrice() {
		return discountedPrice;
	}

	/**
	 * @param discountedPrice
	 *            the discountedPrice to set
	 */
	public void setDiscountedPrice(long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	/**
	 * @return the services
	 */
	public String getServices() {
		return services;
	}

	/**
	 * @param services
	 *            the services to set
	 */
	public void setServices(String services) {
		this.services = services;
	}

	/**
	 * @return the signupRules
	 */
	public String getSignupRules() {
		return signupRules;
	}

	/**
	 * @param signupRules
	 *            the signupRules to set
	 */
	public void setSignupRules(String signupRules) {
		this.signupRules = signupRules;
	}

	/**
	 * @return the requiredTools
	 */
	public String getRequiredTools() {
		return requiredTools;
	}

	/**
	 * @param requiredTools
	 *            the requiredTools to set
	 */
	public void setRequiredTools(String requiredTools) {
		this.requiredTools = requiredTools;
	}

	/**
	 * @return the recomendedTools
	 */
	public String getRecommendedTools() {
		return recommendedTools;
	}

	/**
	 * @param recomendedTools
	 *            the recomendedTools to set
	 */
	public void setRecommendedTools(String recomendedTools) {
		this.recommendedTools = recomendedTools;
	}

	/**
	 * @return the srcCity
	 */
	public String getSrcCity() {
		return srcCity;
	}

	/**
	 * @param srcCity
	 *            the srcCity to set
	 */
	public void setSrcCity(String srcCity) {
		this.srcCity = srcCity;
	}

	/**
	 * @return the dstCountry
	 */
	public List<String> getDstCountries() {
		return dstCountries;
	}

	/**
	 * @param dstCountries
	 *            the dstCountry to set
	 */
	public void setDstCountries(List<String> dstCountries) {
		this.dstCountries = dstCountries;
	}

	/**
	 * @return the dstCities
	 */
	public List<String> getDstCities() {
		return dstCities;
	}

	/**
	 * @param dstCities
	 *            the dstCities to set
	 */
	public void setDstCities(List<String> dstCities) {
		this.dstCities = dstCities;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MainTourInformation [name=" + super.getName() + "images=" + super.getImages() + ", isIranian=" + isIranian + ", type=" + getType() + ", duration="
				+ getDuration() + ", date=" + date + ", price=" + price + ", discountedPrice=" + discountedPrice
				+ ", services=" + services + ", signupRules=" + signupRules + ", requiredTools=" + requiredTools
				+ ", recommendedTools=" + recommendedTools + ", srcCity=" + srcCity + ", dstCountries=" + dstCountries
				+ ", dstCities=" + dstCities + "]";
	}
	
}
