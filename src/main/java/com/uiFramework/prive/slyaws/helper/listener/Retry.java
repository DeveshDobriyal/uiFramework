package com.uiFramework.prive.slyaws.helper.listener;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer; //IRetryAnalyser is a interface in TestNG
import org.testng.ITestResult; //

import com.uiFramework.prive.slyaws.helper.Frame.FrameHelper;
import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;



/**
 * @author user
 * Devesh Dobriyal 24th Sep'18
 * This is the Recovery scenario classs when a test fails
 */

public class Retry implements IRetryAnalyzer {
	private int retryCount = 0;
	private int maxRetryCount = 3;

	private Logger log = LoggerHelper.getLogger(Retry.class);

	public boolean retry(ITestResult arg0) {
		if (retryCount < maxRetryCount) {
			log.info("Retrying tests" + arg0.getName() + "with status" + getResultStatusName(arg0.getStatus())
					+ "For the" + (retryCount + 1) + "times");
			retryCount++;
			return true;

		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1) {
			resultName = "SUCCESS";
		}

		if (status == 2) {
			resultName = "FAILURE";
		}

		if (status == 3) {
			resultName = "SKIP";
		}

		return resultName;

	}
}
