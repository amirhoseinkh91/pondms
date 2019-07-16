package time_series_test;


import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.time_series.Category;
import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.dao.RootCategoryDAO;
import ir.viratech.pond_ms.model.time_series.logic.LeafCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.ParentCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.RootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr;

public class PondUpdater {

	public static void update(String pondUid,RootCategory newCategory)
	{
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
			
		String groupUid = newCategory.getGroup().getExtuid();
		RootCategory root = RootCategoryDAO.getInstance().getByGroupUidAndPondUid(groupUid, pondUid);
		
		if(root == null)
			persistRootCategory(newCategory);
		else
		{
			BaseRootCategoryMgr rootCategoryMgr = BaseRootCategoryMgr.getInstance();
			rootCategoryMgr.delete(root);
			persistRootCategory(newCategory);	
		}
		
		Pond pond = PondMgr.getInstance().getByExtuid(pondUid);
		pond.addToTimeSeriesRootCategories(newCategory);
		PondMgr.getInstance().add(pond);	
	}
	
	private static void persistRootCategory(RootCategory newCategory) {
		
		for(Category c : newCategory.getSubCategories())
			if(c.getType().equals(ParentCategory.PROP_TYPE))
				persistParentCategory((ParentCategory)c);
			else
				persistLeafCategory((LeafCategory)c);
			
		RootCategoryMgr.getInstance().add(newCategory);
	}

	private static void persistLeafCategory(LeafCategory newCategory) {
				
		for(TimeSeriesDateValuePair v : newCategory.getCreatedTimeSeriesValues())
			TimeSeriesDateValuePairMgr.getInstance().add(v);
		
		LeafCategoryMgr.getInstance().add(newCategory);
	}

	private static void persistParentCategory(ParentCategory newCategory) {
		for(Category c : newCategory.getSubCategories())
			if(c.getType().equals(ParentCategory.PROP_TYPE))
				persistParentCategory((ParentCategory)c);
			else
				persistLeafCategory((LeafCategory)c);
		
		ParentCategoryMgr.getInstance().add(newCategory);		
	}
}
