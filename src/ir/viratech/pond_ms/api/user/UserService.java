package ir.viratech.pond_ms.api.user;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.commons.util.password.PasswordException;
import ir.viratech.commons.util.password.PasswordUtility;
import ir.viratech.commons.util.password.PasswordUtility.HashAlgorithm;
import ir.viratech.commons.util.password.PasswordUtility.Threshold;
import ir.viratech.pond_ms.api.auth.MyUserDetailsService;
import ir.viratech.pond_ms.api.user.dto.ChangePasswordDTO;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.logic.UserMgr;

@Path("/user")
@Api(value = "/user", description = "User services")
public class UserService extends AbstractJsonService {

	@Autowired
	@Qualifier("serverPasswordEncoder")
	private PasswordEncoder serverPasswordEncoder;


	@POST
	@Path("/change_password")
	@ApiOperation(value = "change user password")
	public Response changePassword(ChangePasswordDTO changePasswordDTO) {

		String oldPassword = changePasswordDTO.getOldPassword();
		String newPassword = changePasswordDTO.getNewPassword();

		User user = MyUserDetailsService.getCurrentUserAttached();

		PasswordUtility utility = new PasswordUtility();
		utility.addWhiteSpaceRule();
		utility.addLengthRule(5, 50);
        utility.addCheckOldPasswordRule(oldPassword, user.getPassword(), serverPasswordEncoder);

		Threshold threshold = Threshold.valueOf(ApplicationContextUtil.getProperty("password.strong.threshold"));
		utility.addPowerRule(threshold);

		MessageTranslator messageTranslator = MessageService.getMessageTranslator();
		try {
			utility.validatePassword(newPassword);
			UserMgr.getInstance().updatePassword(user, newPassword, serverPasswordEncoder);
			return Response
					.ok(UI_MetadataDTO.createWith_i18n("password.change.success", MessageType.SUCCESS, messageTranslator))
					.build();
		} catch (PasswordException e) {
			return Response
					.status(Status.NOT_ACCEPTABLE)
					.entity(UI_MetadataDTO.createWith_i18n(e.getMessage(), MessageType.ERROR, messageTranslator))
					.build();
		}
	}
}
