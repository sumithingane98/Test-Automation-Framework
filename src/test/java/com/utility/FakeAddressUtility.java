package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	static AddressPOJO addressPOJO;

	public static AddressPOJO getFakeAddress() {
		Faker faker = new Faker(Locale.US);

		addressPOJO = new AddressPOJO(faker.company().name(), faker.address().buildingNumber(),
				faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
				faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
				"5");
		return addressPOJO;

	}

}
