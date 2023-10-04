package com.amajon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amajon.testcases.BaseClass;

public class ProductDetail extends BaseClass {
	WebDriver ldriver;

	public ProductDetail(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//div[@id='Partner-sideSheet']/div/div[3]/span")
	WebElement multOffers;

	@FindBy(css = ".a-cardui-body .a-carousel-card h6")
	List<WebElement> singleOffer;

	@FindBy(linkText = "www.amazon.in/register_business")
	WebElement registerBussiness;

	@FindBy(xpath = "(//span[contains(@id,'A1DQZ9WTSYBF1F')])[1]")
	WebElement promotionText;


	public void getOffer() {
		for (WebElement ele : singleOffer) {
			String offerType = ele.getText();
			if (offerType.equalsIgnoreCase("Partner Offers")) {
				ele.click();
			} else 
				;
		}
		try {
		String promotion = promotionText.getText();
		if (promotion.equalsIgnoreCase("Promotion Terms")) {
			clickRegisterBussiness();
		} 
		}
		catch(Exception e) {
			multOffers.click();
			clickRegisterBussiness();
		};

	}

	public void clickRegisterBussiness() {
		registerBussiness.click();
	}
}
