package org.alex.calling;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.alex.calling.base.BaseAction;
import org.alex.exception.CallingException;
import org.alex.model.*;
import org.alex.service.CallingManager;
/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class ViewItemAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int kindId;
	private String kind;
	private List items; 

	public String execute()throws Exception
	{
		if (kindId <= 0)
		{
			addActionError("您必须选择有效的种类");
			return ERROR;
		}
		else
		{
			setKind(mgr.getKind(kindId));
			setItems(mgr.getItemsByKind(kindId));
			return SUCCESS;
		}
	}

	public void setKindId(int kindId)
	{
		this.kindId = kindId;
	}
	public int getKindId()
	{
		 return this.kindId;
	}

	public void setKind(String kind)
	{
		this.kind = kind;
	}
	public String getKind()
	{
		 return this.kind;
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