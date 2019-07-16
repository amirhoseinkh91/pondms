package ir.viratech.pond_ms.model.tour_relations.tour.base;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.mongodb.logic.AbstractMongodbMgr;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.dao.TourDAO;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.TourMgr;

import java.util.List;

public class BaseTourMgr extends AbstractMongodbMgr<Tour>{

    public static final TourMgr getInstance() {
        return new TourMgr();
    }

    @Override
    public Tour createNew() {
        return (Tour) ApplicationContextProvider.getInitializedApplicationContext().getBean(Tour.class);
    }

    @Override
    protected TourDAO getDAO() {
        return new TourDAO();
    }

    @Override
    public void save(Tour tour) {
        this.getDAO().add(tour);
    }

    public Tour saveAndReturn(Tour tour) {
        return this.getDAO().addAndReturn(tour);
    }

    @Override
    public void update(Tour tour) {
        this.getDAO().update(tour);
    }

    @Override
    public void update(Tour tour, String uid) {
        this.getDAO().update(uid, tour);
    }

    @Override
    public void remove(Tour tour) {
        this.getDAO().remove(tour);
    }

    @Override
    public void remove(String uid) {
        this.getDAO().remove(uid);
    }

    @Override
    public Tour getByUid(String uid) {
        // TODO add getByUID for new modeling...
        return this.getDAO().getByUid(uid);
    }

    @Override
    public List<Tour> list() {
        return this.getDAO().getAll();
    }

    @Override
    public List<Tour> list(Integer start, Integer len) {
        return this.getDAO().getAll(start, len);
    }
}
