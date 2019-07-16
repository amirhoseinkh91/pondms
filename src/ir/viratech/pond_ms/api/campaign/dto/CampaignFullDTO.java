package ir.viratech.pond_ms.api.campaign.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.api.campaign.base.BaseCampaignFullDTO;
import ir.viratech.pond_ms.model.campaign.Campaign;


/**
 * A DTO for class Campaign.
 */
public class CampaignFullDTO extends BaseCampaignFullDTO {


    @Override
    protected JsonNode load_Days(Campaign campaign) {
        try {
            ArrayNode arrayJsonNode = JacksonUtils.createEmptyArrayNode();
            int counter = 1;
            while (counter < 19) {
                ObjectNode jsonNode = JacksonUtils.createEmptyObjectNode();
                jsonNode.put("day" + counter, getDays(counter, campaign));
                arrayJsonNode.add(jsonNode);
                counter++;
            }
            return arrayJsonNode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JacksonUtils.createEmptyObjectNode();
    }

    private Boolean getDays(int dayNumber, Campaign campaign) {
        switch (dayNumber) {
            case 1:
                return campaign.isDay01();
            case 2:
                return campaign.isDay02();
            case 3:
                return campaign.isDay03();
            case 4:
                return campaign.isDay04();
            case 5:
                return campaign.isDay05();
            case 6:
                return campaign.isDay06();
            case 7:
                return campaign.isDay07();
            case 8:
                return campaign.isDay08();
            case 9:
                return campaign.isDay09();
            case 10:
                return campaign.isDay10();
            case 11:
                return campaign.isDay11();
            case 12:
                return campaign.isDay12();
            case 13:
                return campaign.isDay13();
            case 14:
                return campaign.isDay14();
            case 15:
                return campaign.isDay15();
            case 16:
                return campaign.isDay16();
            case 17:
                return campaign.isDay17();
            case 18:
                return campaign.isDay18();
        }
        return false;
    }

    /**
     * FieldInfoContext for CampaignFullDTO
     */
    public static class FieldInfoContext extends BaseCampaignFullDTO.BaseFieldInfoContext {

    }

}
