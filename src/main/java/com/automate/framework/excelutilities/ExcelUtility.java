package com.automate.framework.excelutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.binary.XSSFBRecordType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.automate.automation.bo.User;
import com.automate.framework.config.ConfigReader;
import com.automate.framework.exception.ExcelUtilityException;

public class ExcelUtility {

	static Logger LOGGER = Logger.getLogger(ExcelUtility.class);

	static String usernamePath = "input\\username.xls";
	static String testDataPath = "input\\testdata.xlsx";
	public static HashMap<String, String> testDataMap = new HashMap<String, String>();

	static {
		PropertyConfigurator.configure(ConfigReader.log4jPath);
		usernamePath = System.getProperty("user.dir") + "\\" + usernamePath;
		testDataPath = System.getProperty("user.dir") + "\\" + testDataPath;
	}

	public static void main(String args[]) throws InvalidFormatException {
		try {
			LOGGER.info(System.getenv() + " getprop" + System.getProperty("user.dir"));
			// readExcel();
			testData("Linkedin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	public static List<User> readExcel() throws IOException {
		HSSFWorkbook workbook = null;
		List<User> users = new ArrayList<User>();

		try {
			File file = new File(usernamePath);
			workbook = new HSSFWorkbook(new FileInputStream(file));
			HSSFSheet sheet = workbook.getSheetAt(0);
			int rows = sheet.getPhysicalNumberOfRows();

			if (rows < 2) {
				throw new ExcelUtilityException("No user record found in sheet.");

			} else {
				for (int i = 1; i < rows; i++) {
					Row getRow = sheet.getRow(i);
					if (getRow != null) {
						Cell username = getRow.getCell(0);
						Cell password = getRow.getCell(1);
						Cell role = getRow.getCell(2);
						Cell displayName = getRow.getCell(3);

						User user = new User();
						if (username != null) {
							user.setUsername(username.getStringCellValue());

						}
						if (password != null) {
							user.setPassword(password.getStringCellValue());
						}
						if (role != null) {
							user.setRoleType(role.getStringCellValue());
						}
						if (displayName != null) {
							user.setDisplayName(displayName.getStringCellValue());
						}
						LOGGER.info(user.getUsername() + "" + user.getPassword());
						users.add(user);
					}

				}
			}

		} catch (FileNotFoundException e) {
			LOGGER.error("File not found . Invalid Path" + usernamePath + e);

		} catch (Exception ex) {
			LOGGER.error("Error while reading excel file" + usernamePath + ex);

		} finally {
			workbook.close();
		}
		return users;
	}

	public static HashMap<String, String> testData(String sheetName) throws IOException {

		XSSFWorkbook workbook = null;
		try {
			File file = new File(testDataPath);
			workbook = new XSSFWorkbook(file);
			Sheet sheetList = workbook.getSheet(sheetName);
			Iterator<Row> rows = sheetList.rowIterator();
			while (rows.hasNext()) {
				Row cellRow = rows.next();
				Iterator<Cell> cells = cellRow.cellIterator();
				int i = 0;
				String cellValue0 = "", cellValue1 = "";
				while (cells.hasNext()) {

					Cell cell = cells.next();
					if (i == 0) {
						cellValue0 = cell.toString();

					}
					if (i == 1) {
						cellValue1 = cell.toString();
					}

					i++;
				}
				if (cellValue0 != null) {
					cellValue0.trim();
				}
				if (cellValue1 != null) {
					cellValue0.trim();
				}
				testDataMap.put(cellValue0, cellValue1);
				LOGGER.info(cellValue0 + " " + cellValue1);

			}

		} catch (FileNotFoundException e) {
			LOGGER.error("File not found . Invalid Path" + testDataPath + e);

		} catch (Exception ex) {

			LOGGER.error("Error while reading excel file" + testDataPath + ex);

		} finally {
			workbook.close();
		}
		return testDataMap;
	}
}
