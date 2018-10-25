package com.uiFramework.prive.slyaws.testScripts;

import org.testng.annotations.Test;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.uiFramework.prive.slyaws.pageObject.LoginPage;

import com.uiFramework.prive.slyaws.helper.assertion.AssertionHelper;
import com.uiFramework.prive.slyaws.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;
import com.uiFramework.prive.slyaws.helper.wait.WaitHelper;
import com.uiFramework.prive.slyaws.pageObject.HomePage;
import com.uiFramework.prive.slyaws.pageObject.LoginPage;
import com.uiFramework.prive.slyaws.testbase.TestBase;

public class LoginTestScenarios extends TestBase {
	
	

	private final Logger log = LoggerHelper.getLogger(LoginTestScenarios.class);
	
	LoginPage login;
	HomePage homepage;
	WaitHelper waitHelper;
	
	@DataProvider(name="testData")	
	public  Object[][] testData(){
	Object[][] data = getExcelData("testData.xlsx","LoginData");
	return data;
	}
	
	@BeforeClass
	public void beforeClass() {
	getApplicationUrl(ObjectReader.reader.getUrl());	
	login = new LoginPage(driver);
	}
	
	
	@Test(dataProvider="testData")
	public void loginTest(String USERNAME , String PASSWORD , String runMode) {
		if(runMode.equalsIgnoreCase("n")) {
		throw new SkipException("Run Mode for this set of Data is set to N");	
		}
	login.loginToApplication(USERNAME, PASSWORD);
	boolean status = login.verifySuccessLoginMGS();
	AssertionHelper.updateTestStatus(status);
	
	login.logout();
	}
	

}
