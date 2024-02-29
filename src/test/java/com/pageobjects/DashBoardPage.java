package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generics.BasePage;

public class DashBoardPage extends BasePage{
	public WebDriver driver;
	
	@FindBy(xpath = "//div[contains(text(),'Content Management')]")
	private WebElement contentmanagebtn;
	
	@FindBy(xpath = "//a[normalize-space()='Content Library']")
	private WebElement contentlibrary;
	
	@FindBy(xpath = "//div[@class='muBtn _blue icon-before']")
	private WebElement addcontbtn;
	
	
	@FindBy(xpath = "//h1[contains(.,'sidhartha!')]")
	private WebElement accountname;
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickOnContentmangeBtn() {
		
		waitVisibilityofElement(driver, contentmanagebtn);
		javascriptClick(driver, contentmanagebtn);
		
		
	}
	
	public void clickOnContentLibrary() {
		
		waitVisibilityofElement(driver, contentlibrary);
		javascriptClick(driver, contentlibrary);
	}
	
	public void clickOnAddContent() {
		waitVisibilityofElement(driver, addcontbtn);
		javascriptClick(driver, addcontbtn);
	}
	
	public boolean validateAccount() {
		waitVisibilityofElement(driver, accountname);
		boolean accval = accountname.isDisplayed();
		return accval;
	}

}
