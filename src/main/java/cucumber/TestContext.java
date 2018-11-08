/**
 * 
 */
package cucumber;
import managers.PageObjectManager;
import managers.WebDriverManager;
import cucumber.*;
/**
 * @author sanpatnaik
 *
 */
public class TestContext {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	public TestContext(){
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
	}

	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

}