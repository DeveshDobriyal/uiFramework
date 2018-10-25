package com.uiFramework.prive.slyaws.testScripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.uiFramework.prive.slyaws.helper.assertion.AssertionHelper;
import com.uiFramework.prive.slyaws.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.prive.slyaws.pageObject.LoginPage;
import com.uiFramework.prive.slyaws.testbase.TestBase;

public class LoginTest extends TestBase {

	private final Logger log = Logger.getLogger(LoginTest.class);

	@Test(description="LoginTest with Valid Credential")
	public void testLoginToApplication() {
		getApplicationUrl(ObjectReader.reader.getUrl());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.loginToApplication(ObjectReader.reader.getUserName(), ObjectReader.reader.getPassword());
		boolean status = loginPage.verifySuccessLoginMGS();
		
		AssertionHelper.updateTestStatus(status);
	}
	
}
