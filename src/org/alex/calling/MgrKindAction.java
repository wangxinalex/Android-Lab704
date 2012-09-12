package org.alex.calling;

import java.util.*;
import com.opensymphony.xwork2.ActionContext;

import org.alex.calling.base.BaseActionInterface;
import org.alex.exception.CallingException;
import org.alex.service.CallingManager;

/**
 * Description:
 * @author  lab704
 * @version  1.0
 */
public class MgrKindAction extends BaseActionInterface
{
	private List kinds;
	private String errMsg;

	public String execute() throws Exception
	{
		Map session = ActionContext.getContext().getSession();
		setKinds(mgr.getAllKind());
		setErrMsg(errMsg);
		return SUCCESS;
	}

	public void setKinds(List kinds)
	{
		this.kinds = kinds;
	}
	public List getKinds()
	{
		 return this.kinds;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}
	public String getErrMsg()
	{
		 return this.errMsg;
	}

}