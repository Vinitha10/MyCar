package com.mindtree.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.reusableComponents.BrowserOperations;
import com.mindtree.util1.ReadingExcel;



public class ActionKeywords {
	WebElement element;
	 WebDriver  driver;
	 BrowserOperations operation1 = new BrowserOperations();
	 public  WebDriver navigate() throws IOException
	 { 
		driver =operation1.getConnection();
		return driver;
		
	 }
	 public  WebElement  txtbx_clickSignIn(WebDriver driver) throws Exception{
	    	try{
	           element = driver.findElement(By.xpath(ReadingExcel.getCellData(3, 2,"Xpath")));
	           System.out.println("SignIn text box is found on the Login Page");
	    	}
	    	catch (Exception e)
	    	{
	       		System.out.println("SignIn text box is not found on the Login Page");
	       		
	       	}
	       	return element;
	        }
	public  WebElement txtbx_UserName(WebDriver driver) throws Exception{
   	try{
          element = driver.findElement(By.xpath("//input[@type='email']"));
          System.out.println("Username text box is found on the Login Page");
   	}
   	catch (Exception e)
   	{
      		System.out.println("UserName text box is not found on the Login Page");
      		
      	}
      	return element;
       }
	public  WebElement txtbx_continue1(WebDriver driver) throws Exception{
   	try{
          element = driver.findElement(By.xpath(ReadingExcel.getCellData(5, 2,"Xpath")));
          System.out.println("Continue text box is found on the Login Page");
   	}
   	catch (Exception e)
   	{
      		System.out.println("Continue text box is not found on the Login Page");
      		
      	}
      	return element;
       }
	public  WebElement txtbx_password(WebDriver driver)  throws Exception{
   	try{
          element = driver.findElement(By.xpath(ReadingExcel.getCellData(6, 2,"Xpath")));
          System.out.println("Password text box is found on the Login Page");
   	}
   	catch (Exception e)
   	{
      		System.out.println("Password text box is not found on the Login Page");
   	}
      	return element;
       }
	public  WebElement txtbx_clickLogin(WebDriver driver) throws Exception{
   	try{
          element = driver.findElement(By.xpath(ReadingExcel.getCellData(7, 2,"Xpath")));
          System.out.println("Login  Button is found on the Login Page");
   	}
   	catch (Exception e)
   	{
      System.out.println("Login  Button is not found on the Login Page");
      		
      	}
      	return element;
       }
	public  void txtbx_close(WebDriver driver) throws Exception{
	   	try{
	          driver.close();
	          
	   	}
	   	catch (Exception e)
	   	{
	      
	      		
	      	}
	      	
	       }

}
