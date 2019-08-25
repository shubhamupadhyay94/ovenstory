package com.automate.automation.testcase.ovenstory;

import com.automate.automation.bo.Item;
import com.automate.automation.commonservices.CommonServices;
import com.automate.automation.constants.TestDataConstant;
import com.automate.automation.flow.additem.AddItem;
import com.automate.automation.objectCreation.ObjectCreation;
import com.automate.automation.pages.hoempage.PageOvenStory;
import com.automate.automation.users.Users;
import com.automate.framework.DriverManager;
import com.automate.framework.config.ConfigReader;
import com.automate.framework.excelutilities.ExcelUtility;
import com.automate.framework.iConstants.FrameworkConstant;
import com.automate.framework.reporting.TestListner;
import com.automate.framework.screenshot.FileUtility;
import com.automate.framework.uiaction.UIActions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListner.class)
class OvenStoryTestcase {

	static Logger logger = Logger.getLogger(OvenStoryTestcase.class);

	@BeforeSuite
	public void doCleanUpActivityandLoadConfigFile() {
		try {
			logger.info("Before suite method execution started. Loading required config files..");
			FileUtility.deleteDirectory(FrameworkConstant.OUTPUT_FOLDER);
			ConfigReader.loadConfig();
			Users.returnUserList();
			PropertyConfigurator.configure(FrameworkConstant.LOG4J_PATH);
			ExcelUtility.testData(ConfigReader.getConfig("sheetName"));
			logger.info("Before suite method execution ends. Config files are loaded.");
		} catch (Exception e) {
			logger.error("Error while config files" + e.getMessage(), e);

		}

	}

	@AfterSuite
	public void activityAfterSuite() {
		logger.info("Work in progress..");

	}

	@Test(enabled = true)
	public static void TestCase1() throws Exception {
		String testcasename = "TestCase1";
		WebDriver driver = null;
		try {
			driver = DriverManager.getDriver();
			Item item = ObjectCreation.defaultObjectOfItem();
			item = AddItem.addItemAndCheckout(driver, testcasename, item);
			Assert.assertTrue(item.isResult(), "TestCase1 execution failed.");

		} catch (Exception e) {

			logger.error("TestCase1 execution failed", e);
		} finally {
			UIActions.closeBrowser(driver, testcasename);
		}

	}

	@Test(enabled = true)
	public static void TestCase2() throws Exception {
		boolean status = false;
		String text = null;
		String testcasename = "TestCase2";
		WebDriver driver = null;
		try {
			driver = DriverManager.getDriver();
			PageOvenStory.exicitingOfferWindowPresent(driver, testcasename);
			PageOvenStory.enterDeliveryLocation(driver, testcasename,
					CommonServices.getTestData(TestDataConstant.DELIVERY_LOCATION1));
			PageOvenStory.clickOnMenu(driver, testcasename);
			status = PageOvenStory.isLocationHeaderDisplyaed(driver, testcasename);
			Assert.assertTrue(status, "Menu page is not displayed.");

			PageOvenStory.clickOnPartyOrder(driver, testcasename);
			status = PageOvenStory.isRequestACallBackLinkPresent(driver, testcasename);
			Assert.assertTrue(status, "Party order page is displayed.");

			PageOvenStory.clickOnTerms(driver, testcasename);
			text = PageOvenStory.getHeaderText(driver, testcasename);
			status = text.contains(TestDataConstant.PAGE_OVEN_STORY_SERVICE_TERM);
			Assert.assertTrue(status, "Oven term page is displayed");

			PageOvenStory.clickOnPrivacy(driver, testcasename);
			PageOvenStory.noOfHeaderOnPage(driver, testcasename);
			text = PageOvenStory.getHeaderText(driver, testcasename);
			status = text.contains(TestDataConstant.PAGE_OVEN_STORY_PRIVACY);
			Assert.assertTrue(status, "Oven story privacy page is displayed");

		} catch (Exception e) {

			logger.error("TestCase2 execution failed", e);
		} finally {
			UIActions.closeBrowser(driver, testcasename);

		}

	}

	@Test(enabled = true)
	public static void TestCase3() throws Exception {
		boolean status = false;
		String testcasename = "TestCase3";
		String enterText, getEnteredText = null;
		WebDriver driver = null;
		try {
			driver = DriverManager.getDriver();
			enterText = CommonServices.getTestData(TestDataConstant.DELIVERY_LOCATION2);

			PageOvenStory.exicitingOfferWindowPresent(driver, testcasename);
			PageOvenStory.enterDeliveryLocation(driver, testcasename,
					CommonServices.getTestData(TestDataConstant.DELIVERY_LOCATION1));
			UIActions.waitForDefaultSleep();
			PageOvenStory.clickOnLocationHeader(driver, testcasename);
			PageOvenStory.enterDeliveryLocation(driver, testcasename, enterText);
			UIActions.highWait();
			getEnteredText = PageOvenStory.getLocationHeader(driver, testcasename);
			status = PageOvenStory.verifySelectedLocation(driver, testcasename, enterText, getEnteredText);
			Assert.assertTrue(status, "Location is not selecetd properly.");
		} catch (Exception e) {

			logger.error("TestCase3 execution failed", e);
		} finally {
			UIActions.closeBrowser(driver, testcasename);
		}

	}

}
