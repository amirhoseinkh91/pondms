package ir.viratech.pond_ms.api.tour.tourGuide.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.modelmapper.ModelMapper;

import java.io.Serializable;

public class BaseTourGuideDTO implements Serializable{

    protected ModelMapper modelMapper;
    protected BaseTourGuideDTO() {
        modelMapper = new ModelMapper();
    }

    @JsonProperty
    private String name;
    @JsonProperty
    private String phoneNumber;
    @JsonProperty
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
