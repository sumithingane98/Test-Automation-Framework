package com.ui.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public final class LoginPage extends BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	public MyAccountPage doLoginWith(String emailAddress, String password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCATOR, password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
		
	}

}
