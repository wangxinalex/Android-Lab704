package org.alex.calling.base;

import com.opensymphony.xwork2.ActionSupport;

import org.alex.exception.CallingException;
import org.alex.service.CallingManager;
/**
 * Description:
 * @author lab704
 * @version  1.0
 */
public class BaseAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected CallingManager mgr;

	public void setMgr(CallingManager mgr)
	{
		this.mgr = mgr;
	}
}