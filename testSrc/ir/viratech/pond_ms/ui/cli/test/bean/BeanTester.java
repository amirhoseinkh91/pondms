package ir.viratech.pond_ms.ui.cli.test.bean;

import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.report.Report;
import ir.viratech.pond_ms.model.report.logic.ReportMgr;
import ir.viratech.pond_ms.model.review.Review;
import ir.viratech.pond_ms.model.review.logic.ReviewMgr;

/**
 * Created by amir on 9/7/17.
 */
public class BeanTester {
    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("========================== Started ===============================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");

        // ==================================================================
        // ==================================================================
        // ========================= add tester =============================
        // ==================================================================
        // ==================================================================
        /*
        System.out.println("add 5 data");
        for (int i = 0; i < 5; i++) {
            Review review = ReviewMgr.getInstance().createNew();
            ReviewMgr.getInstance().save(review);
        }
        */

        // ==================================================================
        // ==================================================================
        // ======================== list tester =============================
        // ==================================================================
        // ==================================================================
        /*
        System.out.println("listAll:");
        for (Review r: ReviewMgr.getInstance().list()) {
            System.out.println(r);
        }
        */

        // ==================================================================
        // ==================================================================
        // ========================= getByUID ===============================
        // ==================================================================
        // ==================================================================
        /*
        System.out.println("get By UID:");
        String uid = "97bb9619-c661-45a2-b39b-9e4a02f81d45";
        System.out.println(ReviewMgr.getInstance().getByUid(uid));
        */

        // ==================================================================
        // ==================================================================
        // ===================== update by uid tester =======================
        // ==================================================================
        // ==================================================================
        /*
        System.out.println("update by uid:");
        Review r = ReviewMgr.getInstance().getByUid(uid);
        r.setText("after update by uid");
        ReviewMgr.getInstance().update(r , uid);
        System.out.println(ReviewMgr.getInstance().getByUid(uid));
        */

        // ==================================================================
        // ==================================================================
        // ===================== update by object ===========================
        // ==================================================================
        // ==================================================================
        /*
        System.out.println("update by object:");
        r = ReviewMgr.getInstance().getByUid(uid);
        r.setText("after update by object");
        ReviewMgr.getInstance().update(r);
        System.out.println(ReviewMgr.getInstance().getByUid(uid));
        */
        // ==================================================================
        // ==================================================================
        // =========================== remove ===============================
        // ==================================================================
        // ==================================================================

        System.out.println("==================================================================");
        System.out.println("==================================================================");
        System.out.println("========================= Finished ===============================");
        System.out.println("==================================================================");
        System.out.println("==================================================================");

    }
}
