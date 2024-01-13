package TestLayer;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseLayer.BaseClass;
import PageLayer.SignUpPage;
import UtilisLayer.ExcelReader;

public class SignUpPageTest extends BaseClass{

	@BeforeTest
	public void setUp()
	{
		BaseClass.initialization();
	}
	//--Page layer
//	@Test
//	public void validateSignUpPage()
//	{
//		SignUpPage signup=new SignUpPage();
//		signup.signUpPageFunctionality("monika", "kate", "monika@gmail.com", "1234567897", "India", "Select", "IT Manager");
//		
//	}
	@Test(dataProvider="signupdata")
	public void validateSignUpPage(String Fname,String Lname,String Email,String Phoneno,String Country,String State,
			String BusinessRole)
	{
		SignUpPage signup=new SignUpPage();
		signup.signUpPageFunctionality(Fname, Lname, Email, Phoneno, Country, State, BusinessRole);
		
	}
	
	@DataProvider(name="signupdata")
	public Object [][] getData() throws IOException
	{
		ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\main\\java\\TestDataLayer\\Form.xlsx");
		Object [][] abc=excel.getAllSheetData(0);
		return abc;
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
}
