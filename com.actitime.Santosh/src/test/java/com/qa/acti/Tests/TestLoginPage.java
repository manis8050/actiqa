package com.qa.acti.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestLoginPage extends TestBase {
	
	
	
	@Test
	public void testVerifyTitle()
	{
		logger=extent.createTest("Validate Title");
		logger.log(Status.INFO, "Browser Launched");
		logger.log(Status.INFO, "Navigated to the URL");
		String expectedTitle="actiTIME - Login";
		String aTitle=lpObj.verifyPageTitle();
		System.out.println(aTitle);
		Assert.assertEquals(aTitle, expectedTitle);
		logger.log(Status.PASS, "Verified the Title successfully");
		logger.log(Status.INFO, "Browser Closed");
	}

	@Test(priority=2)
	public void testVerifyActilogo()
	{
		logger=extent.createTest("Validate Login page Logo");
		Assert.assertTrue(lpObj.verifyActiLogoDisplayed());
		logger.log(Status.INFO, "Verified the Logo successfully");
	}
	/*		
	@Test(priority=3)
	public void testLoginFlow(String username,String password)
	{
		lpObj.loginToApplication(username,password);
		etpObj.logoutLnk();
	
	}
	
	@Test(priority=4)
	public void testLoginPageUIElements()
	{
		boolean flag=lpObj.verifyKeepMeLoggedCheckbox();
		System.out.println("flag is:" +flag);
		Assert.assertTrue(flag,"Checkbox is not enabled");
		String actualLoginPageFooter=lpObj.verifyLoginPageFooter();
		String expectedLoginPageFooter="actiTIME 2020 Online";
		Assert.assertEquals(actualLoginPageFooter, expectedLoginPageFooter, "Footer information is not matching");
		Assert.assertTrue(lpObj.verifyLoginWndwcredentialsTooltip(),"Login Window tooltip is not present");	
		
		String actualLoginWndwHdr=lpObj.loginWndwHdr();
		String expectedLoginWndwHdr="Please identify yourself";
		Assert.assertEquals(actualLoginWndwHdr, expectedLoginWndwHdr,"Login window header is not matching");
		
	}
	/*
	@Test(priority=5)
	public void testForgotPasswordFlowEmail()
	{
		boolean actualFlag=lpObj.verifyForgotPasswordFlowEmail("Test123@gmail.com");
		Assert.assertTrue(actualFlag,"Forgot Password validation message is incorrect for email flow");
		
	}
	
	@Test(priority=6)
	public void testForgotPasswordFlowUsername()
	{
		boolean actualFlag=lpObj.verifyForgotPasswordFlowUsername("tester123");
		Assert.assertTrue(actualFlag,"Forgot Password validation message is incorrect for username flow");
	}
	
	
	
	
	@Test(priority=7)
	public void testCopyRightFlow()
	{
		String actualChildWndwTitle=lpObj.verifyCopyRightFlow();
		String expectedChildWndwTitle="actiTIME - Time Tracking Software for Boosting Your Business";
		Assert.assertEquals(actualChildWndwTitle, expectedChildWndwTitle,"CopyRight child window title does not match");
	}
*/
}
