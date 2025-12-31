package com.ui.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTests extends TestBase {

	private MyAccountPage myAccountPage;
	private SearchResultPage searchResultPage;
	private ProductDetailPage productDetailPage;
	private static final String SEARCH_TERM = "Printed Chiffon Dress";

	@BeforeMethod(description = "Valid user logs into the application & searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("kehimah833@etramay.com", "password").searchForProduct(SEARCH_TERM);
	}

	
	@Test(description = "Verify if the logged in user is able to buy a dress", groups = { "e2e", "smoke",
	"sanity" })
	public void checkoutTest(){
		
//		searchResultPage.clickOnTheProductAt(0).changeSize(Size.L);
		String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize().addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePaymentByWire();
//		System.out.println(result);
//		assertEquals(result, "Your order on My Shop is complete.");
		Assert.assertTrue(result.contains("complete"));
	}
}
