package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.Location;
import TestComponents.BaseTest;

public class Test_LocateMe extends BaseTest {

	public Location location;

	@BeforeMethod
	public void setUp() {
		location = new Location(driver);
		
	}

	@Test
	public void test_Location() throws IOException, Exception {
		
		location.setLocation(config.getUrl());
		
		Thread.sleep(10000);
		Assert.assertTrue(location.isLocationTraced());
		Assert.assertTrue(location.isMyLocationUpdate());
	}
}
