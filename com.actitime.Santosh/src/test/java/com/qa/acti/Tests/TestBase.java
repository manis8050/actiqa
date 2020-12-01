package com.qa.acti.Tests;

import java.util.Random;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.actitime.Base.DriverScript;
import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.ReportsPage;
import com.qa.actitime.Pages.TaskListPage;
import com.qa.actitime.Pages.UsersListPage;


public class TestBase extends DriverScript{
	
	LoginPage2 lpObj;
	EnterTimePage etpObj;
	TaskListPage tlpObj;
	ReportsPage rpObj;
	UsersListPage ulpObj;
	Random rand=new Random();
	public ExtentReports extent;
	public ExtentTest logger;
	
	public TestBase()
	{
		super(); //super keyword is used to call the base class constructor
	}
	
	
	@BeforeClass 
	public void reportSetup()
	{
		//ExtentReports repr1=new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir") +"\\acti.reports\\AutomationReport.html");
		//ExtentAventReporter htmlReport = new ExtentAventReporter("./acti.reports/AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		
		
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
	
	

	@AfterMethod()
	public void closeApp()
	
	{
		
		driver.quit();
		extent.flush();
		
	}
	@AfterClass
	public void reportteardown()
	{
		//extent.close();
		
		
	}

}
