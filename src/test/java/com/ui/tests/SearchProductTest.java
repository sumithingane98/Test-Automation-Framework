package com.ui.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners(com.ui.listeners.TestListener.class)

public class SearchProductTest extends TestBase {

	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM  = "Printed Summer Dress";

	@BeforeMethod(description = "Valid user logs into the application")
	public MyAccountPage setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("kehimah833@etramay.com", "password");
		return myAccountPage;
	}

	@Test(description = "Verify if the logged in user is able to search for a product and correct products search result are displayed", groups = {
			"e2e", "sanity", "smoke" })
	public void verifyProductSearchTest() {
//		myAccountPage.searchForProduct("Printed Summer Dress").getSearchResultTitle();
		boolean actualResult = myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
		assertEquals(actualResult, true);
	}

}
