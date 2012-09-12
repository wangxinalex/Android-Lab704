package org.alex.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.alex.business.*;
import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;

import java.io.*;
import java.util.*;
import org.json.*;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
@WebServlet(urlPatterns="/android/viewSucc.jsp")
public class ViewSuccServlet extends BaseServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , 
		HttpServletResponse response)
		throws IOException , ServletException
	{
		
		Integer userId = (Integer)request.getSession(true)
			.getAttribute("userId");
		
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		List<ItemBean> items = auctionManager.getItemByWiner(userId);
		JSONArray jsonArr= new JSONArray(items);
		response.setContentType("text/html; charset=GBK");
		response.getWriter().println(jsonArr.toString());
	}
}