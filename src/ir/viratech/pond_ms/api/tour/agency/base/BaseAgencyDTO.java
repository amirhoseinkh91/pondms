package ir.viratech.pond_ms.api.tour.agency.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.viratech.pond_ms.api.tour.point.PointDTO;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

public class BaseAgencyDTO implements Serializable {

    protected ModelMapper modelMapper;

    public BaseAgencyDTO() {
        modelMapper = new ModelMapper();
    }

    @JsonProperty
    private String name;
    @JsonProperty
    private String address;
    @JsonProperty
    private String website;
    @JsonProperty
    private String phone;
    @JsonProperty
    private String image;
    @JsonProperty
    private PointDTO point;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PointDTO getPoint() {
        return point;
    }

    public void setPoint(PointDTO point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseAgencyDTO that = (BaseAgencyDTO) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (website != null ? !website.equals(that.website) : that.website != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (image != null ? !image.equals(that.image) : that.image != null) return false;
        return point != null ? point.equals(that.point) : that.point == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (website != null ? website.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (image != null ? image.hashCode() : 0);
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BaseAgencyDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", website='" + website + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", point=" + point +
                '}';
    }
}
