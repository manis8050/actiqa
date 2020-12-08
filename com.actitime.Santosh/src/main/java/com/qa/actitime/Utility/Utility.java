package com.qa.actitime.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.qa.actitime.Base.DriverScript;

public class Utility  extends DriverScript{
		
	
	//This method is to highlight the elemnent on the page. Need to call this method before performing any action on an element.
		public static void highlightElement(WebElement ele)
		{
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')", ele);
		}

		
		
		//Take screenshot method (using the FileHandler class in Selenium )
		public static String takeScreenShot(WebDriver driver,String screenName)
		{
			TakesScreenshot tsh=(TakesScreenshot) driver;
			File src=tsh.getScreenshotAs(OutputType.FILE);
			
			String destinationPath=System.getProperty("user.dir")+"\\screenshots\\"+screenName +Calendar.getInstance().getTimeInMillis()%100000000+".png";
			File destFile=new File(destinationPath);
			
			try {
				FileHandler.copy(src, destFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return destinationPath;
		}
		
		//Take screenshotmethod 1  (same method as above but using the FileUtils class from apache commom io)
		public static String captureScreenShot(WebDriver driver,String screenName)
		{
			String dateName=new SimpleDateFormat("MMddyyyyhhmmss").format(new Date());
			TakesScreenshot tsh=(TakesScreenshot) driver;
			File src = tsh.getScreenshotAs(OutputType.FILE);
			String dest=System.getProperty("user.dir")+"\\screenshots\\"+screenName+dateName+".png";   //Did not get displayed in extent html Report if it is with .jpeg/.jpg
			File finalDest=new File(dest);
			try {
				FileUtils.copyFile(src, finalDest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dest;
			
			
		}
		
		//Take Screenshot method 2 (just a different version of writing the above script by combining the lines) but this method does not return anything.
		
		public static void captureScreenShot1(WebDriver driver,String screenName)
		{
			
			String dateValue=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			//Take a screenshot
			File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			//Copy the file to a desired location and use try catch block to handle exception.
			try {
				FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+".//screenshots"+screenName+dateValue+".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			
			
		}
		
		
	}

