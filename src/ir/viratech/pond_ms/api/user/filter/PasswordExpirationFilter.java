package ir.viratech.pond_ms.api.user.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import ir.viratech.pond_ms.api.auth.MyUserDetailsService;
import ir.viratech.pond_ms.model.user.User;

public class PasswordExpirationFilter implements Filter {

	private static final transient Logger logger = Logger.getLogger(PasswordExpirationFilter.class);


	private int errorStatusCode;
	public int getErrorStatusCode() {
		return errorStatusCode;
	}
	public void setErrorStatusCode(int errorStatusCode) {
		this.errorStatusCode = errorStatusCode;
	}

	private String errorMessage = "User password is expired.";
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	private List<String> availablePrefixes;
	public List<String> getAvailablePrefixes() {
		return availablePrefixes;
	}
	public void setAvailablePrefixes(List<String> availablePrefixes) {
		this.availablePrefixes = availablePrefixes;
	}

	/**
	 * Default constructor.
	 */
	public PasswordExpirationFilter() {
	}

	/**
	 * @see FilterService#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		logger.debug("initialized.");
	}

	/**
	 * @see FilterService#destroy()
	 */
	@Override
	public void destroy() {
		logger.debug("destroyed.");
	}


	private boolean isPasswordExpired() {
		User user = MyUserDetailsService.getCurrentUserAttached();
		return (user != null) && user.isPasswordExpired();
	}

	protected boolean isAvailableOnExpiry(ServletRequest servletRequest) {
		if (!(servletRequest instanceof HttpServletRequest)) {
			if (logger.isDebugEnabled())
				logger.debug("request "+servletRequest+" is not instance of HttpServletRequest");
			return true;
		}
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		if (logger.isDebugEnabled())
			logger.debug("request "+servletRequest+" has uri: "+uri);
		for (String prefix : this.getAvailablePrefixes())
			if (StringUtils.startsWithIgnoreCase(uri, prefix)) {
				if (logger.isDebugEnabled())
					logger.debug("request "+servletRequest+"matched with availablePrefix '"+prefix+"'.");
				return true;
			}
		logger.debug("request "+servletRequest+" did not match with any of availablePrefixes.");
		return false;
	}

	/**
	 * @see FilterService#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		if (!(servletResponse instanceof HttpServletResponse) || !isPasswordExpired() || isAvailableOnExpiry(request)) {
			if (logger.isDebugEnabled())
				logger.debug("allowed request "+request);
			chain.doFilter(request, servletResponse);
		} else {
			if (logger.isDebugEnabled())
				logger.debug("denied request "+request);
			((HttpServletResponse) servletResponse).sendError(this.getErrorStatusCode(), this.getErrorMessage());
		}
	}



}
