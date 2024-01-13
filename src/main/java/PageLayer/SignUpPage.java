package PageLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseLayer.BaseClass;
import UtilisLayer.HandleDropDown;
import UtilisLayer.Wait;

public class SignUpPage extends BaseClass{
	
	@FindBy(xpath="//button[text()='Accept All Cookies']")
	private WebElement cookies;
	
	@FindBy(name="firstname")
	private WebElement fname;
	
	@FindBy(name="lastname")
	private WebElement lname;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(name="worknumber")
	private WebElement phoneno;
	
	@FindBy(name="countryname")
	private WebElement country;
	
	@FindBy(name="statename")
	private WebElement state;
	
	@FindBy(name="businessrole")
	private WebElement businessRole;
	
	@FindBy(name="tandc")
	private WebElement checkbox1;
	
	@FindBy(name="optIn")
	private WebElement checkbox2;
	
	
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signUpPageFunctionality(String Fname,String Lname,String Email,String Phoneno,String Country,String State,
			String BusinessRole)
	{
		Wait.click(cookies);
		Wait.sendKeys(fname, Fname);
		Wait.sendKeys(lname, Lname);
		Wait.sendKeys(email, Email);
		Wait.sendKeys(phoneno, Phoneno);
		HandleDropDown.selectByVisibleText(country, Country);
		HandleDropDown.selectByVisibleText(state, State);
		HandleDropDown.selectByVisibleText(businessRole, BusinessRole);
		Wait.click(checkbox1);
		Wait.click(checkbox2);
	
	}
	
	

}
