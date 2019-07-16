package ir.viratech.pond_ms.model.layer.logic;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.cm.core.validation.ValidationException;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_instance.InconsistenceEntityVersionException;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgr;
import ir.viratech.commons.cm.model.entity_instance.logic.EntityInstanceMgrProvider;
import ir.viratech.commons.cm.model.entity_type.EntityTypeNotFoundException;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.commons.model.auth.AccessDeniedException;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.base.BasePondMgr;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.layer.Pond".
 */
public class PondMgr extends BasePondMgr {

	@Override
	protected void validateOnAddOrUpdate(Pond obj) throws InvalidEntityModificationException {
		super.validateOnAddOrUpdate(obj);
		if (!obj.getLayer().isPondRelated()) {
			throw new InvalidEntityModificationException();
		}
	}

	public EntityInstance getFormInstance (String pondUid, String formKey) throws ResponseException {
		Pond pond = PondMgr.getInstance().getByExtuid(pondUid);
		EntityInstance ei = null;
		if (pond == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("pond.not_found", MessageType.ERROR, MessageService.getMessageTranslator()))
					.build());
		if (pond.getFormInstanceUid(formKey) == null)
			return null;
		try {
			EntityInstanceMgr eim = EntityInstanceMgrProvider.getMgr(formKey);
			ei = eim.getByUid_Enriched(pond.getFormInstanceUid(formKey), false);
		} catch (EntityTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ei;
	}

	public EntityInstance setFormInstance (String pondUid, String formKey, EntityInstance instance) {
		Pond pond = PondMgr.getInstance().getByExtuid(pondUid);
		EntityInstance ei = null;
		instance.setEntityType(EntityTypeMgr.getInstance().getByKey(formKey));
		if (pond == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("pond.not_found", MessageType.ERROR, MessageService.getMessageTranslator()))
					.build());
		try {
			EntityInstanceMgr eim = EntityInstanceMgrProvider.getMgr(formKey);
			if (pond.getFormInstanceUid(formKey) == null) {
				ei = eim.add(instance, false);
				pond.setFormInstance(ei.getExtuid(), formKey);
			}
			else {
				eim.addOrUpdate(pond.getFormInstanceUid(formKey), instance, false);
				ei = eim.getByUid(pond.getFormInstanceUid(formKey), false);
			}
		} catch (EntityTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InconsistenceEntityVersionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PondMgr.getInstance().update(pond);
		return ei;

	}

}