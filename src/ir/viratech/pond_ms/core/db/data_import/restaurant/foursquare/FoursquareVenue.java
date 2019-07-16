package ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare;

import java.util.List;

public class FoursquareVenue {

    private FoursquarePhoto foursquarePhoto;
    private String id;
    private String name;
    private FoursquareContact contact;
    private FoursquareLocation location;
    private List<FoursquareCategory> categories;
    private Boolean verified;
    private FoursquareStats stats;
    private FoursquarePrice price;
    private Boolean allowMenuUrlEdit;
    private String url;
    private Double rating;
    private Boolean hasMenu;
    private FoursquareHours hours;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoursquareContact getContact() {
        return contact;
    }

    public void setContact(FoursquareContact contact) {
        this.contact = contact;
    }

    public FoursquareLocation getLocation() {
        return location;
    }

    public void setLocation(FoursquareLocation location) {
        this.location = location;
    }

    public List<FoursquareCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<FoursquareCategory> categories) {
        this.categories = categories;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public FoursquareStats getStats() {
        return stats;
    }

    public void setStats(FoursquareStats stats) {
        this.stats = stats;
    }

    public FoursquarePrice getPrice() {
        return price;
    }

    public void setPrice(FoursquarePrice price) {
        this.price = price;
    }

    public Boolean getAllowMenuUrlEdit() {
        return allowMenuUrlEdit;
    }

    public void setAllowMenuUrlEdit(Boolean allowMenuUrlEdit) {
        this.allowMenuUrlEdit = allowMenuUrlEdit;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(Boolean hasMenu) {
        this.hasMenu = hasMenu;
    }

    public FoursquareHours getHours() {
        return hours;
    }

    public void setHours(FoursquareHours hours) {
        this.hours = hours;
    }


    public FoursquarePhoto getFoursquarePhoto() {
        return foursquarePhoto;
    }

    public void setFoursquarePhoto(FoursquarePhoto foursquarePhoto) {
        this.foursquarePhoto = foursquarePhoto;
    }
}
