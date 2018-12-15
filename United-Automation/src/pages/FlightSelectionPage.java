package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.PageBase;


public class FlightSelectionPage extends PageBase {

	public static void verifySearchData(String cityOrigin, String cityDestination, String departureDate,
			String returnDate) {
		
		waitForElementPresent(By.id("Origin"), 120);
		
		Assert.assertEquals(driver.findElement(By.id("Origin")).getAttribute("value").toLowerCase(), cityOrigin.toLowerCase());
		Assert.assertEquals(driver.findElement(By.id("Destination")).getAttribute("value").toLowerCase(), cityDestination.toLowerCase());
				
		Assert.assertTrue(driver.findElement(By.id("DepartDate")).getAttribute("value").startsWith(departureDate));
		Assert.assertTrue(driver.findElement(By.id("ReturnDateForEditSearch")).getAttribute("value").startsWith(returnDate));
		
		List<WebElement> listFlights = driver.findElements(By.xpath("//ul[@id='flight-result-list-revised']/li"));
		
		Assert.assertTrue(listFlights.size() > 0);
		
	}

	
	
}
