package com.generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Screenshot extends BaseTest implements ITestListener {
	
	public  void onTestFailure(ITestResult result) 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		Date date=Calendar.getInstance().getTime();
		String today=date.toString().replaceAll(":", "_");
		String screenshot_path= System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File destFile=new File(screenshot_path);

		try 
		{
			FileHandler.copy(srcFile, destFile);
		} 
		catch (IOException e) 
		{
		}
		
		
	}

}
