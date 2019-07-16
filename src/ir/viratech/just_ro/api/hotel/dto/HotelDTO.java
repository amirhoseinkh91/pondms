package ir.viratech.just_ro.api.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by justro on 2/11/18.
 */
public class HotelDTO {

    @JsonProperty("Websites")
    private List<WebsiteDTO> websites;
    @JsonProperty("websiteCount")
    private Integer websiteCount;
    @JsonProperty("Uid")
    private String uId;



    public List<WebsiteDTO> getWebsites() {
        return websites;
    }

    public void setWebsites(List<WebsiteDTO> websites) {
        this.websites = websites;
    }

    public Integer getWebsiteCount() {
        return websiteCount;
    }

    public void setWebsiteCount(Integer websiteCount) {
        this.websiteCount = websiteCount;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}
