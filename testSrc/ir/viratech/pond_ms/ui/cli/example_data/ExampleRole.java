package ir.viratech.pond_ms.ui.cli.example_data;

import java.util.Arrays;

import ir.viratech.pond_ms.core.features.EntityFeatureNames;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.user.Feature;
import ir.viratech.pond_ms.model.user.base.BaseFeatureMgr;
import ir.viratech.pond_ms.model.user.role.UserRole;
import ir.viratech.pond_ms.model.user.role.base.BaseUserRoleMgr;

/**
 * The Class ExampleRole.
 */
public class ExampleRole extends BaseExampleFile{

	@Override
	protected void addData() {
		UserRole userRole = BaseUserRoleMgr.getInstance().createNew();
		userRole.setName("user");
		userRole.setDescription("simple user");
		for (String fname : Arrays.asList(FeatureNames.SEE_HOME, FeatureNames.ACCESS_API, Feature.EntityAccessKey.getAccessKeyForView(EntityFeatureNames.USER))) {
			userRole.addToAvailableFeatures(BaseFeatureMgr.getInstance().getByName(fname));
		}
		BaseUserRoleMgr.getInstance().add(userRole);
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String... args) {
		new ExampleRole().addData();
	}

}
