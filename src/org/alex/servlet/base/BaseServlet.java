package org.alex.servlet.base;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.context.ApplicationContext;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class BaseServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext ctx;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		ctx = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
	}

	public ApplicationContext getCtx() {
		return this.ctx;
	}
}