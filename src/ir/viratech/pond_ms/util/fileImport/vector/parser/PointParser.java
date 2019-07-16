package ir.viratech.pond_ms.util.fileImport.vector.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.store.ContentFeatureCollection;
import org.opengis.feature.simple.SimpleFeature;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.PointObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;

public class PointParser extends Parser {

	public PointParser(String filePath, EntityType entityType) throws IOException {
		super(filePath, entityType);
	}

	@Override
	public Map<GISVectorObject, EntityInstance> parse() throws IOException {
		Map<GISVectorObject, EntityInstance> result = new HashMap<>();
		ContentFeatureCollection fc = fs.getFeatures();
		iterator = fc.features();
		while (iterator.hasNext()) {
			SimpleFeature feature = iterator.next();
			EntityInstance form = generateFormInstance(feature);
			com.vividsolutions.jts.geom.Point jtsPoint = (com.vividsolutions.jts.geom.Point)feature.getAttribute("the_geom");
			jtsPoint.setSRID(4326);
			PointObject point = PointObjectMgr.getInstance().createNew();
			point.setPoint(jtsPoint);
			point.setName(getFeatureName(feature));
			result.put(point, form);
		}
		iterator.close();
		return result;
	}

}
