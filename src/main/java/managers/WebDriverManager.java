/**
 * 
 */
package managers;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import enums.DriverType;
import enums.EnvironmentType;
/**
 * @author
 *
 */


public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {	    
		case LOCAL : driver = createLocalDriver();
		break;
		case REMOTE : driver = createRemoteDriver();
		break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		switch (driverType){
		case CHROME :
			String serverUrl = System.getProperty(FileReaderManager.getInstance().getConfigReader().getSystemgridproperty());
			String gridServerUrl = FileReaderManager.getInstance().getConfigReader().getGridServerUrl();
			if (serverUrl != null) {
				gridServerUrl = serverUrl;
			}
			DesiredCapabilities capability = DesiredCapabilities.chrome();
			URL gridUrl=null;
			try {
				gridUrl = new URL(gridServerUrl);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new RemoteWebDriver(gridUrl, capability);
			return driver;
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case INTERNETEXPLORER : driver = new InternetExplorerDriver();
		break;
		}
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {	    
		case FIREFOX : driver = new FirefoxDriver();
		break;
		case CHROME : 
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getSystemgridproperty());
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER : driver = new InternetExplorerDriver();
		break;
		}

		// if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

}