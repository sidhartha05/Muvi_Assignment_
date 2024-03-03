package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generics.BasePage;

public class LandingPage extends BasePage {

	public WebDriver driver;
	
	@FindBy(xpath = "//a[normalize-space()='free trial']")
	private WebElement freetrial;

	public LandingPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnFreeTrial() {

		waitVisibilityofElement(driver, freetrial);
		javascriptClick(driver, freetrial);
	}
	
	public String validateCurrenturl() {
		
		String url = driver.getCurrentUrl();
		return url;
	}
}