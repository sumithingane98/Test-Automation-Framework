package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> readExcelFile(String fileName, String sheetName) {

		String path = System.getProperty("user.dir") + "\\testData\\" + fileName;
		File file = new File(path);
		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet;
		List<User> userList = null;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		Iterator<Row> rowIterator;
		try {
			xssfWorkbook = new XSSFWorkbook(file);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			rowIterator = xssfSheet.iterator();
			rowIterator.next(); // skips header 1st line
			userList = new ArrayList<>();
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}

		try {
			xssfWorkbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
