/**
 * 
 */
package stepDefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import pageObjects.ConfirmationPage;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * @author
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
/*Changes made*/
	@Step
	@And("^verify the email address$")
	public void verify_the_email_address(){
		String userEmailadd = (String)testContext.scenarioContext.getContext(Context.USER_EMAIL);
		Reporter.addStepLog("Verifying if the user was added");
		Assert.assertTrue(confirmationPage.getEmailaddress(Driver).stream().filter(x -> x.contains(userEmailadd)).findFirst().get().length()>0);		
	}

}
