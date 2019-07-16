package ir.viratech.pond_ms.api.layer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.data.DataSourceException;
import org.geotools.data.DataUtilities;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.SchemaException;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.gce.geotiff.GeoTiffReader;
import org.geotools.process.raster.RasterZonalStatistics;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import com.wordnik.swagger.annotations.Api;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO;
import ir.viratech.commons.api.dto.UI_MetadataDTO.MessageDTO.MessageType;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.cm.model.entity_instance.EntityInstance;
import ir.viratech.commons.cm.model.entity_type.EntityType;
import ir.viratech.commons.cm.model.entity_type.logic.EntityTypeMgr;
import ir.viratech.commons.file.model.AbstractFile;
import ir.viratech.commons.file.model.logic.AbstractFileMgr;
import ir.viratech.commons.file.model.logic.NativeFileMgr;
import ir.viratech.commons.tilegenerator.TiffPixelReader;
import ir.viratech.commons.util.i18n.MessageTranslator;
import ir.viratech.pond_ms.api.RequestHandlingException;
import ir.viratech.pond_ms.api.file.dto.DataFileLightDTO;
import ir.viratech.pond_ms.api.layer.dto.DataFileDTO;
import ir.viratech.pond_ms.api.layer.dto.LayerExpandedDTO;
import ir.viratech.pond_ms.api.layer.dto.LeafLayerLightDTO;
import ir.viratech.pond_ms.api.layer.dto.RasterZonalStatisticsDTO;
import ir.viratech.pond_ms.api.layer.handler.GetLayerDataFilesHandler;
import ir.viratech.pond_ms.api.layer.handler.GetVectorLayerObjectsHandler;
import ir.viratech.pond_ms.commons.geo.Point;
import ir.viratech.pond_ms.commons.geo.Polygon;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.core.interceptor.Compress;
import ir.viratech.pond_ms.model.file.DataFile;
import ir.viratech.pond_ms.model.file.base.BaseDataFileMgr;
import ir.viratech.pond_ms.model.file.logic.DataFileMgr;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.layer.Layer;
import ir.viratech.pond_ms.model.layer.LeafLayer;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.RasterLayer;
import ir.viratech.pond_ms.model.layer.VectorLayer;
import ir.viratech.pond_ms.model.layer.logic.LeafLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.RasterLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.VectorLayerMgr;
import ir.viratech.pond_ms.model.map_object.vector.GISVectorObject;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;
import ir.viratech.pond_ms.util.fileImport.exception.DataImportException;
import ir.viratech.pond_ms.util.fileImport.exception.FeatureTypeIncompatibleException;
import ir.viratech.pond_ms.util.fileImport.raster.RasterImporter;
import ir.viratech.pond_ms.util.fileImport.vector.VectorImporter;
import ir.viratech.pond_ms.util.fileImport.zipUtil.ZipFileUtil;

@Api(value = "/layer", description = "Operations about layers")
@Path("/layer")
public class LayerService extends AbstractJsonService {

	private MessageTranslator messageTranslator = MessageService.getMessageTranslator();

	public MessageTranslator getMessageTranslator() {
		return messageTranslator;
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @param requestDto
	 *            contains file data
	 * @throws RequestHandlingException
	 *
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/datafile/add")
	public Response addDataFile(DataFileDTO requestDto) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.ADD_LAYER_FILES))
			return Response.status(Status.FORBIDDEN).build();
		LeafLayer layer = LeafLayerMgr.getInstance().getByExtuid(requestDto.getLayerUID());
		if (layer == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("layer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		AbstractFile compressedFile = AbstractFileMgr.getInstance().getByHashCodeString(requestDto.getHashCode());
		String unzippedPath = validateAndExtract(compressedFile);
		String fileName = checkExtensions(unzippedPath, layer);
		if (Layer.TYPE_VECTOR.equals(layer.getType())) {
			VectorLayer vectorLayer = (VectorLayer) layer;
			EntityType entityType = EntityTypeMgr.getInstance().getByKey(vectorLayer.getFormSchemaKey());
			Map<GISVectorObject, EntityInstance> data = null;
			if ("kml".equals(FilenameUtils.getExtension(fileName))) {
				// TODO
			} else if ("shp".equals(FilenameUtils.getExtension(fileName))) {
				// TODO vectorlayer formschema and objecttype must be mandatory!
				try {
					VectorImporter vectorImporter = new VectorImporter(unzippedPath, vectorLayer.getVectorObjectsType(),
							entityType);
					data = vectorImporter.extractData();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (FeatureTypeIncompatibleException e) {
					throw ResponseException.create(Response.status(Status.BAD_REQUEST)
							.entity(UI_MetadataDTO.createWith_i18n("vectorlayer.file_upload.feature_type.mismatch",
									MessageType.ERROR, getMessageTranslator()))
							.build());
				}
			}
			VectorLayerMgr.getInstance().importVectorData(data, vectorLayer);
		} else if (Layer.TYPE_RASTER.equals(layer.getType())) {
			RasterLayer rasterLayer = (RasterLayer) layer;
			RasterImporter rasterImporter = new RasterImporter(unzippedPath, rasterLayer);
			rasterImporter.cleanData();
			try {
				rasterImporter.importData();
				// TODO
				java.nio.file.Path tempFile = Paths.get(unzippedPath, fileName);
				AbstractFile rasterFile = NativeFileMgr.getInstance().addFile(Files.probeContentType(tempFile),
						tempFile.getFileName().toString(), IOUtils.toByteArray(new FileInputStream(tempFile.toFile())));
				AbstractFile temp = rasterLayer.getRasterFile();
				rasterLayer.setRasterFile(rasterFile);
				if (temp != null) {
					AbstractFileMgr.getInstance().delete(temp);
				}
			} catch (DataImportException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("layer.type.invalid", MessageType.ERROR, getMessageTranslator()))
					.build());
		}
		try {
			FileUtils.deleteDirectory(new File(unzippedPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DataFile datafile = DataFileMgr.getInstance().createNew();
		datafile.setAbstractFile(compressedFile);
		datafile.setDataCollectionDate(requestDto.getDate());
		datafile.setDataReference(requestDto.getReference());
		BaseDataFileMgr.getInstance().add(datafile);
		layer.addToDataFiles(datafile);
		LeafLayerMgr.getInstance().update(layer);

		return Response.ok().build();
		// return new AddFileToLayerHandler(requestDto).handle();

	}

	protected String validateAndExtract(AbstractFile file) {
		String path = null;
		if (file == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(UI_MetadataDTO
					.createWith_i18n("layer.file_upload.hash.invalid", MessageType.ERROR, getMessageTranslator()))
					.build());
		try {
			path = new ZipFileUtil().unzip(file);
			if (path == null)
				throw new NullPointerException();
		} catch (IOException | NullPointerException e) {
			e.printStackTrace();
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(UI_MetadataDTO
					.createWith_i18n("layer.file_upload.unzipping.error", MessageType.ERROR, getMessageTranslator()))
					.build());
		}
		return path;
	}

	protected String checkExtensions(String path, LeafLayer layer) {
		File directory = new File(path);
		String fileName = null;
		for (File f : directory.listFiles())
			if (layer.getMainDataFileExtension().contains(FilenameUtils.getExtension(f.getName()))) {
				if (fileName != null)
					throw ResponseException.create(Response.status(Status.BAD_REQUEST)
							.entity(UI_MetadataDTO.createWith_i18n("layer.file_upload.extension.duplicate",
									MessageType.ERROR, getMessageTranslator()))
							.build());
				fileName = f.getName();
			}
		if (fileName == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST)
					.entity(UI_MetadataDTO.createWith_i18n("layer.file_upload.extension.not_found", MessageType.ERROR,
							getMessageTranslator()))
					.build());
		return fileName;
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/datafile/get/{layer_uid}")
	public Response getVectorDataFiles(@PathParam("layer_uid") String Uid) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.GET_LAYER_FILES))
			return Response.status(Status.FORBIDDEN).build();
		LeafLayer layer = LeafLayerMgr.getInstance().getByExtuid(Uid);
		return new GetLayerDataFilesHandler(layer).handle();
	}

	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *
	 */
	@POST
	@Path("/datafile/delete/{layer_uid}")
	public Response deleteVectorDataFile(@PathParam("layer_uid") String layerUid, DataFileLightDTO requestDto) throws RequestHandlingException {
		if (!AccessChecker.hasAccessToAny(FeatureNames.DELETE_LAYER_FILES))
			return Response.status(Status.FORBIDDEN).build();
		LeafLayer layer = LeafLayerMgr.getInstance().getByExtuid(layerUid);
		if (layer == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("layer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		LeafLayerMgr.getInstance().deleteDatafile(layer, requestDto.getUid());
		return Response.ok().build();
	}

	@GET
	@Compress
	@Path("/vector-object/items/{layer_uid}")
	public Response getVectorLayerObjects(@PathParam("layer_uid") String layerUid, @QueryParam("start") long start,
			@QueryParam("len") int len) throws RequestHandlingException {
		// TODO access checker
		return new GetVectorLayerObjectsHandler(layerUid, start, len).handle();
	}

	@GET
	@Path("/leaf-sublayers/{layer_uid}")
	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 *             if layer is not pondRelated or even not parent!
	 */
	public PlainCollectionDTO<LeafLayer, LeafLayerLightDTO> getLeafSubLayers(@PathParam("layer_uid") String layerUid)
			throws RequestHandlingException {
		// TODO Access checker
		ParentLayer layer = ParentLayerMgr.getInstance().getByExtuid(layerUid);
		if (layer == null)
			throw ResponseException.create(Response.status(Status.BAD_REQUEST).entity(
					UI_MetadataDTO.createWith_i18n("vectorlayer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		ArrayList<LeafLayer> layers = ParentLayerMgr.getInstance().getLeafSubLayers(layer);
		return PlainCollectionDTO.createAndLoad(layers, LeafLayerLightDTO.class);
	}

	@POST
	@Path("/zonal-statistics/{layer_uid}")
	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 */
	public Response getZonalStatistics(@PathParam("layer_uid") String layerUid, Polygon polygon) {
		RasterLayer layer = RasterLayerMgr.getInstance().getByExtuid(layerUid);
		if (layer == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("rasterlayer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		AbstractFile tiffFile = layer.getRasterFile();
		if (tiffFile == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND)
					.entity(UI_MetadataDTO.createWith_i18n("tiff.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());

		/*****
		 * Create polygon
		 */
		com.vividsolutions.jts.geom.Polygon jtsPolygon = polygon.getJtsGeometry();
		DefaultFeatureCollection zones = new DefaultFeatureCollection();
		SimpleFeatureType TYPE = null;
		try {
			TYPE = DataUtilities.createType("the_geom", "Polygon:Polygon:srid=4326,");
		} catch (SchemaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SimpleFeature feature = SimpleFeatureBuilder.build(TYPE, new Object[] { jtsPolygon }, null);
		zones.add(feature);

		/*****
		 * Create Raster coverage
		 */
		GeoTiffReader tiffReader = null;
		GridCoverage2D coverage2d = null;
		try (InputStream is = tiffFile.getBinaryStream()) {
			// Read coverage
			tiffReader = new GeoTiffReader(is);
			coverage2d = tiffReader.read(null);
		} catch (DataSourceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * GeoTiffReader tiffReader = null; GridCoverage2D coverage2d = null;
		 * try { tiffReader = new GeoTiffReader(file, new
		 * Hints(Hints.FORCE_LONGITUDE_FIRST_AXIS_ORDER, true)); coverage2d =
		 * tiffReader.read(null); } catch (DataSourceException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */

		RasterZonalStatistics rasterZonalStatistics = new RasterZonalStatistics();
		SimpleFeatureCollection result = null;
		result = rasterZonalStatistics.execute(coverage2d, 0, zones, null);
		SimpleFeatureIterator ite = result.features();
		RasterZonalStatisticsDTO dto = new RasterZonalStatisticsDTO();

		if (ite.hasNext()) {
			SimpleFeature sf = ite.next();
			ite.close();

			dto.setAvg((double) sf.getAttribute("avg"));
			dto.setMin((double) sf.getAttribute("min"));
			dto.setMax((double) sf.getAttribute("max"));
			dto.setStddev((double) sf.getAttribute("stddev"));
		}

		tiffReader.dispose();
		coverage2d.dispose(true);

		return Response.ok().entity(dto).build();
	}

	@POST
	@Path("/identify-point/{layer_uid}")
	/**
	 * @author Mohammad Javad Rafiei
	 * @throws RequestHandlingException
	 */
	public Response identifyPoint(@PathParam("layer_uid") String layerUid, Point point) {
		RasterLayer layer = RasterLayerMgr.getInstance().getByExtuid(layerUid);
		if (layer == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND).entity(
					UI_MetadataDTO.createWith_i18n("rasterlayer.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());
		AbstractFile tiffFile = layer.getRasterFile();
		if (tiffFile == null)
			throw ResponseException.create(Response.status(Status.NOT_FOUND)
					.entity(UI_MetadataDTO.createWith_i18n("tiff.not_found", MessageType.ERROR, getMessageTranslator()))
					.build());

		TiffPixelReader[] readers = null;
		try {
			InputStream binaryStream = tiffFile.getBinaryStream();

			InputStream stream = tiffFile.getBinaryStream();
			byte[] b = new byte[1024 * 1024];
			int x = 0;
			int iii = 0;
			while (true)
			{
				int n = stream.read(b);
				if (n == -1)
					break;
				for (int i = 0; i < n; i++)
				{
					x ^= b[i] * iii++;
				}
			}
			System.out.println(x);

			readers = TiffPixelReader.getAllReaders(binaryStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		double x = (double) point.getCoordinates().get(0);
		double y = (double) point.getCoordinates().get(1);
		double value = readers[0].getPixel(x, y);

		try {
			for (TiffPixelReader tpr : readers)
				tpr.dispose();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return Response.ok().entity(value).build();
	}

	@POST
	@Path("/batch-import")
	public Response batchImportLayers(List<LayerExpandedDTO> requestDtos) throws RequestHandlingException {
		for (LayerExpandedDTO requestDto : requestDtos) {
			if(Layer.TYPE_PARENT.equals(requestDto.getType())){
				ParentLayer layer = ParentLayerMgr.getInstance().createNew();
				requestDto.saveTo(layer);
				ParentLayerMgr.getInstance().add(layer);
				GISMapMgr.getInstance().update(layer.getMap());
			} else if (Layer.TYPE_VECTOR.equals(requestDto.getType())){
				VectorLayer layer = VectorLayerMgr.getInstance().createNew();
				requestDto.saveTo(layer);
				VectorLayerMgr.getInstance().add(layer);
				GISMapMgr.getInstance().update(layer.getMap());
			}else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		}

		return Response.ok().build();
	}
}
