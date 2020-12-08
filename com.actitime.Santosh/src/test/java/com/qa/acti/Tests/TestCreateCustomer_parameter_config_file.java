package com.qa.acti.Tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.TaskListPage;

public class TestCreateCustomer_parameter_config_file extends TestBase{
	
	@Test
	public void testCreateNewCustomer() throws InterruptedException
	{
//		lpObj=new LoginPage2();
//		etpObj=new EnterTimePage();
//		tlpObj=new TaskListPage();
		
		logger=extent.createTest("Creating New Customer");
		lpObj.loginToApplication(prop.getProperty("username"),prop.getProperty("password"));
		logger.log(Status.PASS, "Logged into the application successfully");
		etpObj.clickTaskMenu();
		logger.log(Status.PASS, "Click on Task Menu");
		tlpObj.clickAddNewCustomer();
		logger.log(Status.PASS, "click on add new Customer link");
		tlpObj.clickAddNewCustItem();
		logger.log(Status.PASS, "click on add new Customer item link");
		tlpObj.enterCustomerName("Testuser"+rand.nextInt(583725462));
		logger.log(Status.PASS, "Entered the customer name");
		tlpObj.enterCustomerDescription("Test Desciprtion 02746586");
		logger.log(Status.PASS, "Entered customer description");
		tlpObj.clickCreateCustomerButton();
		logger.log(Status.PASS,"Clicked on the Create Customer submit form");
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ulpObj.getLogoutLnk())); //using the setters and getters method.
	//	Thread.sleep(3000);
		etpObj.clickLogout();
		logger.log(Status.PASS, "Clicked on Logout");
		
		
		
		
	}
	

}
