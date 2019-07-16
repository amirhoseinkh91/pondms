package ir.viratech.pond_ms.ui.cli.example_data;

import ir.viratech.base.AbstractEntityDAO;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.ui.cli.example_data.file.ExampleFile;
import time_series_test.UpdateTester;



/**
 * The Class DataSuite.
 */
public class DataSuite {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String... args) throws Exception {
		ApplicationContextUtil.initializeCliApplicationContext();
		AbstractEntityDAO.touchSession();
//		ExampleRole.main(args);
//		ExampleUser.main(args);
//		ExampleFile.main(args);
//		ExampleOrganization.main(args);
////		ExamplePositionAndPositionRole.main(args);
//		ExamplePortal.main(args);
//		ExampleOrganizationUser.main(args);
//		ExampleLayer.main(args);
//		ExampleObject.main(args);
////		ExampleCategory.main(args);
		ExampleFoursquareKey.main(args);
		System.out.println("DataSuite Finished!");
		
	}
}
