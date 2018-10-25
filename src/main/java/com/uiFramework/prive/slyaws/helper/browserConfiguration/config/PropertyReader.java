package com.uiFramework.prive.slyaws.helper.browserConfiguration.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.uiFramework.prive.slyaws.helper.browserConfiguration.BrowserType;
import com.uiFramework.prive.slyaws.helper.resource.ResourceHelper;

/**
 * 
 * @author Devesh
 * in this class we are setting the values of the arguments like URL , user id , password from 
 * either the properties file or the VM arguments in the running configs(when there is no config file).
 * these can be set for each test class.
 */
public class PropertyReader implements ConfigReader {

	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader() {
		try {
			/*String filePath = ResourceHelper.getResourcePath("//src//main//java//com//uiFramework//prive//slyaws//helper//resource//config.properties");
			file = new FileInputStream(new File(filePath));
			OR = new Properties();
			OR.load(file);*/
			
			String filePath1 = ResourceHelper.getResourcePath("//src//main//java//com//uiFramework//prive//slyaws//helper//resource//config1.properties");
			file = new FileInputStream(new File(filePath1));
			OR = new Properties();
			OR.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getImpliciteWait() {
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getUrl() {
		if(System.getProperty("url")!=null){
			return System.getProperty("url");//from jenkins
		}
		return OR.getProperty("applicationUrl");//also from the VM arguments of run configurations
	}

	public String getUserName() {
		if(System.getProperty("TEXTBOX_USERNAME")!=null){
			return System.getProperty("username");//from jenkins
		}
		return OR.getProperty("TEXTBOX_USERNAME");//from the VM arguments of run configurations
	}

	public String getPassword() {
		if(System.getProperty("TEXTBOX_PASSWORD")!=null){
			return System.getProperty("password");//jenkins
		}
		return OR.getProperty("TEXTBOX_PASSWORD");//from the VM arguments of run configurations
	}

}
