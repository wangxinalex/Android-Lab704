package org.alex.calling;

import java.util.Map;

import org.alex.calling.base.BaseAction;

import com.opensymphony.xwork2.ActionContext;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class AddItemAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9202872087443699078L;
	private String name;
	private String desc;
	private String remark;
	private double initPrice;
	private int avail;
	private int kind;
	private String vercode;
	
	public String execute() throws Exception
	{
		Map<String, ?> session = ActionContext.getContext().getSession();
		String ver2 = (String)session.get("rand");
		
		session.put("rand" , null);
		Integer userId = (Integer)session.get("userId");
		
		if (vercode.equalsIgnoreCase(ver2))
		{
			
			switch(avail)
			{
				case 6 :
					avail = 7;
					break;
				case 7 :
					avail = 30;
					break;
				case 8 :
					avail = 365;
					break;
			}
			
			mgr.addItem(name , desc , remark , initPrice ,avail , kind, userId);
			
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

	public void setRemark(String remark)
	{
		this.remark = remark;
	}
	public String getRemark()
	{
		 return this.remark;
	}

	public void setInitPrice(double initPrice)
	{
		this.initPrice = initPrice;
	}
	public double getInitPrice()
	{
		 return this.initPrice;
	}

	public void setAvail(int avail)
	{
		this.avail = avail;
	}
	public int getAvail()
	{
		 return this.avail;
	}

	public void setKind(int kind)
	{
		this.kind = kind;
	}
	public int getKind()
	{
		 return this.kind;
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