package ir.viratech.mongo.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

import ir.viratech.commons.spring.context.ApplicationContextProvider;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.model.order.OrderEntry;
import ir.viratech.commons.model.search.SearchCriterion;
import ir.viratech.commons.model.search.SearchQuery;
import ir.viratech.commons.model.uid.UidGenerator;
import ir.viratech.commons.paged_list.api.PagedList;
import ir.viratech.mongo.model.search.SearchConverter;

public abstract class AbstractMongoEntityDAO<E, I extends java.io.Serializable> {


	@Autowired
	protected MongoTemplate mongo;

	@Autowired
	private UidGenerator uidGenerator;

	protected final String entityPropertyNameForExtuid__ = this.getEntityPropertyNameForExtuid__();

	protected final String entitySetterNameForExtuid__ = this.getEntitySetterNameForExtuid__();

	protected final String entityPropertyNameForDeleted__ = this.getEntityPropertyNameForDeleted__();

	protected final String entitySetterNameForDeleted__ = this.getEntitySetterNameForDeleted__();
	
	/**
	 * Provides the name of exposable UID property.
	 * 
	 * @return name of the property
	 */
	protected String getEntityPropertyNameForExtuid__() {
		return "uid";
	}

	/**
	 * Provides the setter method name for setting the exposable UID property.
	 * 
	 * @return the method name
	 */
	protected String getEntitySetterNameForExtuid__() {
		return "setExtuid";
	}
	
	/**
	 * Provides the setter method name for setting the Deleted property.
	 * 
	 * @return the method name
	 */
	protected String getEntitySetterNameForDeleted__() {
		return "setDeleted";
	}

	/**
	 * Provides the name of Deleted property.
	 * 
	 * @return name of the property
	 */
	protected String getEntityPropertyNameForDeleted__() {
		return "deleted";
	}

	protected abstract Class<E> getReferenceClass();

	protected String getRefClassName() {
		return this.getReferenceClass().getName();
	}

	protected abstract I getId(E obj);

	protected UidGenerator getUidGenerator() {
		return this.uidGenerator;
	}

	public I save(E obj) {
		mongo.insert(obj);
		return getId(obj);
	}

	public I update(E obj) {
		mongo.save(obj);
		return getId(obj);
	}

	public I saveOrUpdate(E obj) {
		mongo.save(obj);
		return getId(obj);
	}

	public List<E> findAll(long startIndex, int length) {
		Query query = new Query(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).skip((int) startIndex).limit(length);
		List<E> items = mongo.find(query, this.getReferenceClass());
		return items;
	}

	public List<E> findAll() {
		Query query = new Query(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		List<E> items = mongo.find(query, this.getReferenceClass());
		return items;
	}

	public List<E> findAll(long startIndex, int length, String SortByField, Sort.Direction sortDirection) {
		Query query = new Query(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).skip((int) startIndex).limit(length).with(new Sort(sortDirection, SortByField));
		List<E> items = mongo.find(query, this.getReferenceClass());
		return items;
	}

	public List<E> findAll(String SortByField, Sort.Direction sortDirection) {
		Query query = new Query(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).with(new Sort(sortDirection, SortByField));
		List<E> items = mongo.find(query, this.getReferenceClass());
		return items;
	}

	public E getByExtuid(String extuid) {
		Query searchQuery = new Query(Criteria.where(this.entityPropertyNameForExtuid__).is(extuid)).addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		E obj = mongo.findOne(searchQuery, this.getReferenceClass());
		return obj;
	}

	public E getExistingByExtuid(String extuid) throws EntityObjectNotFoundException {
		E obj = this.getByExtuid(extuid);
		if (obj == null) {
			throw new EntityObjectNotFoundException(extuid, this.getReferenceClass());
		}
		return obj;
	}

	public E getOrCreateByExtuid(String extuid, boolean creationAllowed) {
		E e = this.getByExtuid(extuid);
		if (e == null && creationAllowed) {
			e = this.createNew();
			this.setExtuid(e, extuid);
		}
		return e;
	}

	/**
	 * Sets the uid of a given entity object
	 * 
	 * @param obj
	 *            the entity object
	 * @param extuid
	 *            the uid to set
	 */
	protected void setExtuid(E obj, String extuid) {
		Class<?> cl = obj.getClass();
		try {
			Method method = cl.getMethod(this.entitySetterNameForExtuid__, String.class);
			method.invoke(obj, extuid);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("Could not access method '" + this.entitySetterNameForExtuid__ + "(String)' of class " + getRefClassName(), e);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("Could not successfully invoke method '" + this.entitySetterNameForExtuid__ + "(String)' of class " + getRefClassName(), e);
		}
	}

	public E findOne(Query searchQuery) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		E obj = mongo.findOne(searchQuery, this.getReferenceClass());
		return obj;
	}

	public List<E> getAllByExtuids(Collection<String> uids) {
		Query query = new Query(Criteria.where("uid").in(uids)).addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		List<E> objects = mongo.find(query, this.getReferenceClass());
		return objects;
	}

	public List<E> getAllByMongoIds(Collection<String> ids) {
		Query query = new Query(Criteria.where("_id").in(ids)).addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		List<E> objects = mongo.find(query, this.getReferenceClass());
		return objects;
	}

	public long getCount() {
		Query query = new Query(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		return mongo.count(query, this.getReferenceClass());
	}

	public E createNew() {
		try {
			return ApplicationContextProvider.getInitializedApplicationContext().getBean(getReferenceClass());
//			return this.getReferenceClass().newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public E getByMongoId(String id) {
		Query query = new Query(Criteria.where("_id").in(id)).addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		E obj = mongo.findOne(query, this.getReferenceClass());
		return obj;
	}

	public E getExistingByMongoId(String id) throws EntityObjectNotFoundException {
		Query query = new Query(Criteria.where("_id").in(id)).addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		E obj = mongo.findOne(query, this.getReferenceClass());
		if (obj == null) {
			throw new EntityObjectNotFoundException(id, this.getReferenceClass());
		}
		return obj;
	}
	
	public String generateUid() {
		return this.getUidGenerator().generateUid();
	}

	protected List<E> find(Query searchQuery) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		return mongo.find(searchQuery, this.getReferenceClass());
	}
	
	protected List<E> find(Query searchQuery, String SortByField, Sort.Direction sortDirection) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).with(new Sort(sortDirection, SortByField));
		return mongo.find(searchQuery, this.getReferenceClass());
	}

	protected List<E> find(Query searchQuery, long startIndex, int length) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).skip((int) startIndex).limit(length).with(new Sort(Sort.Direction.DESC, "_id"));
		return mongo.find(searchQuery, this.getReferenceClass());
	}
	
	protected List<E> find(Query searchQuery, long startIndex, int length, String SortByField, Sort.Direction sortDirection) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true)).with(new Sort(sortDirection, SortByField)).skip((int) startIndex).limit(length);
		return mongo.find(searchQuery, this.getReferenceClass());
	}

	protected long getCount(Query searchQuery) {
		searchQuery.addCriteria(Criteria.where(this.entityPropertyNameForDeleted__).ne(true));
		return mongo.count(searchQuery, this.getReferenceClass());
	}

	public E deleteByExtuid(String uid) throws EntityObjectNotFoundException {
		E obj = getExistingByExtuid(uid);
		try {
			Class<?> cl = obj.getClass();
			Method method = cl.getMethod(this.entitySetterNameForDeleted__, boolean.class);
			method.invoke(obj, true);
			update(obj);
			return obj;
		} catch (NoSuchMethodException | SecurityException e) {
			throw new IllegalStateException("Could not access method '" + this.entitySetterNameForDeleted__ + "(boolean)' of class " + getRefClassName(), e);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalStateException("Could not successfully invoke method '" + this.entitySetterNameForDeleted__ + "(boolean)' of class " + getRefClassName(), e);
		}
	}
	
	public PagedList<E> search(SearchQuery searchQuery) {
		Query query = new Query();
		
		
		if((searchQuery != null) && (searchQuery.getCriteria() != null)) {
			for (SearchCriterion criterion : searchQuery.getCriteria()) {
				query.addCriteria(SearchConverter.convert(criterion));
			}
		}
		if ((searchQuery != null) && (searchQuery.getOrderEntries() != null)) {
			for (OrderEntry orderEntry : searchQuery.getOrderEntries()) {
				query.with(SearchConverter.convert(orderEntry));
			}
		}
		return new MongoPagedList(query);
	}
	
	private class MongoPagedList implements PagedList<E> {

		private static final long serialVersionUID = 1L;
		private Query query;
		
		public MongoPagedList(Query query) {
			this.query = query;
		}

		@Override
		public List<E> getItems(long startItemIndex, int pageSize) {
			return (List<E>) find(query, startItemIndex, pageSize);
		}

		@Override
		public long getTotalSize() {
			return getCount(query);
		}

		@Override
		public PagedList<E> clone() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
