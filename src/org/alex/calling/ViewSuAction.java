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
public class ViewSuAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List items;

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		Integer userId = (Integer)session.get("userId");
		setItems(mgr.getItemByWiner(userId));
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

}