package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {

	// to read json file
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {

		Gson gson = new Gson();
		String path = System.getProperty("user.dir") + "\\testData\\logindata.json";
		File testDataFile = new File(path);
		FileReader fileReader = new FileReader(testDataFile);
		TestData testData = gson.fromJson(fileReader, TestData.class);

		List<Object[]> dataToReturn = new ArrayList<>(); // created Object[], because dataprovider returns Object []
		for (User user : testData.getData()) {
			dataToReturn.add(new Object[] { user });
		}

		return dataToReturn.iterator();
	}

	// to read csv file
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}

	// to read csv file
	@DataProvider(name = "LoginTestExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("loginData.xlsx", "loginTestData");
	}

}
