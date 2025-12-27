package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {
	
	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;	
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "Load the Homepage of the Website...")
	public void setup(
			@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("true") boolean isHeadless, 
			ITestResult result
			) {
		
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;

		if(isLambdaTest) {
			logger.info("Load the Homepage of the Website using Lambda...");
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);
			
		}else {
			logger.info("Load the Homepage of the Website on Local...");
//			homePage = new HomePage("chrome");	// Passed value as String to HomePage constructor
//			homePage = new HomePage(CHROME);	// Passed value as ENUM to HomePage constructor
//			homePage = new HomePage(CHROME, isHeadless);	// Passed value as ENUM to HomePage constructor
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);// Passed value using ENUM from Parameter to HomePage constructor
		}
		
	}
	
	// BrowserUtility is parent of HomePage
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description = "Tear Down the Browser")
	public void tearDown() {
		logger.info("Tear Down the Browser...!!!");
		
		if(isLambdaTest) {
			LambdaTestUtility.quitSession(); // quit or close the broswer session on cloud
		}else {
			homePage.quit();		// on local
		}
	}

}
