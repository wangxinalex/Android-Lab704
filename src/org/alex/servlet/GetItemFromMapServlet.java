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
@WebServlet(urlPatterns="/android/getItemFromMap.jsp")
public class GetItemFromMapServlet extends BaseServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , 
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("UTF-8");
		
		String itemName = request.getParameter("itemName");
		itemName=   new   String(itemName.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("itemName-1 = "+itemName);
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		ItemBean itemBean = auctionManager.getItemByName(itemName);
	
		JSONObject jsonObj = new JSONObject(itemBean);
		response.setContentType("text/html; charset=GBK");
		response.getWriter().println(jsonObj.toString());
	}
}