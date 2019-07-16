package ir.viratech.pond_ms.api;

import ir.viratech.commons.api.dto.EntityFullDTO;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 * The base class for MgrBased resources.
 *
 * @param <E> The entity type
 * @param <D> The full DTO type
 */
public abstract class AbstractMgrBasedResource<E extends UIDAndDisplayStringProvider, D extends EntityFullDTO<E>> extends ir.viratech.commons.api.resource.BaseAbstractMgrBasedResource<E, D> {

	@Override
	protected boolean hasAccessToFeature(String f) {
		return AccessChecker.hasAccessToAny(f);
	}

	@Override
	protected MessageTranslator getMessageTranslator() {
		return MessageService.getMessageTranslator();
	}

	@Override
	protected String getFeatureByEntityName_Add(String featureEntityName) {
		return Feature.EntityAccessKey.getAccessKeyForAdd(featureEntityName);
	}
	@Override
	protected String getFeatureByEntityName_View(String featureEntityName) {
		return Feature.EntityAccessKey.getAccessKeyForView(featureEntityName);
	}
	@Override
	protected String getFeatureByEntityName_Edit(String featureEntityName) {
		return Feature.EntityAccessKey.getAccessKeyForEdit(featureEntityName);
	}
	@Override
	protected String getFeatureByEntityName_Delete(String featureEntityName) {
		return Feature.EntityAccessKey.getAccessKeyForDelete(featureEntityName);
	}
	@Override
	protected String getFeatureByEntityName_List(String featureEntityName) {
		return Feature.EntityAccessKey.getAccessKeyForList(featureEntityName);
	}

}
