/**
 * 
 */
package stepDefinitions;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cucumber.listener.Reporter;

import cucumber.ScenarioContext;
import cucumber.TestContext;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Context;
import enums.DriverType;
import managers.FileReaderManager;
import managers.WebDriverManager;
import pageObjects.HomePage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.model.SeverityLevel;
import testDataTypes.*;

/**
 * @author
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
	/*Make your changes*/
	@Features("Run basic functional test")
	@Step
	@Given("^The selenium setup is complete$")
	public void setUp() throws MalformedURLException {
		Driver=testContext.getWebDriverManager().getDriver();
	}
	@Severity(SeverityLevel.NORMAL)
	@Step
	
	@When("^print a simple message \"(.*)\" \"(.*)\" \"(.*)\"$")
	public void printSimpleMessage(String firstname,String lastname, String emailid){
		System.out.println("Setup is complete!");
		Reporter.addStepLog("Setup is complete");

		/*Created a Page Object Manager. Page Object Manager checks for the object and creates if empty*/
		homePage.navigateTo_HomePage();
		Reporter.addStepLog("Navigated to Home Page");
		Userinfo userdata=homePage.set_userDetails(firstname, lastname, emailid);
		/*START: Code to Check the Validation post run*/
		String Email=homePage.getUserEmail(userdata);
		System.out.println("User's Email ID is:"+Email);
		testContext.scenarioContext.setContext(Context.USER_EMAIL, Email);
		/*END*/
		homePage.fill_userDetails(userdata);
		Reporter.addStepLog("Filled the User details");
		homePage.clickOn_Submit();
		Reporter.addStepLog("Clicked on Submit");
	}
	@Step
	/*Changes performed by the developer*/
	@Then("^aos application body is loaded and not null$")
	public void pageBodyIsNotNull() throws MalformedURLException {
		String bodyText = Driver.findElement(By.tagName("body")).getText();
		assertTrue(bodyText != null);
	}
}
