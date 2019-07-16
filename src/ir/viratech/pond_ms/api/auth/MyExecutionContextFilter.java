package ir.viratech.pond_ms.api.auth;

import ir.viratech.commons.api.execution_context.ExecutionContextFilter;
import ir.viratech.commons.execution_context.ExecutionContext;
import ir.viratech.pond_ms.core.execution_context.MyExecutionContext;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyExecutionContextFilter extends ExecutionContextFilter {
	
	@Override
	protected void initExecutionContext(ServletRequest request, ServletResponse response, ExecutionContext c) {
		super.initExecutionContext(request, response, c);
		if (c instanceof MyExecutionContext) {
			((MyExecutionContext) c).setUser(c.getUsername());
		}
	}
	
}
