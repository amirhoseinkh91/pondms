package ir.viratech.pond_ms.api.customer;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.DtoUtil;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.user_verification.core.UserSmsVerificationManager;
import ir.viratech.commons.user_verification.core.exception.SmsSendingProblemException;
import ir.viratech.commons.util.jackson.ObjectMapperProvider;
import ir.viratech.pond_ms.api.customer.dto.AppConfigDTO;
import ir.viratech.pond_ms.api.customer.dto.ProfileDTO;
import ir.viratech.pond_ms.api.customer.dto.UserPhoneVerificationDTO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.core.web_client.WebPageReader;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.CustomerGenders;
import ir.viratech.pond_ms.model.customer.logic.CustomerMgr;
import ir.viratech.pond_ms.model.user.logic.UserMgr;


@Path("cu/v1")
public class CustomerService extends AbstractJsonService{

    @Autowired
    private UserSmsVerificationManager userSmsVerificationManager;

    @POST
	@Path("phone_verification")
	public void sendPhoneVerificationCode(UserPhoneVerificationDTO userPhoneVerificationDTO){
		try {
			userSmsVerificationManager.sendVerificationCode(userPhoneVerificationDTO.getPhoneNumber());
		} catch (SmsSendingProblemException e) {
			e.printStackTrace();
			throw new RuntimeException("A problem occurred in sending verification code", e);
		}
	}

	//27
	@GET
	@Path("profile")
	public ProfileDTO getProfile(){
		return DtoUtil.createAndLoadDto(ProfileDTO.class, ApplicationContextUtil.getCurrentExecutionContext().getCustomer());
	}

	//27
	@POST
	@Path("profile")
	public ProfileDTO setProfile(ProfileDTO profileDTO){
		Customer customer = ApplicationContextUtil.getCurrentExecutionContext().getCustomer();
		if(!StringUtils.isEmpty(profileDTO.getGender())
				&& !CustomerGenders.FEMALE.equals(profileDTO.getGender())
				&& !CustomerGenders.MALE.equals(profileDTO.getGender())
				&& !CustomerGenders.NONE.equals(profileDTO.getGender()))
			throw new ResponseException(Response.status(Status.NOT_ACCEPTABLE).build());
		if(!StringUtils.isEmpty(profileDTO.getAvatarHash())
				&& AbstractFileMgr.getInstance().getByHashCodeString(profileDTO.getAvatarHash()) == null)
			throw new ResponseException(Response.status(Status.NOT_ACCEPTABLE).build());
		CustomerMgr.getInstance().update(customer, profileDTO);
		return DtoUtil.createAndLoadDto(ProfileDTO.class, customer);
	}

	@GET
	@Path("profile/user")
	public ProfileDTO getSepecifucUserProgile(@QueryParam("userUid") String user_uid) {
		return DtoUtil.createAndLoadDto(ProfileDTO.class, UserMgr.getInstance().getByExtuid(user_uid).getCustomer());
	}

	@GET
	@Path("flight/all")
	public JsonNode getAllFlights(@QueryParam("from_date") String fromDate,@QueryParam("to_date") String toDate) throws IOException {
		String serverUrl = ApplicationContextUtil.getProperty("ghasedak24.flightSearchUrl");
		String username = ApplicationContextUtil.getProperty("ghasedak24.username");
		String password = ApplicationContextUtil.getProperty("ghasedak24.password");
		String url = serverUrl + "?fromDate=" + fromDate + "&toDate=" + toDate + "&userName=" + username + "&password=" + password;
		String jsonNodeText = WebPageReader.readResponse(url);
		return ObjectMapperProvider.getObjectMapper().readTree(jsonNodeText);
	}

}
