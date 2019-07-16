package ir.viratech.pond_ms.api.layer;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Component;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.api.entity_modifier.EntityModifierWithSaverDTO;
import ir.viratech.commons.api.search.InvalidDtoException;
import ir.viratech.commons.model.BasicEntityMgr;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.pond_ms.api.layer.base.BaseLayerResource;
import ir.viratech.pond_ms.api.layer.dto.LayerFullDTO;
import ir.viratech.pond_ms.api.layer.dto.LayerLightDTO;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.logic.LayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.RasterLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.OrganizationBasedEntityManager;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 *  This is a REST Resource class for entity "Layer".
 *
 */
@Component
@Path(BaseLayerResource.RESOURCE_PATH)
public class LayerResource extends BaseLayerResource {

	/**
	 * Default constructor.
	 * Also adds the extents.
	 */
	public LayerResource () {
		super();
 		this.addFieldInfoContext("brief", LayerLightDTO.FieldInfoContext.class);
 		this.addFieldInfoContext("full", LayerFullDTO.FieldInfoContext.class);
 	}

	@Override
	protected Layer addWithDto(LayerFullDTO fullDto) {
		if (Layer.TYPE_PARENT.equals(fullDto.getType()))
			return ParentLayerMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForParentLayer()));
		else if (Layer.TYPE_VECTOR.equals(fullDto.getType()))
			return VectorLayerMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForVectorLayer()));
		else if (Layer.TYPE_RASTER.equals(fullDto.getType()))
			return RasterLayerMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForRasterLayer()));
		else
			return null;
	}

	@Override
	protected Layer updateWithDto(String uid, LayerFullDTO fullDto) throws EntityObjectNotFoundException {
		if (Layer.TYPE_PARENT.equals(fullDto.getType()))
			return ParentLayerMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForParentLayer()));
		else if (Layer.TYPE_VECTOR.equals(fullDto.getType()))
			return VectorLayerMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForVectorLayer()));
		else if (Layer.TYPE_RASTER.equals(fullDto.getType()))
			return RasterLayerMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForRasterLayer()));
		else
			return null;
	}

	protected void validateAddOrEdit(LayerFullDTO fullDto) throws InvalidEntityModificationException{
			if(fullDto==null){
				throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
						UI_MetadataDTO.createWith_i18n("layer.fullDto.null", MessageType.ERROR, getMessageTranslator()))
						.build());
			}

	}

	@Override
	protected void validate_Add(LayerFullDTO fullDto) throws InvalidEntityModificationException {
		super.validate_Add(fullDto);
		validateAddOrEdit(fullDto);
		if(fullDto.isSecret() && !AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.EDIT_SECRET_LAYERS)){
			throw new InvalidEntityModificationException("this user can not create secret layers");
		}
	}

	@Override
	protected void validate_Edit(String uid, LayerFullDTO fullDto) throws InvalidEntityModificationException {
		super.validate_Edit(uid, fullDto);
		validateAddOrEdit(fullDto);
		Layer layerToEdit = LayerMgr.getInstance().getByExtuid(uid);
		if(layerToEdit != null && layerToEdit.isSecret() && !AccessChecker.hasAccessToAny(ApplicationContextUtil.getCurrentExecutionContext().getUser(), FeatureNames.EDIT_SECRET_LAYERS)){
			throw new InvalidEntityModificationException("this user can not edit secret layers");
		}
	}
}
