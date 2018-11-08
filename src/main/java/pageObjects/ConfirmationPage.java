/**
 * 
 */
package pageObjects;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/**
 * @author sanpatnaik
 *
 */
public class ConfirmationPage {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(how = How.NAME, using = "firstName"))
	private List<WebElement> email_List;	

	public List<String> getEmailaddress() {
		List<String> emails = new ArrayList<>();
		for(WebElement element : email_List) {
			emails.add(element.findElement(By.cssSelector("firstName")).getText());
		}
		return emails;
	}
}
