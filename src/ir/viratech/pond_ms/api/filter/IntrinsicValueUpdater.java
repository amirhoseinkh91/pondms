package ir.viratech.pond_ms.api.filter;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.just_ro.model.errors.http.Error;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

@Path("/update")
public class IntrinsicValueUpdater extends BaseMongoQueries {

	@GET
	@Path("/{field}/{value}/{IntrinsicValue}")
	@Produces("text/html")
	public Response updateIntrinsicValue(@PathParam("field") String by, @PathParam("value") String value,
			@PathParam("IntrinsicValue") String intrinsicValue) {

		String message = "";
		try {
			if (by.equals("tag"))
				message = updateIntrinsicValue_ByTag(value, intrinsicValue);

			return Response.status(Error.OK_CODE).entity(message).build();
		} catch (NumberFormatException e) {
			return Response.status(Error.Internal_Server_Error_CODE).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(Error.Internal_Server_Error_CODE).entity(e.getMessage()).build();
		}

	}

	public String updateIntrinsicValue_ByTag(String tag, String intrinsicValue) {

		int counter = 0;

		final List<PointObject> pointsList = PointObjectDAO.getInstance().findAll();
		for (PointObject pointObject : pointsList) {
			EntityInstance formInstance = pointObject.getFormInstance("full", false);
			if (formInstance.has("Tags"))
				if (formInstance.get("Tags").asText().contains(ThingsToDoTagMapper(tag))) {
					formInstance.set("IntrinsicValue",
							formInstance.get("IntrinsicValue").asInt() + Integer.parseInt(intrinsicValue));
					counter++;
				}
		}
		return simpleHtmlMaker("h3", (counter + " objects by tag " + ThingsToDoTagMapper(tag) + " updated"));
	}

	@Override
	public String ThingsToDoTagMapper(String inputTag) {
		if (inputTag.equals(INPUT_TAG_SPORT_GAME))
			return SEARCH_TAG_HOBBY;

		if (inputTag.equals(INPUT_TAG_NATURE))
			return SEARCH_TAG_NATURE;

		if (inputTag.equals(INPUT_TAG_WATER))
			return SEARCH_TAG_WATER_SPORTS;

		if (inputTag.equals(INPUT_TAG_SHOPPING_CENTER))
			return SEARCH_TAG_SHOPPING_FASHION;

		if (inputTag.equals(INPUT_TAG_MUSEMN))
			return SEARCH_TAG_MUSEMN;

		if (inputTag.equals(INPUT_TAG_THEATER_CINEMA))
			return SEARCH_TAG_ART_CULTURE;

		if (inputTag.equals(INPUT_TAG_MOUNTAIN_CLIMBING))
			return SEARCH_TAG_MOUNTAIN_CLIMBING;

		if (inputTag.equals(INPUT_TAG_RELIGIOUS_PLACES))
			return SEARCH_TAG_RELIGIOUS;

		if (inputTag.equals(INPUT_TAG_HISTORICAL_PLACES))
			return SEARCH_TAG_CULTURAL_HERITAGE;

		if (inputTag.equals(INPUT_TAG_AQUARIUM))
			return SEARCH_TAG_AQUARIUM;

		if (inputTag.equals(INPUT_TAG_AMUSEMENT_PLACES))
			return SEARCH_TAG_AMUSEMENT_PLACES;

		return inputTag;
	}

	private String simpleHtmlMaker(String htmlTag, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<body>");
		builder.append("<" + htmlTag + ">");
		builder.append(message);
		builder.append("</" + htmlTag + ">");
		builder.append("</body>");
		builder.append("</html>");

		return builder.toString();
	}

}
