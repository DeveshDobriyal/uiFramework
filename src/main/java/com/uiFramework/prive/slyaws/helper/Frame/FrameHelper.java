package com.uiFramework.prive.slyaws.helper.Frame;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;
import com.uiFramework.prive.slyaws.helper.wait.WaitHelper;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper (WebDriver driver)
	{this.driver = driver;
	}
	
	
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
		log.info("Switch To :"+ index + "Frame");
	}
	
	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
		log.info("Switch To :"+ frameName + "Frame");
	}
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switch To :"+ element.toString() + "Frame");
	}
	
	

}
