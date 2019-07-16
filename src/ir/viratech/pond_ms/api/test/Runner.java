package ir.viratech.pond_ms.api.test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.apache.commons.lang.reflect.MethodUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import ir.viratech.commons.api.service.AbstractJsonService;
import ir.viratech.pond_ms.api.test.dto.RunCommandDTO;
import ir.viratech.pond_ms.api.test.dto.RunCommandResultDTO;
import ir.viratech.pond_ms.core.features.FeatureNames;
import ir.viratech.pond_ms.model.user.authorization.AccessChecker;

/**
 * Run a method in a class in context of web.
 * It's usefull for testing
 */
@Component
@Path("/test/runner")
public class Runner extends AbstractJsonService {

	private static final transient Logger logger = Logger.getLogger(Runner.class);

	/**
	 * Run the class.
	 * @param runCommandDTO the class name and method name to run.The method should be static.
	 * @return the result of method invocation.
	 */
	@POST
	public RunCommandResultDTO run(RunCommandDTO runCommandDTO) {
		AccessChecker.checkAccess(FeatureNames.API_SYS_ADMIN);
		RunCommandResultDTO resultDto = new RunCommandResultDTO();
		try {
			logger.info("given runCommandDTO: " + runCommandDTO);
			Class<?> cl = Class.forName(runCommandDTO.getClassName());
			String methodName = runCommandDTO.getMethodName();
			Object[] args = { new String[]{} };
			Object result = MethodUtils.invokeStaticMethod(cl, methodName, args);
			logger.info("result: "+result);
			resultDto.setResultString((result==null)?null:result.toString());
		} catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
			logger.error("Error in parsing and running the command.", e);
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			resultDto.setExceptionStackTrace(sw.toString());
		}
		return resultDto;
	}

}
