package org.alex.calling;

import java.util.*;
import com.opensymphony.xwork2.*;

import org.alex.calling.base.BaseActionInterface;
import org.alex.exception.CallingException;
import org.alex.service.CallingManager;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class MgrItemAction extends BaseActionInterface
{
	private List items;
	private List kinds;

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setItems(mgr.getItemsByOwner(userId));
		setKinds(mgr.getAllKind());
		return SUCCESS;
	}

	public void setItems(List items)
	{
		this.items = items;
	}
	public List getItems()
	{
		 return this.items;
	}

	public void setKinds(List kinds)
	{
		this.kinds = kinds;
	}
	public List getKinds()
	{
		 return this.kinds;
	}
}