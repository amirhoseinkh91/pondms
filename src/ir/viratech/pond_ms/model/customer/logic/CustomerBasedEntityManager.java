package ir.viratech.pond_ms.model.customer.logic;

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
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.CustomerBasedProvider;

public class CustomerBasedEntityManager<T extends CustomerBasedProvider> implements BasicEntityMgr<T> {

	private Customer customer;
	private BasicEntityMgr<T> mgr;
	private String propertyKey;

	public CustomerBasedEntityManager(Customer customer, String propertyKey, BasicEntityMgr<T> mgr) {
		this.customer = customer;
		this.mgr = mgr;
		this.propertyKey = propertyKey;
	}

	@Override
	public T getByExtuid(String uid) {
		T item = mgr.getByExtuid(uid);
		if(item.getCustomer().equals(customer))
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
		searchQuery.addToCriteria(new SingleFieldValueRestriction<Customer>(RestrictionOperator.EQ,
				propertyKey ,customer));
		return mgr.search(searchQuery);
	}

	@Override
	public T add(EntityModifier<T> entityModifier0) throws EntityModificationException {

		EntityModifier<T> entityModifier = new EntityModifier<T>() {

			@Override
			public void modify(T obj) throws EntityModificationException {
				entityModifier0.modify(obj);
				obj.setCustomer(customer);
			}
		};
		return mgr.add(entityModifier);
	}

	@Override
	public T update(String uid, EntityModifier<T> entityModifier) throws EntityObjectNotFoundException, EntityModificationException {
		T item = null;
		if(mgr.getByExtuid(uid).getCustomer().equals(customer))
			item = mgr.update(uid, entityModifier);
		return item;
	}

	@Override
	public T deleteByExtuid(String uid) throws EntityObjectNotFoundException,
			EntityModificationException {
		T item = null;
		if(mgr.getByExtuid(uid).getCustomer().equals(customer))
			item = mgr.deleteByExtuid(uid);
		return item;
	}

	public List<T> list() {
		//TODO remove Integer.MAX_VALUE
		return this.pageList(0, Integer.MAX_VALUE);
	}

}
