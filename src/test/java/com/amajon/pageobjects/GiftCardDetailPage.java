package com.amajon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amajon.testcases.BaseClass;

public class GiftCardDetailPage extends BaseClass {
	WebDriver ldriver;

	public GiftCardDetailPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = "#gc-detail-design-more-link")
	WebElement moreDesign;

	@FindBy(css = "#gc-filter-occasion li")
	List<WebElement> diwaliDesign;

	@FindBy(xpath = "//img[@alt='Gift Card Design']")
	List<WebElement> clickSecondCard;

	@FindBy(css = "#gc-picker-use-this-design")
	WebElement useThisCard;

	@FindBy(xpath = "//button[@id='gc-mini-picker-amount-1' and @value='500']")
	WebElement selectAmount;

	@FindBy(css = "#gc-delivery-mechanism-button-Email")
	WebElement selectEmail;

	@FindBy(xpath = "//div[@id='gc-recipient-field']/span/textarea")
	WebElement recipientEmail;

	@FindBy(css = "#gc-order-form-senderName")
	WebElement senderEmail;

	@FindBy(xpath = "//div[@id='gc-buy-box-atc-button']")
	WebElement addToCart;

	public void selectDiwaliCard() {
		switchWindow();
		moreDesign.click();
		for (WebElement ele2 : diwaliDesign) {
			String diwCard = ele2.getText();
			if (diwCard.equalsIgnoreCase("Diwali")) {
				ele2.click();

			}

		}
		clickOnSecondCard();
	}

	public void clickOnSecondCard() {
		clickSecondCard.get(1).click();
		scrollPage(250);
		useThisCard.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viaEmail() {
		selectAmount.click();
		selectEmail.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		recipientEmail.sendKeys("abc@yopmail.com");
		senderEmail.sendKeys("send@yopmail.com");
	}

	public void addToCart() {
		scrollPage(-250);
		addToCart.click();

	}
}
