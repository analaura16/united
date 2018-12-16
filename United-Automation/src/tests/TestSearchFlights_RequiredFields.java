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
		
		 /*
		  * Book a flight
	     	Navigate to https://www.united.com/en/us/
	     	Select flight
	     	Fill the required info (from* , to*, dates, travelers , class)
	     	Click on find fights
	     	Verify that some results are displayed
		*/
		// Click "Find flights" button without having entered required fields
		HomePage.clickFindFlights();
		
		// Verify that there are errors for the required fields
		HomePage.verifyErrorMessagesRequiredFields();
		
		HomePage.enterOrigin(TestData.cityOrigin);
		HomePage.verifyErrorMessagesRequiredFields();
		
		HomePage.enterDestination(TestData.cityDestination);
		HomePage.verifyErrorMessagesRequiredFields();
		
		HomePage.enterDepartureDate(TestData.departureDate);
		HomePage.hideCalendar();
		HomePage.clickFindFlights();
		HomePage.verifyErrorMessagesRequiredFields();
		
		HomePage.enterReturnDate(TestData.returnDate);
		HomePage.verifyErrorMessagesRequiredFields();
		
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
	    //JOptionPane.showMessageDialog(frame, "Test finished.");
		driver.close();
		driver.quit();
		
	}
	
}
