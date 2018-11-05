/**
 * 
 */
package stepDefinitions;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import testDataTypes.*;

/**
 * @author sanpatnaik
 *
 */

 
public class BrowseHomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	WebDriver Driver;
	
	public BrowseHomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
		Driver=testContext.getWebDriverManager().getDriver();
	}
	@Given("^The selenium setup is complete$")
	public void setUp() throws MalformedURLException {
		Driver=testContext.getWebDriverManager().getDriver();
	}
	@When("^user \\\"(.*)\\\" is selected$")
	public void user_is_selected(String username) throws Throwable {
		System.out.println("Setup is complete!");
		Userinfo userdata=FileReaderManager.getInstance().getJsonReader().getUserByName(username);
		/*Created a Page Object Manager. Page Object Manager checks for the object and creates if empty*/
		homePage.navigateTo_HomePage();
		homePage.fill_userDetails(userdata);
		homePage.clickOn_Submit();
		throw new PendingException();
	}
	@Then("^aos application body is loaded and not null$")
	public void pageBodyIsNotNull() throws MalformedURLException {
		String bodyText = Driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);
	}
}
