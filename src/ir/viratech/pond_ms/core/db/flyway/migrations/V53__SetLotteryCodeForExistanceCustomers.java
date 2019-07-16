package ir.viratech.pond_ms.core.db.flyway.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ir.viratech.just_ro.core.customer.lottery.LotteryCodeGenerator;
import ir.viratech.pond_ms.core.spring.ApplicationContextUtil;


public class V53__SetLotteryCodeForExistanceCustomers extends BaseJdbcMigration{

	@Override
	public void migrate(Connection connection) throws Exception {
		LotteryCodeGenerator lotteryCodeGenerator = ApplicationContextUtil.getApplicationContext().getBean(LotteryCodeGenerator.class);
		Set<String> lotteryCodes = new HashSet<>();
		String query = "select id from pond_ms.CUSTOMERS";
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();
		List<Long> ids = new ArrayList<>();
		while(resultSet.next())
			ids.add(resultSet.getLong(1));

		resultSet.close();
		prepareStatement.close();

		for (Long id : ids) {
			String lotteryCode = lotteryCodeGenerator.genrateLotteryCode();
			while(lotteryCodes.contains(lotteryCode))
				lotteryCode = lotteryCodeGenerator.genrateLotteryCode();
			lotteryCodes.add(lotteryCode);
			query = "update pond_ms.CUSTOMERS set lotteryCode = '" + lotteryCode + "' where id = " + id;
			prepareStatement = connection.prepareStatement(query);
			prepareStatement.execute();
			prepareStatement.close();
		}
	}

}
