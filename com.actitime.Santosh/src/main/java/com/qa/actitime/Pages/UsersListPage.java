package com.qa.actitime.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.Base.DriverScript;

public class UsersListPage extends DriverScript{
	
	//*********************************        PAge Elements/Object Repository **********************************************//
	
	@FindBy(id="container_users") WebElement usersMenuIcon;
	@FindBy(id="logoutLink") WebElement logoutLnk;
	@FindBy(xpath="//div[contains(text(),'PTO Settings')]") WebElement ptoSettingsTab;
	@FindBy(xpath="(//div[contains(text(),'Sick Days Settings')])[1]") WebElement sickDaysTab;
	@FindBy(xpath="(//div[contains(text(),'Work Assignments')])[1]") WebElement workassignTab;
	@FindBy(xpath="//span[contains(text(),'List of Users')]") WebElement userListPageTitle;
	
	
	//************************************ Page element initialization **************************************************//
	
	public UsersListPage()
	{
	PageFactory.initElements(driver,this);
	}
	
	//************************************** PAge actions ***********************************************************//
	
		public String usersMenuClick()
		{
			usersMenuIcon.click();
			return(userListPageTitle.getText());
			
		}
		
		public void usersListTabsClick()
		{
			ptoSettingsTab.click();
			sickDaysTab.click();
			workassignTab.click();
			
		}
		
	}


