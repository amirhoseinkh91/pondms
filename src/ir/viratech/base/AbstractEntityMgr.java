package ir.viratech.base;

import ir.viratech.commons.persistence.base.BaseAbstractEntityMgr;


/**
 * The Class AbstractEntityMgr.
 *
 * @param <E> the entity type
 * @param <I> the identifier type
 */
public abstract class AbstractEntityMgr<E, I extends java.io.Serializable> extends BaseAbstractEntityMgr<E, I> {
	
	@Override
	protected abstract AbstractEntityDAO<E, I> getDAO();

	
}
