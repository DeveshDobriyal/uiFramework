package com.uiFramework.prive.slyaws.helper.window;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.uiFramework.prive.slyaws.helper.Frame.FrameHelper;
import com.uiFramework.prive.slyaws.helper.logger.LoggerHelper;

public class WindowHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	public void switchTOParentWindow() {
		log.info("Switching to parent window");
		driver.switchTo().defaultContent();
	}

	public void switchTOWindow(int index) {
		log.info("Switching to parent window");
		Set<String> windows = driver.getWindowHandles();
		int i = 1;

		for (String window : windows) {
			if (i == index)
				driver.switchTo().window(window);
			else {
				i++;
			}
		}
	}

	public void CloseAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainwindow = driver.getWindowHandle(); // will give the parent window

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainwindow))
				driver.close();
		}
		driver.switchTo().window(mainwindow);
	}

	public void navigateBack() {
		driver.navigate().back();
	}

	public void navigateForward() {
		driver.navigate().forward();
	}
}
