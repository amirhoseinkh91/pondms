package ir.viratech.pond_ms.model.review;

import java.text.SimpleDateFormat;
import java.util.Date;

import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.utils.DatePrettyPrintConverter;
import ir.viratech.pond_ms.model.review.base.BaseReview;
import ir.viratech.pond_ms.model.review.dao.ReviewVoteDAO;

/**
 * The entity class "Review".
 */

public class Review extends BaseReview implements UIDAndDisplayStringProvider {
    private static final long serialVersionUID = 1L;


    @Override
    public String getDisplayString() {
        return getTitle();
    }

    public String getCreationDateString() {
        return DatePrettyPrintConverter.convertToPrerttyString(getCreationDate());
    }

    public String getVisitedDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(getVisitedDate());
    }

    public String getLastModifiedDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(getLastModifiedDate());
    }

    public long getVoteUpCount() {
        return ReviewVoteDAO.getInstance().getVoteUpCount(this);
    }

    public long getVoteDownCount() {
        return ReviewVoteDAO.getInstance().getVoteDownCount(this);
    }
}