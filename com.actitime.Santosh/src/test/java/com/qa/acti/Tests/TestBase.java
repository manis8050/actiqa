package com.qa.acti.Tests;

import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.actitime.Base.DriverScript;
import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.ReportsPage;
import com.qa.actitime.Pages.TaskListPage;
import com.qa.actitime.Pages.UsersListPage;
import com.qa.actitime.Utility.Utility;


public class TestBase extends DriverScript{
	
	LoginPage2 lpObj;
	EnterTimePage etpObj;
	TaskListPage tlpObj;
	ReportsPage rpObj;
	UsersListPage ulpObj;
	Random rand=new Random();
	public ExtentReports extent;
	public ExtentTest logger;
	ExtentHtmlReporter htmlReport;
	WebDriverWait wait;
	
	public TestBase()
	{
		super(); //super keyword is used to call the base class constructor
	}
	
	
	@BeforeClass  //(@BeforeSuite
	public void reportSetup()
	{
	
		htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\acti.reports\\AutomationReport.html");
		//ExtentAventReporter htmlReport = new ExtentAventReporter("./acti.reports/AutomationReport.html");
		extent = new ExtentReports(); //using this object we attach the report
		extent.attachReporter(htmlReport);
		extent.setSystemInfo("OS", "Windows10");  //Key value pair
		htmlReport.config().setDocumentTitle("Automation Report");
		htmlReport.config().setReportName("ActiTime Automation Report");
		// htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setTheme(Theme.STANDARD);
		
	}
	@BeforeMethod
	public void preTest()
	{
		initialization();
		lpObj=new LoginPage2();
		etpObj=new EnterTimePage();
		tlpObj=new TaskListPage();
		rpObj = new ReportsPage();
		ulpObj=new UsersListPage();
	
	}
	
	@AfterMethod
	
		public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			  String screenName=result.getName();
			//System.out.println("screenName is:" +screenName);
			//String screenShotPath=Utility.takeScreenShot(driver,screenName);
			  String screenShotPath=Utility.captureScreenShot(driver, screenName);
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			logger.fail(result.getThrowable());
			try {
				logger.fail("Snapshot below: " +logger.addScreenCaptureFromPath(screenShotPath));
				//logger.addScreenCaptureFromPath(screenShotPath);
				//logger.add
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Passed", ExtentColor.GREEN));
		}
		
		else if(result.getStatus()==ITestResult.SKIP)
		{
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Skipped", ExtentColor.YELLOW));
		}
		extent.flush();
		driver.quit();
	}

	/*@AfterClass()
	public void closeApp()
	
	{
		
		driver.quit();
	
		
	}*/
//	@AfterClass
//	public void reportteardown()
//	{
//		//extent.close();
//		
//		
//	}

}
