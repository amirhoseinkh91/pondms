package ir.viratech.pond_ms.ui.cli.testdao;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.tour_relations.tour.Tour;
import ir.viratech.pond_ms.model.tour_relations.tour.logic.TourMgr;

import java.util.List;

public class TestMongoDAO {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();

//        TestDAO dao = new TestDAO();
//        Review r = ReviewMgr.getInstance().createNew();
//        r.setEnabled(true);
//
//        r.setMonthVisited(new Date());
//        r.setTitle("this is test now in main right here");
//        r.setObjectUid("objectUid");
//        dao.save(r);

       /* String uid = "86154630-b527-4a32-a2ad-655998e6f763";

        System.out.println(ReviewMgr.getInstance().countAll());

       for (Review r : ReviewMgr.getInstance().list() ) {
           System.out.println(r);
           r.setEnabled(false);
       }

        System.out.println("======================== create new ========================");
        System.out.println(ReviewMgr.getInstance().createNew());*/
        new TestMongoDAO().testTourList();
    }

    private void testTourList() {
        System.out.println("======================================");
        System.out.println("======================================");

        List<Tour> tours = TourMgr.getInstance().list();
        String uid = null;
        for (int i = 0; i < tours.size(); i++) {
            Tour tour = tours.get(i);
            if (i ==0)
                uid = tour.getUid();
            System.out.printf("TourName: %s, TotalScore: %d\n" , tour.getMainInformation().getName(), tour.getTotalScore());
        }

        System.out.println("now deleting tour number 1 with uid:" + uid);
        TourMgr.getInstance().delete(uid);

        tours = TourMgr.getInstance().list();
        for (Tour t : tours) {
            System.out.println("uid: " + uid + ", deleted: " + t.isDeleted());
        }

        System.out.println("======================================");
        System.out.println("======================================");
    }
}
