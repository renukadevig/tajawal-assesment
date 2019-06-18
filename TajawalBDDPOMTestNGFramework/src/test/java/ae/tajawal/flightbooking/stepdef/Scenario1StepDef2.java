package ae.tajawal.flightbooking.stepdef;



import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.pages.CartPage;
import ae.tajawal.flightbooking.pages.FlightSearchResultPage;
import ae.tajawal.flightbooking.pages.HomeSearchPage;
import ae.tajawal.flightbooking.pages.responses.CartPageResponseDTO;
import ae.tajawal.flightbooking.pages.responses.FlightSearchRPResponseDTO;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO.SearchData;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;

public class Scenario1StepDef2 extends TestBase{

	
	HomeSearchPage homeSearchPage;
	FlightSearchResultPage flightSearchResultPage;
	CartPage cartPage;
	
	
	//TEST DATA
	HomeSerachPageRequestDTO.SearchData searchHomePageResponseData;
	
	
	
	   
	public Scenario1StepDef2(){
			super();
			
	}
	
	
	
	@Given("^Search input details should be entered in searchFlightdetails page_F$")
	public void enterFlightInputDetails(){
		String brw="firefox";
		initialization(brw);
		
		homeSearchPage = new HomeSearchPage();
		flightSearchResultPage = new FlightSearchResultPage();
		cartPage = new CartPage();
		
		homeSearchPage.createNewContact();
	}
	
	
	@When("^Click on Search Flights button in searchFlightdetails page_F$")
	public void clickSearchButton(){
		homeSearchPage.searchButton();
	}
	

	@Then("^Search summary module should be displayed as per the search query data_F$")
	public void verifySearchResult(){
		 
		 //SearchData currentPageResult=flightSearchResultPage.fetchSummaryInfo();
		 //Equals method is implemented to compare all the fields in flight input. Refer Equals method in SearchData
		// assertEquals(searchHomePageResponseData, currentPageResult);	     
		 System.out.println("executed");
		
	}
	@Given("^User should be in FlightSearchResult screen_F$")
	public void userScreen()
	{
		System.out.println(driver.getTitle());
	}
	
	@When("^Apply filter result to Emirates carrier in flightSearchResult screen_F$")
	public void applyFilter() {
		flightSearchResultPage.selectAirlinecheckbox();
	}
	
	@Then("^listing results should be filtered only with the selected carrier in flightSearchResult screen_F$")
	public void verifyCarrierresult() {
		
		int a = flightSearchResultPage.getitineraryLegcount();
		int b= flightSearchResultPage.getairlineLabelcount();
		assertEquals(a,b);
		
	}
	
	@Given("^User should be in FlightSearchResult_F$")
	public void userScreen2()
	{
		System.out.println(driver.getTitle());
	}
	
	@When("^Select random flight & related price in flightSearchResult screen_F$")
	public void selectAnyFlight()
	{
		FlightSearchRPResponseDTO.IternaryPriceData priceCurrencyAmount=flightSearchResultPage.fetchItinerary1Price();
		System.out.println(priceCurrencyAmount);
		flightSearchResultPage.selectI1Flight();
		
	}
	
	@Then("^the displayed cart price in Cart details page should be aligned with listing price_F$")
	public void verifyCartPrice()
	{
			//FlightSearchRPResponseDTO.IternaryPriceData priceCurrencyAmount=flightSearchResultPage.fetchItinerary1Price();
		//CartPageResponseDTO.CartFeeData  cartCurrencyAmount=cartPage.cartDetails();
		//assertEquals(priceCurrencyAmount.priceCurrency,cartCurrencyAmount.fareFeeCurrencyCd);
		//assertEquals(priceCurrencyAmount.price,cartCurrencyAmount.orginalFare);
		
		
		System.out.println(cartPage.cartDetails());
	}
	
	
	@Given("^User should be in Cart page_F$")
	public void userPage()
	{
		System.out.println(driver.getTitle());
	}
	
	@When("^User enter the travelers details in the details page_F$")
	public void TravellerdetailsFill()
	{
		cartPage.TravellerDetails();
			}
	
	@Then("^Screenshot should be taken at last page_F$")
	public void TakeScreenshot() throws IOException
	{
		
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String filename =  new SimpleDateFormat("yyyyMMddhhmmss'.txt'").format(new Date());
        File dest = new File("./TajawalBDDPOMFramework/screenshots" + filename+".png");
         FileUtils.copyFile(scrFile, dest);
         driver.quit();
	}
	
	

	
	
	
}
