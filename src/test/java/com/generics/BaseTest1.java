package com.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class BaseTest1 implements AutoConstant {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public Logger logger;
	
	@BeforeSuite
	public void suitLevelExecutionStarted() {
		
		Reporter.log("suite level execution started");
	}
	
	@BeforeTest
	public void testLevelExecutionStarted() {
		
		Reporter.log("testlevel execution");
	}
	

	@BeforeClass
	public void setup() {
		
		logger=LogManager.getLogger(this.getClass());
		try {
		prop=new Properties();
		FileInputStream file=new FileInputStream(property_path);
		prop.load(file);
		} 
		catch (IOException e) {
	
			e.printStackTrace();
		}
		
		
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url1"));
		
		
	}
	
	@AfterClass
	public void teardown()
	{
	
	}
	public static String randomString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomNumber() {

		String generatednumber = RandomStringUtils.randomNumeric(10);
		return generatednumber;
	}

	public String randomAlphanumeric() {

		String str = RandomStringUtils.randomAlphabetic(4);
		String num=RandomStringUtils.randomNumeric(4);
		return(str+"@"+ num);
	}
	
}


