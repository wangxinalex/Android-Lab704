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
@WebServlet(urlPatterns = "/android/register.jsp")
public class RegisterServlet extends BaseServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Register "+request.toString());
		request.setCharacterEncoding("gbk");
		String userName = request.getParameter("user");
		String userPass = request.getParameter("pass");
		String userEmail = request.getParameter("email");
		System.out.println(userName + userPass + userEmail);
		
		CallingManager auctionManager = (CallingManager) getCtx()
				.getBean("mgr");
	
		int userId = auctionManager.register(userName, userPass, userEmail);
		response.setContentType("text/html; charset=GBK");
		
		if (userId > 0) {
			response.getWriter().println("恭喜您，注册成功!");
		} else {
			response.getWriter().println("对不起，注册失败!");
		}
		
	}
}
