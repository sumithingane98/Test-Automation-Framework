package com.ui.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.utility.BrowserUtility;

public class LoginTestOLD {

	public static void main(String[] args) {

		WebDriver wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl/index.php");
		browserUtility.maximizeWindow();

		By signInLocator = By.xpath("//a[contains(text(),\"Sign\")]");
		browserUtility.clickOn(signInLocator);

		By emailAddressLocator = By.id("email");
		browserUtility.enterText(emailAddressLocator, "kehimah833@etramay.com");

		By passwordLocator = By.id("passwd");
		browserUtility.enterText(passwordLocator, "password");

		By logInLocator = By.id("SubmitLogin");
		browserUtility.clickOn(logInLocator);

		System.out.println(wd.getTitle());

	}
}
