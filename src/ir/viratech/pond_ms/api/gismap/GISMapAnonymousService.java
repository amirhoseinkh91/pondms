package ir.viratech.pond_ms.api.gismap;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.wordnik.swagger.annotations.ApiOperation;

import ir.viratech.commons.api.ResponseException;
import ir.viratech.commons.api.dto.LoaderDTO;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.dto.SimpleTabularCollectionDTO;
import ir.viratech.commons.api.pagination.PaginationParameters;
import ir.viratech.commons.api.search.InvalidSearchQueryDtoException;
import ir.viratech.commons.api.search.SearchQueryConverter;
import ir.viratech.commons.api.search.SearchQueryDTO;
import ir.viratech.commons.api.search.field.FieldInfoContext;
import ir.viratech.commons.api.search.field.dto.FieldInfoDtoFactory;
import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.commons.api.service.search.SearchParameters;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.pond_ms.api.gismap.dto.GISMapFullDTO;
import ir.viratech.pond_ms.api.gismap.dto.GISMapLightDTO;
import ir.viratech.pond_ms.api.layer.dto.LayerFullDTO;
import ir.viratech.pond_ms.core.i18n.MessageService;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.layer.Layer;

/**
 * @deprecated because of generating {@link GISMapAnonymousResource} as a replacement of it
 * 				<br> But codes in this class can used as a pattern for simulating resource in a service 
 */

@Deprecated
@Path("/gis-map")
public class GISMapAnonymousService extends AbstractJsonService {
	private static final transient Logger logger = Logger.getLogger(GISMapAnonymousService.class);

	/**
	 * Gets the list of anonymous-viewable maps.
	 *
	 * @param listStart
	 *            the list start
	 * @param listLength
	 *            the list length
	 * @param extent
	 *            the extent
	 * @param request
	 *            the request
	 * @return the list
	 */
	@GET
	@Path("/items")
	@ApiOperation(value = "Returns a list of searched entity objects")
	public Object getList(@BeanParam SearchParameters searchParameters) {
		SearchQueryDTO searchQueryDto = searchParameters.extractBody(SearchQueryDTO.class);
		PaginationParameters paginationParameters = searchParameters.getPaginationParameters();
		String extent = searchParameters.getExtent();
		GISMapFullDTO.FieldInfoContext searchFieldInfoContext = new GISMapFullDTO.FieldInfoContext();
		SearchQuery searchQuery;
		PagedList<GISMap> pagedGISMapList;
		try {
			searchQuery = SearchQueryConverter.convert(searchQueryDto, searchFieldInfoContext);
			pagedGISMapList = GISMapMgr.getInstance().search(searchQuery);
			long start = paginationParameters.getValidStart();
			int length = paginationParameters.getValidLength(10, 50);
			FieldInfoContext<? extends LoaderDTO<GISMap>> responseFieldInfoContext = StringUtils.equals(extent, "full") ? new GISMapFullDTO.FieldInfoContext() : new GISMapLightDTO.FieldInfoContext();
			return new SimpleTabularCollectionDTO<>(
					PlainCollectionDTO.createAndLoad(pagedGISMapList.getItems(start, length), responseFieldInfoContext).getItems(),
					pagedGISMapList.getTotalSize(),
					FieldInfoDtoFactory.createFieldInfoDtoCollection(responseFieldInfoContext, "gismap.", MessageService.getMessageTranslator()));
		} catch (InvalidSearchQueryException | InvalidSearchQueryDtoException e) {
			logger.error("", e);
			throw ResponseException.createWithStatus_BadRequest(e);
		}

	}

	//TODO this service should be removed if not needed
	@GET
	@Path("/items/{map-uid}/root-layers")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get root layers of map")
	public PlainCollectionDTO<Layer, LayerFullDTO> getFirstLayers(@PathParam("map-uid") String gismapUid) {
		List<Layer> layers = GISMapMgr.getInstance().getRootLayersByMapExtuid(gismapUid);
		return PlainCollectionDTO.createAndLoad(layers, LayerFullDTO.class);
	}
	
	
	@GET
	@Path("/items/{map-uid}")
	@Produces(MediaType.APPLICATION_JSON)
	@ApiOperation(value = "get all infos of a map")
	public GISMapFullDTO getInfo(@PathParam("map-uid") String gismapUid) {
		GISMap gisMap = GISMapMgr.getInstance().getByExtuid(gismapUid);
		if(gisMap == null)
			throw ResponseException.createWithStatus_NotFound("No map object found with uid='"+gismapUid+"'");
		
		GISMapFullDTO gisMapFullDTO = new GISMapFullDTO();
		gisMapFullDTO.loadFrom(gisMap);
		return gisMapFullDTO;
	}
}
