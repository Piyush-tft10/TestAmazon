package com.amajon.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amajon.testcases.BaseClass;

public class ProductResult extends BaseClass {
	WebDriver ldriver;

	public ProductResult(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(css = ".s-image")
	List<WebElement> allItems;

	public void clickOnItem() {
		allItems.get(0).click();
		switchWindow();
		scrollPage(250);
	}
}
