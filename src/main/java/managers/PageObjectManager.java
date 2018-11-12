/**
 * 
 */
package managers;
import org.openqa.selenium.WebDriver;
import pageObjects.*;

/**
 * @author
 *
 */
public class PageObjectManager {

	private WebDriver driver;

	private HomePage homePage;
	private ConfirmationPage confirmationPage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}
	public ConfirmationPage getConfirmationPage() {
		return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;
	}
}
