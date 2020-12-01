package com.qa.acti.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.ReportsPage;
import com.qa.actitime.Pages.TaskListPage;

public class TestEnterTimePage extends TestBase{
	
	@Test
	public void verifyLogout()
	{
//		lpObj=new LoginPage2();
//		etpObj=new EnterTimePage();
//		tlpObj=new TaskListPage();

		lpObj.loginToApplication("admin", "manager");
		etpObj.clickLogout();
	}

	@Test
	public void verifyTaskMenuDisplayed()
	{
		lpObj.loginToApplication("admin", "manager");
		boolean taskMenuFlag=etpObj.verifyTaskMenuDisplayed();
		Assert.assertTrue(taskMenuFlag, "Task Menu icon is not displayed");
		etpObj.clickLogout();
	}
}
