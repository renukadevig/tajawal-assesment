package ae.tajawal.flightbooking.pages;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO;
import ae.tajawal.flightbooking.pages.responses.HomeSerachPageRequestDTO.SearchData;
import ae.tajawal.flightbooking.util.DateUtil;

public class HomeSearchPage extends TestBase {

	@FindBy(xpath = "//input[@data-testid='FlightSearchBox__FromAirportInput']")
	WebElement origin;
	
	@FindBy(xpath="//input[@placeholder='Origin']//parent::div[1]//following-sibling::ul/li[2]")
	WebElement originList;
	
	@FindBy(xpath="//input[@placeholder='Destination']")
	WebElement destination;
	
	@FindBy(xpath="//input[@placeholder='Destination']//parent::div[1]//following-sibling::ul/li[3]")
	WebElement destinationList;
	
	
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__FromDateButton']")
	WebElement fromDateButton;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__ToDateButton']")
	WebElement ToDateButton;
	
	@FindBy(xpath="//div[@aria-label='Mon Jul 01 2019']")
	WebElement fromDate;
	
	@FindBy(xpath="//div[@aria-label='Mon Jul 15 2019']")
	WebElement toDate;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__CabinTypeDropdown']")
	WebElement cabinTypeDropdown;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__CabinTypeDropdown']/div[2]/a[contains(text(),'Economy')]")
	WebElement cabinTypeDropdownValue;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__PaxDropdown']")
	WebElement paxDropdown;
	
	@FindBy(xpath="//div[@data-testid='FlightSearchBox__PaxDropdown']/div[2]//div[@data-testid='FlightSearchPAXSelection__AdultsPlusButton']")
	WebElement paxDropdownvalue;
	
	@FindBy(xpath="//button[@data-testid='FlightSearchBox__SearchButton']")
	WebElement searchButton;
		
	
	
	// Initializing the Page Objects:
	public HomeSearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	public void createNewContact(){
		
		//HomeSerachPageRequestDTO.SearchData testData=getTestData();
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		Random array = new Random();
    	ArrayList<String> Origin = new ArrayList<String>();
    	Origin.add("Dubai");
    	Origin.add("Chennai");
    	Origin.add("Kochi");
    	int i = array.nextInt(3);
		
		origin.sendKeys(Origin.get(i));
		System.out.println("createNewContact method called");
		
		WebElement OriginList1=wait.until(ExpectedConditions.elementToBeClickable(originList));
		OriginList1.click();
		
		Random array1 = new Random();
    	ArrayList<String> Destination = new ArrayList<String>();
    	Destination.add("Dubai");
    	Destination.add("Chennai");
    	Destination.add("Kochi");
    	int j = array1.nextInt(3);
    	
		destination.sendKeys(Destination.get(j));
		
		WebElement DestinationList1=wait.until(ExpectedConditions.elementToBeClickable(destinationList));
		DestinationList1.click();
		
		fromDateButton.click();
		
		fromDate.click();
		
		toDate.click();
		cabinTypeDropdown.click();
		cabinTypeDropdownValue.click();
		paxDropdown.click();
		paxDropdownvalue.click();
		
		//setting Data for response
		//return testData;
				
	}
	
	/*private SearchData getTestData() {
		HomeSerachPageRequestDTO.SearchData testData=(new HomeSerachPageRequestDTO()).new SearchData();
		testData.destination="Kochi";
		testData.origin="Dubai";
		testData.passengerAdultCount=2;
		testData.cabinType="Economy";
		testData.depatureDate=DateUtil.parseDateEEEDDMM("Mon, 01/07");
		testData.returnDate=DateUtil.parseDateEEEDDMM("Mon, 15/07");		
		return testData;
	}
*/

	public String[] getInputText()
	{
		
		String[] getInputText= {origin.getText(),destination.getText(),fromDateButton.getText(),ToDateButton.getText(),cabinTypeDropdown.getText(),paxDropdown.getText()};
		return getInputText;
	}



	public void searchButton(){
		searchButton.click();
	}
	

}
