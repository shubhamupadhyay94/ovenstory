package com.automate.automation.pages.hoempage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automate.framework.exception.UIActionsException;

public interface IOvenHomePage {

	By INPUT_DELIVERY_LOCATION = By.id("locationSearchInput");

	By HEADER_LOCATION_NAME = By.xpath("//div[@class='locationHeader']//span[@class='locationNameHeader']");

	By ADD_ITEM = By.xpath("//h2[contains(text(),'BOGO Veg Pizza Combo')]/../..//a[@id='addProductCombo']");
	By HEADER_CUSTOMIZATION_WINDOW = By.xpath("//h2[@class='customiseProductName']");
	By BUTTON_NEXT = By.xpath("//a[contains(@class,'changeCustomisationSetBtn')]");
	By SELECT_ITEM_BY_ITEM_NAME = By
			.xpath("//label[contains(text(),'Veg Overload Pizza')]/../..//input[starts-with(@id,'product_')]");
	By SELECT_ITEM_BASE = By.xpath("//label[contains(text(),'Chipotle Cheese')]/../..//..//input[@name='baseSelect']");
	By CHECKOUT_BUTTON = By.id("checkoutBtn");
	By DIV_EXCITING_OFFER = By.xpath("//div[contains(@class,'show-animate')]");
	By BUTTON_NO_OFFER_SELECTED = By.id("wzrk-cancel");

	// menu option
	By LINK_SIDE_MENU_BAR = By.xpath("//a[@class='headerIcon']");
	By LINK_SIDE_MENU = By.xpath("//li[@id='sb_col']//a");
	By LINK_MENU_PARTY_PRDER = By.xpath("//li[@id='sb_po']//a");
	By LINK_MENU_TERMS = By.xpath("//li[@id='sb_tr']//a");

	By LINK_MENU_PRIVACY = By.xpath("//li[@id='sb_pr']//a");

	By LINK_REQUEST_A_CALL_BACK = By.className("primaryBtn");
	By HEADER_OVEN_STORY_SERVICE = By.xpath("//h1[@class='pageHeading']");
	By AUTO_COMPLETE_LOCATION=By.xpath("//div[contains(@class,'setpositionDropdownContainer')]");

	public String enterDeliveryLocation(WebDriver driver, String testcasename, String location)
			throws UIActionsException;

	public String getLocationHeader(WebDriver driver, String testcasename) throws UIActionsException;

	public boolean verifySelectedLocation(WebDriver driver, String testcasename, String enteredLocation,
			String locationHeader) throws UIActionsException;

	public void clickOnAddItem(WebDriver driver, String testcasename, String itemName) throws UIActionsException;

	public boolean isCustomizableWindowOpen(WebDriver driver, String testcasename) throws UIActionsException;

	public boolean selectAnyItemFromDifferentVeriety(WebDriver driver, String testcasename, String itemVeriety)
			throws UIActionsException;

	public boolean selectAnyBase(WebDriver driver, String testcasename, String base) throws UIActionsException;

	public void clickOnNext(WebDriver driver, String testcasename) throws UIActionsException;

	public void clickOnCheckout(WebDriver driver, String testcasename) throws UIActionsException;

	public boolean exicitingOfferWindowPresent(WebDriver driver, String testcase) throws UIActionsException;

	// side menu

	public void clickOnSideMenu(WebDriver driver, String testcasename) throws UIActionsException;

	public void clickOnMenu(WebDriver driver, String testcasename) throws UIActionsException;

	public void clickOnPartyOrder(WebDriver driver, String testcasename) throws UIActionsException;

	public void clickOnTerms(WebDriver driver, String testcasename) throws UIActionsException;

	public void clickOnPrivacy(WebDriver driver, String testcasename) throws UIActionsException;

	public boolean isLocationHeaderDisplyaed(WebDriver driver, String testcasename) throws UIActionsException;

	public boolean isRequestACallBackLinkPresent(WebDriver driver, String testcasename) throws UIActionsException;

	public String getHeaderText(WebDriver driver, String testcasename) throws UIActionsException;
	public void noOfHeaderOnPage(WebDriver driver, String testcasename) throws UIActionsException ;

	public void clickOnLocationHeader(WebDriver driver, String testcasename) throws UIActionsException;
}
