package ir.viratech.pond_ms.api.campaign.dto;

import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.util.date.DateUtil;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.api.campaign.base.BaseCampaignFlagUpSaveDTO;
import ir.viratech.pond_ms.model.campaign.Campaign;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A DTO for class Campaign.
 */
public class CampaignFlagUpSaveDTO extends BaseCampaignFlagUpSaveDTO {

    private static final String START_DATE = "2019-03-15";

    @Override
    protected void save_Flag_up(Campaign campaign, boolean flag_up) throws BadDtoEntityModificationException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(MyDateUtils.now());
            Date now = formatter.parse(format);
            Date startDate = formatter.parse(START_DATE);
            int dateDiff = MyDateUtils.dayDifferenceWithoutAbs(startDate, now);
            if (dateDiff >= 0 && dateDiff <= 17) {
                switch (dateDiff) {
                    case 0:
                        campaign.setDay01(true);
                        break;
                    case 1:
                        campaign.setDay02(true);
                        break;
                    case 2:
                        campaign.setDay03(true);
                        break;
                    case 3:
                        campaign.setDay04(true);
                        break;
                    case 4:
                        campaign.setDay05(true);
                        break;
                    case 5:
                        campaign.setDay06(true);
                        break;
                    case 6:
                        campaign.setDay07(true);
                        break;
                    case 7:
                        campaign.setDay08(true);
                        break;
                    case 8:
                        campaign.setDay09(true);
                        break;
                    case 9:
                        campaign.setDay10(true);
                        break;
                    case 10:
                        campaign.setDay11(true);
                        break;
                    case 11:
                        campaign.setDay12(true);
                        break;
                    case 12:
                        campaign.setDay13(true);
                        break;
                    case 13:
                        campaign.setDay14(true);
                        break;
                    case 14:
                        campaign.setDay15(true);
                        break;
                    case 15:
                        campaign.setDay16(true);
                        break;
                    case 16:
                        campaign.setDay17(true);
                        break;
                    case 17:
                        campaign.setDay18(true);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * FieldInfoContext for CampaignFlagUpSaveDTO
     */
    public static class FieldInfoContext extends BaseCampaignFlagUpSaveDTO.BaseFieldInfoContext {

    }

}
