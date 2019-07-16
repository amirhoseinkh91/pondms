package ir.viratech.pond_ms.util.fileImport.vector.parser;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.data.store.ContentFeatureSource;
import org.geotools.feature.FeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.feature.type.AttributeType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

public abstract class Parser {

	protected ContentFeatureSource fs;
	protected FeatureIterator<SimpleFeature> iterator;
	protected ShapefileDataStore ds;
	protected String filePath;
	protected EntityType entityType;
	
	public Parser(String filePath, EntityType entityType) throws IOException {
		this.filePath = filePath;
		this.entityType = entityType;
		getShpFile(filePath);
	}

	public String getFeatureType() throws IOException {
		String t = ds.getTypeNames()[0];
		SimpleFeatureSource featureSource = ds.getFeatureSource(t);
		SimpleFeatureType schema = featureSource.getSchema();
		String geomType = schema.getGeometryDescriptor().getType().getBinding().getName();
		return geomType;
	}

	protected void getShpFile(String filePath) throws IOException {
		File folder = new File(filePath);
		File[] shpFiles = folder.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getAbsolutePath().endsWith(".shp");
			}
		});

		extractShpData(new URL("file:" + shpFiles[0].getPath()));
	}

	private void extractShpData(URL url) throws IOException {
		ds = new ShapefileDataStore(url);
		ds.setCharset(Charset.forName("UTF-8"));
		fs = ds.getFeatureSource();
	}

	public void close() throws IOException, NullPointerException {
		fs.unLockFeatures();
		iterator.close();
		ds.dispose();
	}

	protected EntityInstance generateFormInstance (SimpleFeature feature){
		if (this.entityType == null)
			return null;
		EntityInstance ei = new EntityInstance(this.entityType,
				toObjectNode(feature, getFormSchemaRawFieldNames(this.entityType)));
		return ei;
	}
	
	private Set<String> getFormSchemaRawFieldNames(EntityType et) {
		Set<String> result = new HashSet<>();
		for(String str: et.getProcessedEntitySchema().getProperties().keySet())
			if (!str.startsWith("@") && !str.startsWith("_"))
				result.add(str);
		return result;
	}

	private ObjectNode toObjectNode(SimpleFeature feature, Set<String> properties) {
		SimpleFeatureType featureType = feature.getFeatureType();
		ObjectNode result = JsonNodeFactory.instance.objectNode();
		for (int i = 1; i < featureType.getAttributeCount(); i++) {
			AttributeType type = featureType.getType(i);
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.convertValue(type.getBinding().cast(feature.getAttribute(type.getName())),
					JsonNode.class);
			if (properties.contains(type.getName().toString()) && !(node.has("NA")))
				result.put(type.getName().toString(), node);
		}
		return result;
	}
	
	public String getFeatureName (SimpleFeature feature) {
		String nameCandidate1 = (String) feature.getAttribute("Name");
		String nameCandidate2 = (String) feature.getAttribute("name");
		String nameCandidate3 = (String) feature.getAttribute("NAME");
		if (nameCandidate1 != null)
			return nameCandidate1;
		else if (nameCandidate2 != null)
			return nameCandidate2;
		else if (nameCandidate3 != null)
			return nameCandidate3;
		else
			return null;
	}

	public abstract Map<GISVectorObject, EntityInstance> parse() throws IOException;
}
