package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;
import managers.*;
import testDataTypes.*;
import selenium.*;

public class HomePage{
	WebDriver driver;
	ConfigFileReader configFileReader;
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private List<WebElement> email_List;

	@FindBy(how = How.NAME, using = "firstName") 
	private WebElement txtbx_FirstName;

	@FindBy(how = How.NAME, using = "lastName") 
	private WebElement txtbx_LastName;


	@FindBy(how = How.NAME, using = "emailAddress") 
	private WebElement txtbx_EmailAddress;

	@FindBy(how = How.CSS, using = ".submitBtn") 
	private WebElement btn_Submit;


	public void enter_FirstName(String firstName) {
		txtbx_FirstName.sendKeys(firstName);
	}

	public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
	}

	public void enter_email(String email) {
		txtbx_EmailAddress.sendKeys(email);
	}

	public void clickOn_Submit() {
		btn_Submit.submit();
	}
	public Userinfo set_userDetails(String firstname,String lastname, String emailid){
		Userinfo user = new Userinfo();
		user.setFirstname(firstname);
		user.setLastName(lastname);
		user.setEmailAddress(emailid);
		return user;
		
	}
	public void fill_userDetails(Userinfo user){
		enter_FirstName(user.getFirstname());
		enter_LastName(user.getLastName());
		enter_email(user.getEmailAddress());             
	}

	public void navigateTo_HomePage() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		/*Invoking Ajax Calls*/
		Wait.untilPageLoadComplete(driver, (long) 20);
	}
	public String getUserEmail(Userinfo email) {
		String emailadd=email.getEmailAddress();
		return emailadd;
	}


}