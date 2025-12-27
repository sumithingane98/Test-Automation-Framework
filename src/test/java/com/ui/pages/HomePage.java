package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.ui.pojo.Environment;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

import static com.utility.JSONUtlity.*;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName, boolean isHeadless) {	// calls public BrowserUtility(Browser browserName, boolean isHeadless)
//	public HomePage(Browser browserName) {  // calls public BrowserUtility(Browser browserName)
//	public HomePage(String browserName) {	// calls public BrowserUtility(String browserName)
		super(browserName, isHeadless);
//		goToWebsite(readProperty(QA, "URL"));
		goToWebsite(readJSON(QA).getUrl());
		maximizeWindow();
	}
	
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(readJSON(QA).getUrl());
	}

	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to Sign in page...");
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;

	}
}
