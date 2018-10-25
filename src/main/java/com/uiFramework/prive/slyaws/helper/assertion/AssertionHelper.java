package com.uiFramework.prive.slyaws.helper.assertion;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class AssertionHelper {
	
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	
	public static void verifyText(String s1 , String s2)
	{   log.info("Verifying test:"+s1+ "with "+s2);
		Assert.assertEquals(s1, s2);
	}

	public static void makeTrue() {
		log.info("making script pass intentionally");
		Assert.assertTrue(true);
	}
	
	public static void makeTrue(String message) {
		log.info("making script fail intentionally"+message);
		Assert.assertTrue(true, message);
	}
	
	public static void makeFalse() {
		log.info("making script fail intentionally");
		Assert.assertTrue(false);
	}
	
	public static void makeFalse(String message) {
		log.info("making script fail intentionally"+message);
		Assert.assertTrue(false, message);
	}
	
	public static void verfyTrue(boolean status)
	{
		Assert.assertTrue(status);
	}
	
	
	public static void verfyFalsee(boolean status)
	{
		Assert.assertFalse(status);
	}
	
	public static void verifyNull(String s1) {
		log.info("Verify obj is null");
		Assert.assertNull(s1);
	}
	
public static void verifyNotNull(String s1) {
	log.info("Verify obj is not null");
		Assert.assertNotNull(s1);
	}
public static void fail(){
	Assert.assertTrue(false);
}

public static void pass(){
	Assert.assertTrue(true);
}
public static void updateTestStatus(boolean status){
	if(status){
		pass();
	}
	else{
		fail();
	}
}
	
}
