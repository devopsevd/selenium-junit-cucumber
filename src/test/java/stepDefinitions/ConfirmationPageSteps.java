/**
 * 
 */
package stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;

/**
 * @author sanpatnaik
 *
 */


public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;
	WebDriver Driver;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
		Driver=testContext.getWebDriverManager().getDriver();
	}

	@And("^verify the email address$")
	public void verify_the_email_address(){
		String userEmailadd = (String)testContext.scenarioContext.getContext(Context.USER_EMAIL);
		Assert.assertTrue(confirmationPage.getEmailaddress(Driver).stream().filter(x -> x.contains(userEmailadd)).findFirst().get().length()>0);		
	}

}
