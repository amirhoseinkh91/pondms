package ir.viratech.just_ro.core.customer.lottery;

import java.util.Random;

public class LotteryCodeGenerator {
	private static int codeSize = 7;
	public String genrateLotteryCode() {
		Random random = new Random();
		String code = "";
		for(int i=0; i < codeSize; i++)
			code += random.nextInt(10);
		return code;
	}
}
