package ir.viratech.pond_ms.util.fileImport.vector;

import java.io.IOException;
import java.util.Map;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.util.fileImport.exception.FeatureTypeIncompatibleException;
import ir.viratech.pond_ms.util.fileImport.vector.parser.LineParser;
import ir.viratech.pond_ms.util.fileImport.vector.parser.Parser;
import ir.viratech.pond_ms.util.fileImport.vector.parser.PointParser;
import ir.viratech.pond_ms.util.fileImport.vector.parser.PolygonParser;

public class VectorImporter  {

	private Parser parser;

	public Parser getParser() {
		return parser;
	}
	
	public VectorImporter(String fileDir, String expectedFeatureType, EntityType entityType) throws IOException, FeatureTypeIncompatibleException {
		initialize(fileDir, expectedFeatureType, entityType);
	}


	public void initialize(String fileDir, String expectedFeatureType, EntityType ent) throws IOException, FeatureTypeIncompatibleException {
		/** TODO
		 * IF TIME EXCEEDS, CHECK OBJECTS IN BOUNDING BOX!!
		 */
		switch (expectedFeatureType) {
		case GISVectorObject.TYPE__POLYGON:
			parser = new PolygonParser(fileDir, ent);
			break;
		case GISVectorObject.TYPE__POINT:
			parser = new PointParser(fileDir, ent);
			break;
		case GISVectorObject.TYPE__LINE:
			parser = new LineParser(fileDir, ent);
			break;
		}
		if (!isFeatureTypesEqual(expectedFeatureType)) 
			throw new FeatureTypeIncompatibleException();
	}

	
	public Map<GISVectorObject, EntityInstance> extractData() throws IOException {
		Map<GISVectorObject, EntityInstance> result = parser.parse();
		parser.close();
		return result;
	}
	
	public boolean isFeatureTypesEqual(String type) throws IOException {
		return parser.getFeatureType().endsWith(type);
	}
	
}
