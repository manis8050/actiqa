package com.qa.actitime.Pages;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.actitime.Base.DriverScript;
import com.qa.actitime.Utility.Utilities;

public class LoginPage2 extends DriverScript{
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
	@FindBy(id="toPasswordRecoveryPageLink") WebElement forgotPwdLnk;
	@FindBy(id="headerContainer") WebElement forgotPwdHeader;
	@FindBy(xpath="//div[contains(text(),'Please enter email address or username below to ge')]") WebElement forgotPwdTooltip;
	@FindBy(xpath="//input[@id='forgetPasswordEmailOrUsername']") WebElement forgotPasswordTb;
	@FindBy(xpath="//a[@id='forgetPasswordButton']") WebElement requestLoginBtn;
	@FindBy(xpath="//a[@id='toLoginPageLink']") WebElement toLoginPageLnk;
	@FindBy(xpath="//nobr[contains(text(),'actiTIME 2020 Online')]") WebElement footerLnk;
	@FindBy(xpath="//a[contains(text(),'actiTIME Inc.')]") WebElement copyRightLnk;
	@FindBy(xpath="//td[@id='headerContainer']") WebElement headerLabel;
	@FindBy(xpath="//table[@id='demoCredentials']") WebElement credentialsTooltip;
	@FindBy(xpath="//span[@id='errorSpan']") WebElement forgotPwdErrorTxt;
	@FindBy(xpath="//a[@id='logoutLink']") WebElement logoutLnk;
	

	

	// ****************************  Page Initialization ***************************************//

	//PageFactory is a class which is used to initialize the respective page elements of that class
	public LoginPage2()
	{
		
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver,30);
		
	}

	// ******************************* Page Actions ***************************************************//
	public boolean verifyActiLogoDisplayed()
	{
		return actiLogo.isDisplayed();
	}

	//Parameterization i.e. taking the values when the method is called.
	public void loginToApplication(String username,String password)
	{
		Utilities.highlightElement(usernameTb);   //This method is called to highlight the element on the page.
		usernameTb.sendKeys(username);
		Utilities.highlightElement(passwordTb);
		passwordTb.sendKeys(password);
		Utilities.highlightElement(loginBtn);
		loginBtn.click();
	}

	public String verifyPageTitle()
	{
		return driver.getTitle();
	}

	public String loginWndwHdr()
	{
		// System.out.println("Header id attribute value is:" +headerLabel.getAttribute("id"));
		String loginWndwHdrText=headerLabel.getText();
		return loginWndwHdrText;
		
	}
	
	public boolean verifyLoginWndwcredentialsTooltip()
	{
		
		boolean lgnWndwTooltip=credentialsTooltip.isDisplayed();
				
		return lgnWndwTooltip;
	}
	public boolean verifyKeepMeLoggedCheckbox()
	{
		keepMeLoggedCb.click();
		return keepMeLoggedCb.isSelected();
		
	}
	
	
	public String verifyForgotPwdHdr()
	{
		String forgotpwdHdrtext=forgotPwdHeader.getText();
		return forgotpwdHdrtext;
		
	}
	
	public String verifyForgotPwdTooltip()
	{
		String forgotPwdTooltipTxt=forgotPwdTooltip.getText();
		return forgotPwdTooltipTxt;
	}

	public boolean verifyForgotPasswordFlowEmail(String email)
	{
		forgotPwdLnk.click();
		forgotPasswordTb.sendKeys(email);
		requestLoginBtn.click();
		// Thread.sleep(3000);
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(forgotPwdErrorTxt));
		
		//System.out.println("Forgot pwd txt is:" +forgotPwdErrorTxt.getText());
		boolean forgotPwdEmailFlag=forgotPwdErrorTxt.getText().equalsIgnoreCase("Cannot recover login info.\n" +"Please make sure that everything is typed in correctly.");
		return forgotPwdEmailFlag;
	}
	public boolean verifyForgotPasswordFlowUsername(String username)
	{
		forgotPwdLnk.click();
		forgotPasswordTb.sendKeys(username);
		requestLoginBtn.click();
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(forgotPwdErrorTxt));
		System.out.println("Forgot pwd txt is:" +forgotPwdErrorTxt.getText());
		boolean forgotPwdUNFlag=forgotPwdErrorTxt.getText().equalsIgnoreCase("Cannot recover login info.\n" + "Please make sure that everything is typed in correctly.");
		return forgotPwdUNFlag;
	}
	
	public void verifyReturnLoginPageLinkFlow()
	{
		toLoginPageLnk.click();
	}
	
	public String verifyLoginPageFooter()
	{
		String footerTxt=footerLnk.getText();
		return footerTxt;
	}
	
	public String verifyCopyRightFlow()
	{
		copyRightLnk.click();
        Iterator<String> ite=driver.getWindowHandles().iterator();
		String parentWindow1=ite.next();
		String childWindow=ite.next();
		System.out.println("childwindow address is:" +childWindow);
		
		driver.switchTo().window(childWindow);
		String childWndwTitle=driver.getTitle();
		System.out.println("child window title is:" +childWndwTitle);
	//	driver.findElement(By.linkText("Start Using actiTIME")).click();
		
		driver.switchTo().window(parentWindow1);
		return childWndwTitle;
		
	}

}
