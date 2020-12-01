package com.qa.acti.Tests;

import org.testng.annotations.Test;

import com.qa.actitime.Pages.EnterTimePage;
import com.qa.actitime.Pages.LoginPage2;
import com.qa.actitime.Pages.ReportsPage;
import com.qa.actitime.Pages.TaskListPage;

public class TestReportPage extends TestBase{
	
	
	@Test
	public void verifyGenerateHtmlReport()
	{
		
		lpObj.loginToApplication(prop.getProperty("username"), prop.getProperty("password"));
		etpObj.clickReportsMenu();
		rpObj.clickCreateNewReport();
		rpObj.clickConfigureReportparameters();
		rpObj.clickGenerateHtmlReport();
	}

}
