package ir.viratech.mongo.model;

import ir.viratech.commons.model.BasicEntityMgr;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityModifier;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.commons.util.containers.CollectionsUtil;

import java.util.List;
import java.util.Set;

public abstract class AbstractMongoEntityMgr<E, I extends java.io.Serializable> implements BasicEntityMgr<E> {

	protected abstract AbstractMongoEntityDAO<E,I> getDAO();
	
	@Override
	public E createNew() {		
		return this.getDAO().createNew();
	}

	@Override
	public E getByExtuid(String uid) {
		E obj = this.getDAO().getByExtuid(uid);
		return obj;
	}
	
	@Override
	public E getExistingByExtuid(String uid) throws EntityObjectNotFoundException {
		return this.getDAO().getExistingByExtuid(uid);
	}

	private E getOrCreateByExtuid_UsingDAO(String uid, boolean creationAllowed) {
		return this.getDAO().getOrCreateByExtuid(uid, creationAllowed);
	}
	
	@Override
	public E getOrCreateByExtuid(String uid, boolean creationAllowed) {
		return this.getOrCreateByExtuid_UsingDAO(uid, creationAllowed);
	}
	
	public E findOne() {
		return CollectionsUtil.getFirst_Nullable(this.getDAO().findAll());
	}
	
	public E getByMongoId(String id) {
		E obj = this.getDAO().getByMongoId(id);
		return obj;
	}
	
	public E getExistingByMongoId(String id) throws EntityObjectNotFoundException {
		return this.getDAO().getExistingByMongoId(id);
	}
	
	public List<E> getAllByExtuids(Set<String> extuids) {
		if(extuids != null)
			return this.getDAO().getAllByExtuids(extuids);
		else
			return null;
	}
	
	public List<E> getAllByIds(Set<String> ids) {
		if(ids != null) {
			return this.getDAO().getAllByMongoIds(ids);
		} else
			return null;
	}

	@Override
	public long countAll() {		
		return this.getDAO().getCount();
	}

	@Override
	public List<E> pageList(long listStart, int listLength) {
		if(listLength == 0) {
			return this.getDAO().findAll();
		}
		return this.getDAO().findAll((int)listStart, listLength);
	}

	
	public List<E> list() {
		return this.getDAO().findAll();
	}
	
	@Override
	public PagedList<E> search(SearchQuery searchQuery)
			throws InvalidSearchQueryException {
		 return getDAO().search(searchQuery);
	}

	@Override
	public E add(EntityModifier<E> entityModifier)
			throws EntityModificationException {
		E obj = this.createAndModify(entityModifier);
		onAdd(obj);
		//TODO: consider object validation
		this.getDAO().save(obj);
		return obj;
	}

	public I add(E obj) {
		return this.getDAO().save(obj);
	}

	@Override
	public E update(String extuid, EntityModifier<E> entityModifier)
			throws EntityObjectNotFoundException, EntityModificationException {
		E obj = this.getDAO().getExistingByExtuid(extuid);
		this.onEdit(obj);
		entityModifier.modify(obj);
		this.getDAO().update(obj);
		return obj;
	}
	
	public E update(E obj) {
		this.getDAO().update(obj);
		return obj;
	}

	@Override
	public E deleteByExtuid(String uid) throws EntityObjectNotFoundException,
			EntityModificationException {
		return this.getDAO().deleteByExtuid(uid);
	}

	protected E createAndModify(EntityModifier<E> entityModifier) throws EntityModificationException {
		E obj = this.createNew();
		entityModifier.modify(obj);
		return obj;
	}
	
	protected void onAdd(E obj) {		
	}
	
	protected void onEdit(E obj) {
	}
}
