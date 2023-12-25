package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import PageComponents.ConfigDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class BaseTest {

	public WebDriver driver;
	public DevTools devTools;

	protected ConfigDataReader config = new ConfigDataReader();

	@BeforeClass
	public void launchApplication() {

		switch (config.getBrowser()) {

		case "chrome":
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			devTools=((ChromeDriver) driver).getDevTools();
			devTools.createSession();
			break;
		default:
			break;
		}

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
