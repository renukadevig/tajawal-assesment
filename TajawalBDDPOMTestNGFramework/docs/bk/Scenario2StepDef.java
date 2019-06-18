package ae.tajawal.flightbooking.stepdef;



import static org.junit.Assert.*;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.pages.CartPage;
import ae.tajawal.flightbooking.pages.FlightSearchResultPage;
import ae.tajawal.flightbooking.pages.HomeSearchPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Scenario2StepDef extends TestBase{
	
	HomeSearchPage homeSearchPage;
	FlightSearchResultPage FlightSearchResultPage;
	CartPage CartPage;
	//String sheetName = "contacts";
	
	   
	public Scenario2StepDef(){
			super();
			
	}
	
	
	//@Before
	public void setUp() throws InterruptedException {
		
		initialization();
		
		homeSearchPage = new HomeSearchPage();
		FlightSearchResultPage = new FlightSearchResultPage();
		CartPage = new CartPage();
		
}
	
	//@Given("^Search input details should be entered in searchFlightdetails screen$")
	public void enterFlightInputDetails(){
		homeSearchPage.createNewContact();
	}
	
	
	//@When("^Click on Search Flights button in searchFlightdetails screen$")
	public void clickSearchButton(){
		homeSearchPage.searchButton();
	}
	
	
	
	

}
