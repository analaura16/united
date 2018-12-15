package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import common.PageBase;
import common.TestData;

public class HomePage extends PageBase {

	
	// Change language of the Web site to "lang"
	public static void changeLanguage(String lang) {
		
		String currentLanguage = driver.findElement(By.xpath("//*[@id='gh-eb-Geo-a-default']/span[2]")).getText();
				
		// If the current language is not 'lang' (e.g.:'English'), then select lang from dropdown list
		if (!currentLanguage.equals(lang)) {
			
			String xpathDropdown = "//*[@id='gh-eb-Geo-a-default']";
			driver.findElement(By.xpath(xpathDropdown)).click();
			
			String xpathLang = "//*[@id='gh-eb-Geo-o']/ul/li/a/span[text()='" + lang + "']";
			
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLang)));
			
			driver.findElement(By.xpath(xpathLang)).click();
			
		}
		
	}
	
	
	// Search products by "value" specified
	public static void searchBy(String value) {
		
		String xpathInput = "//input[@id='gh-ac']";
		
		driver.findElement(By.xpath(xpathInput)).clear();
		driver.findElement(By.xpath(xpathInput)).sendKeys(value);
		
		// Click Search button
		String xpathButton = "//input[@value='Search']";
		
		driver.findElement(By.xpath(xpathButton)).submit();
		
	}


	public static void enterOrigin(String origin) {
		
		driver.findElement(By.id("bookFlightOriginInput")).clear();
		driver.findElement(By.id("bookFlightOriginInput")).sendKeys(origin);
		
		Assert.assertEquals(origin, driver.findElement(By.id("bookFlightOriginInput")).getAttribute("value"));
		
	}


	public static void enterDestination(String destination) {
		
		driver.findElement(By.id("bookFlightDestinationInput")).clear();
		driver.findElement(By.id("bookFlightDestinationInput")).sendKeys(destination);
		
		Assert.assertEquals(destination, driver.findElement(By.id("bookFlightDestinationInput")).getAttribute("value"));
				
	}


	public static void enterDepartureDate(String date) {
		
		driver.findElement(By.id("DepartDate")).clear();
		driver.findElement(By.id("DepartDate")).sendKeys(date);
				
		Assert.assertEquals(date, driver.findElement(By.id("DepartDate")).getAttribute("value"));
		
	}


	public static void enterReturnDate(String date) {

		driver.findElement(By.id("ReturnDate")).clear();
		driver.findElement(By.id("ReturnDate")).sendKeys(date);
				
		Assert.assertEquals(date, driver.findElement(By.id("ReturnDate")).getAttribute("value"));
		
	}


	public static void clickSelectTravelers() {
		
		driver.findElement(By.id("bookFlightModel.passengers")).click();
		
		waitForElementPresent(By.id("bookFlightModel.passengers"), 3);
		
	}	

	
	public static void selectTravelers(String travellerAge, int amount) {
		
		
		switch(travellerAge) {
		
			case "Adults":
				driver.findElement(By.id("NumOfAdults")).clear();
				driver.findElement(By.id("NumOfAdults")).sendKeys(Integer.toString(amount));
				break;
				
			case "Seniors":
				driver.findElement(By.id("NumOfSeniors")).clear();
				driver.findElement(By.id("NumOfSeniors")).sendKeys(Integer.toString(amount));
				break;
				
			case "Infants":
				driver.findElement(By.id("NumOfInfants")).clear();
				driver.findElement(By.id("NumOfInfants")).sendKeys(Integer.toString(amount));
				break;
			
			case "Infants on lap":
				driver.findElement(By.id("NumOfLapInfants")).clear();
				driver.findElement(By.id("NumOfLapInfants")).sendKeys(Integer.toString(amount));
				break;
			
			case "Children (15-17)":
				driver.findElement(By.id("NumOfChildren04")).clear();
				driver.findElement(By.id("NumOfChildren04")).sendKeys(Integer.toString(amount));
				break;
			
			case "Children (12-14)":
				driver.findElement(By.id("NumOfChildren03")).clear();
				driver.findElement(By.id("NumOfChildren03")).sendKeys(Integer.toString(amount));
				break;
			
			case "Children (5-11)":
				driver.findElement(By.id("NumOfChildren02")).clear();
				driver.findElement(By.id("NumOfChildren02")).sendKeys(Integer.toString(amount));
				break;
			
			case "Children (2-4)":
				driver.findElement(By.id("NumOfChildren01")).clear();
				driver.findElement(By.id("NumOfChildren01")).sendKeys(Integer.toString(amount));
				break;
			
		}
				
		
		
	}


	public static void verifyAmountTravelers() {

		try {
			driver.findElement(By.id("passengersCloseBtn")).click();
		} catch (NoSuchElementException e) {
			
		}
		
		int totalAmountTravelers = TestData.numTravelersAdult + TestData.numTravelersSenior + TestData.numTravelersInfant 
				+ TestData.numTravelersInfantLap + TestData.numTravelersChildren15_17 + TestData.numTravelersChildren12_14 
				+ TestData.numTravelersChildren5_11 + TestData.numTravelersChildren2_4;
		
		String expected = driver.findElement(By.id("bookFlightModel.passengers")).getAttribute("value");
		
		Assert.assertTrue(expected.startsWith(Integer.toString(totalAmountTravelers)));
		
		
		// This will be used when more than one kind of traveler is selected. 
		/*
		
		
		int totalAmountTravelers = TestData.numTravelersAdult + TestData.numTravelersSenior + TestData.numTravelersInfant 
				+ TestData.numTravelersInfantLap + TestData.numTravelersChildren15_17 + TestData.numTravelersChildren12_14 
				+ TestData.numTravelersChildren5_11 + TestData.numTravelersChildren2_4;
		
		String actual = totalAmountTravelers + " travelers";
		String expected = driver.findElement(By.id("bookFlightModel.passengers")).getAttribute("value");
		
		Assert.assertEquals(actual, expected);
		*/
	}


	public static void selectTravelerCategory(String type) {
		 
		driver.findElement(By.xpath("//button[@id='cabinType']")).click();
		driver.findElement(By.xpath("//button[@id='cabinType']")).sendKeys(type);
		//econ
		//premimuEconomy
		//businessFirst
		//driver.findElement(By.xpath("//button[@id='cabinType']/div[text()='" + type + "']/..")).click();
		//driver.findElement(By.xpath("//button[@id='cabinType']/div[2]")).click();
			
	}
	
	public static void clickFindFlights() {
		
		driver.findElement(By.xpath("//button/span[text()='Find flights']/..")).submit();
		
	}


	


}
