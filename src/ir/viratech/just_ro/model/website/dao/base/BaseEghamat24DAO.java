package ir.viratech.just_ro.model.website.dao.base;

import ir.viratech.just_ro.model.website.dao.Eghamat24DAO;
import ir.viratech.pond_ms.api.filter.BaseMongoQueries;

/**
 * Created by amir on 8/31/17.
 */
public class BaseEghamat24DAO  extends BaseMongoQueries{

    public Eghamat24DAO getInstance(){
        return new Eghamat24DAO();
    }

}
