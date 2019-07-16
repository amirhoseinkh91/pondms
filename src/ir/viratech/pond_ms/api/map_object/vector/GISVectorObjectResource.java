package ir.viratech.pond_ms.api.map_object.vector;

import javax.ws.rs.Path;

import org.springframework.stereotype.Component;

import ir.viratech.commons.api.entity_modifier.EntityModifierWithSaverDTO;
import ir.viratech.commons.api.search.InvalidDtoException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.pond_ms.api.map_object.vector.base.BaseGISVectorObjectResource;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectFullDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectLightDTO;
import ir.viratech.pond_ms.api.map_object.vector.dto.GISVectorObjectMapDTO;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.map_object.vector.logic.LineObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PointObjectMgr;
import ir.viratech.pond_ms.model.map_object.vector.logic.PolygonObjectMgr;

/**
 * This is a REST Resource class for entity "GISVectorObject".
 *
 */
@Component
@Path(BaseGISVectorObjectResource.RESOURCE_PATH)
public class GISVectorObjectResource extends BaseGISVectorObjectResource {

	/**
	 * Default constructor. Also adds the extents.
	 */
	public GISVectorObjectResource() {
		super();
		this.addFieldInfoContext("brief", GISVectorObjectLightDTO.FieldInfoContext.class);
		this.addFieldInfoContext("full", GISVectorObjectFullDTO.FieldInfoContext.class);
		this.addFieldInfoContext("map", GISVectorObjectMapDTO.FieldInfoContext.class);
	}


	@Override
	protected GISVectorObject addWithDto(GISVectorObjectFullDTO fullDto) {
		if (GISVectorObject.TYPE__POINT.equals(fullDto.getType())) {
			return PointObjectMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForPointObject()));
		}
		else if (GISVectorObject.TYPE__LINE.equals(fullDto.getType())) {
			return LineObjectMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForLineObject()));
		}
		else if (GISVectorObject.TYPE__POLYGON.equals(fullDto.getType())) {
			return PolygonObjectMgr.getInstance().add(new EntityModifierWithSaverDTO<>(fullDto.createSaverForPolygonObject()));
		}
		else
			return null;
	}


	@Override
	protected GISVectorObject updateWithDto(String uid, GISVectorObjectFullDTO fullDto)
			throws EntityObjectNotFoundException {
		if (GISVectorObject.TYPE__POINT.equals(fullDto.getType()))
			return PointObjectMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForPointObject()));
		else if (GISVectorObject.TYPE__LINE.equals(fullDto.getType()))
			return LineObjectMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForLineObject()));
		else if (GISVectorObject.TYPE__POLYGON.equals(fullDto.getType()))
			return PolygonObjectMgr.getInstance().update(uid, new EntityModifierWithSaverDTO<>(fullDto.createSaverForPolygonObject()));
		else
			return null;
	}

	protected void validateAddOrEdit(GISVectorObjectFullDTO fullDto){
		try {
			fullDto.getFieldInfoContext().findByDto_Layer(fullDto.getLayer());
		} catch (InvalidDtoException e) {
			throw new InvalidEntityModificationException("error in dto", e);
		}
	}

	@Override
	protected void validate_Add(GISVectorObjectFullDTO fullDto) throws InvalidEntityModificationException {
		super.validate_Add(fullDto);
		validateAddOrEdit(fullDto);
	}

	@Override
	protected void validate_Edit(String uid, GISVectorObjectFullDTO fullDto) throws InvalidEntityModificationException {
		super.validate_Edit(uid, fullDto);
		validateAddOrEdit(fullDto);
	}
}
