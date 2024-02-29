package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.generics.BasePage;

public class SignupPage extends BasePage {

	public WebDriver driver;

	@FindBy(xpath = "//input[@id='name']")
	private WebElement usernametextfield;

	@FindBy(xpath = "//input[@id='companyname']")
	private WebElement companynamefield;

	@FindBy(xpath = "//input[@placeholder='Phone Number']")
	private WebElement phnnofield;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailfield;

	@FindBy(xpath = "//input[@id='inputPassword']")
	private WebElement passwordfield;

	@FindBy(xpath = "//input[@id='subdomain']")
	private WebElement domainfield;
	
	@FindBy(xpath = "//label[contains(text(),'I agree to Muvi')]")
	private WebElement checkbox;
	
	@FindBy(xpath = "//button[@id='nextbtn']")
	private WebElement nextbtn;

	public SignupPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String username) {

		waitVisibilityofElement(driver, usernametextfield);
		usernametextfield.sendKeys(username);
	}
	public void enterComapnyName(String company) {
		waitVisibilityofElement(driver, companynamefield);
		companynamefield.sendKeys(company);
	}

	public void enterPhnno(String phnno) {
		waitVisibilityofElement(driver, phnnofield);
		phnnofield.sendKeys(phnno);
	}
	public void enterEmail(String email) {

		waitVisibilityofElement(driver, emailfield);
		emailfield.sendKeys(email);
	}

	public void enterPassword(String pwd) {

		waitVisibilityofElement(driver, passwordfield);
		passwordfield.sendKeys(pwd);

	}
	public void enterDomainName(String domainname) {
		waitVisibilityofElement(driver, domainfield);
		domainfield.sendKeys(domainname);
	}
	
	public void clickOnCheckBox() {
		waitVisibilityofElement(driver, checkbox);
		javascriptClick(driver, checkbox);
		
	}
	public void clickOnNext() {
		waitVisibilityofElement(driver, nextbtn);
		javascriptClick(driver, nextbtn);
		
	}

	
}