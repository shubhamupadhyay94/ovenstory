package com.automate.framework.uiaction;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.framework.exception.UIActionsException;

public class UIActions {
	static Logger logger = Logger.getLogger(UIActions.class);
	static int HIGH_WAIT = 3;
	static int DEFAULT_LOW_WAIT = 1;
	static int DEFAULT_WAIT = 2;

	public static void click(WebDriver driver, By by) throws UIActionsException {

		boolean status = false;
		try {
			WebElement element = UIActions.findElement(driver, by);
			status = UIActions.isElementDisplayed(driver, by);
			if (status) {
				if (UIActions.isElementClickable(driver, by)) {
					element.click();
					logger.info("Clicked on element . Element is " + by);
				}
			}

		} catch (Exception e) {
			try {
				WebElement element = UIActions.findElement(driver, by);
				status = UIActions.isElementDisplayed(driver, by);
				if (status) {
					if (UIActions.isElementClickable(driver, by)) {
						element.click();
						logger.info("Clicked on element . Element is " + by);
					}
				}
			} catch (Exception et) {
				throw new UIActionsException(et);

			}
		}

	}

	public static void highWait() throws UIActionsException {
		try {
			Thread.sleep(HIGH_WAIT * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new UIActionsException(e);
		}
	}

	public static void waitForDefaultSleep() throws UIActionsException {
		try {
			Thread.sleep(DEFAULT_WAIT * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new UIActionsException(e);
		}
	}

	public static void waitForDefaultLowSleep() throws UIActionsException {
		try {
			Thread.sleep(DEFAULT_LOW_WAIT * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new UIActionsException(e);
		}
	}

	public static boolean isAlertPresent(WebDriver driver) throws UIActionsException {
		boolean status = false;
		try {
			Alert alert = driver.switchTo().alert();
			logger.info("Alert is present on page.");
			status = true;
		} // try
		catch (NoAlertPresentException Ex) {
			logger.info("Alert is not present on page.");
			status = false;
		}
		return status;
	}

	public static boolean acceptAlert(WebDriver driver) throws UIActionsException {
		boolean status = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			logger.info("Alert is present. Accepted alert");
			status = true;
		} // try
		catch (NoAlertPresentException Ex) {
			logger.error("Alert is no alert present on page");
			status = false;
		} catch (Exception e) {
			logger.error("Exception occured while accepting alert.");
			status = false;
		}
		return status;
	}

	public static boolean dismissAlert(WebDriver driver) throws UIActionsException {
		boolean status = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			logger.info("Alert is present. Dismissed alert");
			status = true;
		} // try
		catch (NoAlertPresentException Ex) {
			logger.error("Alert is no alert present on page");
			status = false;
		} catch (Exception e) {
			logger.error("Exception occured while rejecting alert.");
			status = false;
		}
		return status;
	}

	public static WebElement findElement(WebDriver driver, By by) throws UIActionsException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			WebElement element = driver.findElement(by);
			return element;
		} catch (NoSuchElementException e) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
				wait.until(ExpectedConditions.presenceOfElementLocated(by));
				WebElement element = driver.findElement(by);
				return element;
			} catch (Exception ec) {
				logger.error("Error while finding element on page" + by);
				throw new UIActionsException(ec);
			}
		} catch (Exception e) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT);
				wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				WebElement element = driver.findElement(by);
				return element;
			} catch (Exception ec) {
				logger.error("Error while finding element on page" + by);
				throw new UIActionsException(ec);
			}
		}
	}

	public static boolean isElementDisplayed(WebDriver driver, By by) throws UIActionsException {
		boolean status = false;
		try {

			WebElement element = UIActions.findElement(driver, by);
			status = element.isDisplayed();
			if (status) {
				logger.info("Elememnt is displayed on UI.");
			} else {
				logger.error("Element is not displau=yed.");
			}
	
		} catch (Exception e) {
			try {
				logger.error("Retrying to find element " + by);
				WebElement element = UIActions.findElement(driver, by);
				status = element.isDisplayed();
				if (status) {
					logger.info("Elememnt is displayed on UI." + by);
				} else {
					logger.error("Element is not displau=yed." + by);
				}

			} catch (Exception rt) {
				throw new UIActionsException(rt);
			}
		}
		return status;

	}

	public static boolean isElementSelected(WebDriver driver, By by) throws UIActionsException {
		boolean status = false;
		try {

			WebElement element = UIActions.findElement(driver, by);
			status = element.isSelected();
			if (status) {
				logger.info("Elememnt is Selected ." + by);
			} else {
				logger.error("Element is not Selected." + by);
			}
		
		} catch (Exception e) {
			try {
				WebElement element = UIActions.findElement(driver, by);
				status = element.isSelected();
				if (status) {
					logger.info("Elememnt is Selected ." + by);
				} else {
					logger.error("Element is not Selected." + by);
				}

			} catch (Exception rt) {
				throw new UIActionsException(rt);
			}
		}
		return status;

	}

	public static void scroll(WebDriver driver) throws UIActionsException {

		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			logger.info("Scrolling window by 200");
		} catch (Exception e) {
			logger.error("Error while scrolling window. Retrying again.");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)");
			logger.info("Scrolling window by 200");
			try {

			} catch (Exception rt) {
				throw new UIActionsException(rt);
			}
		}

	}

	public static boolean isElementClickable(WebDriver driver, By by) throws UIActionsException {
		boolean status = false;
		try {

			WebElement element = UIActions.findElement(driver, by);
			status = element.isEnabled();
			if (status) {
				logger.info("Elememnt is Enabled on UI." + by);
			} else {
				logger.error("Element is not enabled." + by);
			}
			return status;
		} catch (Exception e) {
			try {
				logger.error("Retrying to find element " + by);
				WebElement element = UIActions.findElement(driver, by);
				status = element.isDisplayed();
				if (status) {
					logger.info("Elememnt is displayed on UI." + by);
				} else {
					logger.error("Element is not displau=yed." + by);
				}

			} catch (Exception et) {
				throw new UIActionsException(et);
			}
		}
		return status;

	}

	@SuppressWarnings("null")
	public static String getText(WebDriver driver, By by) throws UIActionsException {

		String gettext = "";
		try {
			WebElement element = UIActions.findElement(driver, by);
			gettext = element.getText();
			logger.info("Text is " + gettext);
			if (gettext != null || !(gettext.equals(""))) {
				return gettext;
			} else if (gettext == null || gettext.equals("")) {
				String value = element.getAttribute("value");
				if (value != null || !(gettext.equals(""))) {
					gettext = value;
					logger.info("Text is find using attribute " + value);
				}
			} else {
				logger.error("No text found in element" + by);
			}

		} catch (Exception e) {
			try {
				WebElement element = UIActions.findElement(driver, by);
				gettext = element.getText();
				logger.info("Text is " + gettext);
				if (gettext != null || !(gettext.equals(""))) {
					return gettext;
				} else if (gettext == null || gettext.equals("")) {
					String value = element.getAttribute("value");
					if (value != null || !(gettext.equals(""))) {
						gettext = value;
						logger.info("Text is find using attribute " + value);
					}
				} else {
					logger.error("No text found in element" + by);
				}
			} catch (Exception ex) {
				logger.error("No text found after retrying also");
			}

		}
		return gettext;
	}

	public static String sendKeys(WebDriver driver, By by, String text) throws UIActionsException {
		String value = "";
		try {
			WebElement element = UIActions.findElement(driver, by);
			element.sendKeys(text);
			value = UIActions.getText(driver, by);
			logger.info("Entered value is " + value);

		} catch (Exception e) {
			logger.info("Exception occured while perfroming sendkeys. Trying 2nd time.");
			try {
				WebElement element = UIActions.findElement(driver, by);
				element.sendKeys(text);
				value = UIActions.getText(driver, by);
				logger.info("Entered value is filed second time" + value);
			} catch (Exception ex) {
				throw new UIActionsException(ex);
			}
		}
		return value;
	}

	public static String selectValueFromDropdown(WebDriver driver, By by, String text) throws UIActionsException {

		try {

		} catch (Exception e) {

		}
		return text;
	}

	public static String getAttributeValue(WebDriver driver, By by, String attributeName) throws UIActionsException {

		String gettext = "";
		try {
			WebElement element = UIActions.findElement(driver, by);
			String value = element.getAttribute(attributeName);
			if (value != null || !(gettext.equals(""))) {
				gettext = value;
				logger.info("Text is find using attribute " + value);
			} else {
				logger.error("No text found is found using attribute" + by);
			}

		} catch (Exception e) {
			try {
				WebElement element = UIActions.findElement(driver, by);
				String value = element.getAttribute(attributeName);
				if (value != null || !(gettext.equals(""))) {
					gettext = value;
					logger.info("Text is find using attribute " + value);
				} else {
					logger.error("No text found is found using attribute" + by);
				}
			} catch (Exception ex) {
				logger.error("No text found after retrying also");
			}

		}
		return gettext;
	}

	public static void closeBrowser(WebDriver driver, String testcasename) throws UIActionsException {

		try {
			if (driver != null) {
				driver.quit();
				logger.info("Closed driver for testcase" + testcasename);
			} else {
				logger.info("driver is null");
			}

		} catch (WebDriverException e) {
			logger.error("WebDriverException occured while closing browser.", e);
			throw new UIActionsException(e);
		} catch (Exception e) {
			logger.error("Error while closing browser.", e);
			throw new UIActionsException(e);
		}
	}

}
