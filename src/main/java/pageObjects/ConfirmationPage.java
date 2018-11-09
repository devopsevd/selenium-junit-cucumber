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

	@FindAll(@FindBy(how = How.CSS, using = ".submitBtn"))
	private List<WebElement> email_List;	

	/*public List<String> getEmailaddress() {
		List<String> emails = new ArrayList<>();
		for(WebElement element : email_List) {
			emails.add(element.findElement(By.cssSelector("selector")).getText());
		}
		return emails;
	}*/
	public List<String> getEmailaddress(WebDriver driver){
	    WebElement table = driver.findElement(By.xpath("/html/body/div[3]/fieldset/table"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	    List<WebElement> column = table.findElements(By.tagName("td"));
	    List<String> value = new ArrayList<String>();

	    System.out.println(rows.size());

	        for (int j=0; j<column.size(); j++){
	            System.out.println(column.get(j).getText());
	            value.add(column.get(j).getText());
	        }
	        return value;
	}
}
