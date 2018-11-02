package stepDefinitions;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;
import managers.*;
import cucumber.api.java.en.And;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import pageObjects.HomePage;

public class Steps {

	WebDriver driver;
	HomePage homePage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	WebDriverManager webDriverManager;

	@Given("^The selenium setup is complete$")
	public void setUp() throws MalformedURLException {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
	}

	@When("^print a simple message$")
	public void printSimpleMessage() {
		System.out.println("Setup is complete!");
		/*Created a Page Object Manager. Page Object Manager checks for the object and creates if empty*/
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage();
		homePage.fill_userDetails();
		homePage.clickOn_Submit();
	}

	@Then("^aos application body is loaded and not null$")
	public void pageBodyIsNotNull() throws MalformedURLException {
		String bodyText = driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);
	}

	@And("^close the web browser$")
	public void tearDownWebDriver() {
		driver.quit();
	}

}