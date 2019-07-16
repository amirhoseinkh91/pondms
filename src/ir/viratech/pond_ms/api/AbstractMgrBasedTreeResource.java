package ir.viratech.pond_ms.api;

import java.util.Collection;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.wordnik.swagger.annotations.ApiOperation;

import ir.viratech.base.UIDAndDisplayStringAndTreeProvider;
import ir.viratech.commons.api.dto.EntityFullDTO;
import ir.viratech.commons.api.dto.EntityLoaderDTO;
import ir.viratech.commons.api.dto.PlainCollectionDTO;
import ir.viratech.commons.api.search.InvalidSearchQueryDtoException;
import ir.viratech.commons.api.search.SearchQueryConverter;
import ir.viratech.commons.api.search.SearchQueryDTO;
import ir.viratech.commons.api.service.search.SearchParameters;
import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.InvalidEntityModificationException;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;

/**
 * The base class for MgrBased resources.
 *
 * @param <E>
 *            The entity type
 * @param <D>
 *            The full DTO type
 */
public abstract class AbstractMgrBasedTreeResource<E extends UIDAndDisplayStringAndTreeProvider<E> & BaseEntityInterface, D extends EntityFullDTO<E>>
		extends AbstractMgrBasedResource<E, D> {

	private static final int MAX_NUMBER = 10000000;

	public abstract Collection<E> getRootChildren();

	public abstract void moveEntity(String childExtuid, String parentExtuid)
			throws InvalidEntityModificationException, EntityObjectNotFoundException;

	@GET
	@Path("children/{uid: .+}")
//	@ApiOperation("Returns a specific entity object")
//	@ApiResponses({ @ApiResponse(code = 200, message = "OK, with some response content"),
//			@ApiResponse(code = 204, message = "OK, with no response content"),
//			@ApiResponse(code = 400, message = "Bad Request, for bad information sent to server"),
//			@ApiResponse(code = 403, message = "Forbidden, for accessing something not allowed"),
//			@ApiResponse(code = 404, message = "Not Found, for referring something which does not exist"),
//			@ApiResponse(code = 500, message = "Internal server error") })
	@SuppressWarnings("unchecked")
	public PlainCollectionDTO<E, ? extends EntityLoaderDTO<E>> getChildren(@PathParam("uid") String uid) {
		Collection<E> children;
		if (uid.equals("root")) {
			children = getRootChildren();
		} else {
			children = getByUid(uid).getChildren();
		}
		return PlainCollectionDTO.createAndLoad(children, TreeDTO.getTreeGenericClass());
	}

	@POST
	@Path("/move")
	@ApiOperation(value = "moves a node and puts it a child of another node")
	public void move(EntityMovingDTO dto) throws InvalidEntityModificationException, EntityObjectNotFoundException {
		moveEntity(dto.getChildUid(), dto.getParentUid());
	}

	@GET
	@Path("/search")
//	@ApiOperation(value = "Search in tree")
	public TreeSearchListDTO<?> getTreeList(@BeanParam SearchParameters searchParameters) throws InvalidSearchQueryException, InvalidSearchQueryDtoException{
		searchParameters = (searchParameters == null ? new SearchParameters() : searchParameters);
		SearchQueryDTO searchQueryDTO = searchParameters.extractBody(SearchQueryDTO.class);
		SearchQuery searchQuery = SearchQueryConverter.convert(searchQueryDTO, getFullDtoFieldInfoContext());

		Collection<E> eList = getListAndTotalCount(0, MAX_NUMBER, searchQuery).getItems();
		TreeSearchListDTO<E> response = new TreeSearchListDTO<E>();
		response.loadFrom(eList);
		return response;
	}

	// @Override
	// protected void validate_Edit(String uid, D fullDto) throws
	// InvalidEntityModificationException {
	// super.validate_Edit(uid, fullDto);
	// {
	// fullDto.get
	// }
	// }
}
