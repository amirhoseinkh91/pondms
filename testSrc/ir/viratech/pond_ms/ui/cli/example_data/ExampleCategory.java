package ir.viratech.pond_ms.ui.cli.example_data;


import java.util.Date;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.layer.ParentLayer;
import ir.viratech.pond_ms.model.layer.Pond;
import ir.viratech.pond_ms.model.layer.base.BasePondMgr;
import ir.viratech.pond_ms.model.layer.logic.ParentLayerMgr;
import ir.viratech.pond_ms.model.layer.logic.PondMgr;
import ir.viratech.pond_ms.model.time_series.LeafCategory;
import ir.viratech.pond_ms.model.time_series.ParentCategory;
import ir.viratech.pond_ms.model.time_series.RootCategory;
import ir.viratech.pond_ms.model.time_series.TimeSeriesDateValuePair;
import ir.viratech.pond_ms.model.time_series.TimeSeriesGroup;
import ir.viratech.pond_ms.model.time_series.base.BaseLeafCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseParentCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseRootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.model.time_series.base.BaseTimeSeriesGroupMgr;
import ir.viratech.pond_ms.model.time_series.logic.LeafCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.ParentCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.RootCategoryMgr;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesDateValuePairMgr;
import ir.viratech.pond_ms.model.time_series.logic.TimeSeriesGroupMgr;

public class ExampleCategory {
	protected void addData() {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		
			
		BaseRootCategoryMgr rootCategoryMgr = BaseRootCategoryMgr.getInstance();
		
		RootCategory root = RootCategoryMgr.getInstance().createNew();
		root.setId(new Long("321"));
		root.setName("roots test");
		rootCategoryMgr.add(root);
	
		BaseParentCategoryMgr parentCategoryMgr = BaseParentCategoryMgr.getInstance();
		
		ParentCategory parent = ParentCategoryMgr.getInstance().createNew();
		parent.setId(new Long("123"));
		parent.setName("parents test");
		parentCategoryMgr.add(parent);
		
		root.addToSubCategories(parent);
		
		BaseTimeSeriesDateValuePairMgr timeSeriesValueMgr = BaseTimeSeriesDateValuePairMgr.getInstance();
		
		TimeSeriesDateValuePair value1 = TimeSeriesDateValuePairMgr.getInstance().createNew();
		TimeSeriesDateValuePair value2 = TimeSeriesDateValuePairMgr.getInstance().createNew();
		
		value1.setSubmissionTime(new Date().getTime());
		value1.setTimeSeriValue("12345");
		
		
		value2.setSubmissionTime(new Date().getTime());
		value2.setTimeSeriValue("123455");
		
		BaseTimeSeriesGroupMgr groupCategoryMgr = BaseTimeSeriesGroupMgr.getInstance();
		
		TimeSeriesGroup group = BaseTimeSeriesGroupMgr.getInstance().createNew();
		group.setDescription("this is a test");
		group.setName("groups test");
		groupCategoryMgr.add(group);

		TimeSeriesGroup group1 = BaseTimeSeriesGroupMgr.getInstance().createNew();
		group1.setDescription("this is a test");
		group1.setName("water");
		groupCategoryMgr.add(group1);

		TimeSeriesGroup group2 = BaseTimeSeriesGroupMgr.getInstance().createNew();
		group2.setDescription("this is a test");
		group2.setName("population");
		groupCategoryMgr.add(group2);

		
		BaseLeafCategoryMgr leafCategoryMgr = BaseLeafCategoryMgr.getInstance();

		LeafCategory leaf = LeafCategoryMgr.getInstance().createNew();
		leaf.setName("leaf test");
		leaf.setTimeSeriesValueType("integer");
		
		timeSeriesValueMgr.add(value1);
		timeSeriesValueMgr.add(value2);
	
		leafCategoryMgr.add(leaf);
		
		leaf = LeafCategoryMgr.getInstance().reget(leaf);
		leaf.addToTimeSeriesValues(value1);
		leaf.addToTimeSeriesValues(value2);
		BaseLeafCategoryMgr.getInstance().update(leaf);
	
		root = RootCategoryMgr.getInstance().reget(root);
		root.setGroup(group);
		BaseRootCategoryMgr.getInstance().update(root);
		LeafCategoryMgr.getInstance().update(leaf);
			
		parent.addToSubCategories(leaf);

		ParentCategoryMgr.getInstance().update(parent);
		RootCategoryMgr.getInstance().update(root);
		LeafCategoryMgr.getInstance().update(leaf);
		BaseTimeSeriesDateValuePairMgr.getInstance().update(value1);
		BaseTimeSeriesDateValuePairMgr.getInstance().update(value2);
	
		
		ParentLayer layer = ParentLayerMgr.getInstance().get(new Long("6"));
		Pond pond = PondMgr.getInstance().createNew();
		pond.addToTimeSeriesRootCategories(root);
		pond.setTitle("test for time series");
		pond.setLayer(layer);
		BasePondMgr.getInstance().add(pond);
	}
	
	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		
		new ExampleCategory().addData();
		
	}
}
