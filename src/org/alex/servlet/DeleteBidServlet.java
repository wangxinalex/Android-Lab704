package org.alex.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alex.service.CallingManager;
import org.alex.servlet.base.BaseServlet;
@WebServlet(urlPatterns="/android/deleteBid.jsp")
public class DeleteBidServlet extends BaseServlet{
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
		
	
//		String bidPost = request.getParameter("post");
		
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		auctionManager.deleteBidById(bidId,userId);
//		auctionManager.updateBidById(bidId,userId,bidPost);
		response.setContentType("text/html; charset=GBK");
	
		if (bidId > 0)
		{
			response.getWriter().println("删除成功!");
		}
		else
		{
			response.getWriter().println("对不起，删除失败!");
		}
	}
}
