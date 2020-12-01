package com.qa.actitime.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.Base.DriverScript;

public class LoginPage extends DriverScript{
	
	//Find element using the driver.findElement so far but in POM we will use @FindBy annotation to find the element
	//Naming convetion for the variables=> variable name=name+data type of it.
	//for example if it is logo we give the variable name as "actiLogo"
	//if it is username text box then we give the variable name as "usernameTb" where tb is the text box.
	
	//****************************************** Page Elements/Object Repository ****************************************//
	@FindBy(xpath="//div[@class='atLogoImg']") WebElement actiLogo;
	@FindBy(id="username") WebElement usernameTb;
	@FindBy(name="pwd") WebElement passwordTb;
	@FindBy(id="loginButton") WebElement loginBtn;
	@FindBy(id="keepLoggedInCheckBox") WebElement keepMeLoggedCb;


	// // ****************************  Page Initialization ***************************************//
	
	//PageFactory is a class which is used to initialize the respective page elements of that class
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	// ******************************* Page Actions ***************************************************//
	public boolean verifyActiLogoDisplayed()
	{
		return actiLogo.isDisplayed();
	}
	
	public void loginToApplication(String username,String password)
	{
		usernameTb.sendKeys(username);
		passwordTb.sendKeys(password);
		loginBtn.click();
	}

	
	public String verifyPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyKeepMeLoggedCheckbox()
	{
		keepMeLoggedCb.click();
		return keepMeLoggedCb.isSelected();
	}
	
	
}
