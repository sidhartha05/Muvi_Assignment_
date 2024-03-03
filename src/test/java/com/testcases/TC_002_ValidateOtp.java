package com.testcases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generics.BaseTest1;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.Code;
import com.mailosaur.models.Message;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;
import com.pageobjects.LandingPage;
import com.pageobjects.ProductPage;
import com.pageobjects.SignupPage;

public class TC_002_ValidateOtp extends BaseTest1 {
	
	String serverDomain ="uplhmp7g.mailosaur.net";
	String apikey="4YA7R8bV4q5vXmQPft0p8xpTMXGqmOR6";
    String serverId="uplhmp7g";
    public String getRandommail(){
		
		return "muviaesidhartha05"+System.currentTimeMillis()+"@"+serverDomain;
	}

	@Test
	public void validateOtp() throws IOException, MailosaurException, InterruptedException{
		
		String emailid=getRandommail();

		LandingPage land=new LandingPage(driver);
		String actualurl = land.validateCurrenturl();
		Assert.assertEquals(actualurl, prop.getProperty("url1"));
		logger.info("Landing page url validated successfully");
		land.clickOnFreeTrial();
		logger.info("Clicked on Landing page Free Trial Successfully");
		ProductPage prod=new ProductPage(driver);
		String produrl = prod.validateProductpageurl();
		Assert.assertEquals(produrl, prop.getProperty("produrl"));
		logger.info("Product page url validated successfully");
		prod.clickOnMuviFreeTrial();
		logger.info("Clicked on product page Free Trail successfully");
		SignupPage page=new SignupPage(driver);
		String actualtitle = page.validateSignupTitle();
		
		Assert.assertEquals(actualtitle, prop.getProperty("title"));
		logger.info("Signup page Title validated successfully");
		page.enterUserName(prop.getProperty("signupname"));
		page.enterComapnyName(prop.getProperty("comapnyname"));
		page.enterPhnno(prop.getProperty("phnno"));
		page.enterEmail(emailid); 
		page.enterPassword(prop.getProperty("password1"));
		page.enterDomainName(prop.getProperty("domainname"));
		page.clickOnCheckBox();
		page.clickOnNext();
		
		logger.info("Entered all the details in Signup page successfully");
		

		MailosaurClient mailosaur=new MailosaurClient(apikey);
		MessageSearchParams params=new MessageSearchParams();
		params.withServer(serverId);
		  



		

		SearchCriteria criteria=new SearchCriteria();
		criteria.withSentTo(emailid);
		criteria.withSentFrom(prop.getProperty("from"));

		Message message = mailosaur.messages().get(params, criteria);
		
		System.out.println(message.html().codes().size());
		
		
		
		Code firstCode = message.html().codes().get(0);

		String otp = firstCode.value();
		page.enterOtp(otp);
		logger.info("Entered OTP Successfully");
		page.clickOnvalidateotp();
		logger.info("OTP validated successfully");
	}
}