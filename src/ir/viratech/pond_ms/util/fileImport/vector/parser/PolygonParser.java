package ir.viratech.pond_ms.util.fileImport.vector.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.store.ContentFeatureCollection;
import org.opengis.feature.simple.SimpleFeature;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.PolygonObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr;

public class PolygonParser extends Parser {

	public PolygonParser(String filePath, EntityType entityType) throws IOException {
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
			com.vividsolutions.jts.geom.MultiPolygon jtsMultiPolygon = (com.vividsolutions.jts.geom.MultiPolygon) feature
					.getAttribute("the_geom");
			for (int i = 0; i < jtsMultiPolygon.getNumGeometries(); i++) {
				com.vividsolutions.jts.geom.Polygon jtsPolygon = (com.vividsolutions.jts.geom.Polygon) jtsMultiPolygon.getGeometryN(i);
				jtsPolygon.setSRID(4326);
				PolygonObject polygon = PolygonObjectMgr.getInstance().createNew();
				polygon.setPolygon(jtsPolygon);
				polygon.setName(getFeatureName(feature));
				result.put(polygon, form);
			}
		}
		iterator.close();
		return result;
	}
}
