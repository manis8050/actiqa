package com.qa.actitime.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverScript {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	

	public DriverScript()
	{

		try
		{
			//Creating an object of the Properties class(in Java) so we load the data from the config.properties file.
			 prop=new Properties();

			String filePath=System.getProperty("user.dir")+"//actiConfiguration//config.properties";

			//Creating an object of the File class which takes the source file path as argument.
			File src=new File(filePath);

			//Creating an object of the FileInputStream which streams the data from source file.
			FileInputStream fis=new FileInputStream(src);

			//Load is a method which reads the property list from Input byte stream
			prop.load(fis);
		}

		catch(Exception e)
		{
			System.out.println("File not Found " +e.getMessage());
		}
	}
	
	
	// @Test
	public static void initialization()
	{
		String browser=prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome"))
		{
			// System.out.println("in Chrome");
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("FF"))
		{
			System.out.println("in FF");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("In IE"))
		{
			System.out.println("in IE");
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			
		}
		
		String url=prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

}
