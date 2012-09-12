package org.alex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;
@WebServlet(urlPatterns="/android/updateBid.jsp")
public class UpdateBidServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request , 
		HttpServletResponse response)
		throws IOException , ServletException
	{
		Integer userId = (Integer)request.getSession(true)
		.getAttribute("userId");
		System.out.println("userId = "+userId);
		Integer bidId = Integer.parseInt(request.getParameter("id"));
		System.out.println("bidId = "+bidId);
		request.setCharacterEncoding("gbk");
		
	
		String bidPost = request.getParameter("post");
		
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		
		auctionManager.updateBidById(bidId,userId,bidPost);
		response.setContentType("text/html; charset=GBK");
	
		if (bidId > 0)
		{
			response.getWriter().println("恭喜您，更新成功!");
		}
		else
		{
			response.getWriter().println("对不起，更新失败!");
		}
	}
}
