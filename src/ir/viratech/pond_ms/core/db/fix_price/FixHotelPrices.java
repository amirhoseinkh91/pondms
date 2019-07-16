package ir.viratech.pond_ms.core.db.fix_price;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import ir.viratech.commons.persistence.mongo.base.MongoDBManager;
import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.just_ro.manager.website.hotel.AriaBooking;
import ir.viratech.just_ro.manager.website.hotel.Eghamat24;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;

public class FixHotelPrices {

    private static MongoDBManager mongoDBManager;

    public static void main(String[] args) {

        ApplicationContextUtil.initializeCliApplicationContext();
        mongoDBManager = (MongoDBManager) ApplicationContextProvider.getInitializedApplicationContext().getBean("mongoDBManager");
        new FixHotelPrices().start();

    }

    private void start() {

        DBCollection hotelCol = mongoDBManager.getCollection("hotel_col");

        DBObject query = new BasicDBObject("_isDeleted" , false);

        DBCursor dbObjects = hotelCol.find(query);
        int mainCounter = 0;
        int hasPriceCounter = 0;
        int hasNotPriceCounter = 0;
        while (dbObjects.hasNext()) {
            DBObject hotel = dbObjects.next();
            try {
                if (hotel.get("lowestPrices") != null) {
                    double price = 0.0;
                    double ariaPrice = 10000000000000.0;
                    double eghamatPrice = 10000000000000.0;

                    if (hotel.get("lowestPrices") instanceof BasicDBObject) {
                        BasicDBObject dbObject = (BasicDBObject) hotel.get("lowestPrices");
                        boolean ariaKeyContain = dbObject.containsKey(AriaBooking.ariabookingwebSiteKey);
                        boolean eghamatKeyContain = dbObject.containsKey(Eghamat24.eghamat24WebSiteKey);
                        if (ariaKeyContain) {
                            BasicDBObject ariabooking = (BasicDBObject) dbObject.get(AriaBooking.ariabookingwebSiteKey);
                            ariaPrice = ariabooking.getDouble("price");
                        }
                        if (eghamatKeyContain) {
                            BasicDBObject eghamat24 = (BasicDBObject) dbObject.get(Eghamat24.eghamat24WebSiteKey);
                            eghamatPrice = eghamat24.getDouble("price");
                        }

                        if (!(ariaKeyContain && eghamatKeyContain)) {
                            price = 0;
                        }
                    } else if (hotel.get("lowestPrices") instanceof BasicDBList) {
                        BasicDBList dbList = (BasicDBList) hotel.get("lowestPrices");
                        if (dbList.size() == 0) {
                            price = 0;
                        } else {
                            for (int i = 0; i < dbList.size(); i++) {
                                BasicDBObject dbObject = (BasicDBObject) dbList.get(i);
                                if (dbObject.getString("link").contains("ariabooking")) {
                                    ariaPrice = dbObject.getDouble("price");
                                } else if (dbObject.getString("link").contains("eghamat24")) {
                                    eghamatPrice = dbObject.getDouble("price");
                                }
                            }
                        }
                    }
                    price = getLowestPrice(ariaPrice, eghamatPrice);
                    String uid = (String) hotel.get("gis_object_uid");
                    System.out.print( uid + "\t" + price);
                    if (price != 0) {
                        hasPriceCounter++;
                        hotelCol.update(hotel, new BasicDBObject("$set" , new BasicDBObject("lowestPrice" , price)));
                    } else {
                        hasNotPriceCounter++;
                        hotelCol.update(hotel, new BasicDBObject("$set" , new BasicDBObject("lowestPrice" , null)));
                    }
                    DBCursor objects = hotelCol.find(new BasicDBObject("gis_object_uid", uid));
                    while (objects.hasNext()) {
                        System.out.println( "\t---> " + objects.next().get("lowestPrice"));
                    }
                    mainCounter++;
                }

            } catch (ClassCastException e ) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("=============================");
        System.out.println( mainCounter + " hotels updated");
        System.out.println(hasPriceCounter + " hotels have lowestPrice");
        System.out.println(hasNotPriceCounter + " hotels have not lowestPrice");


    }

    private double getLowestPrice(double ariaPrice, double eghamatPrice) {
        if (ariaPrice < eghamatPrice)
            return ariaPrice;
        if (eghamatPrice < ariaPrice)
            return eghamatPrice;
        return 0;
    }

}
