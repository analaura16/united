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
		
		// Set up Chrome driver - Enter to United Web site
		setUpDriver();
		
	}
	
	@Test
	public void testSearchFlight() throws InterruptedException {
		
		// Fill in "From" field		
		HomePage.enterOrigin(TestData.cityOrigin);
		
		// Fill in "To" field
		HomePage.enterDestination(TestData.cityDestination);
		
		// Enter Departure date
		HomePage.enterDepartureDate(TestData.departureDate);
		
		// Enter Return date
		HomePage.enterReturnDate(TestData.returnDate);
		
		// Select number of travelers
		HomePage.clickSelectTravelers();
		HomePage.selectTravelers("Adults", TestData.numTravelersAdult);
		HomePage.verifyAmountTravelers();
		
		//HomePage.selectTravelerCategory(TestData.premiumEconomy);
		
		// Click "Find flights" button
		HomePage.clickFindFlights();
		
		// Verify that the data displayed corresponds to the data entered in previous steps
		FlightSelectionPage.verifySearchData(TestData.cityOrigin, TestData.cityDestination, TestData.departureDate, TestData.returnDate);
	
	}
	
		
	@AfterClass
	public void finishTest() {
		
		System.out.println("Test finished.");		
	    //JOptionPane.showMessageDialog(frame, "Test finished.");
		driver.close();
		driver.quit();
		
	}
}
