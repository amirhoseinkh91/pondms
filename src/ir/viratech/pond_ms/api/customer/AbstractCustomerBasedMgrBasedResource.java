package ir.viratech.pond_ms.api.customer;

import ir.viratech.commons.api.dto.EntityFullDTO;
import ir.viratech.commons.api.entity_modifier.EntityModifierWithSaverDTO;
import ir.viratech.commons.model.BasicEntityMgr;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.ListAndTotalCount;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.commons.model.UIDAndDisplayStringProvider;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.pond_ms.api.AbstractMgrBasedResource;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.customer.Customer;
import ir.viratech.pond_ms.model.customer.CustomerBasedProvider;
import ir.viratech.pond_ms.model.customer.logic.CustomerBasedEntityManager;

public abstract class AbstractCustomerBasedMgrBasedResource<E extends CustomerBasedProvider & UIDAndDisplayStringProvider, D extends EntityFullDTO<E>>
extends AbstractMgrBasedResource<E, D> {

	protected abstract BasicEntityMgr<E> getMgr();
	public String getPropertyKey(){
		return "customer";
	};

	private final CustomerBasedEntityManager<E> getCustomerBasedMgr(){
		Customer customer = ApplicationContextUtil.getCurrentExecutionContext().getCustomer();
		return new CustomerBasedEntityManager<E>(customer, getPropertyKey(), this.getMgr());
	}

	@Override
	protected E getByUid(String uid) {
		return this.getCustomerBasedMgr().getByExtuid(uid);
	}

	@Override
	protected E add(EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityModificationException {
		return this.getCustomerBasedMgr().add(entityModifier);
	}

	@Override
	protected E update(String uid, EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityObjectNotFoundException, EntityModificationException {
		return this.getCustomerBasedMgr().update(uid, entityModifier);
	}

	@Override
	protected E deleteByUid(String uid) throws EntityObjectNotFoundException, EntityModificationException {
		return this.getCustomerBasedMgr().deleteByExtuid(uid);
	}

	@Override
	protected ListAndTotalCount<E> getListAndTotalCount(long listStart, int listLength, SearchQuery searchQuery) throws InvalidSearchQueryException {
		if (searchQuery == null) {
			return new SimpleListAndTotalCount<E>(this.getCustomerBasedMgr().pageList(listStart, listLength), this.getCustomerBasedMgr().countAll());
		}
		PagedList<E> pl = this.getCustomerBasedMgr().search(searchQuery);
		return SimpleListAndTotalCount.create(pl, listStart, listLength);
	}

}
