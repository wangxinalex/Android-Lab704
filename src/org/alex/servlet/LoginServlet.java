package org.alex.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;

import java.io.*;
import org.json.*;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
@WebServlet(urlPatterns="/android/login.jsp")
public class LoginServlet extends BaseServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , 
		HttpServletResponse response)
		throws IOException , ServletException
	{
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");

		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		//validate if user has logged in
		int userId = auctionManager.validLogin(user , pass);
		response.setContentType("text/html; charset=GBK");
		
		if (userId > 0)
		{
			request.getSession(true).setAttribute("userId" , userId);
		}
		try
		{
			// 把验证的userId封装成JSONObject
			JSONObject jsonObj = new JSONObject()
				.put("userId" , userId);
			// 输出响应
			response.getWriter().println(jsonObj.toString()); 
		}
		catch (JSONException ex)
		{
			ex.printStackTrace();
		}
	}
}