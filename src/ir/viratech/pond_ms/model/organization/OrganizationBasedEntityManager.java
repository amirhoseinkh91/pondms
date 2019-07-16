package ir.viratech.pond_ms.model.organization;

import java.util.List;

import ir.viratech.commons.model.BasicEntityMgr;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityModifier;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.model.search.criterion.RestrictionOperator;
import ir.viratech.commons.model.search.criterion.SingleFieldValueRestriction;
import ir.viratech.commons.paged_list.api.PagedList;

public class OrganizationBasedEntityManager<T extends OrganizationBasedProvider> implements BasicEntityMgr<T> {

	private Organization org;
	private BasicEntityMgr<T> mgr;
	private String propertyKey;

	public OrganizationBasedEntityManager(String propertyKey, Organization org, BasicEntityMgr<T> mgr) {
		this.org = org;
		this.mgr = mgr;
		this.propertyKey = propertyKey;
	}

	@Override
	public T getByExtuid(String uid) {
		T item = mgr.getByExtuid(uid);
		if (item.getOrganization().equals(org))
			return item;
		return null;
	}

	@Override
	public T getExistingByExtuid(String uid) throws EntityObjectNotFoundException {
		return mgr.getExistingByExtuid(uid);
	}

	@Override
	public T getOrCreateByExtuid(String uid, boolean creationAllowed) {
		return mgr.getOrCreateByExtuid(uid, creationAllowed);
	}

	@Override
	public T createNew() {
		return mgr.createNew();
	}

	@Override
	public long countAll() {
		try {
			return search(new SearchQuery()).getTotalSize();
		} catch (InvalidSearchQueryException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<T> pageList(long listStart, int listLength) {
		try {
			return search(new SearchQuery()).getItems(listStart, listLength);
		} catch (InvalidSearchQueryException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public PagedList<T> search(SearchQuery searchQuery) throws InvalidSearchQueryException {
		searchQuery.addToCriteria(new SingleFieldValueRestriction<Organization>(RestrictionOperator.EQ, propertyKey, org));
		return mgr.search(searchQuery);
	}

	@Override
	public T add(final EntityModifier<T> entityModifier0) throws EntityModificationException {

		EntityModifier<T> entityModifier = new EntityModifier<T>() {

			@Override
			public void modify(T obj) throws EntityModificationException {
				entityModifier0.modify(obj);
				obj.setOrganization(org);
			}
		};
		return mgr.add(entityModifier);
	}

	@Override
	public T update(String uid, EntityModifier<T> entityModifier) throws EntityObjectNotFoundException, EntityModificationException {
		T item = null;
		if (mgr.getByExtuid(uid).getOrganization().equals(org))
			item = mgr.update(uid, entityModifier);
		return item;
	}

	@Override
	public T deleteByExtuid(String uid) throws EntityObjectNotFoundException, EntityModificationException {
		T item = null;
		if (mgr.getByExtuid(uid).getOrganization().equals(org))
			item = mgr.deleteByExtuid(uid);
		return item;
	}

	public List<T> list() {
		//TODO remove Integer.MAX_VALUE
		return this.pageList(0, Integer.MAX_VALUE);
	}

}
