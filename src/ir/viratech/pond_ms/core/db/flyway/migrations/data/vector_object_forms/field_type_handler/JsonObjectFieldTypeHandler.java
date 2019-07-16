package ir.viratech.pond_ms.core.db.flyway.migrations.data.vector_object_forms.field_type_handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import ir.viratech.commons.cm.core.field_type.AbstractFieldTypeHandler;
import ir.viratech.commons.cm.core.schema.PropertyInfo;
import ir.viratech.commons.cm.core.validation.ValidationErrorEntry;
import ir.viratech.commons.cm.model.entity_instance.SinglePropertyInstance;
import ir.viratech.commons.util.i18n.MessageTranslator;

public class JsonObjectFieldTypeHandler extends AbstractFieldTypeHandler{

	public static final String TYPE = "jsonObject";
	

	@Autowired
	private MessageTranslator messageTranslator;

	
	@Override
	public boolean canHandle(PropertyInfo propertyInfo) {
		if (TYPE.equals(propertyInfo.getType()))
			return true;
		return false;
	}

	@Override
	public ValidationErrorEntry validate(SinglePropertyInstance singlePropertyInstance) {
		if (singlePropertyInstance.getData().isObject()){
			return null;
		}else{
			return new ValidationErrorEntry(messageTranslator.getMessage("cm.validation.jsonObjectField.invalid"), singlePropertyInstance);
		}
	}

	@Override
	public Map<String, Object> getSearchMappingDefinition(PropertyInfo propertyInfo) {
		return null;
	}

	@Override
	public Object getSearchDocumentDefinition(SinglePropertyInstance singlePropertyInstance) {
		return null;
	}

}
