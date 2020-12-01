package com.qa.actitime.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.Base.DriverScript;

public class ReportsPage extends DriverScript{
	
	//********************************************** Page Elements//Object Repository ***************************************//
	@FindBy(xpath="//span[contains(text(),'New Report')]") WebElement newReportBtn;
	@FindBy(xpath="//div[contains(text(),'Configure Report Parameters')]") WebElement configRprtparametersBtn;
	@FindBy(id="applyReportConfiguration") WebElement generateHtmlRprtBtn;

	
	// ******************************************* Page Initialization ************************************//
	
	public ReportsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
  //******************************************** Page Actions ************************************************//
	
	
	public void clickCreateNewReport()
	{
		newReportBtn.click();
	}
	
	public void clickConfigureReportparameters()
	{
		configRprtparametersBtn.click();
	}
	
	public void clickGenerateHtmlReport()
	{
		generateHtmlRprtBtn.click();
		
	}
	
}
