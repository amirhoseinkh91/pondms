package ir.viratech.pond_ms.api.map_object.vector.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "GISVectorObject".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseGISVectorObjectMapDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<GISVectorObject> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "GISVectorObjectMapDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<GISVectorObjectMapDTO> {
		
		
		// =========== BEGIN createFieldInfo methods ===========
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "uid".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Uid(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "name".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Name(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "type".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Type(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "point".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Point(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "line".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Line(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * creates a PrimitiveFieldInfo for primitive property "polygon".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Polygon(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", true, false));
			this.putFieldInfo(this.createFieldInfo_Name("name", "name", "name", null, "name", true, null));
			this.putFieldInfo(this.createFieldInfo_Type("type", "type", "type", null, "type", true, false));
			this.putFieldInfo(this.createFieldInfo_Point("point", "point", "point", "string", "point", true, null));
			this.putFieldInfo(this.createFieldInfo_Line("line", "line", "line", "string", "line", true, null));
			this.putFieldInfo(this.createFieldInfo_Polygon("polygon", "polygon", "polygon", "string", "polygon", true, null));
		}
		
		/**
		 * Creates a DTO of type "GISVectorObjectMapDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public GISVectorObjectMapDTO createDto() {
			return new GISVectorObjectMapDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public GISVectorObjectMapDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(GISVectorObjectMapDTO.FieldInfoContext.class);
	}
	
	
	
	
	////////////////////
	// DTO Properties //
	////////////////////
	
	// uid
	
	private String uid;
	
	/**
	 * Getter for property "uid".
	 *
	 * @return the value of property "uid"
	 */
	@JsonProperty
	public String getUid() {
		return this.uid;
	}
	
	
	// name
	
	private String name;
	
	/**
	 * Getter for property "name".
	 *
	 * @return the value of property "name"
	 */
	@JsonProperty
	public String getName() {
		return this.name;
	}
	
	
	// type
	
	private String type;
	
	/**
	 * Getter for property "type".
	 *
	 * @return the value of property "type"
	 */
	@JsonProperty
	public String getType() {
		return this.type;
	}
	
	/**
	 * Used for loading the property type from a given internal entity.
	 * 
	 * @param gISVectorObject the given internal entity
	 * @return the value of property type based on the given internal entity
	 */
	protected abstract String load_Type(GISVectorObject gISVectorObject);
	
	
	// point
	
	private ir.viratech.pond_ms.commons.geo.Point point;
	
	/**
	 * Getter for property "point".
	 *
	 * @return the value of property "point"
	 */
	@JsonProperty
	public ir.viratech.pond_ms.commons.geo.Point getPoint() {
		return this.point;
	}
	
	/**
	 * Used for loading the property point from a given internal entity.
	 * 
	 * @param gISVectorObject the given internal entity
	 * @return the value of property point based on the given internal entity
	 */
	protected abstract ir.viratech.pond_ms.commons.geo.Point load_Point(GISVectorObject gISVectorObject);
	
	
	// line
	
	private ir.viratech.pond_ms.commons.geo.LineString line;
	
	/**
	 * Getter for property "line".
	 *
	 * @return the value of property "line"
	 */
	@JsonProperty
	public ir.viratech.pond_ms.commons.geo.LineString getLine() {
		return this.line;
	}
	
	/**
	 * Used for loading the property line from a given internal entity.
	 * 
	 * @param gISVectorObject the given internal entity
	 * @return the value of property line based on the given internal entity
	 */
	protected abstract ir.viratech.pond_ms.commons.geo.LineString load_Line(GISVectorObject gISVectorObject);
	
	
	// polygon
	
	private ir.viratech.pond_ms.commons.geo.Polygon polygon;
	
	/**
	 * Getter for property "polygon".
	 *
	 * @return the value of property "polygon"
	 */
	@JsonProperty
	public ir.viratech.pond_ms.commons.geo.Polygon getPolygon() {
		return this.polygon;
	}
	
	/**
	 * Used for loading the property polygon from a given internal entity.
	 * 
	 * @param gISVectorObject the given internal entity
	 * @return the value of property polygon based on the given internal entity
	 */
	protected abstract ir.viratech.pond_ms.commons.geo.Polygon load_Polygon(GISVectorObject gISVectorObject);
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "GISVectorObject".
	 * 
	 * @param gISVectorObject the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(GISVectorObject gISVectorObject) {
		this.uid = gISVectorObject.getExtuid();
		this.name = gISVectorObject.getName();
		this.type = this.load_Type(gISVectorObject);
		this.point = this.load_Point(gISVectorObject);
		this.line = this.load_Line(gISVectorObject);
		this.polygon = this.load_Polygon(gISVectorObject);
	}
	
	/**
	 * Saves this DTO to an entity object of type "GISVectorObject".
	 * 
	 * @param gISVectorObject the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(GISVectorObject gISVectorObject) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: name
		//Disabled save for property: type
		//Disabled save for property: point
		//Disabled save for property: line
		//Disabled save for property: polygon
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("name", this.name);
		data.put("type", this.type);
		data.put("point", this.point);
		data.put("line", this.line);
		data.put("polygon", this.polygon);
		return data;
	}
	
}