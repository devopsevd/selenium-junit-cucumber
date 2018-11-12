/**
 * 
 */
package stepDefinitions;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.WebDriverManager;
import pageObjects.HomePage;
import ru.yandex.qatools.allure.annotations.Step;
import cucumber.TestContext;

/**
 * @author
 *
 */
public class CloseBrowserSteps {
	TestContext testContext;
	WebDriver Driver;
	public CloseBrowserSteps(TestContext context) {
		testContext = context;
		Driver=testContext.getWebDriverManager().getDriver();
	}
	@Step
	@And("^close the web browser$")
	public void tearDownWebDriver() {
		Driver.quit();
	}

}
