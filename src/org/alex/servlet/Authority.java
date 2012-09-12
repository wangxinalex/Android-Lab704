package org.alex.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

/**
 * Description: Check whether the user has already logged in the system, filter
 * the request from guests
 * 
 * @author lab704
 * @version 1.0
 */
@WebFilter(urlPatterns = "/android/*")
public class Authority implements Filter {
	public void init(FilterConfig config) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;

		HttpSession session = hrequest.getSession(true);
		Integer userId = (Integer) session.getAttribute("userId");
		// filter user's request unless he is trying to log in or register
		if ((userId != null && userId > 0)
				|| hrequest.getRequestURI().endsWith("/login.jsp")
				|| hrequest.getRequestURI().endsWith("/register.jsp")) {

			chain.doFilter(request, response);
		} else {
			response.setContentType("text/html; charset=GBK");

			response.getWriter().println("您还没有登录系统，请先系统！");
		}
	}

	public void destroy() {
	}
}