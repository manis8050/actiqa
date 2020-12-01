package com.qa.actitime.Base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.qa.actitime.Configuration.ProjectConfiguration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript1 {

	public static WebDriver driver;
	public static WebDriverWait wait;

	// @Test
	public void initialization()
	{
		ProjectConfiguration pConfigObj=new ProjectConfiguration();
		Properties prop = pConfigObj.loadProperties();
		String browserType=prop.getProperty("browser");
		String url=prop.getProperty("url");

		if(browserType.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}

		else if(browserType.equalsIgnoreCase("FF"))
		{

			System.out.println("in FF");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();

		}
		else if(browserType.equalsIgnoreCase("In IE"))
		{
			System.out.println("in IE");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();

		}


		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);

	}
}


