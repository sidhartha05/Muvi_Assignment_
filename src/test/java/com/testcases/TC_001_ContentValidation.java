package com.testcases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generics.BaseTest;
import com.pageobjects.AddContent;
import com.pageobjects.DashBoardPage;
import com.pageobjects.LoginPage;
import com.sun.tools.sjavac.Log;

public class TC_001_ContentValidation extends BaseTest {

	@Test
	public void loginpageTest() throws InterruptedException {

		LoginPage login=new LoginPage(driver);

		String accurl = login.validateLoginPage();
		Assert.assertEquals(accurl, prop.getProperty("url"));
		logger.info("Login page validate succesfully");
		login.enterEmail(prop.getProperty("emailid"));
		login.enterPassword(prop.getProperty("password"));
		logger.info("email id and password entered");
		login.clickOnLogin();
		logger.info("click on login button");
	}
	@Test(dependsOnMethods = "loginpageTest")
	public void clickOnContentMangementTest() {

		DashBoardPage dash=new DashBoardPage(driver);

		boolean validation = dash.validateAccount();

		Assert.assertTrue(validation, "Account validated Succesfully");

		logger.info("Account succesfully validated");


		dash.clickOnContentmangeBtn();

		logger.info("clicked on contentmanagement button");
		dash.clickOnContentLibrary();
		logger.info("clicked on contentlibrary button");
		dash.clickOnAddContent();
		logger.info("clicked on add content button");
	}


	@Test(dataProvider = "logindata", dependsOnMethods ="clickOnContentMangementTest")
	public void addContentTest(String content,String permalink,String storydes, String searchtag) throws Throwable {
		AddContent add=new AddContent(driver);
		add.enterContentName(content);
		add.enterPermalinkName(permalink);
		add.chooseCategory();
		add.selectFromChooseCategory();
		add.enterStory(storydes);
		add.enterStoryTag(searchtag);
		add.clickOnAddFile();
		add.clickOnBrowseBtn();
		add.clickOnZendesk();
		add.clickOnSaveandPublishbtn();
		logger.info("Clicked on save and publish button");
		add.validateContentlist();
		logger.info("contentlist validated succesfully");
	}
}