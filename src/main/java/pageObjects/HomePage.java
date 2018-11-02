package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.NAME, using = "firstName") 
    private WebElement txtbx_FirstName;
    
    @FindBy(how = How.NAME, using = "lastName") 
    private WebElement txtbx_LastName;
    

    @FindBy(how = How.NAME, using = "emailAddress") 
    private WebElement txtbx_EmailAddress;

    @FindBy(how = How.CSS, using = ".submitBtn") 
	private WebElement btn_Submit;
    

    public void enter_FirstName(String firstName) {
		txtbx_FirstName.sendKeys(firstName);
    }
    
    public void enter_LastName(String lastName) {
		txtbx_LastName.sendKeys(lastName);
    }
    
    public void enter_email(String email) {
		txtbx_EmailAddress.sendKeys(email);
    }
    
    public void clickOn_Submit() {
		btn_Submit.submit();
    }
    
    public void fill_userDetails(){
        enter_FirstName("John");
        enter_LastName("Doe");
        enter_email("john.doe@test.com");             
    }

	public void navigateTo_HomePage() {
		driver.get("http://10.240.0.7/SpringIODemo/demoPage");
	}


}