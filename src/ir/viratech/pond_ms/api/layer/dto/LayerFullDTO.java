package ir.viratech.pond_ms.api.layer.dto;

import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.SaverDTO;
import ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException;
import ir.viratech.commons.api.search.EntityByDtoFinder;
import ir.viratech.commons.api.search.EntityByDtoFinder_ByUid;
import ir.viratech.pond_ms.api.gismap.dto.GISMapLightDTO;
import ir.viratech.pond_ms.api.gradient.dto.GradientLightDTO;
import ir.viratech.pond_ms.api.layer.base.BaseLayerFullDTO;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.gradient.Gradient;
import ir.viratech.pond_ms.model.gradient.logic.GradientMgr;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.RasterLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.user.role.Role;
import ir.viratech.pond_ms.model.user.role.logic.RoleMgr;

/**
 * A DTO for class Layer.
 *
 */
public class LayerFullDTO extends BaseLayerFullDTO {

	/**
	 * FieldInfoContext for LayerFullDTO
	 */
	public static class FieldInfoContext extends BaseLayerFullDTO.BaseFieldInfoContext {

		@Override
		protected EntityByDtoFinder<ParentLayer, LayerLightDTO> createEntityByDtoFinder_ParentLayer() {
			return new EntityByDtoFinder_ByUid<ParentLayer, LayerLightDTO>(ParentLayerMgr.getInstance());
		}

		@Override
		protected EntityByDtoFinder<GISMap, GISMapLightDTO> createEntityByDtoFinder_Map() {
			return new EntityByDtoFinder_ByUid<GISMap, GISMapLightDTO>(GISMapMgr.getInstance());
		}

		@Override
		protected EntityByDtoFinder<Pond, PondLightDTO> createEntityByDtoFinder_Pond() {
			return new EntityByDtoFinder_ByUid<Pond, PondLightDTO>(PondMgr.getInstance());
		}

		@Override
		protected EntityByDtoFinder<Gradient, GradientLightDTO> createEntityByDtoFinder_Gradient() {
			return new EntityByDtoFinder_ByUid<Gradient, GradientLightDTO>(GradientMgr.getInstance());
		}

	}

	public void saveParentAndMap(Layer layer) {
		GISMap previousMap = layer.getMap();
		ParentLayer previousParentLayer = layer.getParentLayer();

		save_Map(layer, getMap());
		save_ParentLayer(layer, getParentLayer());

		// the below logic handles possibility of changing layers' parent
		if (previousParentLayer != null && !previousParentLayer.equals(layer.getParentLayer())) {
			previousParentLayer.removeFromSubLayers(layer);
		}

		if (layer.getParentLayer() != null && !layer.getParentLayer().equals(previousParentLayer)) {
			layer.getParentLayer().addToSubLayers(layer);
		}

		if (previousParentLayer == null && previousMap != null && !previousMap.equals(layer.getMap())) {
			previousMap.removeFromLayers(layer);
		}

		//note that "map" field of layer has notNull constraint in both .vu and .hbm
		if (layer.getParentLayer() == null && !layer.getMap().equals(previousMap)) {
			layer.getMap().addToLayers(layer);
		}
	}

	public SaverDTO<ParentLayer> createSaverForParentLayer() {
		return new SaverDTO<ParentLayer>() {
			@Override
			public void saveTo(ParentLayer layer) throws BadDtoEntityModificationException {
				LayerFullDTO dto = LayerFullDTO.this;
				dto.save_Name(layer, getName());
				saveParentAndMap(layer);
				((ParentLayer) layer).setPondRelated((dto.isIsPond() == null) ? false : dto.isIsPond());

			}

		};
	}

	public SaverDTO<VectorLayer> createSaverForVectorLayer() {
		return new SaverDTO<VectorLayer>() {
			@Override
			public void saveTo(VectorLayer layer) throws BadDtoEntityModificationException {
				LayerFullDTO dto = LayerFullDTO.this;
				dto.save_Name(layer, getName());
				saveParentAndMap(layer);
				layer.setFormSchemaKey(dto.getFormSchemaKey());
				layer.setVectorObjectsType(dto.getVectorObjectsType());
				layer.setSecret(dto.isSecret());
				layer.setDescription(dto.getDescription());
				layer.setLineColor(getColor());
				layer.setPointIcon(getIcon());
				layer.setLineWidth(getWidth());
				layer.setPolygonFill(getFill());
				layer.setLabled(isIsLabeled());
			}
		};
	}

	public SaverDTO<RasterLayer> createSaverForRasterLayer() {
		return new SaverDTO<RasterLayer>() {
			@Override
			public void saveTo(RasterLayer layer) throws BadDtoEntityModificationException {
				LayerFullDTO dto = LayerFullDTO.this;
				dto.save_Name(layer, getName());
				saveParentAndMap(layer);
				layer.setSecret(dto.isSecret());
				layer.setDescription(dto.getDescription());
				save_Gradient(dto.getGradient(), layer);
			}
		};
	}

	private void save_Gradient (GradientLightDTO gradientDTO, RasterLayer layer) {
		Gradient __internalProperty_gradient = null;
		if (gradientDTO != null) {
//			try {
				Role role = RoleMgr.getInstance().getByName("sysadmin");
				System.err.println(role.getId() + "  " + role.getExtuid());
//				__internalProperty_gradient = getFieldInfoContext().findByDto_Gradient(gradientDTO);
				__internalProperty_gradient = GradientMgr.getInstance().getByExtuid(gradientDTO.getUid());
//			} catch (ir.viratech.commons.api.search.InvalidDtoException e) {
//				throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("The given dto is invalid: "+gradientDTO, e);
//			}
			if (__internalProperty_gradient == null)
				throw new ir.viratech.commons.api.entity_modifier.BadDtoEntityModificationException("No entity was found for the given dto: "+gradientDTO);
		}
		layer.setGradient(__internalProperty_gradient);
	}

	// TODO this generic method is equivalent to three upper ones.
	// if that methods are not needed, they should be removed, otherwise
	// this method must be removed. :)
	/**
	 * @deprecated because save for each type of layer can have different
	 *             algorithm
	 */
	@Deprecated
	public <T extends Layer> SaverDTO<T> createSaverForLayer(Class<T> type) {
		return new SaverDTO<T>() {
			@Override
			public void saveTo(T layer) throws BadDtoEntityModificationException {
				LayerFullDTO dto = LayerFullDTO.this;
				dto.save_Name(layer, getName());
				saveParentAndMap(layer);
			}
		};
	}

	@Override
	protected PlainCollectionDTO<Layer, LayerLightDTO> load_SubLayers(Layer layer) {
		if (Layer.TYPE_PARENT.equals(layer.getType())) {
			ParentLayer pl = (ParentLayer) layer;

			return PlainCollectionDTO.createAndLoad(pl.getSubLayers(), LayerLightDTO.class);
		}
		return null;
	}

	@Override
	protected String load_Type(Layer layer) {
		return layer.getType();
	}

	@Override
	protected Integer load_ChildCount(Layer layer) {
		if (Layer.TYPE_PARENT.equals(layer.getType()))
			return ((ParentLayer) layer).getSubLayers().size();
		else
			return 0;
	}

	// TODO remove this if it's not needed.
	public Class<? extends Layer> getTypeClass() {
		if (Layer.TYPE_PARENT.equals(this.getType()))
			return ParentLayer.class;
		else if (Layer.TYPE_VECTOR.equals(this.getType()))
			return VectorLayer.class;
		else if (Layer.TYPE_RASTER.equals(this.getType()))
			return RasterLayer.class;

		return null;
	}

	@Override
	protected String load_FormSchemaKey(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer) layer).getFormSchemaKey();
		return null;
	}

	@Override
	protected String load_VectorObjectsType(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer) layer).getVectorObjectsType();
		return null;
	}

	@Override
	protected Boolean load_Secret(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()) || Layer.TYPE_RASTER.equals(layer.getType()))
			return ((LeafLayer) layer).isSecret();
		return null;
	}

	@Override
	protected Boolean load_IsPond(Layer layer) {
		return layer.isPondRelated();
	}

	@Override
	protected PondLightDTO load_Pond(Layer layer) {
		if (!Layer.TYPE_PARENT.equals(layer.getType()))
			return null;
		Pond pond = PondMgr.getInstance().getByLayer((ParentLayer) layer);
		if (pond == null)
			return null;
		PondLightDTO dto = new PondLightDTO();
		dto.loadFrom(pond);
		return dto;
	}

	@Override
	protected String load_Icon(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			return vl.getPointIcon();
		}
		return null;
	}

	@Override
	protected String load_Color(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			return vl.getLineColor();
		}
		return null;
	}

	@Override
	protected String load_Width(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			return vl.getLineWidth();
		}
		return null;
	}

	@Override
	protected String load_Fill(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vl = (VectorLayer) layer;
			return vl.getPolygonFill();
		}
		return null;
	}

	@Override
	protected GradientLightDTO load_Gradient(Layer layer) {
		if (Layer.TYPE_RASTER.equals(layer.getType())) {
			GradientLightDTO dto = new GradientLightDTO();
			dto.loadFrom(((RasterLayer)layer).getGradient());
			return dto;
		}

		return null;
	}

	@Override
	protected Boolean load_IsLabeled(Layer layer) {
		if (Layer.TYPE_VECTOR.equals(layer.getType()))
			return ((VectorLayer)layer).isLabled();
		return null;
	}

}
