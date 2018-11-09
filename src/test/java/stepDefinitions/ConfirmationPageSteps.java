/**
 * 
 */
package stepDefinitions;
import org.junit.Assert;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;
import pageObjects.HomePage;

/**
 * @author sanpatnaik
 *
 */


public class ConfirmationPageSteps {
	TestContext testContext;
	ConfirmationPage confirmationPage;
	HomePage homePage;

	public ConfirmationPageSteps(TestContext context) {
		testContext = context;
		confirmationPage = testContext.getPageObjectManager().getConfirmationPage();
	}

	@And("^verify the email address$")
	public void verify_the_email_address(){
		homePage.navigateTo_HomePage();
		String userEmailadd = (String)testContext.scenarioContext.getContext(Context.USER_EMAIL);
		Assert.assertTrue(confirmationPage.getEmailaddress().stream().filter(x -> x.contains(userEmailadd)).findFirst().get().length()>0);		
	}

}
