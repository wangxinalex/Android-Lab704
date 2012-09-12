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
 * 
 * @author lab704
 * @version 1.0
 */
@WebServlet(urlPatterns = "/android/addItem.jsp")
public class AddItemServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");
		request.setCharacterEncoding("gbk");

		String itemName = request.getParameter("itemName");
		String itemDesc = request.getParameter("itemDesc");
		String remark = request.getParameter("itemRemark");
		String initPrice = request.getParameter("initPrice");
		String kindId = request.getParameter("kindId");
		String avail = request.getParameter("availTime");

		CallingManager auctionManager = (CallingManager) getCtx()
				.getBean("mgr");
		// add item by business data access object
		int itemId = auctionManager.addItem(itemName, itemDesc, remark,
				Double.parseDouble(initPrice), Integer.parseInt(avail),
				Integer.parseInt(kindId), userId);
		response.setContentType("text/html; charset=GBK");

		if (itemId > 0) {
			response.getWriter().println("恭喜您，资源添加成功!");
		} else {
			response.getWriter().println("对不起，资源添加失败!");
		}
	}
}