package com.uiFramework.prive.slyaws.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.Status;
import com.uiFramework.prive.slyaws.helper.assertion.VerificationHelper;
import com.uiFramework.prive.slyaws.helper.browserConfiguration.config.ObjectReader;
import com.uiFramework.prive.slyaws.helper.javaScript.JavaScriptHelper;
import com.uiFramework.prive.slyaws.helper.wait.WaitHelper;
import com.uiFramework.prive.slyaws.testbase.TestBase;
import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class LoginPage {

	private WebDriver driver;
	private final Logger log = Logger.getLogger(LoginPage.class);
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id=\"gwt-debug-UserLoginView-loginButton\"]")
	WebElement BUTTON_LOGIN;
	
	@FindBy(xpath="//*[@id=\"gwt-debug-UserLoginView-emailAddress\"]")
	WebElement TEXTBOX_USERNAME;
	
	
	@FindBy(xpath="//*[@id=\"gwt-debug-UserLoginView-password\"]")
	WebElement TEXTBOX_PASSWORD;
	
	@FindBy(xpath="//*[@id=\"gwt-debug-MyMaterialTopBarView-logoutAnchor\"]/i")
	WebElement LINK_LOGOUT;
	
	
	@FindBy(xpath="//*[@id=\"gwt-debug-MyMainMaterialView-myMaterialTopMenuBarPanel\"]/div/ul/li[1]/span")
	WebElement SUCCESSMSGOBJ;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		
		waitHelper.waitForElement(BUTTON_LOGIN, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver); // taking screen shot  on obj creation and adding it to extent report and email report	
	    TestBase.logExtentReport("Loginin Page obj created");
	}
	
	public void enterUserName(String USERNAME)
	{
		log.info("entering the user id");
		this.TEXTBOX_USERNAME.sendKeys(USERNAME);
	}
	
	public void enterPassword(String PASSWORD)
	{
	log.info("entering the password");
	this.TEXTBOX_PASSWORD.sendKeys(PASSWORD);			
	}
    
	public HomePage clickOnLoginButton() 
	{ log.info("Login button Clicked");
	logExtentReport("clicking on Login button...");
	/*JavaScriptHelper javaScriptHelper = new JavaScriptHelper(driver);
	javaScriptHelper.scrollDownVertically();*/
	BUTTON_LOGIN.click();
	return new HomePage(driver);
	}
    
	public boolean verifySuccessLoginMGS() {
		
		return new VerificationHelper(driver).isDisplayed(SUCCESSMSGOBJ);
		
	}
	
	public void loginToApplication(String USERNAME, String PASSWORD){
		
		enterUserName(USERNAME);
		enterPassword(PASSWORD);
		clickOnLoginButton();
	}
	
	public void logout(){
		waitHelper.waitForElement(LINK_LOGOUT, ObjectReader.reader.getExplicitWait());
		LINK_LOGOUT.click();
		log.info("clicked on logout link");
		
	}
	
	public void logExtentReport(String s1){
		TestBase.test.log(Status.INFO, s1);
	}
	
}
