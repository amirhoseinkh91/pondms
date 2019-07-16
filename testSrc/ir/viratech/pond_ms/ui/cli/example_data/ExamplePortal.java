package ir.viratech.pond_ms.ui.cli.example_data;

import java.util.List;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

import ir.viratech.commons.persistence.base.BaseAbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gismap.GISMap;
import ir.viratech.pond_ms.model.gismap.base.BaseGISMapMgr;
import ir.viratech.pond_ms.model.gismap.logic.GISMapMgr;
import ir.viratech.pond_ms.model.organization.Organization;
import ir.viratech.pond_ms.model.organization.logic.OrganizationMgr;

public class ExamplePortal {

	protected void addData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		GISMap gisMap = GISMapMgr.getInstance().createNew();
		gisMap.setOrganization(organization);
		gisMap.setLatinTitle("first_portal");
		gisMap.setTitle("portale aval");
		gisMap.setDefaultZoom(14);
		gisMap.setMaxZoom(16);
		gisMap.setMinZoom(12);
		Coordinate[] coorArray = new Coordinate[5];
		coorArray[0] = (new Coordinate(51.27649784088135, 35.77325759103725));
		coorArray[1] = (new Coordinate(51.5374231338501, 35.77994251888403));
		coorArray[2] = (new Coordinate(51.5264368057251, 35.58361791939281));
		coorArray[3] = (new Coordinate(51.2902307510376, 35.588085204763246));
		coorArray[4] = (new Coordinate(51.27649784088135, 35.77325759103725));
		GeometryFactory geomFactory = new GeometryFactory(new PrecisionModel(), 4326);
		gisMap.setBoundingBox(geomFactory.createPolygon(geomFactory.createLinearRing(coorArray), null));
		gisMap.setCenter(geomFactory.createPoint(new Coordinate(51.3888888, 35.63333333)));
		BaseGISMapMgr.getInstance().add(gisMap);
	}

	protected void addAnotherData(Organization organization) {
		BaseAbstractEntityDAO.closeCurrentThreadSessions();
		BaseAbstractEntityDAO.touchSession();
		GISMap gisMap = GISMapMgr.getInstance().createNew();
		gisMap.setOrganization(organization);
		gisMap.setLatinTitle("second_portal");
		gisMap.setTitle("portale dovom");
		gisMap.setDefaultZoom(14);
		gisMap.setMaxZoom(16);
		gisMap.setMinZoom(12);
		Coordinate[] coorArray = new Coordinate[5];
		coorArray[0] = (new Coordinate(50.882406234741204, 35.862900208895226));
		coorArray[1] = (new Coordinate(51.03278160095214, 35.86178725699084));
		coorArray[2] = (new Coordinate(51.02934837341308, 35.763786314534315));
		coorArray[3] = (new Coordinate(50.88721275329589, 35.76545779822543));
		coorArray[4] = (new Coordinate(50.882406234741204, 35.862900208895226));
		GeometryFactory geomFactory = new GeometryFactory(new PrecisionModel(), 4326);
		gisMap.setBoundingBox(geomFactory.createPolygon(geomFactory.createLinearRing(coorArray), null));
		gisMap.setCenter(geomFactory.createPoint(new Coordinate(50.9555555, 35.8000000)));
		BaseGISMapMgr.getInstance().add(gisMap);
	}

	public static void main(String... args) {
		ApplicationContextUtil.initializeCliApplicationContext();
		List<Organization> organizations = OrganizationMgr.getInstance().list();
		if(organizations.size() < 2){
			ExampleOrganization.main(args);
			organizations = OrganizationMgr.getInstance().list();
		}
		new ExamplePortal().addData(organizations.get(0));
		new ExamplePortal().addAnotherData(organizations.get(1));
	}
}
