package ir.viratech.pond_ms.model.tour_relations.tour.logic;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.CustomerInput;
import ir.viratech.pond_ms.model.tour_relations.tour.DayTourObject;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.base.BaseTourMgr;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class TourMgr extends BaseTourMgr {

    @Override
    public Tour createNew() {
        Tour t = (Tour) ApplicationContextProvider.getInitializedApplicationContext().getBean(Tour.class);
        return this.initialize(t);
    }

    public Tour addOrUpdateDay(String tourUid, DayTourObject dayTourObject, Integer dayNumber) {
        Tour tour = getByUid(tourUid);
        return this.addOrUpdateDay(tour, dayTourObject, dayNumber);
    }

    public Tour addOrUpdateDay(Tour tour, DayTourObject dayTourObject, Integer dayNumber) {
        if (dayNumber != null ) {
            try {
                if (tour.getDays().size() <= dayNumber)
                    this.addDay(tour,dayTourObject,dayNumber);
                else
                    this.updateDay(tour,dayTourObject,dayNumber);
            } catch (NullPointerException e) {
                this.addDay(tour,dayTourObject,dayNumber);
            }
        } else {
            this.addDay(tour,dayTourObject,dayNumber);
        }
        this.update(tour);
        return tour;
    }

    public void addDay (Tour tour, DayTourObject dayTourObject, Integer dayNumber) {
        if (dayNumber != null) {
            tour.addDay(dayTourObject.getObjects(), dayNumber);
        }
        else
            tour.addDay(dayTourObject.getObjects());
    }

    public void updateDay (Tour tour, DayTourObject dayTourObject, Integer dayNumber) {
        if (dayNumber != null) {
            tour.removeDay(dayNumber);
            tour.addDay(dayTourObject.getObjects(), dayNumber);
        }
    }

    public void updateDay (String tourUid, DayTourObject dayTourObject, Integer dayNumber) {
        this.updateDay(this.getByUid(tourUid), dayTourObject, dayNumber);
    }

    public List<Tour> getAll (CustomerInput customerInput) {
        return this.getDAO().getAll(customerInput);
    }

    public Tour deleteDay (String tourUid , Integer dayNumber) {
        Tour tour = this.getByUid(tourUid);
        if (dayNumber != null)
            tour.removeDay(dayNumber - 1);
        this.update(tour);
        return tour;
    }

    public Set<String> getSrcCities () {
        return this.getDAO().getSrcCities();
    }

    public  Set<String> getDstCities(String srcCity) {
        return this.getDAO().getDstCities(srcCity);
    }

    public Tour initialize(Tour tour) {
        tour.setCreator(ApplicationContextUtil.getCurrentExecutionContext().getUsername());
        tour.setCreationDate(new Date());
        tour.setId(new ObjectId());
        tour.setUid(this.getDAO().generateUid());
        return tour;
    }

    public Tour initialize() {
        return this.initialize(TourMgr.getInstance().createNew());
    }

    public void delete(String uid) {
        this.delete(getByUid(uid));
    }

    public void delete(Tour tour) {
        this.getDAO().delete(tour);
    }
}
