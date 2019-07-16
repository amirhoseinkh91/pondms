package ir.viratech.pond_ms.ui.cli.data_import;

import org.springframework.context.ApplicationContext;

import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;
import ir.viratech.pond_ms.model.gradient.Gradient;
import ir.viratech.pond_ms.model.gradient.logic.GradientMgr;

public class GradientMgrTest {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
		String uid = "0fb4e102-1043-4800-a977-29d71f7f9e62";
		Gradient gradient = GradientMgr.getInstance().getByExtuid(uid);
		System.out.println(gradient.getTitle());
	}

}
