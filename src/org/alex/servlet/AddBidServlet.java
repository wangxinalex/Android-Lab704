package org.alex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
@WebServlet(urlPatterns="/android/addBid.jsp")
public class AddBidServlet extends BaseServlet
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
		request.setCharacterEncoding("gbk");
		
		String itemId = request.getParameter("itemId");
		String dateTime  =request.getParameter("dateTime");
		String bidPrice = request.getParameter("bidPrice");
		String bidPost = request.getParameter("bidPost");
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		int bidId = auctionManager.addBid(Integer.parseInt(itemId)
			, Double.parseDouble(bidPrice),dateTime,bidPost
			, userId);
		response.setContentType("text/html; charset=GBK");
	
		if (bidId > 0)
		{
			response.getWriter().println("恭喜您，预约成功!");
		}
		else
		{
			response.getWriter().println("对不起，预约失败!");
		}
	}
}