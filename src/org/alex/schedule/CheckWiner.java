package org.alex.schedule;

import java.util.TimerTask;

import org.alex.exception.CallingException;
import org.alex.service.CallingManager;

/**
 * Description:
 * 
 * @author lab704
 * @version 1.0
 */
public class CheckWiner extends TimerTask {
	private CallingManager mgr;

	public void setMgr(CallingManager mgr) {
		this.mgr = mgr;
	}

	public void run() {
		try {
			mgr.updateWiner();
		} catch (CallingException ae) {
			ae.printStackTrace();
		}
	}
}
