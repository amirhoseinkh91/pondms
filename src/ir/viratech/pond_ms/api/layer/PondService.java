package ir.viratech.pond_ms.api.layer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.layer.dto.DataFileDTO;
import ir.viratech.pond_ms.api.time_series.dto.CategoryLightDTO;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

@Api(value = "/pond", description = "Operations about ponds")
@Path("/pond")
public class PondService extends AbstractJsonService {

	private MessageTranslator messageTranslator = MessageService.getMessageTranslator();

	public MessageTranslator getMessageTranslator() {
		return messageTranslator;
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @param requestDto
	 *            contains file data
	 * @throws RequestHandlingException
	 *
	 */
	@GET
	@Path("/form-keys")
	public Response getPondFormKeys(DataFileDTO requestDto) throws RequestHandlingException {
		// TODO Access Checker
		return Response.ok().entity(Pond.getFormSchemaKeys()).build();
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *
	 */
	@GET
	@Path("/form-instance/{pond_uid}")
	public Response getPondFormInstance(@PathParam("pond_uid") String pondUid, @QueryParam("form_key") String formKey)
			throws RequestHandlingException {
		if (formKey.endsWith("SECRET") && !AccessChecker.hasAccessToAny(FeatureNames.SEE_SECRET_POND_FORMS))
			return Response.status(Status.FORBIDDEN).build();
		EntityInstance result = PondMgr.getInstance().getFormInstance(pondUid, formKey);
		return Response.ok().entity(result).build();
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 */
	@POST
	@Path("/form-instance/{pond_uid}")
	public Response setPondFormInstance(@PathParam("pond_uid") String pondUid, @QueryParam("form_key") String formKey,
			EntityInstance formInstance)
			throws RequestHandlingException {
		if (formKey.endsWith("SECRET") && !AccessChecker.hasAccessToAny(FeatureNames.EDIT_SECRET_POND_FORMS))
			return Response.status(Status.FORBIDDEN).build();
		EntityInstance result = PondMgr.getInstance().setFormInstance(pondUid, formKey, formInstance);
		return Response.ok().entity(result).build();
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 */
	@GET
	@Path("/time-series/{pond_uid}")
	public Response getTimeSeriesRootCategories (@PathParam("pond_uid") String pondUid) {
		//TODO Access!
		Pond pond = PondMgr.getInstance().getByExtuid(pondUid);
		if (pond == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("pond.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		Set<RootCategory> rootCategories = pond.getTimeSeriesRootCategories();
		List<CategoryLightDTO> result = new ArrayList<>();
		for (RootCategory rc: rootCategories) {
			CategoryLightDTO dto = new CategoryLightDTO();
			dto.loadFrom(rc);
			result.add(dto);
		}
		return Response.ok().entity(result).build();
	}

}
