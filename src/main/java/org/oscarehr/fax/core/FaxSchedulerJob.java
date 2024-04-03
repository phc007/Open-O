/**
 * Copyright (c) 2001-2002. Department of Family Medicine, McMaster University. All Rights Reserved.
 * This software is published under the GPL GNU General Public License.
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * This software was written for the
 * Department of Family Medicine
 * McMaster University
 * Hamilton
 * Ontario, Canada
 */
package org.oscarehr.fax.core;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PreDestroy;

import org.apache.logging.log4j.Logger;
import org.oscarehr.util.MiscUtils;
import org.springframework.stereotype.Component;

import oscar.OscarProperties;

@Component
public class FaxSchedulerJob extends TimerTask {
	private static final Logger logger = MiscUtils.getLogger();
	private static Boolean isRunning = false;
	private static String errorMessage = "";

	private static final String FAX_POLL_INTERVAL_KEY = "faxPollInterval";
	private static Timer timer;
	private static TimerTask timerTask = null;

	@Override
	public void run() {
		try {
			isRunning = true;
			FaxImporter faxImporter = new FaxImporter();
			faxImporter.poll();
			
			FaxSender faxSender = new FaxSender();
			faxSender.send();
			
			FaxStatusUpdater faxStatusUpdater = new FaxStatusUpdater();
			faxStatusUpdater.updateStatus();
		} catch (Exception e) {
			/*
			* Catching any unexpected exception thrown by these methods here and logging it.
			* Also, cancelling the thread so that an admin has to manually reboot the scheduler
			* or restart the system to start the task again. Doing this because it would not be good
			* to keep running the thread even after it throws an unknown error, which may lead to the
			* fax scheduler going haywire.
			*/
			logger.error("Fax scheduler has been stopped due to an unexpected error", e);
			errorMessage = e.getMessage();
			isRunning = false;
			cancel();
		}
	}

	public synchronized void restartTask() {
		cancelTask();
		startTask();
	}

	private synchronized void startTask() {
		if (isRunning) { return; }

		String faxPollInterval = (String) OscarProperties.getInstance().get(FAX_POLL_INTERVAL_KEY);
		long period = 60000;
		try {
			period = Long.parseLong(faxPollInterval);
		} catch (Exception e) {
			logger.error("FaxSchedularJob not scheduled, period is missing or invalid properties file : " + FAX_POLL_INTERVAL_KEY + '=' + faxPollInterval, e);
			return;
		}
		timerTask = new FaxSchedulerJob();
		timer = new Timer("FaxSchedulerJob Timer");
		timer.schedule(timerTask, 3000, period);
	}

	@PreDestroy
	private synchronized void cancelTask() {
		if (timerTask != null) { 
			timerTask.cancel(); 
			timer.cancel();
		} else {
			this.cancel();
		}
		isRunning = false;
	}

	public Boolean isRunning() {
		return isRunning;
	}

	public String getErrorMessage() {
		return errorMessage;
	}	

}
