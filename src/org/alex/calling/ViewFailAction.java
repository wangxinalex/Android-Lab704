package org.alex.calling;

import java.util.List;

import org.alex.calling.base.BaseAction;
/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class ViewFailAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List failItems;

	public String execute()throws Exception
	{
		setFailItems(mgr.getFailItems());
		return SUCCESS;
	}

	public void setFailItems(List failItems)
	{
		this.failItems = failItems;
	}
	public List getFailItems()
	{
		 return this.failItems;
	}
}