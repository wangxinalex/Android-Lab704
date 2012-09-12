package org.alex.calling;

import com.opensymphony.xwork2.ActionContext;

import java.util.*;

import org.alex.calling.base.BaseAction;
/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class LoginAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String vercode;

	@Override
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String )session.get("rand");
		
		session.put("rand" , null);
		if (vercode.equalsIgnoreCase(ver2))
		{
			Integer userId = mgr.validLogin(username,password);
			if (userId != null && userId > 0)
			{
				session.put("userId" , userId);
				return SUCCESS;
			}
			else
			{
				addActionError("用户名/密码不匹配");
				return "failure";
			}
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return "failure";
		}
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}

	
	public void setVercode(String vercode)
	{
		this.vercode = vercode;
	}
	public String getVercode()
	{
		return this.vercode;
	}

}