package ir.viratech.pond_ms.api.organization.base;

import static ir.viratech.commons.api.field_info.FieldInfoContextProvider.getFieldInfoContextInstance;
import ir.viratech.pond_ms.api.organization.dto.OrganizationFullDTO;
import ir.viratech.pond_ms.model.organization.Organization;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * A base DTO for class "Organization".
 * Do not edit this file.
 * It is an automatically generated class.
 *
 */
public abstract class BaseOrganizationFullDTO extends ir.viratech.commons.api.dto.AbstractFullDTO<Organization> {
	
	
	/**
	 * 
	 * Base FieldInfoContext for "OrganizationFullDTO".
	 *
	 */
	public static abstract class BaseFieldInfoContext extends ir.viratech.commons.api.search.field.AbstractFieldInfoContext<OrganizationFullDTO> {
		
		
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
		 * creates a PrimitiveFieldInfo for primitive property "title".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Title(
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
		 * creates a PrimitiveFieldInfo for primitive property "code".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param typeKey a key showing the type of the property (used in client side) 
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param sortable true if the property could be used for sorting in client search queries
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.PrimitiveFieldInfo<?> createFieldInfo_Code(
				String externalName, String internalName, String internalSearchExpression, String typeKey, String bundleKey, boolean searchable, Boolean sortable) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_String(externalName, internalName, internalSearchExpression, typeKey, bundleKey, searchable, sortable);
		}
		
		
		/**
		 * Creates an EntityByDtoFinder for the DTO property "parent".
		 * The created object finds entities of type "ir.viratech.pond_ms.model.organization.Organization" 
		 * by DTO's of type "ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>".
		 * @return the created EntityByDtoFinder
		 */
		protected abstract ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> createEntityByDtoFinder_Parent();
		
		private ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> entityByDtoFinder_Parent;
		
		/**
		 * Getter for the previously created EntityByDtoFinder for property "parent".
		 * @return the previously created EntityByDtoFinder object 
		 */
		public final ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> getEntityByDtoFinder_Parent() {
			return this.entityByDtoFinder_Parent;
		}
		
		/**
		 * Finds entities of type "ir.viratech.pond_ms.model.organization.Organization" 
		 * by DTO's of type "ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>".
		 * It is targeted for the DTO property: parent
		 * @param parentDto 
		 *		the given dto by which the entity should be found
		 * @return the found entity
		 * @throws ir.viratech.commons.api.search.InvalidDtoException
		 * 		If the given dto is not valid or is not representing an internal entity
		 */
		public final ir.viratech.pond_ms.model.organization.Organization findByDto_Parent(ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parentDto) throws ir.viratech.commons.api.search.InvalidDtoException {
			return this.getEntityByDtoFinder_Parent().findByDto(parentDto);
		}
		
		/**
		 * creates a DtoFieldInfo for dto-property "parent".
		 * @param externalName the external name of the property in the DTO class
		 * @param internalName the internal name of the property in the entity class
		 * @param internalSearchExpression the internal search expression by which the property could be really searched
		 * @param bundleKey Used for i18n translation of the property
		 * @param searchable true if the property could be accessed in client search queries
		 * @param fieldInfoContext the FieldInfoContext of the dto-property: parent
		 * @param entityByDtoFinder the EntityByDtoFinder for the dto-property: parent
		 * @return the FieldInfo created for the property
		 */
		protected ir.viratech.commons.api.search.field.DtoFieldInfo<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> createFieldInfo_Parent(
				String externalName, String internalName, String internalSearchExpression, String bundleKey, boolean searchable, 
				ir.viratech.commons.api.search.field.FieldInfoContext<ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> fieldInfoContext, 
				ir.viratech.commons.api.search.EntityByDtoFinder<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>> entityByDtoFinder) {
			return new ir.viratech.commons.api.search.field.types.FieldInfo_Dto<ir.viratech.pond_ms.model.organization.Organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>>(
						externalName, internalName, internalSearchExpression, bundleKey, searchable, fieldInfoContext, entityByDtoFinder);
		}
		
		
		// =========== END createFieldInfo methods ===========
		
		/**
		 * The default constructor for BaseFieldInfoContext.
		 */
		protected BaseFieldInfoContext() {
			this.putFieldInfo(this.createFieldInfo_Uid("uid", "extuid", "extuid", null, "uid", false, false));
			this.putFieldInfo(this.createFieldInfo_Title("title", "displayString", "displayString", null, "title", false, false));
			this.putFieldInfo(this.createFieldInfo_Name("name", "name", "name", null, "name", true, null));
			this.putFieldInfo(this.createFieldInfo_Code("code", "code", "code", null, "code", true, null));
			this.entityByDtoFinder_Parent = createEntityByDtoFinder_Parent();
			this.putFieldInfo(this.createFieldInfo_Parent("parent", "parent", "parent", "parent", true, 
					getFieldInfoContextInstance(ir.viratech.commons.api.dto.SimpleUltraLightDTO.FieldInfoContext.<ir.viratech.pond_ms.model.organization.Organization>getGenericClass()), this.getEntityByDtoFinder_Parent()));
		}
		
		/**
		 * Creates a DTO of type "OrganizationFullDTO".
		 *
		 * @return the created DTO
		 */
		@Override
		public OrganizationFullDTO createDto() {
			return new OrganizationFullDTO();
		}
		
	}
	
	/**
	 * Provides the corresponding FieldInfoContext of this DTO.
	 *
	 * @return the corresponding FieldInfoContext object
	 */
	public OrganizationFullDTO.FieldInfoContext getFieldInfoContext() {
		return getFieldInfoContextInstance(OrganizationFullDTO.FieldInfoContext.class);
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
	
	
	// title
	
	private String title;
	
	/**
	 * Getter for property "title".
	 *
	 * @return the value of property "title"
	 */
	@JsonProperty
	public String getTitle() {
		return this.title;
	}
	
	
	// name
	
	private String name;
	private boolean __modified__Name = false;
	
	/**
	 * Getter for property "name".
	 *
	 * @return the value of property "name"
	 */
	@JsonProperty
	public String getName() {
		return this.name;
	}
	
	/**
	 * Setter for property "name".
	 *
	 * @param name the new value for property "name"
	 */
	public void setName(String name) {
		this.__modified__Name = true;
		this.name = name;
	}
	
	/**
	 * Shows the modification state of the property "name".
	 * 
	 * @return true if the property is modified
	 */
	public boolean hasModifiedName() {
		return this.__modified__Name;
	}
	
	
	// code
	
	private String code;
	private boolean __modified__Code = false;
	
	/**
	 * Getter for property "code".
	 *
	 * @return the value of property "code"
	 */
	@JsonProperty
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Setter for property "code".
	 *
	 * @param code the new value for property "code"
	 */
	public void setCode(String code) {
		this.__modified__Code = true;
		this.code = code;
	}
	
	/**
	 * Shows the modification state of the property "code".
	 * 
	 * @return true if the property is modified
	 */
	public boolean hasModifiedCode() {
		return this.__modified__Code;
	}
	
	
	// parent
	
	private ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parent;
	private boolean __modified__Parent = false;
	
	/**
	 * Getter for property "parent".
	 *
	 * @return the value of property "parent"
	 */
	@JsonProperty
	public ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> getParent() {
		return this.parent;
	}
	
	/**
	 * Setter for property "parent".
	 *
	 * @param parent the new value for property "parent"
	 */
	public void setParent(ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parent) {
		this.__modified__Parent = true;
		this.parent = parent;
	}
	
	/**
	 * Shows the modification state of the property "parent".
	 * 
	 * @return true if the property is modified
	 */
	public boolean hasModifiedParent() {
		return this.__modified__Parent;
	}
	
	/**
	 * Used for loading the property parent from a given internal entity.
	 * 
	 * @param organization the given internal entity
	 * @return the value of property parent based on the given internal entity
	 */
	protected ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> load_Parent(Organization organization) {
		ir.viratech.pond_ms.model.organization.Organization __internalProperty_parent = organization.getParent();
		if (__internalProperty_parent == null)
			return null; 
		ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parent = new ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>();
		parent.loadFrom(__internalProperty_parent);
		return parent;
	}
	
	/**
	/**
	 * Used for saving a given value of property parent to a given internal entity.
	 * 
	 * @param organization
	 * 		the given internal entity
	 * @param parentDto 
	 * 		the value of property parent which should be saved to the given internal entity
	 * @throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException 
	 * 		if the given value of property parent is not appropriate for saving the entity
	 */
	protected void save_Parent(Organization organization, ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parentDto)
			throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		ir.viratech.pond_ms.model.organization.Organization __internalProperty_parent = null;
		if (parentDto != null) {
			try {
				__internalProperty_parent = findByDto_Parent(parentDto);
			} catch (ir.viratech.commons.api.search.InvalidDtoException e) {
				throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("The given dto is invalid: "+parentDto, e);
			}
			if (__internalProperty_parent == null)
				throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("No entity was found for the given dto: "+parentDto);
		}
		organization.setParent(__internalProperty_parent);
	}
	
	/**
	 * Finds entities based on the DTO property "parent".
	 * It finds entities of type "ir.viratech.pond_ms.model.organization.Organization" 
	 * based on DTO's of type "ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization>",
	 * targeted on the DTO property "parent".
	 * 
	 * @param parentDto 
	 *		the given dto by which the entity should be found
	 * @return the found entity
	 * @throws ir.viratech.commons.api.search.InvalidDtoException
	 * 		If the given dto is not valid or is not representing an internal entity  
	 */
	protected ir.viratech.pond_ms.model.organization.Organization findByDto_Parent(ir.viratech.commons.api.dto.SimpleUltraLightDTO<ir.viratech.pond_ms.model.organization.Organization> parentDto) throws ir.viratech.commons.api.search.InvalidDtoException {
		return this.getFieldInfoContext().findByDto_Parent(parentDto);
	}
	
	
	
	/////////////////////////
	// save/load functions //
	/////////////////////////
	
	/**
	 * Loads this DTO from an entity object of type "Organization".
	 * 
	 * @param organization the entity object from which this DTO is loaded. 
	 */
	@Override
	public void loadFrom(Organization organization) {
		this.uid = organization.getExtuid();
		this.title = organization.getDisplayString();
		this.name = organization.getName();
		this.code = organization.getCode();
		this.parent = this.load_Parent(organization);
	}
	
	/**
	 * Saves this DTO to an entity object of type "Organization".
	 * 
	 * @param organization the entity object to which this DTO is saved. 
	 * @throws BadDtoEntityModificationException If this DTO is not valid for saving. 
	 */
	@Override
	public void saveTo(Organization organization) throws ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException {
		//Disabled save for property: uid
		//Disabled save for property: title
		if (this.hasModifiedName()) {
			organization.setName(this.name);
		}
		if (this.hasModifiedCode()) {
			organization.setCode(this.code);
		}
		if (this.hasModifiedParent()) {
			this.save_Parent(organization, this.parent);
		}
	}
	
	
	
	//////////////
	// toString //
	//////////////
	
	@Override
	protected Map<String, Object> toStringData() {
		Map<String, Object> data = super.toStringData();
		data.put("uid", this.uid);
		data.put("title", this.title);
		data.put("name", this.name);
		data.put("code", this.code);
		data.put("parent", this.parent);
		return data;
	}
	
}
