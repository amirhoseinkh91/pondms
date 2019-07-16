package ir.viratech.pond_ms.ui.cli.data_import;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.dao.EntityTypeDAO_JDBC;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.commons.util.jackson.JacksonUtils;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gradient.Gradient;
import ir.viratech.pond_ms.model.gradient.GradientStop;
import ir.viratech.pond_ms.model.gradient.logic.GradientMgr;
import ir.viratech.pond_ms.model.gradient.logic.GradientStopMgr;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.dao.PointObjectDAO;

public class GradientImport {

	public static void main(String[] args) throws FileNotFoundException {
		
		//TODO: the line below is commented due to foreignKey to Gradients Table.
//		clearAllGradients();
		File dir = new File("assets/colors");
		for (File file : dir.listFiles()) {
			Gradient gradient = readGradientFromFile(file);
			GradientMgr.getInstance().add(gradient);
		}
	}

	public static Gradient readGradientFromFile(File f) throws FileNotFoundException {
		try (Scanner scanner = new Scanner(new FileInputStream(f))) {
			Gradient gradient = GradientMgr.getInstance().createNew();
			String name = scanner.nextLine().split("=")[1];
			gradient.setTitle(name);
			Map<Double, GradientStop> stops = new HashMap<>();
			int offset = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] rgb = line.split(",");
				GradientStop gds = GradientStopMgr.getInstance().createNew();
				gds.setRed(Double.parseDouble(rgb[0].replaceAll(" ", "")) / 255.0);
				gds.setGreen(Double.parseDouble(rgb[1].replaceAll(" ", "")) / 255.0);
				gds.setBlue(Double.parseDouble(rgb[2].replaceAll(" ", "")) / 255.0);
				stops.put((double) offset++, gds);
			}
			gradient.setStops(stops);
			return gradient;
		}
	}

	public static void clearAllGradients() {
		List<Gradient> grads = GradientMgr.getInstance().list();
		for (Gradient g : grads)
			GradientMgr.getInstance().delete(g);
	}
}
