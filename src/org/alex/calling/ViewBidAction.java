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
public class ViewBidAction extends BaseAction
{
	private List bids;
	
	public String execute()throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setBids(mgr.getBidByUser(userId));
		return SUCCESS;
	}

	public void setBids(List bids)
	{
		this.bids = bids;
	}

	public List getBids()
	{
		 return this.bids;
	}

}