package com.pageobjects;

import java.awt.AWTException;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.generics.BasePage;

public class AddContent extends BasePage {

	public WebDriver driver;


	@FindBy(xpath = "(//div[@class=\"uploadBox cursor my-2 col-4\"])[1]")
	private WebElement addfilebtn;

	@FindBy(xpath = "//div[text()='Browse, or Drag & drop your file here.']")
	private WebElement browsebtn;

	@FindBy(xpath = "//div[text()='Upload']")
	private WebElement uploadbtn;


	@FindBy(xpath = "//input[@placeholder='Content Name']")
	private WebElement contentname;

	@FindBy(xpath = "//input[@placeholder='Permalink Name']")
	private WebElement permalinktext;

	@FindBy(xpath = "//input[@id='categorySelect']")
	private WebElement category;

	@FindBy(xpath = "//div[text()='Video']")
	private WebElement categoruoption;

	@FindBy(xpath = "//textarea[@placeholder='Story / Description']")
	private WebElement storydescription;


	@FindBy(xpath = "//input[@placeholder='Add a tag']")
	private WebElement storytag;
	
	@FindBy(xpath = "(//div[text()='Add Media'])[1]")
	private WebElement addmedia;
	
	@FindBy(xpath = "//div[text()='Browse, or Drag & drop your file here.']")
	private WebElement browsemediafile;

	@FindBy(xpath = "//a[@id='banner-tab']")
	private WebElement bannertag;

	@FindBy(xpath = "//div[@class='col-8']//div[@class='uploadBox cursor my-1 h-80 p-1']")
	private WebElement websiteaddfile;


	@FindBy(xpath = "//div[text()='Browse, or Drag & drop your file here.']")
	private WebElement websitebrowsefile;


	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement saveandpublishbtn;

	@FindBy(xpath = "//iframe[@id='launcher']")
	private WebElement iframeid;


	@FindBy(xpath = "//button[@class='StyledButton-sc-qe3ace-0 minimizeButton-31FRu u-userLauncherColor StyledIconButton-sc-1t0ughp-0 stzzW']//*[name()='svg']")
	private WebElement minimizebtn;

	@FindBy(xpath = "//div[@class='d-flex']//span[@aria-hidden='true'][normalize-space()='×']")
	private WebElement canceluploadbtn;

	@FindBy(xpath = "//div[@class=\"row flex-nowrap gx-4 align-items-center\"]//a//strong")
	private List<WebElement> contentlist;

	@FindBy(xpath = "//div[text()='sidhartha']")
	private WebElement dropdown;

	@FindBy(xpath = "//div[contains(text(),'Logout')]")
	private WebElement logout;

	public AddContent(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterContentName(String content) throws InterruptedException {

		waitVisibilityofElement(driver, contentname);
		javascriptHighlightElement(driver, contentname);
		contentname.sendKeys(content);
	}

	public void enterPermalinkName(String permalink) throws InterruptedException {

		waitVisibilityofElement(driver, permalinktext);
		javascriptHighlightElement(driver, permalinktext);
		permalinktext.sendKeys(permalink);
	}

	public void chooseCategory() {
		waitVisibilityofElement(driver, category);
		javascriptClick(driver, category);
	}

	public void enterStory(String story) throws InterruptedException {
		waitVisibilityofElement(driver, storydescription);
		javascriptHighlightElement(driver, storydescription);
		storydescription.sendKeys(story);
	}

	public void enterStoryTag(String tag) throws InterruptedException {
		waitVisibilityofElement(driver, storytag);
		javascriptHighlightElement(driver, storytag);
		storytag.sendKeys(tag);

	}

	public void selectFromChooseCategory() {

		waitVisibilityofElement(driver, categoruoption);
		javascriptClick(driver, categoruoption);
	}

	public void clickOnAddFile() {

	
		javascriptClick(driver, addfilebtn);

	}

	public void clickOnBannerTag() {
		clickOnElement(driver, bannertag);


	}
	public void clickOnBrowseBtn() throws AWTException, InterruptedException {

		clickOnElement(driver, browsebtn);
		StringSelection ss=new StringSelection(System.getProperty("user.dir")+"\\files\\"+"pan.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robotEnter();
		clickOnElement(driver, uploadbtn);
		Thread.sleep(10000);
	}

	public void clickOnWebsiteAddfile() {

		clickOnElement(driver, websiteaddfile);
	}

	public void clickOnWebsiteBrowsefile() throws AWTException {

		clickOnElement(driver, websitebrowsefile);
		StringSelection ss=new StringSelection(System.getProperty("user.dir")+"\\files\\"+"pan.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		robotEnter();
		clickOnElement(driver, uploadbtn);
	}

	public void clickOnZendesk() throws InterruptedException {
		waitVisibilityofElement(driver, iframeid);
		driver.switchTo().frame(iframeid);
		clickOnElement(driver, minimizebtn);
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
	}

	public void clickOnUploadBtn() {
		clickOnElement(driver, canceluploadbtn);
	}

	public void clickOnSaveandPublishbtn() throws InterruptedException {
		scrollToElement(driver, saveandpublishbtn);
		javascriptClick(driver, saveandpublishbtn);
		Thread.sleep(10000);
	}
	
	public void validateContentlist() throws Throwable {
		waitVisibilityofAllElements(driver, contentlist);
		Thread.sleep(3000);
		for(int i=0;i<contentlist.size();i++)
		{
			if(contentlist.get(i).getText().equalsIgnoreCase("My 1st Content"))
			{
				javascriptClick(driver, dropdown);
				javascriptClick(driver, logout);
			}
		}
	}
}