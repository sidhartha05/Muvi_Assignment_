package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generics.BasePage;

public class ProductPage extends BasePage{

	public WebDriver driver;

	@FindBy(xpath = "//a[@href='https://www.muvi.com/one/signup']")
	private WebElement signup;

	public ProductPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnMuviFreeTrial() {

		waitVisibilityofElement(driver, signup);
		javascriptClick(driver, signup);

	}
}