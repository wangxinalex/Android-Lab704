package org.alex.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.alex.business.*;
import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;

import java.io.*;
import org.json.*;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
@WebServlet(urlPatterns="/android/getItem.jsp")
public class GetItemServlet extends BaseServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , 
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("gbk");
		
		String itemId = request.getParameter("itemId");
	
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		ItemBean itemBean = auctionManager.getItem(Integer.parseInt(itemId));
	
		JSONObject jsonObj = new JSONObject(itemBean);
		response.setContentType("text/html; charset=GBK");
		response.getWriter().println(jsonObj.toString());
	}
}