package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;

import com.mongodb.BasicDBObject;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class V57__AddPointIndexForHotelAndThingsToDoAndRestaurant extends BaseJdbcMigration{

	@Override
	public void migrate(Connection arg0) throws Exception {
		MongoDBManager mongoDBManager = ApplicationContextUtil.getApplicationContext().getBean(MongoDBManager.class);
		mongoDBManager.getCollection("hotel_col").createIndex(new BasicDBObject("point", "2dsphere"));
		mongoDBManager.getCollection("restaurant_col").createIndex(new BasicDBObject("point", "2dsphere"));
		mongoDBManager.getCollection("things_to_do_col").createIndex(new BasicDBObject("point", "2dsphere"));
	}

}
