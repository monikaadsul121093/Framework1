package UtilisLayer;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import BaseLayer.BaseClass;

public class ExtentReportsSetUp extends BaseClass{

	
	public static ExtentReports setUp(String suitename)
	{
		ExtentReports extentreports=new ExtentReports();
		String path=System.getProperty("user.dir")+"\\ExtentHTMLReports\\"+suitename+"_"+date()+".html";
		ExtentSparkReporter spark=new ExtentSparkReporter(path);
		extentreports.attachReporter(spark);
		return extentreports;
		
		/*ExtentReports extentreports=new ExtentReports();
		 * extentreports.attachReporter(new ExtentSparkReporter(System.getProperty("user.dir")+"\\ExtentReport\\"+suitename+"_"+date()+".html"));
		 * return extentreports;
		 */
	}
	
	
	public static String screenShot(String foldername,String testcase)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File f=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"\\"+foldername+"\\"+testcase+date()+".png";
		try {
			FileUtils.copyFile(f, new File(destination));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return destination;
	/* 	String destination=System.getProperty("user.dir")+"\\"+foldername+"\\"+tesecase+date()+".png";
	 * FileUtilis.copyFile(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE),new File(path));
	 * return destination;
	 */
	}
	
	public static String date()
	{
		SimpleDateFormat simple=new SimpleDateFormat("ddMMyyyy_HHmmss");
		String date=simple.format(new Date());
		return date;
	}
}
