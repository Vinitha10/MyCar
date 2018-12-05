package com.mindtree.util1;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listners implements ITestListener, ISuiteListener, IInvokedMethodListener {

	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{		 
		 String textMsg = "About to begin executing following method : " + returnMethodName(method.getTestMethod());		 
		 Reporter.log(textMsg, true);		
	}
	public String returnMethodName(ITestNGMethod method)
	{
		return method.getRealClass().getSimpleName()+" " +method.getMethodName();
	}

	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{	
		String textMsg = "Completed executing following method : " + returnMethodName(method.getTestMethod());		 
		Reporter.log(textMsg, true);
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("About to begin executing Suite " + suite.getName(), true);
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		Reporter.log("About to end executing Suite " + suite.getName(), true);
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The execution of the main test starts now");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	private void printTestResults(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		 
		 if (result.getParameters().length != 0) 
		 {
		 String params = null;
		 for (Object parameter : result.getParameters())
		 {		 
			 params += parameter.toString() + ",";		 
		 }
		 Reporter.log("Test Method had the following parameters : " + params, true);		 
		 }		 
		 String status = null;		 
		 switch (result.getStatus()) 
		 {		 
		 case ITestResult.SUCCESS:		 
			 status = "Pass";		 
			 break;		 
		 case ITestResult.FAILURE:		 
		       status = "Failed";		 
		       break;		 
		 case ITestResult.SKIP:		 
			 status = "Skipped";		 
		 }
		 Reporter.log("Test Status: " + status, true);
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		printTestResults(result);
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("About to begin executing Test " + context.getName(), true);
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("Completed executing test " + context.getName(), true);
	}
	 

}
