package com.qa.acti.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.ReportsPage;
import com.qa.actitime.Pages.TaskListPage;
import com.qa.actitime.Pages.UsersListPage;

public class TestUsersListPage extends TestBase{

	
	@Test
	public void verifyUserListUI()
	{
//		LoginPage2 lpObj;
//		EnterTimePage etpObj;
//		TaskListPage tlpObj;
//		ReportsPage rpObj;
//		UsersListPage ulpObj;
//		
		lpObj.loginToApplication(prop.getProperty("username"),prop.getProperty("password"));
		String actualpageTitle=ulpObj.usersMenuClick();
		Assert.assertEquals(actualpageTitle, "List of Users");
		ulpObj.usersListTabsClick();
		etpObj.clickLogout();
		
	}
}
