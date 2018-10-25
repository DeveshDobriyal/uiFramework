package com.uiFramework.prive.slyaws.helper.wait;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class WaitHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
	this.driver=driver;	
	log.info("Wait helper obj created");
	}
	/**
	 * This is ImplicitWait method
	 * 
	 * @param timeout
	 * @param unit
	 */
	public void setImplicitWait(long timeout, TimeUnit unit)
	{   log.info("Implicit wait time set to :"+ timeout); 
		driver.manage().timeouts().implicitlyWait(timeout, unit);
	}
	
	/**
	 * This will help us to get WebDriverWait object
	 * 
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 * @return
	 */
	
	private WebDriverWait getWait(int timeOutInSeconds , int pollingEveryInMiliSec) {
		
		WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingEveryInMiliSec));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		return wait;
		
	}
	/**
	 * This method will make sure element is visible
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public void WaitForElementVisibleWithPollingTime(WebElement element , int timeOutInSeconds , int pollingEveryInMillisec)
	{
		log.info("waiting for :"+element.toString()+"for :"+ timeOutInSeconds+"seconds");
	    WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
	    wait.until(ExpectedConditions.visibilityOf(element));
	    log.info("Element is visible now");

	}
	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void WaitForElementClickable(WebElement element , int timeOutInSeconds)
	{
		log.info("Waiting for :"+element.toString()+"for :"+ timeOutInSeconds+"seconds");
	    WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    log.info("Element is clickable now");

	}
	/**
	 * This method will make sure invisibilityOf element
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean WaitForElementNotPresent(WebElement element , int timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+"for :"+ timeOutInSeconds+"seconds");
	    WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
	    boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
	    log.info("Element is invisible now");
	    return status;

	}
	/**
	 * This method will wait for frameToBeAvailableAndSwitchToIt
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void WaitForframeToBeAvailableAndSwitchToIt(WebElement element , int timeOutInSeconds)
	{
		log.info("waiting for :"+element.toString()+"for :"+ timeOutInSeconds+"seconds");
	    WebDriverWait wait = new WebDriverWait(driver , timeOutInSeconds);
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
	    log.info("Frame is available and Switched");   
	}
	/* will be used in the same class , for fluent weight OBJ
	 * 
	 * 
	 * */
	private Wait<WebDriver> getfluentWait(int timeOutInSeconds , int pollingEveryInMiliSec)
	{
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds)).pollingEvery(Duration.ofMillis(pollingEveryInMiliSec)).ignoring(NoSuchElementException.class);
		return fWait;
	}
	/**
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingEveryInMiliSec
	 */
	public WebElement waitForElement(WebElement element , int timeOutInSeconds , int pollingEveryInMillisec)
	{
		Wait<WebDriver> fWait = getfluentWait(timeOutInSeconds , pollingEveryInMillisec);
		fWait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public void pageLoadTime(long timeout , TimeUnit unit) {
		log.info("waiting for a page to load for :" + unit);
		driver.manage().timeouts().pageLoadTimeout(timeout, unit);
		log.info("Page is loaded");
	}
	/**
	 * This method will make sure elementToBeClickable
	 * 
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElement(WebElement element, int timeOutInSeconds) {
		log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
	}

	
	
}
