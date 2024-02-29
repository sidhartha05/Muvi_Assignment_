package com.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest extends Excelllibrary implements AutoConstant{
	
	public static WebDriver driver;
	public Properties prop;
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
			driver.get(prop.getProperty("url"));
		
		
	}
	
	@AfterClass
	public void teardown()
	{
	driver.close();
	}
}