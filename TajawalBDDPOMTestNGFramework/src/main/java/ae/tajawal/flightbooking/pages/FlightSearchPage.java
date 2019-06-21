package ae.tajawal.flightbooking.pages;

import java.util.ArrayList;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ae.tajawal.flightbooking.common.TestBase;

/**
 * @author Renuka Devi G
 *
 */
public class FlightSearchPage extends TestBase {
	static final Logger logger = Logger.getLogger(FlightSearchPage.class);

	@FindBy(xpath = "//input[@data-testid='FlightSearchBox__FromAirportInput']")
	WebElement origin;

	@FindBy(xpath = "//li[@data-testid='FlightSearchBox__AirportOption0']")
	WebElement originList;

	@FindBy(xpath = "//input[@data-testid='FlightSearchBox__ToAirportInput']")
	WebElement destination;

	@FindBy(xpath = "//li[@data-testid='FlightSearchBox__AirportOption0']")
	WebElement destinationList;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__FromDateButton']")
	WebElement fromDateButton;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__ToDateButton']")
	WebElement ToDateButton;

	@FindBy(xpath = "//div[@aria-label='Mon Jul 01 2019']")
	WebElement fromDate;

	@FindBy(xpath = "//div[@aria-label='Mon Jul 15 2019']")
	WebElement toDate;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__CabinTypeDropdown']")
	WebElement cabinTypeDropdown;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__CabinTypeDropdown']/div[2]/a[contains(text(),'Economy')]")
	WebElement cabinTypeDropdownValue;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__PaxDropdown']")
	WebElement paxDropdown;

	@FindBy(xpath = "//div[@data-testid='FlightSearchBox__PaxDropdown']/div[2]//div[@data-testid='FlightSearchPAXSelection__AdultsPlusButton']")
	WebElement paxDropdownvalue;

	@FindBy(xpath = "//button[@data-testid='FlightSearchBox__SearchButton']")
	WebElement searchButton;

	// Initializing the Page Objects:
	public FlightSearchPage() {
		PageFactory.initElements(driver, this);

	}

	String departure;
	String arrival;

	public void enterSearchDetails() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 50);

		Random array = new Random();
		ArrayList<String> Origin = new ArrayList<String>();
		Origin.add("Chennai");
		Origin.add("Kochi");

		int i = array.nextInt(2);

		origin.sendKeys(Origin.get(i));
		origin.click();
		logger.info("createNewContact method called");
		Thread.sleep(2000);
		departure = originList.getText();

		WebElement OriginList1 = wait.until(ExpectedConditions.elementToBeClickable(originList));
		OriginList1.click();

		Random array1 = new Random();
		ArrayList<String> Destination = new ArrayList<String>();
		Destination.add("Dubai");
		Destination.add("Bahrain");
		int j = array1.nextInt(2);

		destination.sendKeys(Destination.get(j));
		destination.click();
		Thread.sleep(2000);

		arrival = destinationList.getText();
		WebElement DestinationList1 = wait.until(ExpectedConditions.elementToBeClickable(destinationList));
		DestinationList1.click();

		fromDateButton.click();

		fromDate.click();

		toDate.click();
		cabinTypeDropdown.click();
		cabinTypeDropdownValue.click();
		paxDropdown.click();
		paxDropdownvalue.click();

	}

	String ognCountry1;
	String arrCountry1;

	public String[] fetchArrivalDestinationList() {
		String[] origincountry = departure.split(",");
		String ognCountry = origincountry[0].trim();

		String[] destcountry = arrival.split(",");
		String arrCountry = destcountry[0].trim();

		String[] roundtrip = { ognCountry, arrCountry };
		return roundtrip;
	}

	public void clickSearchButton() {
		searchButton.click();
	}

}
