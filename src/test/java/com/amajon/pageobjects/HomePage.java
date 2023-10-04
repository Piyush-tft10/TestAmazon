package com.amajon.pageobjects;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amajon.testcases.BaseClass;

public class HomePage extends BaseClass {
	WebDriver ldriver;

	public HomePage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = ".a-icon-previous-rounded")
	WebElement previouButton;

	@FindBy(xpath = "//ol[@class='a-carousel']")
	WebElement item;

	// @FindBy(css = "#itembox-Partner .vsx-offers-count")
	// WebElement allOffers;

	// @FindBy(xpath = "(//div[@class='a-carousel-col a-carousel-right']/a)[1]")
	// WebElement showAllButton;

	@FindBy(css = "#nav-search-dropdown-card")
	WebElement category;

	@FindBy(css = "#nav-search-dropdown-card div select option")
	List<WebElement> selectGiftCard;

	@FindBy(css = "#nav-search-submit-button")
	WebElement hitSearch;

	public void giftCardCategory() {
		category.click();
		for (WebElement ele2 : selectGiftCard) {
			String catGift = ele2.getText();
			if (catGift.equalsIgnoreCase("Gift Cards")) {
				ele2.click();
			}
		}
		hitSearch.click();
		scrollPage(250);
	}

	public void goToItem() {
		waitForElementToAppear(previouButton, 5);
		previouButton.click();
		waitForElementToAppear(item, 5);
		item.click();
	}

}
