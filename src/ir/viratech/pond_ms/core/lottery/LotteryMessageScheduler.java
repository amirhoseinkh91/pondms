package ir.viratech.pond_ms.core.lottery;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

public class LotteryMessageScheduler {

	@Autowired
	private LotteryMessageManager lotteryMessageManager;

	@Qualifier("pondmanagementThreadPoolTaskScheduler")
	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;

	@PostConstruct
	public void start() {
		threadPoolTaskScheduler.scheduleWithFixedDelay(lotteryMessageManager, 10000l);
	}
}
