package UtilisLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ITestListenerSetup extends ExtentReportsSetUp implements ITestListener{
	ExtentReports extentreports;
	ExtentTest extenttest;
	
    public void onStart(ITestContext context) 
    {
    	  extentreports=ExtentReportsSetUp.setUp(context.getSuite().getName());
	}

	public void onTestStart(ITestResult result) 
	
	{
		  extenttest=extentreports.createTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result)
	{
		extenttest.log(Status.PASS, result.getMethod().getMethodName());
		String dest=ExtentReportsSetUp.screenShot("passcreenshot", result.getMethod().getMethodName());
		extenttest.addScreenCaptureFromPath(dest);
	}

	public void onTestFailure(ITestResult result) 
	{
		extenttest.log(Status.FAIL, result.getMethod().getMethodName());
		String dest=ExtentReportsSetUp.screenShot("failscreenshot",  result.getMethod().getMethodName());
		extenttest.addScreenCaptureFromPath(dest);
		
	}

	public void onTestSkipped(ITestResult result)
	{
		extenttest.log(Status.SKIP, result.getMethod().getMethodName());
	}

	

	public void onFinish(ITestContext context)
	{
		extentreports.flush();
	}

	
}
