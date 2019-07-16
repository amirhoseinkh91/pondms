package ir.viratech.pond_ms.model.time_series.logic;


import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.model.time_series.dao.RootCategoryDAO;

/**
 * Mgr class for entity "ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair".
 */
public class TimeSeriesDateValuePairMgr extends BaseTimeSeriesDateValuePairMgr {


	public void addTimeSeriesToPond(RootCategory newCategory)
	{
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
			
		RootCategory root = RootCategoryDAO.getInstance()
				.getByGroupUidAndPondUid(newCategory.getGroup().getExtuid(),
						newCategory.getPond().getExtuid());
		
		if(root == null)
			RootCategoryMgr.getInstance().add(newCategory);
		else
		{
			BaseRootCategoryMgr rootCategoryMgr = BaseRootCategoryMgr.getInstance();
			rootCategoryMgr.delete(root);
			RootCategoryMgr.getInstance().add(newCategory);
		}	
	}
	
	public void addTimeSeriesToGISVectorObject(RootCategory newCategory)
	{
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
			
		RootCategory root = RootCategoryDAO.getInstance()
				.getByGroupUidAndObjectUid(newCategory.getGroup().getExtuid(),
						newCategory.getGISVectorObject().getExtuid());
		
		if(root == null)
			RootCategoryMgr.getInstance().add(newCategory);
		else
		{
			BaseRootCategoryMgr rootCategoryMgr = BaseRootCategoryMgr.getInstance();
			rootCategoryMgr.delete(root);
			RootCategoryMgr.getInstance().add(newCategory);
		}	
	}


}