package com.automate.automation.objectCreation;

import com.automate.automation.bo.Item;
import com.automate.automation.commonservices.CommonServices;
import com.automate.automation.constants.TestDataConstant;


public class ObjectCreation {

	public static Item defaultObjectOfItem() {

		Item item = new Item();
		item.setDeliveryLocation(CommonServices.getTestData(TestDataConstant.DELIVERY_LOCATION1));
		item.setItemName(CommonServices.getTestData(TestDataConstant.ITEM_NAME));
		item.setDifferentVerietyOfItem(CommonServices.getTestData(TestDataConstant.DIFFERENT_VERIETY_OF_ITEM));
		item.setItemBase(CommonServices.getTestData(TestDataConstant.ITEM_BASE));
		return item;

	}

}
