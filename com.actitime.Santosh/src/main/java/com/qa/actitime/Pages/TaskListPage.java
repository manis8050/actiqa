package com.qa.actitime.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.actitime.Base.DriverScript;

public class TaskListPage extends DriverScript{
	
	// ************************************************ Page Elements *******************************************************//

      @FindBy(id="container_tasks") WebElement tasksIcon;
      @FindBy(xpath="//div[contains(text(),'Add New')]") WebElement addNewtaskBtn;
    //  @FindBy(xpath="//body/div[@id='taskManagementPage']/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]") WebElement addNewtaskBtn;
      @FindBy(xpath="//div[contains(text(),'+ New Customer')]") WebElement addNewCustomerlink;
     // @FindBy(xpath="//input[@placeholder='Enter Customer Name'][1]") WebElement newCustNameTb;
      @FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]") WebElement newCustNameTb;
      @FindBy(xpath="//textarea[@placeholder='Enter Customer Description']") WebElement newCustDescriptionTA;   //Description text area(TA)
      @FindBy(xpath="//div[contains(text(),'Create Customer')]") WebElement createCustomerBtn;
      @FindBy(xpath="//body/div[@id='customerLightBox']/div[@id='customerLightBox_content']/div[3]/div[2]/div[2]") WebElement cancelBtn;
      @FindBy(xpath="//div[contains(text(),'Copy Projects from an Existing Customer:')]/parent::div/div[2]/span//div[@class='searchItemList']/div[contains(@class,'itemRow')]") List<WebElement> projectsDrpdnwn;      
      
      //********************************************* Page Initialization *******************************************************//
      
      public TaskListPage()
      {
    	  PageFactory.initElements(driver, this);
      }
      
      
      
      //******************************************* Page Actions ************************************************************//
      
      public void clickAddNewCustomer()
      {
    	  addNewtaskBtn.click();
      }
      
      
      public void clickAddNewCustItem()
      {
    	  addNewCustomerlink.click();
      }
      
      
      public void enterCustomerName(String username)
      {
    	  newCustNameTb.sendKeys(username);
    	  
      }
      
      public void enterCustomerDescription(String custDescription)
      {
    	  newCustDescriptionTA.sendKeys(custDescription);
      }
      
      
      public void clickCreateCustomerButton()
      {
    	  createCustomerBtn.click();
      }
      
      
      
}



