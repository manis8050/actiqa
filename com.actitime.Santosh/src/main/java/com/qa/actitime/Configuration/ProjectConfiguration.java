package com.qa.actitime.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	
	public Properties loadProperties()
	{
	Properties prop=null;
	
		try {
        String filepath=System.getProperty("user.dir")+"\\actiConfiguration\\config.properties";
		
		//Creating the object of the File class and specify the path of the source file
		File src=new File(filepath);
		
		
		//Create FileInputStream object to stream the contents of the source file
		
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
			
			
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
		return prop;
		
	}

}
