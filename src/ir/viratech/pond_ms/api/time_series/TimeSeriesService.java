package ir.viratech.pond_ms.api.time_series;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.time_series.dto.AddTimeSeriesRequestDTO;
import ir.viratech.pond_ms.api.time_series.dto.CategoryLightDTO;
import ir.viratech.pond_ms.api.time_series.handler.AddTimeSeriesRequestHandler;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.GISVectorObjectMgr;
import ir.viratech.pond_ms.model.time_series.RootCategory;

@Api(value = "/time series", description = "Operations about time series")
@Path("/time-series")
public class TimeSeriesService {

	private MessageTranslator messageTranslator = MessageService.getMessageTranslator();

	public MessageTranslator getMessageTranslator() {
		return messageTranslator;
	}

	
	@POST
	@Path("/add")
	public Response addTimeSeriesToPond(AddTimeSeriesRequestDTO dto) throws RequestHandlingException
	{
		//TODO : check access
		return new AddTimeSeriesRequestHandler(dto).handle();
	}
	
	@GET
	@Path("/get/{uid}")
	public Response getTimeSeries(@PathParam("uid") String uid) {
		//TODO Access!
		Set<RootCategory> rootCategories = null;

		Pond pond = PondMgr.getInstance().getByExtuid(uid);
		GISVectorObject vector = GISVectorObjectMgr.getInstance().getByExtuid(uid);
		if (pond != null) {
			rootCategories = pond.getTimeSeriesRootCategories();
		}
		else if (vector != null) {
			rootCategories = vector.getTimeSeriesRootCategories();
		}
		else			
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("pond.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		List<CategoryLightDTO> result = new ArrayList<>();
		for (RootCategory rc: rootCategories) {
			CategoryLightDTO dto = new CategoryLightDTO();
			dto.loadFrom(rc);
			result.add(dto);
		}
		return Response.ok().entity(result).build();
	}
}
