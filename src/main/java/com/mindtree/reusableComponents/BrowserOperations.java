package com.mindtree.reusableComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserOperations {
	
	Properties obj = new Properties();
	WebDriver driver;
	public void setrepository() throws IOException
	{
	
	 FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\object.properties");
	 obj.load(objfile);
	 System.out.println("loaded");
	}
	
	public WebDriver getConnection() throws IOException
	{
		setrepository();
		//System.out.println();
    	String path=obj.getProperty("IntializngDriver");
    	//System.out.println(path);
    	
    	//System.out.println(obj.getProperty("PropertyDriver"));
    	System.setProperty(obj.getProperty("PropertyDriver"), path);
    	
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get(obj.getProperty("Url"));
    	
    	return driver;
	}

	
	
   
}
