package ir.viratech.pond_ms.api.tour.tour.base;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import ir.viratech.just_ro.model.calendar.CalendarTool;
import ir.viratech.just_ro.model.errors.http.Error;
import ir.viratech.pond_ms.api.AbstractMongoObjectResource;
import ir.viratech.pond_ms.api.tour.day.base.BaseStepObjectsDTO;
import ir.viratech.pond_ms.api.tour.day.dto.DayObjectDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourFullDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourLightDTO;
import ir.viratech.pond_ms.api.tour.tour.dto.TourMediumDTO;
import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.CustomerInput;
import ir.viratech.pond_ms.model.tour_relations.tour.DayTourObject;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.TourMgr;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BaseTourResource extends AbstractMongoObjectResource<Tour> {

    public static final String PATH = "/tour";

    @Override
    public Tour save(Tour tour) {
        return TourMgr.getInstance().saveAndReturn(tour);
    }

    @Override
    public Tour update(Tour tour) {
        return null;
    }

    @Override
    public List<Tour> list(Integer start, Integer len) {
        return null;
    }

    @Override
    public Tour getByUid(String uid) {
        return null;
    }

    @Override
    public void remove(String uid) {

    }

    public void addDayToTour(String tourUid, Integer dayNumber, String dayInput) throws JSONException {
        List<BaseStepObjectsDTO> list = new DayObjectDTO().convert(new JSONObject(dayInput));
        DayObjectDTO dayObjectDTO = new DayObjectDTO();
        dayObjectDTO.setDayObjects(list);
        DayTourObject dayTourObject = (DayTourObject) dayObjectDTO.map(dayObjectDTO, DayTourObject.class);
        TourMgr.getInstance().addOrUpdateDay(tourUid, dayTourObject, dayNumber);
    }

    public List<Tour> filterTours(CustomerInput input) {
        return TourMgr.getInstance().getAll(input);
    }

    protected Response extentHandler_List(CustomerInput input) {
        if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
                Feature.EntityAccessKey.LIST + "_" + EntityFeatureNames.TOUR)) {
            List<Tour> tours = this.filterTours(input);

            if (AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(),
                    Feature.EntityAccessKey.MANAGEMENT + "_" + EntityFeatureNames.TOUR)) {
                try {
                    if (input.getExtent().equals("full")) {
                        return Response.ok().entity(new TourFullDTO().convertToFullDTO(tours)).build();
                    } else if (input.getExtent().equals("medium")) {
                        return Response.ok().entity(TourMediumDTO.convertToMediumDTO(tours)).build();
                    } else if (input.getExtent().equals("light")) {
                        return Response.ok().entity(TourLightDTO.convertToLightDTO(tours)).build();
                    } else
                        return Response.status(Error.Bad_Request_CODE).build();
                } catch (NullPointerException e) {
                    return Response.ok().entity(TourLightDTO.convertToLightDTO(tours)).build();
                }
            } else {
                List<Tour> availableTours = checkDateValidation(tours);
                return Response.ok().entity(TourMediumDTO.convertToMediumDTO(availableTours)).build();
            }
        } else {
            return redirectTo403Page();
        }

    }

    protected List<Tour> checkDateValidation(List<Tour> tours) {
        List<Tour> availableTours = new ArrayList<>();
        if (tours.size() > 0)
            for (int i = 0; i < tours.size(); i++)
                if (isTourAvailable(tours.get(i)))
                    availableTours.add(tours.get(i));
        return availableTours;
    }

    protected boolean isTourAvailable(Tour tour) {
        CalendarTool calendarTool = new CalendarTool();
        String today = calendarTool.getIranianToday();
        try {
            if (Integer.parseInt(tour.getMainInformation().getDate().replaceAll("/", "")) >= Integer.parseInt(today.replaceAll("/", "")))
                return true;
            else
                return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

}
