package com.qa.acti.Tests;

import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.actitime.Utility.ExcelLib;

public class TestCreateCustomer_parameter_Excel_file extends TestBase{
	
	@Test(dataProvider="logindata")
	public void testCreateNewCustomer(String username,String password) throws InterruptedException
	{
//		lpObj=new LoginPage2();
//		etpObj=new EnterTimePage();
//		tlpObj=new TaskListPage();
	    logger=extent.createTest("Create New Customer");
		lpObj.loginToApplication(username,password);
		logger.log(Status.PASS, "Logged into the application");
		etpObj.clickTaskMenu();
		logger.log(Status.INFO, "Clicked on Task Menu");
		tlpObj.clickAddNewCustomer();
		logger.log(Status.INFO, "Clicked on Add New Button");
		tlpObj.clickAddNewCustItem();
		logger.log(Status.INFO, "Click on Add New Customer Button");
		tlpObj.enterCustomerName("Custname"+rand.nextInt(2597546));
		logger.log(Status.INFO, "Enter Customer Name");
	    tlpObj.enterCustomerDescription("Test Descciprtion 02746586");
	    logger.log(Status.INFO, "Enter Customer Description");
		tlpObj.clickCreateCustomerButton();
		logger.log(Status.PASS, "Clicked on Create Customer");
		Thread.sleep(3000);
		etpObj.clickLogout();
		logger.log(Status.INFO, "Clicked Logout Link");
		
	}
	
	@DataProvider(name="logindata")
	public String[][] loginDataExcel()
	{
		ExcelLib exlObj=new ExcelLib();
		XSSFSheet sheetname=exlObj.getSheetName(prop.getProperty("sheetname"));
		int rowCount=exlObj.getRowCount(sheetname);
		int colCount=exlObj.getColumnCount(sheetname);
		String[][] data=exlObj.getCellData(sheetname, rowCount, colCount);
		return data;
	
	}

}
