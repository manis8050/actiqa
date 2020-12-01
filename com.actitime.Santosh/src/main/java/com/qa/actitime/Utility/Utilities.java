package com.qa.actitime.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.actitime.Base.DriverScript;

public class Utilities  extends DriverScript{
		
	
	//This method is to highlight the elemnent on the page. Need to call this method before performing any action on an element.
		public static void highlightElement(WebElement ele)
		{
			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style','background:yellow;border: 2px solid red;')", ele);
		}

	}

