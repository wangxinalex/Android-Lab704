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
@WebServlet(urlPatterns="/android/addKind.jsp")
public class AddKindServlet extends BaseServlet
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
		
		String name = request.getParameter("kindName");
		String desc = request.getParameter("kindDesc");
		
		CallingManager auctionManager = (CallingManager)getCtx().getBean("mgr");
		// call AuctionManager to add kind
		int kindId = auctionManager.addKind(name , desc);
		response.setContentType("text/html; charset=GBK");
		
		if (kindId > 0)
		{
			response.getWriter().println("恭喜您，种类添加成功!");
		}
		else
		{
			response.getWriter().println("对不起，种类添加失败!");
		}
	}
}