package ir.viratech.pond_ms.api.campaign;

import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.utils.MyDateUtils;
import ir.viratech.pond_ms.api.campaign.dto.CampaignFullDTO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.campaign.Campaign;
import ir.viratech.pond_ms.model.campaign.logic.CampaignMgr;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.user.User;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

@Path("/campaign")
@SuppressWarnings("Duplicates")
public class CampaignService extends AbstractJsonService {
    private static final String START_DATE = "2019-03-14";

    @GET
    @Path("join")
    public Response signUpToCampaign(@QueryParam("destination") String destination, @QueryParam("device_os") String deviceOs) {
        try {
            User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
            if (user != null) {
                Customer customer = user.getCustomer();
                Campaign useId = CampaignMgr.getInstance().getByUseId(customer.getExtuid());
                if (useId == null) {
                    Campaign campaign = CampaignMgr.getInstance().createNew();
                    campaign.setUseId(customer.getExtuid());
                    campaign.setPhone_num(customer.getPhoneNumber());
                    campaign.setDestination(destination);
                    if (!StringUtils.isEmpty(deviceOs)) {
                        campaign.setDevice_name(deviceOs);
                    }
                    CampaignMgr.getInstance().add(campaign);
                    return Response.ok(DtoUtil.createAndLoadDto(CampaignFullDTO.class, campaign)).build();
                }
                return Response.ok(DtoUtil.createAndLoadDto(CampaignFullDTO.class, useId)).build();
            }
            return Response.status(401).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).build();
        }
    }

    @GET
    @Path("/flag-up")
    public Response flagUp() {
        try {
            User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
            if (user != null) {
                Customer customer = user.getCustomer();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String format = formatter.format(MyDateUtils.now());
                Date now = formatter.parse(format);
                Date startDate = formatter.parse(START_DATE);
                int dateDiff = MyDateUtils.dayDifferenceWithoutAbs(startDate, now);
                if (dateDiff < 0) {
                    return Response.status(406).build();
                }
                Campaign campaign = CampaignMgr.getInstance().getByUseId(customer.getExtuid());
                setFlagUpDay(campaign, startDate, now);
                CampaignMgr.getInstance().update(campaign);
                return Response.ok(DtoUtil.createAndLoadDto(CampaignFullDTO.class, campaign)).build();
            }
            return Response.status(401).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).build();
        }
    }

    @GET
    @Path("/get-user")
    public Response getUser(@QueryParam("userId") String userId) {
        try {
            User user = ApplicationContextUtil.getCurrentExecutionContext().getUser();
            if (user != null) {
                Customer customer = user.getCustomer();
                Campaign campaign = CampaignMgr.getInstance().getByUseId(customer.getExtuid());
                if (campaign == null) {
                    return Response.status(406).build();
                }
                return Response.ok(DtoUtil.createAndLoadDto(CampaignFullDTO.class, campaign)).build();
            }
            return Response.status(401).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).build();
        }
    }

    private void setFlagUpDay(Campaign campaign, Date startDate, Date now) {
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
    }
}
