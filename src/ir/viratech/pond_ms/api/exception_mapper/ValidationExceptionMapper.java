package ir.viratech.pond_ms.api.exception_mapper;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.pond_ms.api.model.UIMetadata;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException>{
	private static final Logger logger = Logger.getLogger(ValidationExceptionMapper.class);

	@Override
	public Response toResponse(ValidationException validationExceptionMessage) {

		if(logger.isDebugEnabled()){
			logger.debug("Exception catched in ValidationExceptionMapper", validationExceptionMessage);
		}

		List<String> localizedValidationExceptionMsg=new ArrayList<String>();
		for (ValidationErrorEntry error : validationExceptionMessage.getErrorList()) {
			localizedValidationExceptionMsg.add(error.getDescription());
		}
		ObjectNode res = new ObjectNode(JsonNodeFactory.instance);
		res.set("UI_Metadata", UIMetadata.buildMessage(localizedValidationExceptionMsg.toString(), "error"));
		return  Response.status(Response.Status.NOT_ACCEPTABLE).entity(res).build();

	}

}






