package ir.viratech.pond_ms.api.tour.tour.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;

import ir.viratech.pond_ms.api.tour.tour.base.BaseTourResource;
import ir.viratech.pond_ms.api.tour.tour.dto.TourFullDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourLightDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourMediumDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourSaverDTO;
import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.CustomerInput;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.TourMgr;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

@Path(BaseTourResource.PATH)
public class TourResource extends BaseTourResource {

	@POST
	@Path("/items")
	public Response add(TourSaverDTO saverDTO) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.ADD + "_" + EntityFeatureNames.TOUR)) {
			try {
				Tour tour = super.save(TourSaverDTO.convertToEntity(saverDTO));
				return Response.ok().entity(TourLightDTO.convertToLightDTO(tour)).build();
			} catch (Exception e) {
				e.printStackTrace();
				return Response.serverError().entity("{\"msg:\"" + "\" " +  e.getMessage() +"\"}").build();
			}
		} else {
			return redirectTo403Page();
		}
	}

	@POST
	@Path("/{uid}/day/{dayNumber}")
	public Response addDay(@PathParam("uid") String tourUid, @PathParam("dayNumber") Integer dayNumber,
						   @RequestBody String dayInput) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.ADD + "_" + EntityFeatureNames.TOUR)) {
			try {
				super.addDayToTour(tourUid, dayNumber, dayInput);
				return Response.ok().build();
			} catch (JSONException e) {
				return Response.serverError().entity(e.getMessage()).build();
			}
		} else {
			return redirectTo403Page();
		}
	}

	@GET
	@Path("/cities/items")
	public Response getCities(@QueryParam("srcCity") String srcCity) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.LIST + "_" + EntityFeatureNames.TOUR)){
			if (srcCity == null)
				return Response.ok().entity(TourMgr.getInstance().getSrcCities()).build();
			else
				return  Response.ok().entity(TourMgr.getInstance().getDstCities(srcCity)).build();
		} else {
			return redirectTo403Page();
		}
	}

	@GET
	@Path("/filter/items")
	public Response filter(@BeanParam CustomerInput input) {
		return super.extentHandler_List(input);
	}

	@GET
	@Path("/items")
	public Response getAll(@BeanParam CustomerInput input) {
		return super.extentHandler_List(input);
	}

	@GET
	@Path("/items/{uid}")
	public Response get(@PathParam("uid") String uid) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.VIEW + "_" + EntityFeatureNames.TOUR)) {
			Tour tour = TourMgr.getInstance().getByUid(uid);
			if (isTourAvailable(tour))
				return Response.ok().entity(new TourFullDTO().convertToFullDTO(tour)).build();
			else
				return Response.noContent().build();
		} else {
			return redirectTo403Page();
		}
	}

	@DELETE
	@Path("/items/{uid}")
	public Response delete(@PathParam("uid") String uid, @QueryParam("day") Integer day) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.DELETE + "_" + EntityFeatureNames.TOUR)) {
			if (day == null)
				TourMgr.getInstance().delete(uid);
			if (day != null)
				TourMgr.getInstance().deleteDay(uid, day);
			return Response.noContent().build();
		} else {
			return redirectTo403Page();
		}
	}

	/*
	 * this is for sysadmin role
	 */
	@POST
	@Path("/items/{uid}")
	public Response update(@PathParam("uid") String uid, @RequestBody TourFullDTO tourFullDTO) {
		// TODO what is update now?!!
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
				Feature.EntityAccessKey.EDIT + "_" + EntityFeatureNames.TOUR)) {
			System.out.println(tourFullDTO);
			System.out.println((Tour) new TourFullDTO().map(tourFullDTO, Tour.class));
			TourMgr.getInstance().update((Tour) new TourFullDTO().map(tourFullDTO, Tour.class) , uid);
			return Response.ok().entity((TourFullDTO) new TourFullDTO().map(TourMgr.getInstance().getByUid(uid) , TourFullDTO.class)).build();
		} else {
			return redirectTo403Page();
		}
	}

	/*
	 * this is for agency role
	 */
	@POST
	@Path("/{uid}")
	public Response update(@PathParam("uid") String uid, @RequestBody TourSaverDTO saverDTO) {
		if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), Feature.EntityAccessKey.EDIT+"_"+ EntityFeatureNames.TOUR)) {
			TourMgr.getInstance().update((Tour) new TourSaverDTO().map(saverDTO, Tour.class) , uid);
			return Response.ok().entity(TourMediumDTO.convertToMediumDTO(TourMgr.getInstance().getByUid(uid))).build();
		} else {
			return redirectTo403Page();
		}
	}

}
