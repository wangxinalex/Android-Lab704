package org.alex.calling;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.alex.calling.base.BaseAction;


public class AddBidAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//pack the attribution of parameters
	private int itemId;
	private double bidPrice;
	private double maxPrice;
	private String vercode;
	
	@Override
	public void validate()
	{
		
		if(bidPrice <= maxPrice)
		{
			addFieldError("bidPrice", "������ľ��۱�����ڵ�ǰ��߼ۣ�");
		}
	}
	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		
		Integer userId = (Integer)session.get("userId");
		String ver2 = (String)session.get("rand");
		session.put("rand" , null);
	
		if (vercode.equalsIgnoreCase(ver2))
		{
			mgr.addBid(itemId , bidPrice ,null,null, userId);  
			return SUCCESS;
		}
		else
		{
			addActionError("��֤�벻ƥ��,����������");
			return INPUT;
		}
	}

	public void setItemId(int itemId)
	{
		this.itemId = itemId;
	}
	public int getItemId()
	{
		 return this.itemId;
	}

	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}
	public double getBidPrice()
	{
		 return this.bidPrice;
	}

	public void setMaxPrice(double maxPrice)
	{
		this.maxPrice = maxPrice;
	}
	public double getMaxPrice()
	{
		 return this.maxPrice;
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