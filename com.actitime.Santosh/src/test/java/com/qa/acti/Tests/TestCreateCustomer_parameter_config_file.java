package com.qa.acti.Tests;

import org.testng.annotations.Test;

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
	
		lpObj.loginToApplication(prop.getProperty("username"),prop.getProperty("password"));
		etpObj.clickTaskMenu();
		tlpObj.clickAddNewCustomer();
		tlpObj.clickAddNewCustItem();
		tlpObj.enterCustomerName("Testryerydhf675");
		tlpObj.enterCustomerDescription("Test Descciprtion 02746586");
		tlpObj.clickCreateCustomerButton();
		Thread.sleep(3000);
		etpObj.clickLogout();
		
		
		
		
	}
	

}
