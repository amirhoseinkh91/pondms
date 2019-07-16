package ir.viratech.pond_ms.api;

import javax.ws.rs.PathParam;

import ir.viratech.commons.api.dto.EntityFullDTO;
import ir.viratech.commons.api.entity_modifier.EntityModifierWithSaverDTO;
import ir.viratech.commons.event_logging.model.BaseEntityInterface;
import ir.viratech.commons.model.BasicEntityMgr;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.ListAndTotalCount;
import ir.viratech.commons.model.SimpleListAndTotalCount;
import ir.viratech.commons.model.search.InvalidSearchQueryException;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.OrganizationBasedEntityManager;
import ir.viratech.pond_ms.model.organization.OrganizationBasedProvider;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

/**
 * The base class for MgrBased resources.
 *
 * @param <E>
 *            The entity type
 * @param <D>
 *            The full DTO type
 */
public abstract class AbstractOrganizationBasedMgrBasedResource<E extends OrganizationBasedProvider & BaseEntityInterface, D extends EntityFullDTO<E>> extends
		AbstractMgrBasedResource<E, D> {

	@PathParam("org_key") String org_key;
	protected Organization org;

	protected abstract BasicEntityMgr<E> getMgr();

	public String getPropertyKey() {
		return "organization";
	};

	private final OrganizationBasedEntityManager<E> getOrgBasedMgr() throws EntityModificationException {
		org = OrganizationMgr.getInstance().getByExtuid(org_key);
		Organization organization = ApplicationContextUtil.getCurrentExecutionContext().getUser().getOrganization();
		if(organization != null && !org.equals(organization)){
			throw new EntityModificationException("");
		}
		return new OrganizationBasedEntityManager<E>(getPropertyKey(), org, this.getMgr());
	}

	@Override
	protected E getByUid(String uid) {
		return this.getOrgBasedMgr().getByExtuid(uid);
	}

	@Override
	protected E add(EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityModificationException {
		return this.getOrgBasedMgr().add(entityModifier);
	}

	@Override
	protected E update(String uid, EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityObjectNotFoundException, EntityModificationException {
		return this.getOrgBasedMgr().update(uid, entityModifier);
	}

	@Override
	protected E deleteByUid(String uid) throws EntityObjectNotFoundException, EntityModificationException {
		return this.getOrgBasedMgr().deleteByExtuid(uid);
	}

	@Override
	protected ListAndTotalCount<E> getListAndTotalCount(long listStart, int listLength, SearchQuery searchQuery) throws InvalidSearchQueryException {
		if (searchQuery == null) {
			return new SimpleListAndTotalCount<E>(this.getOrgBasedMgr().pageList(listStart, listLength), this.getOrgBasedMgr().countAll());
		}
		PagedList<E> pl = this.getOrgBasedMgr().search(searchQuery);
		return SimpleListAndTotalCount.create(pl, listStart, listLength);
	}

}
