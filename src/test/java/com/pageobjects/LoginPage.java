package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v117.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generics.BasePage;

public class LoginPage extends BasePage{
	
	public WebDriver driver;
	@FindBy(xpath = "//input[@placeholder='Email address']")
	private WebElement emailtext;
	
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement passwordtxt;
	
	
	@FindBy(xpath = "//span[@id='login-hide']")
	private WebElement loginbtn;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) throws InterruptedException {
		
		waitVisibilityofElement(driver, emailtext);
		javascriptHighlightElement(driver, emailtext);
		emailtext.sendKeys(email);
		
	}
	
	public void enterPassword(String pwd) throws InterruptedException {
		
		waitVisibilityofElement(driver, passwordtxt);
		javascriptHighlightElement(driver, passwordtxt);
		passwordtxt.sendKeys(pwd);
	}
	
	public void clickOnLogin() {
		
		waitVisibilityofElement(driver, loginbtn);
		javascriptClick(driver, loginbtn);
	}
	public String validateLoginPage() {
		
		String url = driver.getCurrentUrl();
		return url;
		
		
	}
	

}
