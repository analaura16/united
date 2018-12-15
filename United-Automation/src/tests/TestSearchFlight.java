package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import common.PageBase;
import common.TestData;
import pages.FlightSelectionPage;
import pages.HomePage;
//import pages.ListingPage;

import javax.swing.JOptionPane;


public class TestSearchFlight extends PageBase {

	@BeforeClass
	public void setUp() throws Exception {
		
		// Set up Chrome driver
		// 1- Enter to United Web site
		setUpDriver();
		
	}
	
	@Test
	public void testSearchFlight() throws InterruptedException {
		
		 /*
		  * Book a flight
	     	Navigate to https://www.united.com/en/us/
	     	Select flight
	     	Fill the required info (from* , to*, dates, travelers , class)
	     	Click on find fights
	     	Verify that some results are displayed
		*/
		
		HomePage.enterOrigin(TestData.cityOrigin);
		HomePage.enterDestination(TestData.cityDestination);
		HomePage.enterDepartureDate(TestData.departureDate);
		HomePage.enterReturnDate(TestData.returnDate);
		HomePage.clickSelectTravelers();
		HomePage.selectTravelers("Adults", TestData.numTravelersAdult);
		HomePage.verifyAmountTravelers();
		
		//HomePage.selectTravelers("Infants on lap", "1");
		//HomePage.selectTravelerCategory(TestData.premiumEconomy);
		HomePage.clickFindFlights();
		
		FlightSelectionPage.verifySearchData(TestData.cityOrigin, TestData.cityDestination, TestData.departureDate, TestData.returnDate);
		
	
	}
	
	@AfterClass
	public void finishTest() {
		
		System.out.println("Test finished.");		
	    JOptionPane.showMessageDialog(frame, "Test finished.");
		driver.close();
		driver.quit();
		
	}
}
