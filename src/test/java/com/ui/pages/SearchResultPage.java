package com.ui.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");
	private static final By ALL_PRODUCT_LIST_NAME_LOCATOR = By.xpath("//h5[@itemprop=\"name\"]/a");
	
	private static final By MORE_BUTTON_LOCATOR = By.xpath("(//div[@class=\"button-container\"]//a/span[text()='More'])[1]");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LIST_NAME_LOCATOR);
		
		boolean result = productNamesList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
		
	}
	
	public ProductDetailPage clickOnTheProductAtIndex(int index) {
		clickOn(getAllElements(ALL_PRODUCT_LIST_NAME_LOCATOR).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}

}
