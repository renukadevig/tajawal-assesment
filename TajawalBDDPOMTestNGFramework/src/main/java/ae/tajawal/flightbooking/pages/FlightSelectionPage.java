package ae.tajawal.flightbooking.pages;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.csv.CSVPrinter;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.constants.DirectoryConstants;
import ae.tajawal.flightbooking.pages.responses.FlightSelectionPageDTO;
import ae.tajawal.flightbooking.util.CSVUtil;
import ae.tajawal.flightbooking.util.DateUtil;
import ae.tajawal.flightbooking.util.FileUtil;
import ae.tajawal.flightbooking.util.NumberUtil;

/**
 * @author Renuka Devi G
 *
 */
public class FlightSelectionPage extends TestBase {

	static final Logger logger = Logger.getLogger(FlightSelectionPage.class);

	WebDriverWait wait = new WebDriverWait(driver, 80);

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__OriginCityLabel']")
	WebElement originCity;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__DestinationCityLabel']")
	WebElement destinationCity;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__DepartureDateLabel']")
	WebElement departureDate;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__ArrivalDateLabel']")
	WebElement arrivalDate;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__PassengersCountLabel']")
	WebElement passengerCount;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResults__CabinTypeLabel']")
	WebElement cabinType;

	@FindBy(xpath = "//span[contains(text(),'Airlines')]/parent::div/following-sibling::div/div[2]/a[contains(text(),'Show all')]")
	WebElement showAirlineAll;

	@FindBy(xpath = "//input[@data-testid='FlightSearchResult__AirlinesFilter__Flight1AirlineAICheckbox']/following-sibling::label")
	WebElement chkboxselectai;

	@FindBy(xpath = "//input[@data-testid='FlightSearchResult__AirlinesFilter__Flight1AirlineEKCheckbox']/following-sibling::label")
	WebElement chkboxselectemirates;

	@FindBys(@FindBy(xpath = "//input[@data-testid='FlightSearchResult__AirlinesFilter__Flight1AirlineEKCheckbox']/following-sibling::label"))
	List<WebElement> chkboxselectemiratesall;

	@FindBys(@FindBy(xpath = "//div[@class='search-result-leg-card sc-krvtoX hYkmLE sc-bYSBpT dTBkYG row']"))
	List<WebElement> itineraryLegcount;

	@FindBys(@FindBy(xpath = "//div[starts-with(@data-testid,'FlightSearchResult__Itinerary') and contains(text(),'Spicejet')]"))
	List<WebElement> airlineLabelcount;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResult__Itinerary1__CurrencyLabel']")
	WebElement currenyLabel;

	@FindBy(xpath = "//div[@data-testid='FlightSearchResult__Itinerary1__PriceLabel']")
	WebElement priceLabel;

	@FindBy(xpath = "//button[@data-testid='FlightSearchResult__Itinerary1__SelectFlightButton']")
	WebElement selectflightButton;

	@FindBy(xpath = "//span[contains(text(),'Price')]/parent::a[starts-with(@data-testid,'FlightSearchResult__Sorting__Price—-HighestFirstSelected')]")
	WebElement Pricehyperlink;

	@FindBys(@FindBy(xpath = "//div[starts-with(@data-testid,'FlightSearchResult__Itinerary')  and substring(@data-testid, string-length(@data-testid) - 9, string-length(@data-testid)) = 'PriceLabel']"))
	List<WebElement> priceDetails;

	// Initializing the Page Objects:
	public FlightSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	public String[] fetchSummaryInfo() throws InterruptedException {

		logger.info("fetchsummary method called");

		String arr[] = new String[6];
		Thread.sleep(2000);
		WebElement originCity1 = wait.until(ExpectedConditions.visibilityOf(originCity));
		String depart;
		depart = originCity1.getText();

		if (depart == "MAA") {
			depart = "Chennai";
		} else if (depart == "KCZ") {
			depart = "Kochi";
		} else
			depart = depart;

		String arrv;
		arrv = destinationCity.getText();

		if (arrv == "DXB") {
			arrv = "Dubai";
		} else if (arrv == "BAH") {
			arrv = "Bahrain";
		} else
			arrv = arrv;

		arr[0] = depart;

		arr[1] = arrv;
		arr[2] = departureDate.getText();
		arr[3] = arrivalDate.getText();
		arr[4] = passengerCount.getText();
		arr[5] = cabinType.getText();
		return arr;

		// DateUtil.parseDateEEEDDMM(departureDate.getText());
	}

	public void selectAirlinecheckbox() {

		WebElement showAirlines = wait.until(ExpectedConditions.elementToBeClickable(showAirlineAll));
		showAirlines.click();
		logger.info(chkboxselectemiratesall.size());

		if ((chkboxselectemiratesall.size()) >= 1) {
			WebElement emirateschkboxselect = wait.until(ExpectedConditions.elementToBeClickable(chkboxselectemirates));
			emirateschkboxselect.click();
		} else {
			WebElement aichkboxselect = wait.until(ExpectedConditions.elementToBeClickable(chkboxselectai));
			aichkboxselect.click();
		}

		logger.info("checked");

	}

	public String fetchAirlineDetails() {

		String airlineNameChecked;

		if ((chkboxselectemiratesall.size()) >= 1) {
			WebElement emirateschkboxgettext = wait
					.until(ExpectedConditions.elementToBeClickable(chkboxselectemirates));
			airlineNameChecked = emirateschkboxgettext.getText();
		} else {
			WebElement aichkboxchkbox = wait.until(ExpectedConditions.elementToBeClickable(chkboxselectai));
			airlineNameChecked = aichkboxchkbox.getText();
		}

		String[] airlines = airlineNameChecked.split(":");
		String airlinesFilter = airlines[1].trim();
		logger.info(airlinesFilter);
		return airlinesFilter;
	}

	public List<String> fetchAllAirlineNames() {

		List<String> airlineListNames = new ArrayList();

		List<WebElement> airlineNameElements = driver.findElements(By.xpath(
				"//div[starts-with(@data-testid,'FlightSearchResult__Itinerary')  and substring(@data-testid, string-length(@data-testid) - 11, string-length(@data-testid)) = 'AirlineLabel']"));
		airlineNameElements.size();
		for (int i = 0; i < airlineNameElements.size(); i++) {
			airlineListNames.add(airlineNameElements.get(i).getText());
		}
		return airlineListNames;
	}

	public FlightSelectionPageDTO.IternaryPriceData fetchItineraryPrice() {

		FlightSelectionPageDTO.IternaryPriceData iternaryPriceData = (new FlightSelectionPageDTO()).new IternaryPriceData();
		iternaryPriceData.priceCurrency = currenyLabel.getText();
		WebElement priceLabel1 = wait.until(ExpectedConditions.visibilityOf(priceLabel));
		iternaryPriceData.price = NumberUtil.commaSeperatedDouble(priceLabel1.getText());
		logger.info("PL:" + priceLabel1.getText());
		logger.info("ITNPrce:" + iternaryPriceData.price);
		return iternaryPriceData;

	}

	public void selectFlight() {
		selectflightButton.click();
	}

	public void priceSortClick() throws InterruptedException {
		Thread.sleep(8000);
		//
		WebElement sortActionElement = null;
		try {
			sortActionElement = Pricehyperlink;

		} catch (Exception e) {
			logger.error("Unable to find highest sort item");
		}
		if (sortActionElement != null && sortActionElement.isDisplayed() && sortActionElement.isEnabled()) {
			sortActionElement.click();
		}

	}

	public FlightSelectionPageDTO.SortingChecker sortingCheck() {

		FlightSelectionPageDTO.SortingChecker sortingChecker = (new FlightSelectionPageDTO()).new SortingChecker();

		WebElement priceLabelInterested = wait.until(ExpectedConditions.visibilityOf(priceLabel));
		String priceOfInterest = priceLabelInterested.getText();
		logger.info(priceOfInterest);
		Number priceOfInterestNum = null;
		try {
			priceOfInterestNum = NumberFormat.getNumberInstance(java.util.Locale.US).parse(priceOfInterest);
			sortingChecker.firstElementPrice = priceOfInterestNum.doubleValue();
		} catch (ParseException e1) {

			logger.error("error in sort check", e1);
		}

		List<WebElement> pricelabels = driver.findElements(By.xpath(
				"//div[starts-with(@data-testid,'FlightSearchResult__Itinerary')  and substring(@data-testid, string-length(@data-testid) - 9, string-length(@data-testid)) = 'PriceLabel']"));

		int pricelabelscount = priceDetails.size();
		// logger.info(pricelabelscount);

		List<Double> priceList = new ArrayList<Double>();

		for (WebElement element : pricelabels) {
			String elementText = element.getText();
			logger.info("Working on value " + elementText);
			try {
				Number convertedToNumber = NumberFormat.getNumberInstance(java.util.Locale.US).parse(elementText);
				if (convertedToNumber != null)
					priceList.add(convertedToNumber.doubleValue());
			} catch (ParseException e) {

				logger.error("error in sort check", e);
			}
		}
		List<String> flightsList = fetchAllAirlineNames();

		printDataToCSV(flightsList, priceList);

		if (priceOfInterestNum != null && priceList != null && !priceList.isEmpty()) {
			// Scenario one comparing the lowest price with the price displayed as per page
			// view
			if (priceOfInterestNum == priceList.get(0)) {
				logger.info("First price is equal to the top price element");
			}

			Collections.sort(priceList);
			logger.info("Sorting completed");

			Double firstPriceItem = priceList.get(0);

			sortingChecker.lowestPrice = firstPriceItem;

			if (priceOfInterestNum.doubleValue() == firstPriceItem) {
				logger.info("*** This test case is success, first element is the lowest !");
			} else {
				logger.info("*** This test case is failed, first element is not the lowest !");
			}
		} else {
			logger.error("ERROR, unable to execute the sceanrio as required values are not compatible");
		}

		return sortingChecker;
	}

	private void printDataToCSV(List<String> flightsList, List<Double> priceList) {
		boolean folderExists = FileUtil.ensureFolderExistence(DirectoryConstants.DATA_EXPORT_FOLDER);
		if (folderExists) {
			String fileName = DirectoryConstants.DATA_EXPORT_FOLDER + "/AirlineDetailsData_"
					+ DateUtil.getCurrentTimeString() + ".csv";
			logger.info("Start priinting");

			String[] headers = { "Airline", "Price" };
			CSVPrinter csvPrinter = CSVUtil.createCSVFile(fileName, headers);

			for (int i = 0; i < priceList.size(); i++) {
				String currentFligt = flightsList.get(i);
				String currentPrice = Double.toString(priceList.get(i));
				String[] values = { currentFligt, currentPrice };
				CSVUtil.writeRecord(csvPrinter, values);
			}
			logger.info("End priinting");
		} else {
			logger.info("Error in folder creation of printDataToCSV ");
		}

	}

}
