package com.amajon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amajon.testcases.BaseClass;

public class AnniversaryGiftCardPage extends BaseClass {
	WebDriver ldriver;

	public AnniversaryGiftCardPage(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@class='a-link-normal']/span")
	List<WebElement> giftCardType;

	@FindBy(css = ".s-image")
	List<WebElement> randomCardSelect;

	public void selectRandomCard() {
		for (WebElement ele3 : randomCardSelect) {
			ele3.click();
			break;
		}

	}

	public void selectAnniversaryType() {
		try {
			for (WebElement ele3 : giftCardType) {
				String crdType = ele3.getText();
				if (crdType.equalsIgnoreCase("Anniversary")) {
					ele3.click();
					selectRandomCard();
				}
			}
		} catch (Exception e) {
			for (WebElement ele3 : giftCardType) {
				String crdType = ele3.getText();
				if (crdType.equalsIgnoreCase("Anniversary")) {
					ele3.click();
					selectRandomCard();
				}
				;
			}
		}

	}
}
