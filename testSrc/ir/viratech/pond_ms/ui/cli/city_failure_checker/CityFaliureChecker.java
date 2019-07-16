package ir.viratech.pond_ms.ui.cli.city_failure_checker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

public class CityFaliureChecker {

	public static void main(String[] args) throws IOException {

		ApplicationContextUtil.initializeCliApplicationContext();

		List<PointObject> pointObjects = PointObjectDAO.getInstance().findAll();
		int counter = 0;
		for (int i = 0; i < pointObjects.size(); i++) {
			for (int j = 0; j < i; j++) {
				String layer1_name = pointObjects.get(i).getLayer().getParentLayer().getName().replaceAll("شهر", "").trim();
				String layer2_name = pointObjects.get(j).getLayer().getParentLayer().getName().replaceAll("شهر", "").trim();
				boolean first_in_second = layer1_name.startsWith(layer2_name);
				boolean first_eq_second = layer1_name.equals(layer2_name);
//				boolean second_in_first = layer2_name.startsWith(layer1_name);
//				System.out.println((first_in_second) && !(first_eq_second) && !(layer2_name.equals(" ")) && !(layer1_name.equals(" ")));
				if ( (first_in_second) && !(first_eq_second) && !(layer2_name.equals("")) && !(layer1_name.equals(""))) {
					System.out.println(++counter);
					System.out.println(layer1_name + "\t" + layer2_name);
//					writeToFile(pointObjects.get(i), pointObjects.get(j), "/home/amir/Desktop/WrongDataInCity.txt");
//					System.out.println(pointObjects.get(i).getDisplayString());
//					System.out.println(pointObjects.get(j).getDisplayString());
					break;
//					if (second_in_first) {
//
//					}
//					if (first_in_second){
//
//					}
				}
			}
		}

//		System.out.println(counter);

	}

	private static void writeToFile(PointObject p1, PointObject p2, String filePath) throws IOException {

		File file = new File(filePath);
		FileWriter writer = new FileWriter(file, true);

		writer.append("p1.extuid: " + p1.getExtuid() + "\t" + "p2.extuid: "  + p2.getExtuid());
		writer.append("p1.layeruid: " + p1.getLayer().getExtuid() + "\t" + "p2.layeruid: "  + p2.getLayer().getExtuid());

		writer.flush();
	}

}
