package com.automate.framework;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automate.framework.config.ConfigReader;
import com.automate.framework.iConstants.FrameworkConstant;
import com.automate.framework.uiaction.UIActions;

public class DriverManager {

	static Logger logger = Logger.getLogger(DriverManager.class);

	static String browserName = ConfigReader.getConfig("browser");
	static String chromePath = ConfigReader.getConfig("chromePath");
	static String url = ConfigReader.getConfig("url");

	static {
		PropertyConfigurator.configure("log4j.properties");
		ConfigReader.loadConfig();
		chromePath = System.getProperty("user.dir") + "\\" + chromePath;
	}

	public static WebDriver getDriver() {
		WebDriver driver = null;
		try {
			logger.info(chromePath + "broser name " + browserName);
			if (browserName.equalsIgnoreCase(FrameworkConstant.BROWSER_CHROME))
				System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
			driver.get(url);
			UIActions.waitForDefaultLowSleep();

		} catch (WebDriverException e) {
			logger.error("Error while creating driver in WebDriverException", e);

		} catch (Exception e) {
			logger.error("Webdriver is not created.", e);
		}
		return driver;

	}

	public static void main(String args[]) {

		DriverManager.getDriver();
	}
}
