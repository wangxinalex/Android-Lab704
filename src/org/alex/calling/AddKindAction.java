package org.alex.calling;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.alex.calling.base.BaseAction;
import org.alex.exception.CallingException;
import org.alex.service.CallingManager;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class AddKindAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String desc;
	private String vercode;

	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
		if (vercode.equalsIgnoreCase(ver2))
		{				
			mgr.addKind(name , desc);
			return SUCCESS;
		}
		else
		{
			addActionError("验证码不匹配,请重新输入");
			return INPUT;
		}
	}


	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
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