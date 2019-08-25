package com.automate.automation.commonservices;

import com.automate.framework.excelutilities.ExcelUtility;

public class CommonServices {

	public static String getTestData(String key) {
		return ExcelUtility.testDataMap.get(key);
	}
}
