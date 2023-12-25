package Pages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v119.emulation.Emulation;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageComponents.BasePage;

public class Location extends BasePage {

	WebDriver driver = null;

	public Location(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "latitude")
	private WebElement latitudeValue;

	@FindBy(id = "longitude")
	private WebElement longitudeValue;

	@FindBy(id = "my_location")
	private WebElement myLocation;

	@FindBy(id = "coordinates_url]")
	private WebElement myLocationDetails;

	@FindBy(css = "div[class$=error] > p")
	private WebElement invalidLoginMessage;

	public void setLocation(String url) {

		Map<String, Object> coordinates = new HashMap<String, Object>();

		coordinates.put("latitude", 42.1408845);
		coordinates.put("longitude", -72.5033907);
		coordinates.put("accuracy", 100);

		((ChromiumDriver) driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);

		driver.navigate().to(url);
		driver.manage().window().maximize();

	}

	public boolean isLocationTraced() {
		return latitudeValue.getText().equalsIgnoreCase("42.1408845")
				&& longitudeValue.getText().equalsIgnoreCase("-72.5033907");
	}

	public boolean isMyLocationUpdate() {
		waitForWebElement(myLocation);

		return myLocation.getAttribute("value").contains("42.1408845")
				&& myLocation.getAttribute("value").contains("-72.5033907");
	}
	
}
