package com.mindtree.actions;

import org.openqa.selenium.WebDriver;

import com.mindtree.pageobjects.ActionKeywords;



public class Login_Action {
	WebDriver driver;
	ActionKeywords action = new ActionKeywords();
	
	public void executeLogin(WebDriver driver,String username,String password) throws Exception
	{
		action.txtbx_clickSignIn(driver).click();
		action.txtbx_UserName(driver).sendKeys(username);
		action.txtbx_continue1(driver).click();
		action.txtbx_password(driver).sendKeys(password);
		action.txtbx_clickLogin(driver).click();
		//action.txtbx_close(driver);
	}


}
