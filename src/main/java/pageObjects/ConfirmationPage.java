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
	WebElement userTable = driver.findElement(By.ByClassName.className("springOneTable"));
	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindAll(@FindBy(how = How.NAME, using = "emailAddress"))
	//private List<WebElement> email_List;
	
	List<WebElement> email_List = userTable.findElements(By.tagName("tr"));
	//assertEquals(3, email_List.size());

	public List<String> getEmailaddress() {
		List<String> emails = new ArrayList<>();
		for(WebElement element : email_List) {
			emails.add(element.findElement(By.tagName("td")).getText());
		}
		return emails;
	}
}
