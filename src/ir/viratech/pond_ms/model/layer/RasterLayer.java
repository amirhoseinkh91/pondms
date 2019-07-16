package ir.viratech.pond_ms.model.layer;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import ir.viratech.pond_ms.model.layer.base.BaseRasterLayer;
import ir.viratech.pond_ms.util.config.ConfigConstants;
import ir.viratech.pond_ms.util.config.ConfigUtils;

/**
 * The entity class "RasterLayer".
 */

public class RasterLayer extends BaseRasterLayer {
	private static final long serialVersionUID = 1L;

	public static final String COLORMAP_TEMPERATURE = "temperature";
	public static final String COLORMAP_NDVI = "ndvi";
	public static final String COLORMAP_DEM = "dem";


	@Override
	public String getType() {
		return Layer.TYPE_RASTER;
	}

	@Override
	public Set<String> getMainDataFileExtension() {
		return new HashSet<>(Arrays.asList("tif"));
	}

	public String getCacheTilesPath() {
		String relativeLayerTilesPathFromWebapps = ConfigUtils.get(ConfigConstants.RASTER_TILES_BASE_PATH);
		if (relativeLayerTilesPathFromWebapps == null)
			relativeLayerTilesPathFromWebapps = "RasterCache";
		String cacheTilesPath = Paths.get(System.getProperty("catalina.base"), "webapps", relativeLayerTilesPathFromWebapps,
				this.getExtuid()).toString();
		return cacheTilesPath;
	}

	@Override
	public void onDelete() {
		// TODO must handle foreign keys
		// this type has raster file which is not cascade delete in hbm
		super.onDelete();
	}

	@Override
	public String getEntityTypeKey() {
		return "rasterLayer";
	}

}