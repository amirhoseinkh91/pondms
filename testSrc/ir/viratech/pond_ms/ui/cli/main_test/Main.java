package ir.viratech.pond_ms.ui.cli.main_test;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.hotel.dao.HotelDAO;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by justro on 2/12/18.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContextUtil.initializeCliApplicationContext();
        AbstractEntityDAO.touchSession();
        start();
        AbstractEntityDAO.closeCurrentThreadSessions();
    }

    public static void start() {
        System.out.println("==========================");
        System.out.println("starting....");
        List<PointObject> pointObjects = PointObjectMgr.getInstance().list();
        System.out.println("point objects found: " + pointObjects.size());
        for (PointObject pointObject : pointObjects) {
            if (isHotel(pointObject)) {
                check(pointObject);
            }
        }
        System.out.println("finish....");
        System.out.println("==========================");
    }

    private static void check(PointObject pointObject) {
        try {
            HotelDAO.getInstance().getByName_eghamat24(pointObject.getName());
        } catch (IndexOutOfBoundsException e){
            writeToFile(pointObject);
        }
    }

    private static void writeToFile(PointObject pointObject) {
        File file = new File("/home/amir/Desktop/hotelssss.txt");
        try {
            FileWriter writer = new FileWriter(file);
            writer.append(pointObject.getName() + "\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isHotel(PointObject pointObject) {
        EntityType hotelEntityType = EntityTypeMgr.getInstance().getByKey("Hotel");
        return pointObject.getFormInstance("full", false).getEntityType().equals(hotelEntityType);
    }

}
