package ir.viratech.pond_ms.util.fileImport.vector.parser;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.store.ContentFeatureCollection;
import org.opengis.feature.simple.SimpleFeature;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.LineObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr;

public class LineParser extends Parser {

	public LineParser(String filePath, EntityType entityType) throws IOException {
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
			com.vividsolutions.jts.geom.MultiLineString jtsMultiLineString = (com.vividsolutions.jts.geom.MultiLineString) feature
					.getAttribute("the_geom");
			for (int i = 0; i < jtsMultiLineString.getNumGeometries(); i++) {
				com.vividsolutions.jts.geom.LineString jtsLine = (com.vividsolutions.jts.geom.LineString) jtsMultiLineString
						.getGeometryN(i);
				jtsLine.setSRID(4326);
				LineObject line = LineObjectMgr.getInstance().createNew();
				//TODO correct it!
				line.setLine(jtsLine);
				line.setName(getFeatureName(feature));
				result.put(line, form);
			}
		}
		iterator.close();
		return result;
	}

}
