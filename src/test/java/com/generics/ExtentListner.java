package com.generics;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListner implements ITestListener {
	
	ExtentSparkReporter htmlreporter;
	ExtentReports reports;
	ExtentTest test;
	
	
	
	public void configureReport() {
		
		String timestamp=new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportname="Muvi report"+timestamp+".html";
		
		htmlreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+reportname);
		reports=new ExtentReports();
		reports.attachReporter(htmlreporter);
		
		reports.setSystemInfo("user_name", "sidhartha");
		reports.setSystemInfo("Os", "Windows 10");
		reports.setSystemInfo("browser", "chrome");
		
		htmlreporter.config().setDocumentTitle("Extent report demo");
		htmlreporter.config().setReportName("This is my first report");
		htmlreporter.config().setTheme(Theme.DARK);
	}
	
	public void onStart(ITestContext result) {
		
		configureReport();
		System.out.println("on start method invoked");
	}
	public void onFinish(ITestContext context) {
		System.out.println("on finish method invoked");
	    reports.flush();
	  }
	public  void onTestFailure(ITestResult result) {
		
		System.out.println("Name of the failed method "+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed method is : "+ result.getName(), ExtentColor.RED));
		
		String screenshot_path= System.getProperty("user.dir")+"\\Screenshots\\"+result.getName()+".png";
		File screenshotfile=new File(screenshot_path);
		if(screenshotfile.exists()) {
		test.addScreenCaptureFromPath(screenshot_path);
		}
	     
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("Name of the passed method "+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed method is : "+ result.getName(), ExtentColor.GREEN));
	  }
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Name of the Skipped method "+ result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skipped method is : "+ result.getName(), ExtentColor.YELLOW));
	    
	  }
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    
	  }
	
	public void onTestStart(ITestResult result) {
	    System.out.println("Name of the test method started : "+result.getName());
	  }

	

}
