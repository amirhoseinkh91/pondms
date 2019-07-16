package ir.viratech.pond_ms.api;

import java.util.Collection;

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
import ir.viratech.pond_ms.model.organization.OrganizationBasedAndTreeProvider;
import ir.viratech.pond_ms.model.organization.OrganizationBasedEntityManager;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

/**
 * The base class for MgrBased resources.
 *
 * @param <E>
 *            The entity type
 * @param <D>
 *            The full DTO type
 */
public abstract class AbstractOrganizationBasedMgrBasedTreeResource<E extends OrganizationBasedAndTreeProvider<E> & BaseEntityInterface, D extends EntityFullDTO<E>> extends
		AbstractMgrBasedTreeResource<E, D> {

	@PathParam("org_key") String org_key;
//	protected Organization org;

	protected abstract BasicEntityMgr<E> getMgr();

	protected abstract Collection<E> getRootChildren(Organization org);

	public String getPropertyKey() {
		return "organization";
	}

	private final OrganizationBasedEntityManager<E> getOrgBasedMgr() throws EntityModificationException {
		Organization org = OrganizationMgr.getInstance().getByExtuid(org_key);
		Organization organization = ApplicationContextUtil.getCurrentExecutionContext().getUser().getOrganization();
		if(organization != null && !org.equals(organization)){
			throw new EntityModificationException("");
		}
		return new OrganizationBasedEntityManager<E>(getPropertyKey(), org, this.getMgr());
	}

	@Override
	public final Collection<E> getRootChildren() {
		return getRootChildren(OrganizationMgr.getInstance().getByExtuid(org_key));
	}

	@Override
	protected E getByUid(String uid) {
		return this.getOrgBasedMgr().getByExtuid(uid);
	}

	@Override
	protected E add(EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityModificationException {
		E e = this.getOrgBasedMgr().add(entityModifier);
		return e;
	}

	@Override
	protected E update(String uid, EntityModifierWithSaverDTO<E, D> entityModifier) throws EntityObjectNotFoundException, EntityModificationException {
		E e = this.getOrgBasedMgr().update(uid, entityModifier);
		return e;
	}

	@Override
	protected E deleteByUid(String uid) throws EntityObjectNotFoundException, EntityModificationException {
		E e = this.getOrgBasedMgr().deleteByExtuid(uid);
		return e;
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
