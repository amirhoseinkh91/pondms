package ir.viratech.pond_ms.core.db.data_import.restaurant.foursquare;

public class FoursquareContact {

    private String phone;
    private String formattedPhone;
    private String twitter;

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFormattedPhone() {
        return formattedPhone;
    }

    public void setFormattedPhone(String formattedPhone) {
        this.formattedPhone = formattedPhone;
    }

}
