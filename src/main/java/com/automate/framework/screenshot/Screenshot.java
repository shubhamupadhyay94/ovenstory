package com.automate.framework.screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.automate.framework.config.ConfigReader;
import com.automate.framework.exception.UIActionsException;


public class Screenshot {

	Screenshot() {
	}

	static String screenshot = ConfigReader.getConfig("Screenshot");

	static Logger logger = Logger.getLogger(Screenshot.class);

	public static void takeScreenshot(WebDriver driver, String testcasename, String screenshotName)
			throws UIActionsException {

		try {
			String filePath = "";
			logger.info("Directory path is " + screenshot);
			filePath=FileUtility.createDirectory(screenshot + "\\" + testcasename);
			String suffix = System.currentTimeMillis() + "";
			String fileName = suffix + "_" + testcasename + "_" + screenshotName;
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File file = screenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, FileUtility.createFile(fileName, filePath+"\\"));

		} catch (Exception e) {
			logger.error("Error while taking screenshot " + e.getStackTrace());
			throw new UIActionsException(e.getMessage(), e);
		}
	}

}
