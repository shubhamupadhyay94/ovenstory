package com.automate.automation.pages.hoempage;

import org.openqa.selenium.WebDriver;
import com.automate.framework.exception.UIActionsException;

public class PageOvenStory {

	static IOvenHomePage iOvenHomePage = new IOvenHomePageImpl();

	public static String enterDeliveryLocation(WebDriver driver, String testcasename, String location)
			throws UIActionsException {
		return iOvenHomePage.enterDeliveryLocation(driver, testcasename, location);
	}

	public static String getLocationHeader(WebDriver driver, String testcasename) throws UIActionsException {
		return iOvenHomePage.getLocationHeader(driver, testcasename);
	}

	public static boolean verifySelectedLocation(WebDriver driver, String testcasename, String enteredLocation,
			String locationHeader) throws UIActionsException {
		return iOvenHomePage.verifySelectedLocation(driver, testcasename, enteredLocation, locationHeader);
	}

	public static void clickOnAddItem(WebDriver driver, String testcasename, String itemName)
			throws UIActionsException {

		iOvenHomePage.clickOnAddItem(driver, testcasename, itemName);

	}

	public static boolean selectAnyItemFromDifferentVeriety(WebDriver driver, String testcasename, String itemName)
			throws UIActionsException {

		return iOvenHomePage.selectAnyItemFromDifferentVeriety(driver, testcasename, itemName);

	}

	public static boolean selectAnyBase(WebDriver driver, String testcasename, String base) throws UIActionsException {
		return iOvenHomePage.selectAnyBase(driver, testcasename, base);

	}

	public static boolean isCustomizableWindowOpen(WebDriver driver, String testcasename) throws UIActionsException {
		return iOvenHomePage.isCustomizableWindowOpen(driver, testcasename);

	}

	public static void clickOnNext(WebDriver driver, String testcasename) throws UIActionsException {

		iOvenHomePage.clickOnNext(driver, testcasename);
	}

	public static void clickOnCheckout(WebDriver driver, String testcasename) throws UIActionsException {
		iOvenHomePage.clickOnCheckout(driver, testcasename);

	}

	public static boolean exicitingOfferWindowPresent(WebDriver driver, String testcasename) throws UIActionsException {
		return iOvenHomePage.exicitingOfferWindowPresent(driver, testcasename);

	}

	public static void clickOnSideMenu(WebDriver driver, String testcasename) throws UIActionsException {
		iOvenHomePage.clickOnSideMenu(driver, testcasename);

	}

	public static void clickOnMenu(WebDriver driver, String testcasename) throws UIActionsException {
		clickOnSideMenu(driver, testcasename);
		iOvenHomePage.clickOnMenu(driver, testcasename);
	}

	public static void clickOnPartyOrder(WebDriver driver, String testcasename) throws UIActionsException {
		clickOnSideMenu(driver, testcasename);
		iOvenHomePage.clickOnPartyOrder(driver, testcasename);

	}

	public static void clickOnTerms(WebDriver driver, String testcasename) throws UIActionsException {
		clickOnSideMenu(driver, testcasename);
		iOvenHomePage.clickOnTerms(driver, testcasename);
	}

	public static void clickOnPrivacy(WebDriver driver, String testcasename) throws UIActionsException {
		clickOnSideMenu(driver, testcasename);
		iOvenHomePage.clickOnPrivacy(driver, testcasename);
	}

	public static boolean isLocationHeaderDisplyaed(WebDriver driver, String testcasename) throws UIActionsException {
		return iOvenHomePage.isLocationHeaderDisplyaed(driver, testcasename);

	}

	public static boolean isRequestACallBackLinkPresent(WebDriver driver, String testcasename)
			throws UIActionsException {
		return iOvenHomePage.isRequestACallBackLinkPresent(driver, testcasename);
	}

	public static String getHeaderText(WebDriver driver, String testcasename) throws UIActionsException {
		return iOvenHomePage.getHeaderText(driver, testcasename);
	}

	public static void noOfHeaderOnPage(WebDriver driver, String testcasename) throws UIActionsException {
		iOvenHomePage.noOfHeaderOnPage(driver, testcasename);
	}

	public static void clickOnLocationHeader(WebDriver driver, String testcasename) throws UIActionsException {

		iOvenHomePage.clickOnLocationHeader(driver, testcasename);

	}

}
