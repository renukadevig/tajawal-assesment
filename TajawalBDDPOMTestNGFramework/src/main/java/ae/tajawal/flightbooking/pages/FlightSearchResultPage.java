package ae.tajawal.flightbooking.pages;

import java.awt.Dimension;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.pages.responses.CartPageResponseDTO;
import ae.tajawal.flightbooking.pages.responses.FlightSearchRPResponseDTO;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO;
import ae.tajawal.flightbooking.pages.responses.CartPageResponseDTO.CartFeeData;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO.SearchData;
import ae.tajawal.flightbooking.util.DateUtil;
import ae.tajawal.flightbooking.util.NumberUtil;

public class FlightSearchResultPage extends TestBase {
	
//Emirates_assert_page2
	
	WebDriverWait wait = new WebDriverWait(driver,40);				
			
	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__OriginCityLabel']")
	WebElement originCity;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResults__DestinationCityLabel']")
	WebElement destinationCity;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResults__DepartureDateLabel']")
	WebElement departureDate;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResults__ArrivalDateLabel']")
	WebElement arrivalDate;
	
	
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResults__PassengersCountLabel']")
	WebElement passengerCount;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResults__CabinTypeLabel']")
	WebElement cabinType;
	
		
	@FindBy(xpath="//div/input[@data-testid='FlightSearchResult__AirlinesFilter__Flight1AirlineSGCheckbox']/parent::div/label[contains(text(),'SG: Spicejet')]")
	WebElement airlinechkbox11;
	
	@FindBy(xpath="//div/input[@data-testid='FlightSearchResult__AirlinesFilter__Flight2AirlineSGCheckbox']/parent::div/label[contains(text(),'SG: Spicejet')]")
	WebElement airlinechkbox22;
	
	@FindBys(@FindBy(xpath="//div[@class='search-result-leg-card sc-krvtoX hYkmLE sc-bYSBpT dTBkYG row']"))
	List<WebElement> itineraryLegcount;
	
	@FindBys(@FindBy(xpath="//div[starts-with(@data-testid,'FlightSearchResult__Itinerary') and contains(text(),'Spicejet')]"))
	List<WebElement> airlineLabelcount;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResult__Itinerary1__CurrencyLabel']")
	WebElement currenyLabel;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchResult__Itinerary1__PriceLabel']")
	WebElement priceLabel;
	
	@FindBy(xpath="//button[@data-testid='FlightSearchResult__Itinerary1__SelectFlightButton']")
	WebElement selectflightButton;
	
	@FindBy(xpath="//span[contains(text(),'Price')]/parent::a[starts-with(@data-testid,'FlightSearchResult__Sorting__Price—-HighestFirstSelected')]")
	WebElement Pricehyperlink;
	
	@FindBys(@FindBy(xpath="//div[starts-with(@data-testid,'FlightSearchResult__Itinerary')  and substring(@data-testid, string-length(@data-testid) - 9, string-length(@data-testid)) = 'PriceLabel']"))
	List<WebElement> priceDetails;
	
	
		
	
	
	// Initializing the Page Objects:
	public FlightSearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public String[] fetchSummaryInfo(){
		
		//HomeSerachPageRequestDTO.SearchData testData=(new HomeSerachPageRequestDTO()).new SearchData();
		
		System.out.println("fetchsummary method called");
		
		
		String arr[]=new String[6];
		
		WebElement originCity1=wait.until(ExpectedConditions.visibilityOf(originCity));
		arr[0]=originCity1.getText();
		
		arr[1]=destinationCity.getText();
		arr[2]=departureDate.getText();
		arr[3]=arrivalDate.getText();
		arr[4]=passengerCount.getText();
		arr[5]= cabinType.getText();
		return arr;
		
		
		//DateUtil.parseDateEEEDDMM(departureDate.getText());	
	}
	
	public void selectAirlinecheckbox() {
		WebElement airlineChkboxArrival=wait.until(ExpectedConditions.elementToBeClickable(airlinechkbox11));
		airlineChkboxArrival.click();
		
		WebElement airlineChkboxDeparture=wait.until(ExpectedConditions.elementToBeClickable(airlinechkbox22));
		airlineChkboxDeparture.click();
		
		
	}
	
	public int getitineraryLegcount() {
		return itineraryLegcount.size();
		
		
	}
	
	public int getairlineLabelcount() {
		return airlineLabelcount.size();
		
		
	}
	public FlightSearchRPResponseDTO.IternaryPriceData fetchItinerary1Price() {
		
		FlightSearchRPResponseDTO.IternaryPriceData iternaryPriceData=(new FlightSearchRPResponseDTO()).new IternaryPriceData();
		iternaryPriceData.priceCurrency=currenyLabel.getText();
		WebElement priceLabel1=wait.until(ExpectedConditions.visibilityOf(priceLabel));		
		iternaryPriceData.price=NumberUtil.commaSeperatedDouble(priceLabel1.getText());
		return iternaryPriceData;		
	}
	
	public void selectI1Flight() {
		selectflightButton.click();
	}
	
	public void priceSortClick() throws InterruptedException {
	Thread.sleep(8000);
	//
	WebElement sortActionElement=null;
	try {
		sortActionElement=Pricehyperlink;
		
	} catch (Exception e) {
		System.out.println("Unable to find highest sort item");
	}
	if(sortActionElement!=null && sortActionElement.isDisplayed() && sortActionElement.isEnabled()) {
		sortActionElement.click();
	}
	
	}
	
	public Number priceOfInterestNum() {
	
	WebElement priceLabelInterested=wait.until(ExpectedConditions.visibilityOf(priceLabel));
	String priceOfInterest=priceLabelInterested.getText();
	System.out.println(priceOfInterest);
	Number priceOfInterestNum=null;
	try {
		priceOfInterestNum = NumberFormat.getNumberInstance(java.util.Locale.US).parse(priceOfInterest);
	} catch (ParseException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return priceOfInterestNum;
	}
	
	
	public int pricelabelscount() {
	
	int pricelabelscount=priceDetails.size();
	System.out.println(pricelabelscount);
	return pricelabelscount;
	}
	
	

}
