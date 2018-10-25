package com.uiFramework.prive.slyaws.helper.javaScript;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class JavaScriptHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		log.info("JS helper is initialised");
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script, args);
	}

	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public void ScrollToElement(WebElement element) {
		log.info("Scroll to WebElement");
		executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);

	}

	public void scrollToElementClick(WebElement element) {
		ScrollToElement(element);
		element.click();
		log.info("Element is clicked:" + element.toString());
	}

	public void scrollIntoView(WebElement element) {
		log.info("Scroll Till web element");
		executeScript("argument[0].scrollIntoView", element);
	}

	public void scrollIntoViewclick(WebElement element) {
		scrollIntoView(element);
		element.click();
		log.info("Element is clicked:" + element.toString());
	}

	public void scrollDownVertically() {
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public void scrollUpVertically() {
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
    
	/*This method will scroll till given pixel (eg = 1500)
	 * 
	 * */
     public void scrollDownByPixel(int pixel)
     {
    	 executeScript("window.scrollBY(0,"+pixel+")");
     }
     
     public void scrollUpByPixel(int pixel)
     {
    	 executeScript("window.scrollBY(0,-"+pixel+")");
     }
     /*
      * This method  will zoom screen by 100%
      * */
      public void zoomInBy100Percent() {
    	  executeScript("document.body.styl.zoom='100%'");
      }
      
      public void zoomInBy60Percent() {
    	  executeScript("document.body.styl.zoom='60%'");
      }
      
      public void clickElement(WebElement element) {
    	  executeScript("argument[0].click();",element);
      }


}
