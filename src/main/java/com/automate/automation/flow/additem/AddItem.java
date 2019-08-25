package com.automate.automation.flow.additem;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.automate.automation.bo.Item;

import com.automate.automation.pages.hoempage.PageOvenStory;


public class AddItem {
	static Logger logger = Logger.getLogger(AddItem.class);

	public static Item addItemAndCheckout(WebDriver driver, String testcasename, Item item) throws Exception {

		logger.info("addItemAndCheckout floe execution started.");
		try {
			String location;
			boolean selectedLocation, itemFromVerietySelected;

			// handle offer window
			PageOvenStory.exicitingOfferWindowPresent(driver, testcasename);
			if (item.getDeliveryLocation() != null) {

				item.setDeliveryLocation(
						PageOvenStory.enterDeliveryLocation(driver, testcasename, item.getDeliveryLocation()));
				location = PageOvenStory.getLocationHeader(driver, testcasename);
				selectedLocation = PageOvenStory.verifySelectedLocation(driver, testcasename,
						item.getDeliveryLocation(), location);
				item.setRightLocationSelected(selectedLocation);
			}
			if (item.getItemName() != null) {
				PageOvenStory.clickOnAddItem(driver, testcasename, item.getItemName());
				if (PageOvenStory.isCustomizableWindowOpen(driver, testcasename)) {

					if (item.getDifferentVerietyOfItem() != null) {
						itemFromVerietySelected = PageOvenStory.selectAnyItemFromDifferentVeriety(driver, testcasename,
								item.getDifferentVerietyOfItem());
						if (itemFromVerietySelected) {
							PageOvenStory.clickOnNext(driver, testcasename);
						} else {
							throw new Exception("Item from different veriety not selected.");
						}

					} else {
						PageOvenStory.clickOnNext(driver, testcasename);
					}

					if (item.getItemBase() != null) {
						itemFromVerietySelected = PageOvenStory.selectAnyBase(driver, testcasename, item.getItemBase());
						if (itemFromVerietySelected) {
							PageOvenStory.clickOnNext(driver, testcasename);

						} else {
							throw new Exception("Item from different base is not selected.");
						}
					} else {
						PageOvenStory.clickOnNext(driver, testcasename);
					}
				}

			}
			PageOvenStory.clickOnCheckout(driver, testcasename);
			item.setResult(true);
			logger.info("addItemAndCheckout flow executed sucessfully.");

		} catch (Exception e) {
			item.setResult(false);
			logger.error("Error while executing addItemAndCheckout flow");
			throw e;
		}
		return item;
	}
}
