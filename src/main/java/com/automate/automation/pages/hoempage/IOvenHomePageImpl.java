package com.automate.automation.pages.hoempage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automate.framework.exception.UIActionsException;
import com.automate.framework.screenshot.Screenshot;
import com.automate.framework.uiaction.UIActions;

public class IOvenHomePageImpl implements IOvenHomePage {

	static Logger logger = Logger.getLogger(IOvenHomePageImpl.class);

	public String enterDeliveryLocation(WebDriver driver, String testcasename, String location)
			throws UIActionsException {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		String locationName = null;
		WebElement element = null;
		try {

			Screenshot.takeScreenshot(driver, testcasename, "Before entering location");
			locationName = UIActions.sendKeys(driver, INPUT_DELIVERY_LOCATION, location);
			UIActions.highWait();
			logger.info("Entered location is " + locationName);
			Screenshot.takeScreenshot(driver, testcasename, "After entering location");
			element = UIActions.findElement(driver, INPUT_DELIVERY_LOCATION);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ARROW_DOWN);
			element.sendKeys(Keys.ENTER);
			UIActions.waitForDefaultLowSleep();
			wait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_LOCATION_NAME));

		} catch (Exception e) {
			try {
				logger.error("Retrying to fill delivery location in 2nd attempt.");
				Screenshot.takeScreenshot(driver, testcasename, "Before entering location 2nd attempt");
				locationName = UIActions.sendKeys(driver, INPUT_DELIVERY_LOCATION, location);
				UIActions.waitForDefaultLowSleep();
				logger.info("Entered location is " + locationName);
				Screenshot.takeScreenshot(driver, testcasename, "After entering location 2nd time");
				element = UIActions.findElement(driver, INPUT_DELIVERY_LOCATION);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ARROW_DOWN);
				element.sendKeys(Keys.ENTER);
				UIActions.waitForDefaultLowSleep();
				wait.until(ExpectedConditions.visibilityOfElementLocated(HEADER_LOCATION_NAME));
			} catch (Exception ex) {
				logger.error("Failed delivery location selection in 2nd attempt.");
				throw new UIActionsException(ex);

			}
		}
		return locationName;
	}

	public String getLocationHeader(WebDriver driver, String testcasename) throws UIActionsException {
		String locationName = null;
		locationName = UIActions.getText(driver, HEADER_LOCATION_NAME);
		logger.info("Location name on home page is" + locationName);
		Screenshot.takeScreenshot(driver, testcasename, "home page");
		UIActions.waitForDefaultSleep();
		return locationName;
	}

	public boolean verifySelectedLocation(WebDriver driver, String testcasename, String enteredLocation,
			String locationHeader) throws UIActionsException {
		boolean status = false;
		if (enteredLocation.equalsIgnoreCase(locationHeader) || locationHeader.contains(enteredLocation)) {
			logger.info("Right location is selected");
			status = true;
		} else {
			logger.error("Right location is not selected");
			status = false;
		}
		return status;
	}

	public void clickOnAddItem(WebDriver driver, String testcasename, String itemName) throws UIActionsException {

		UIActions.scroll(driver);
		String itemNameXpath = "//h2[contains(text(),'" + itemName + "')]/../..//a[@id='addProductCombo']";
		By item = By.xpath(itemNameXpath);
		UIActions.click(driver, item);
		UIActions.waitForDefaultSleep();
		logger.info("Clicked on add item.");
		Screenshot.takeScreenshot(driver, testcasename, "After clicking on add button");

	}

	public boolean selectAnyItemFromDifferentVeriety(WebDriver driver, String testcasename, String itemName)
			throws UIActionsException {

		String getValue = "";
		boolean status = false;

		String itemNameXpath = "//label[contains(text(),'" + itemName
				+ "')]/../..//span[contains(@class,'radioUnselected ')]";

		String verifyItemSelected = "//label[contains(text(),'" + itemName
				+ "')]/../..//input[contains(@id,'product_')]";

		By item = By.xpath(itemNameXpath);
		By itemSelected = By.xpath(verifyItemSelected);
		UIActions.click(driver, item);
		logger.info("Clicked on select any item based on name." + itemName);
		Screenshot.takeScreenshot(driver, testcasename, "select any one item");

		status = UIActions.isElementSelected(driver, itemSelected);

		return status;

	}

	public boolean selectAnyBase(WebDriver driver, String testcasename, String base) throws UIActionsException {

		String getValue = "";
		boolean status = false;

		String itemNameXpath = "//label[contains(text(),'" + base
				+ "')]/../..//..//span[contains(@class,'radioUnselected')]";

		String verifyItemSelected = "//label[contains(text(),'" + base + "')]/../../..//input[@name='baseSelect']";

		By item = By.xpath(itemNameXpath);
		By itemSelected = By.xpath(verifyItemSelected);
		UIActions.click(driver, item);
		logger.info("Selected base is ." + base);
		Screenshot.takeScreenshot(driver, testcasename, "base any one base");
		status = UIActions.isElementSelected(driver, itemSelected);
		return status;

	}

	public boolean isCustomizableWindowOpen(WebDriver driver, String testcasename) throws UIActionsException {
		boolean customization = UIActions.isElementDisplayed(driver, HEADER_CUSTOMIZATION_WINDOW);

		Screenshot.takeScreenshot(driver, testcasename, "HEADER_CUSTOMIZATION_WINDOW");
		logger.info("Customization window is open.");
		return customization;

	}

	public void clickOnNext(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, BUTTON_NEXT);
		logger.info("Clicked on Next button.");
		UIActions.waitForDefaultLowSleep();
		Screenshot.takeScreenshot(driver, testcasename, "BUTTON_NEXT");

	}

	public void clickOnCheckout(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, CHECKOUT_BUTTON);
		logger.info("Clicked on checkout button.");
		Screenshot.takeScreenshot(driver, testcasename, "checkout button");

	}

	public boolean exicitingOfferWindowPresent(WebDriver driver, String testcase) throws UIActionsException {
		boolean offer = UIActions.isElementDisplayed(driver, DIV_EXCITING_OFFER);
		if (offer) {
			UIActions.click(driver, BUTTON_NO_OFFER_SELECTED);
		} else {
			logger.info("No offer popup");
		}
		return offer;
	}

	// side menu option
	public void clickOnSideMenu(WebDriver driver, String testcasename) throws UIActionsException {

		UIActions.click(driver, LINK_SIDE_MENU_BAR);
		UIActions.waitForDefaultLowSleep();
		logger.info("Clicked on side menu bar");
		Screenshot.takeScreenshot(driver, testcasename, "SIDE_MENU_BAR");

	}

	public void clickOnMenu(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, LINK_SIDE_MENU);
		UIActions.waitForDefaultLowSleep();
		logger.info("Clicked on menu option");
		Screenshot.takeScreenshot(driver, testcasename, "LINK_SIDE_MENU");

	}

	public void clickOnPartyOrder(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, LINK_MENU_PARTY_PRDER);
		UIActions.waitForDefaultLowSleep();
		logger.info("Clicked on party order.");
		Screenshot.takeScreenshot(driver, testcasename, "LINK_MENU_PARTY_PRDER");

	}

	public void clickOnTerms(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, LINK_MENU_TERMS);
		UIActions.waitForDefaultLowSleep();
		logger.info("Clicked on terms menu option.");
		Screenshot.takeScreenshot(driver, testcasename, "LINK_MENU_TERMS");

	}

	public void clickOnPrivacy(WebDriver driver, String testcasename) throws UIActionsException {
		UIActions.click(driver, LINK_MENU_PRIVACY);
		logger.info("Clicked on terms menu option.");
		Screenshot.takeScreenshot(driver, testcasename, "LINK_MENU_TERMS");

	}

	public boolean isLocationHeaderDisplyaed(WebDriver driver, String testcasename) throws UIActionsException {

		boolean status = false;
		status = UIActions.isElementDisplayed(driver, HEADER_LOCATION_NAME);
		Screenshot.takeScreenshot(driver, testcasename, "HEADER_LOCATION_NAME");
		return status;
	}

	public boolean isRequestACallBackLinkPresent(WebDriver driver, String testcasename) throws UIActionsException {
		boolean status = false;
		status = UIActions.isElementDisplayed(driver, LINK_REQUEST_A_CALL_BACK);
		Screenshot.takeScreenshot(driver, testcasename, "LINK_REQUEST_A_CALL_BACK");
		return status;
	}

	public String getHeaderText(WebDriver driver, String testcasename) throws UIActionsException {
		String text = "";
		text = UIActions.getText(driver, HEADER_OVEN_STORY_SERVICE);
		logger.info("Text present on header is " + text);
		Screenshot.takeScreenshot(driver, testcasename, "HEADER_OVEN_STORY_SERVICE");
		return text;
	}

	public void noOfHeaderOnPage(WebDriver driver, String testcasename) throws UIActionsException {

		WebDriverWait wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(HEADER_OVEN_STORY_SERVICE, 1));
		Screenshot.takeScreenshot(driver, testcasename, "HEADER_OVEN_STORY_SERVICE");

	}

	public void clickOnLocationHeader(WebDriver driver, String testcasename) throws UIActionsException {

		UIActions.click(driver, HEADER_LOCATION_NAME);
		Screenshot.takeScreenshot(driver, testcasename, "home page");
		UIActions.waitForDefaultSleep();

	}

}
