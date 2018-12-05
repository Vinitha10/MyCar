package com.mindtree.automationframewok;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.actions.Login_Action;
import com.mindtree.pageobjects.ActionKeywords;
import com.mindtree.reusableComponents.BrowserOperations;
import com.mindtree.util1.ReadingExcel;
import com.mindtree.util1.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MainTest {
	private static ExtentReports report;
	private static ExtentTest test;
	WebDriver driver;
	BrowserOperations operations = new BrowserOperations();
	Login_Action action = new Login_Action();
	ActionKeywords actionkey = new ActionKeywords();
	@BeforeSuite
	public void beforeMethod() 
	{ 
	   System.out.println("Execution of Before Suite is carring on"); 
	}
	
	@BeforeClass
	public static void startTest()
	{
		//ExtentReports logger= ExtentReports.get(MainTest.class);
		report = new ExtentReports(System.getProperty("user.dir")+"/test-output/extentreport/ExtentReportResults.html",true);
		test = report.startTest("startTest");
		System.out.println("Before class");
	}
	@Test(dataProvider="getData")
	public void passingValues(String username,String password) throws Exception
	{
		//ExtentReports logger= ExtentReports.get(MainTest.class);
		
		for (int iRow=1;iRow<=9;iRow++)
		{
		   String sActionKeyword = ReadingExcel.getCellData(iRow, 3,"Actions");
		   if((sActionKeyword.equalsIgnoreCase("browser")) &&  (ReadingExcel.getCellData(iRow, 5,"Actions")).equals("Yes"))
		    {
	    	   driver =actionkey.navigate();
	    	}
		   else if(sActionKeyword.equals("MyAccount")&&  (ReadingExcel.getCellData(iRow, 5,"Actions")).equals("Yes"))
		   {
			  action.executeLogin(driver,username,password);
		    	break;
		    	 
		   }
		     
	}
		 String path=Screenshot.getScreenShot(driver, "Screenshot");
			test.log(LogStatus.PASS,"Screenshots" + test.addScreenCapture(path));	
		actionkey.txtbx_close(driver);
	}
	
	
	@AfterTest(groups="all")
	public static void endTest()
	{
	report.endTest(test);
	report.flush();
	}
	@AfterSuite
	public void afterMethod()
	{	 
	   System.out.println("Execution of After Suite is carring on");	 
	}
	@DataProvider(name="getData")

	  public static Object[][] credentials() {
		int i=1;
	    Object data[][] = new Object[2][2];
		 data[0][0] = ReadingExcel.getCellData(1, 1, "login");
		 data[0][1] =ReadingExcel.getCellData(1, 2, "login");
		 data[1][0]=ReadingExcel.getCellData(2, 1, "login");	
		 data[1][1]=ReadingExcel.getCellData(2, 2, "login");
		/* data[2][0]=ReadingExcel.getCellData(3, 1, "login");	
		 data[2][1]=ReadingExcel.getCellData(3, 2, "login");
		 data[3][0]=ReadingExcel.getCellData(4, 1, "login");	
		 data[3][1]=ReadingExcel.getCellData(4, 2, "login");*/
		 
		return data;
	  }
	/*@AfterMethod
	public void failedScreenshot(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			 String path=Screenshot.getScreenShot(driver, "Screenshot");
				test.log(LogStatus.FAIL,"Screenshots" + test.addScreenCapture(path));	
		}
	}*/

	

}
