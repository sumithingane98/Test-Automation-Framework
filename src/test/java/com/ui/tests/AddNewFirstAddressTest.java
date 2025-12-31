package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners(com.ui.listeners.TestListener.class)

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO addressPOJO;
	private FakeAddressUtility fakeAddressUtility;

	@BeforeMethod(description = "Valid First Time user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("kehimah833@etramay.com", "password");
//		addressPOJO = new AddressPOJO("Infosys", "address line 1", "address line 2", "city", "23456", "1234567890",
//				"1234567890", "other", "office address", "5");
		addressPOJO = fakeAddressUtility.getFakeAddress();
	}

	@Test
	public void addNewAddress() {
//		myAccountPage.goToAddAddressPage().saveAddress();
//		myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
		String newAddress = myAccountPage.goToAddAddressPage().saveAddress(addressPOJO);
		Assert.assertEquals(newAddress, addressPOJO.getAddressAlias().toUpperCase());
	}

}
