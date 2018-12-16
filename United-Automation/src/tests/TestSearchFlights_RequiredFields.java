package tests;

import javax.swing.JOptionPane;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.PageBase;
import common.TestData;
import pages.FlightSelectionPage;
import pages.HomePage;

public class TestSearchFlights_RequiredFields extends PageBase {

	@BeforeClass
	public void setUp() throws Exception {
		
		// Set up Chrome driver - Enter to United Web site
		setUpDriver();
		
	}
	
	@Test
	public void testSearchFlight_RequiredFields() throws InterruptedException {
		
		// Click "Find flights" button without having entered required fields
		HomePage.clickFindFlights();
		
		// Verify that there are errors for the required fields
		HomePage.verifyErrorMessagesRequiredFields();
		
		// Fill in "From" field
		HomePage.enterOrigin(TestData.cityOrigin);
		HomePage.verifyErrorMessagesRequiredFields();
		
		// Fill in "To" field
		HomePage.enterDestination(TestData.cityDestination);
		HomePage.verifyErrorMessagesRequiredFields();
		
		// Enter Departure date
		HomePage.enterDepartureDate(TestData.departureDate);
		HomePage.hideCalendar();
		HomePage.clickFindFlights();
		HomePage.verifyErrorMessagesRequiredFields();
	
		// Enter Return date
		HomePage.enterReturnDate(TestData.returnDate);
		HomePage.verifyErrorMessagesRequiredFields();
		
		// Select number of travelers
		HomePage.clickSelectTravelers();
		HomePage.selectTravelers("Adults", TestData.numTravelersAdult);
		HomePage.verifyAmountTravelers();
		
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
