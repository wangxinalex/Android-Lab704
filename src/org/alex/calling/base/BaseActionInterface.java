package org.alex.calling.base;

import com.opensymphony.xwork2.Action;

import org.alex.service.CallingManager;
/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class BaseActionInterface implements Action
{
	protected CallingManager mgr;

	public void setMgr(CallingManager mgr)
	{
		this.mgr = mgr;
	}

	public String execute() throws Exception
	{
		return SUCCESS;
	}
}