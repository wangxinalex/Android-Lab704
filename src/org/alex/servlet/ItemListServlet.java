package org.alex.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import org.alex.business.ItemBean;
import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;

import java.io.*;
import org.json.*;
import java.util.*;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
@WebServlet(urlPatterns="/android/itemList.jsp")
public class ItemListServlet extends BaseServlet
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
		
		String kindId = request.getParameter("kindId");
		
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		List<ItemBean> items = auctionManager
			.getItemsByKind(Integer.parseInt(kindId));
		
		JSONArray jsonArr= new JSONArray(items);
		response.setContentType("text/html; charset=GBK");
		response.getWriter().println(jsonArr.toString()); 
	}
}