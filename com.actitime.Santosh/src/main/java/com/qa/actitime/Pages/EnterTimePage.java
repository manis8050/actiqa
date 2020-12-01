package com.qa.actitime.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.Base.DriverScript;

public class EnterTimePage extends DriverScript{
	
	
	//*********************************************** Page Elements/Object Repository *********************************************//
	@FindBy(id="container_tasks") WebElement tasksMenuIcon;
	@FindBy(id="logoutLink") WebElement logoutLnk;
	@FindBy(id="container_reports") WebElement reportsMenuIcon;
	
	
	
	// ***************************************** Page Initialization *******************************************//
	//PageFactory is a class which is used to initialize the respective page elements of that class
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	// *************************************** Page Actions ******************************************************//
	
	public String landingPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyTaskMenuDisplayed()
	{
		return tasksMenuIcon.isDisplayed();
	}
	public void clickTaskMenu()
	{
		tasksMenuIcon.click();
		
	}
	public void clickLogout()
	{
		logoutLnk.click();
	}
	
	public void clickReportsMenu()
	{
		reportsMenuIcon.click();
	}
	
}

