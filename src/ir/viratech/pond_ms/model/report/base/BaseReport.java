package ir.viratech.pond_ms.model.report.base;

import ir.viratech.mongo.model.AbstractMongoEntity;
import ir.viratech.pond_ms.model.report.Report;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by amir on 9/7/17.
 */
@Document(collection = BaseReportDAO.REPORT_COLLECTION)
public class BaseReport extends AbstractMongoEntity {

    public final static String PROP_objectUid = "objectUid";

    @Indexed
    private String objectUid;

    public String getObjectUid() {
        return objectUid;
    }

    public void setObjectUid(String objectUid) {
        this.objectUid = objectUid;
    }

    @Override
    public void init() {
        this.set__type(getType());
    }

    @Override
    protected Class getRefClass() {
        return Report.class;
    }

    public String getType() {
        return getRefClass().getSimpleName();
    }
}
