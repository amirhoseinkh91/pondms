package ir.viratech.pond_ms.test;

import org.springframework.transaction.annotation.Transactional;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.base.AbstractEntityMgr;
import ir.viratech.commons.model.EntityModificationException;
import ir.viratech.commons.model.EntityObjectNotFoundException;
import ir.viratech.commons.spring.tx.WriteTransactional;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.User;
import ir.viratech.pond_ms.model.user.base.BaseAuthUserMgr;
import ir.viratech.pond_ms.model.user.base.BaseFeatureDAO;
import ir.viratech.pond_ms.model.user.base.BaseFeatureMgr;
import ir.viratech.pond_ms.model.user.base.BaseUserDAO;
import ir.viratech.pond_ms.model.user.base.BaseUserMgr;
import ir.viratech.pond_ms.model.user.dao.UserDAO;

/**
 * The Class TransactionTestMgr.
 */
@SuppressWarnings("deprecation")
public class TransactionTestMgr extends AbstractEntityMgr<User, Long>{

	/**
	 * Check transaction.
	 */
	@Transactional
	public void checkTransaction(){
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("firstTest");
		feature.setDescription("firstTest");
		BaseFeatureDAO.getInstance().save(feature);
	}


	/**
	 * Check transaction with logical error.
	 */
	@Transactional
	public void checkTransactionWithLogicalError(){
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("secondTest");
		feature.setDescription("secondTest");
		BaseFeatureDAO.getInstance().save(feature);
		User user = new User();
		BaseUserDAO.getInstance().save(user);
	}

	/**
	 * Check rollback.
	 */
	@WriteTransactional
	public void checkRollback(){
		User user = BaseUserMgr.getInstance().createNew();
		user.setEnabled(true);
		user.setAuthUser(BaseAuthUserMgr.getInstance().createNew());
		user.getAuthUser().setUsername("username");
		user.getAuthUser().setPassword("password");
		user.setFirstName("Alexsander");
		user.setLastName("Pierro");
		BaseUserDAO.getInstance().save(user);
		System.out.println(user.getId());
		try {
			User obj = BaseUserDAO.getInstance().getByExtuid("salam");
			if (obj == null) {
				throw new EntityObjectNotFoundException("salam");
			}
			this.checkAndDelete(obj);
		} catch (EntityObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityModificationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Check rollback with runtime.
	 */
	@WriteTransactional
	public void checkRollbackWithRuntime(){
		User user = BaseUserMgr.getInstance().createNew();
		user.setEnabled(true);
		user.setAuthUser(BaseAuthUserMgr.getInstance().createNew());
		user.getAuthUser().setUsername("username");
		user.getAuthUser().setPassword("password");
		user.setFirstName("Alexsander");
		user.setLastName("Pierro");
		BaseUserDAO.getInstance().save(user);
		System.out.println(user.getId());
		throw new RuntimeException();
	}





	/**
	 * Check transaction db error.
	 */
	@Transactional
	public void checkTransactionDBError(){
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("thirdTest");
		feature.setDescription("thirdTest");
		BaseFeatureDAO.getInstance().save(feature);
		feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("thirdTest");
		feature.setDescription("thirdTest");
		BaseFeatureDAO.getInstance().save(feature);
	}




	/**
	 * _check transaction.
	 */
	public void _checkTransaction(){
		this.startWriteTransaction();
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("firstTest_without@transactional");
		feature.setDescription("firstTest_without@transactional");
		BaseFeatureDAO.getInstance().save(feature);
		this.finishWriteTransaction();
	}



	/**
	 * _check transaction with logical error.
	 */
	public void _checkTransactionWithLogicalError(){
		this.startWriteTransaction();
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("secondTest_without@transactional");
		feature.setDescription("secondTest_without@transactional");
		BaseFeatureDAO.getInstance().save(feature);
		User user = new User();
		BaseUserDAO.getInstance().save(user);
		this.finishWriteTransaction();
	}



	/**
	 * _check transaction db error.
	 */
	public void _checkTransactionDBError(){
		this.startWriteTransaction();
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("thirdTest_without@transactional");
		feature.setDescription("thirdTest_without@transactional");
		BaseFeatureDAO.getInstance().save(feature);
		feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("thirdTest_without@transactional");
		feature.setDescription("thirdTest_without@transactional");
		BaseFeatureDAO.getInstance().save(feature);
		this.finishWriteTransaction();
	}




	/**
	 * _check transaction roll back.
	 */
	public void _checkTransactionRollBack(){
		this.startWriteTransaction();
		Feature feature = BaseFeatureMgr.getInstance().createNew();
		feature.setName("forthTest_without@transactional");
		feature.setDescription("forthTest_without@transactional");
		BaseFeatureDAO.getInstance().save(feature);
		BaseFeatureDAO.getInstance().rollbackCurrentTransaction(null);
		this.finishWriteTransaction();
	}


	@Override
	protected AbstractEntityDAO<User, Long> getDAO() {
		return UserDAO.getInstance();
	}

}
