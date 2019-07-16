package ir.viratech.pond_ms.model.city.dao;

import java.util.List;

import org.hibernate.Query;

import ir.viratech.commons.spring.tx.ReadTransactional;
import ir.viratech.pond_ms.model.city.City;
import ir.viratech.pond_ms.model.city.base.BaseCityDAO;

/**
 * DAO class for entity "ir.viratech.pond_ms.model.city.City".
 */
public class CityDAO extends BaseCityDAO {

	
	@ReadTransactional
	public String getByName_eghamat24(String faName) {
		String queryString = SELECT + City.PROP_EGHAMAT_NAME + FROM + City.REF + WHERE + City.PROP_CITY_NAME + LIKE   +"'"+faName+"'";
		Query query = getQuery(queryString);
		List<String> list = getList(query);
		return list.get(0);
	}


}