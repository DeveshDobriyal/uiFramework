package com.uiFramework.prive.slyaws.helper.select;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class DropDownHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(DropDownHelper.class);

	public DropDownHelper(WebDriver driver) {
		this.driver = driver;
		log.info("DropDownHelper obj created");
	}

	public void selectUsingValue(WebElement element, String value) {
Select select = new Select(element);
log.info("select using value and value is: "+ value);
select.selectByValue(value);
	}

	public void selectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("select using  index is: "+ index);
		select.selectByIndex(index);

	}

	public void selectVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		log.info("select using visible text is: "+ visibleText);
		select.selectByVisibleText(visibleText);
	}
	
	public void deselectUsingValue(WebElement element, String value) {
		Select select = new Select(element);
		log.info("deselect using value and value is: "+ value);
		select.selectByValue(value);
			}
	public void deselectUsingIndex(WebElement element, int index) {
		Select select = new Select(element);
		log.info("deselect using  index is: "+ index);
		select.selectByIndex(index);

	}
	public void deselectVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		log.info("deselect using visible text is: "+ visibleText);
		select.selectByVisibleText(visibleText);
	}
	
	public List<String> getAllDropDownData(WebElement element)
	{ Select select = new Select(element);
	List<WebElement> elementList = select.getAllSelectedOptions();
	List<String> valueList = new LinkedList<String>();
	for(WebElement ele:elementList) {
	log.info(ele.getText());
	valueList.add(ele.getText());
	}
	return valueList;
	}

}
