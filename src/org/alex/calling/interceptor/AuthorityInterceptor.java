package org.alex.calling.interceptor;

import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.*;
import java.util.Map;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class AuthorityInterceptor extends AbstractInterceptor
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//filter the request
	public String intercept(ActionInvocation invocation) throws Exception
	{
		//get HTTP Session from user
		Map session = ActionContext.getContext().getSession();
		Object userId = session.get("userId");
		//if user has not logged in
		if (userId == null)
		{
			return "login";
		}
		//otherwise, continue executing
		else
		{
			return invocation.invoke();
		}
	}
}