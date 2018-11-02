// package seleniumTests;

// import static org.junit.Assert.assertTrue;

// import java.net.MalformedURLException;
// import java.net.URL;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;

// public class E2E_Test {

// 	private WebDriver driver;

// 	@Before
// 	public void setUp() throws MalformedURLException {
// 		String serverUrl = System.getProperty("grid.server.url");
// 		String gridServerUrl = "http://10.240.0.7:4444/wd/hub";
// 		if (serverUrl != null) {
// 			gridServerUrl = serverUrl;
// 		}
// 		DesiredCapabilities capability = DesiredCapabilities.chrome();
// 		URL gridUrl = new URL(gridServerUrl);
// 		driver = new RemoteWebDriver(gridUrl, capability);
// 		driver.get("http://www.google.com");
// 	}

// 	@After
// 	public void tearDownWebDriver() {
// 		driver.quit();
// 	}


// 	@Test
// 	public void pageBodyIsNotNull() throws MalformedURLException {
// 		String bodyText = driver.findElement(By.tagName("body")).getText();
// 		assertTrue(bodyText != null);
// 	}


// }