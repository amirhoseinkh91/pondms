package ir.viratech.pond_ms.core.spring;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * The Class WebApplicationContextInitializer.
 */
public class WebApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextInitializer#initialize(org.springframework.context.ConfigurableApplicationContext)
	 */
	@Override
	public void initialize(ConfigurableApplicationContext context) {
		ApplicationContextUtil.getApplicationContextInitializer().initialize(context);
	}

}
