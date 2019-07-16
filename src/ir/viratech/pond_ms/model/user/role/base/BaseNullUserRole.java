package ir.viratech.pond_ms.model.user.role.base;

import java.io.Serializable;


/**
 *  Base class for entity "ir.viratech.pond_ms.model.user.role.NullUserRole".
 *  It is an automatically generated file and should not be edited.
 *
 * @hibernate.class
 *  table="pond_ms.ROLES"
 */

public abstract class BaseNullUserRole extends ir.viratech.pond_ms.model.user.role.Role  implements Serializable {
	private static final long serialVersionUID = 1L;


	/** The constant referring the name of class "NullUserRole". */
	public static final String REF = "NullUserRole";
	
	/** The constant referring the property "id". */
	public static final String PROP_ID = "id";
	
	
	/** The name of table for this class. */
	public static final String TABLE = "pond_ms.ROLES";
	
	/** Name of column referring the property "id". */
	public static final String PROPCOLUMN_ID = "id";
	
	

	
	
	


	private int hashCode_ = Integer.MIN_VALUE;








	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (null == obj) return false;
		if (!(obj instanceof ir.viratech.pond_ms.model.user.role.NullUserRole)) return false;
		else {
			ir.viratech.pond_ms.model.user.role.NullUserRole nullUserRole = (ir.viratech.pond_ms.model.user.role.NullUserRole) obj;
			return (this.getId() == nullUserRole.getId());
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode_) {
			return (int) this.getId();
		}
		return this.hashCode_;
	}


	



}