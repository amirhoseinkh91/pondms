package ir.viratech.pond_ms.ui.cli.countUnratedThingsToDos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

public class CountUnratedThingsToDos {

	private static final String FILE_PATH = "rate-0-points";
	private static FileWriter writer;
	
	
	public static void main(String[] args) throws IOException {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractEntityDAO.touchSession();
		writer = new FileWriter(ApplicationContextUtil.getProperty(FILE_PATH), true);
		
		List<PointObject> pointObjects = PointObjectMgr.getInstance().list();
		
		int counter = 0;
		for (PointObject pointObject : pointObjects) {
			EntityInstance formInstance = pointObject.getFormInstance("full",false);
			Integer rate = formInstance.get("Rate", Integer.class);
			if (rate.intValue() == 0){
				counter++;
				writeToFile(pointObject);
			}
		}
		System.out.println("number of objects without Rate: " + counter);
		writer.close();
		AbstractEntityDAO.closeCurrentThreadSessions();
	}
	
	private static  void writeToFile(PointObject p) throws IOException {
		
		writer.append(p.getStateFromLayer() + " - " + p.getCityFromLayer() + " - " + p.getName() + "\n");
		writer.flush();
	}
	
}
