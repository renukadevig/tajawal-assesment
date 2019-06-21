package ae.tajawal.flightbooking.stepdef;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.constants.DirectoryConstants;
import ae.tajawal.flightbooking.pages.FlightCartPage;
import ae.tajawal.flightbooking.pages.FlightSearchPage;
import ae.tajawal.flightbooking.pages.FlightSelectionPage;
import ae.tajawal.flightbooking.pages.responses.FlightCartPageDTO;
import ae.tajawal.flightbooking.pages.responses.FlightSearchPageDTO;
import ae.tajawal.flightbooking.pages.responses.FlightSelectionPageDTO;
import ae.tajawal.flightbooking.util.DateUtil;
import ae.tajawal.flightbooking.util.FileUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Renuka Devi G
 *
 */
public class StepDefinition extends TestBase {
	static final Logger logger = Logger.getLogger(StepDefinition.class);

	FlightSearchPage flightSearchPage;
	FlightSelectionPage flightSelectionPage;
	FlightCartPage flightCartPage;

	String flightInputs[];

	// TEST DATA
	FlightSearchPageDTO.SearchData searchHomePageResponseData;

	FlightSelectionPageDTO.IternaryPriceData priceCurrencyAmount;

	public StepDefinition() {
		super();

	}

	// @Parameters({ "browser" })
	@Given("^Search input details should be entered in searchFlightdetails page$")
	public void enterFlightInputDetails(
	// String browser
	) throws InterruptedException {
		String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
		logger.info("--------------------browser:" + browser + "-----------------------------");
		initialization(browser);

		flightSearchPage = new FlightSearchPage();
		flightSelectionPage = new FlightSelectionPage();
		flightCartPage = new FlightCartPage();

		flightSearchPage.enterSearchDetails();
		flightInputs = flightSearchPage.fetchArrivalDestinationList();
	}

	@When("^Click on Search Flights button in searchFlightdetails page$")
	public void clickSearchButton() {
		flightSearchPage.clickSearchButton();
	}

	@Then("^Search summary module should be displayed as per the search query data$")
	public void verifySearchResult() throws InterruptedException {

		String currentPageResult[] = flightSelectionPage.fetchSummaryInfo();

		assertEquals(flightInputs[0], currentPageResult[0].trim());
		assertEquals(flightInputs[1], currentPageResult[1].trim());
		assertEquals("Mon, 01/07", currentPageResult[2]);
		assertEquals("Mon, 15/07", currentPageResult[3]);
		assertEquals("2", currentPageResult[4]);
		assertEquals("Economy", currentPageResult[5]);

	}

	@When("^Apply filter to carrier Emirates or Air India$")
	public void applyFilter() {
		flightSelectionPage.selectAirlinecheckbox();
	}

	@Then("^listing results should be filtered only with the selected carrier in flightSearchResult screen$")
	public void verifyCarrierResult() {

		logger.info("Inside verifyCarrierresult StepDefinition - yet to create code for comparison");
		String selectedAirlineName = flightSelectionPage.fetchAirlineDetails();
		List<String> airlineNamesInResult = flightSelectionPage.fetchAllAirlineNames();

		// Remove duplicates from the list. Using LinkedHashSet to preserve insertion
		// order for further use cases.
		Set<String> airlineNamesInResultUnique = new LinkedHashSet<String>(airlineNamesInResult);

		logger.info("---------- before removing duplicates -----------");
		for (String airlineName : airlineNamesInResult)
			logger.info(airlineName);
		logger.info("---------- after removing duplicates -----------");
		for (String airlineName : airlineNamesInResultUnique)
			logger.info(airlineName);

		assertEquals(airlineNamesInResultUnique.size(), 1);
		assertEquals(airlineNamesInResultUnique.contains(selectedAirlineName), true);

	}

	@When("^Click on Price sort if Price is not already sorted with ascending order$")
	public void priceSort() {
		logger.info("By default it is sorted with ascending order in the screen, so no need to sort");
	}

	@Then("^verify the first listed price is the cheapest one compare to the others$")
	public void sortPrice() {
		logger.info("Getting FlightSelectionPageDTO.IternaryPriceData ");
		priceCurrencyAmount = flightSelectionPage.fetchItineraryPrice();
		logger.info("PriceItenary:" + priceCurrencyAmount);

		FlightSelectionPageDTO.SortingChecker sortingChecker = flightSelectionPage.sortingCheck();
		assertEquals(sortingChecker.firstElementPrice, sortingChecker.lowestPrice);
	}

	@When("^Select random flight & related price in flightSearchResult screen$")
	public void selectAnyFlight() {

		flightSelectionPage.selectFlight();

	}

	@Then("^the displayed cart price in Cart details page should be aligned with listing price$")
	public void verifyCartPrice() {
		FlightCartPageDTO.CartFeeData cartCurrencyAmount = flightCartPage.fetchCartDetails();
		logger.info("CartPrice:" + cartCurrencyAmount);
		assertEquals(priceCurrencyAmount.priceCurrency, cartCurrencyAmount.orginalFareCurrenctCd);
		assertEquals(priceCurrencyAmount.price, cartCurrencyAmount.orginalFare);

	}

	@When("^User enter the travelers details in the details page$")
	public void travellerdetailsFill() {
		flightCartPage.enterTravellerDetails();
	}

	@Then("^Screenshot should be taken at last page$")
	public void takeScreenshot() throws IOException {
		boolean folderExists = FileUtil.ensureFolderExistence(DirectoryConstants.SCREENSHOTS_FOLDER);

		if (folderExists) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String filename = "TravellerDetailsLastPage" + DateUtil.getCurrentTimeString();
			File dest = new File(DirectoryConstants.SCREENSHOTS_FOLDER + "/" + filename + ".png");
			FileUtils.copyFile(scrFile, dest);
			driver.quit();
		} else {
			logger.info("Error in folder creation of TakeScreenshot ");
		}

	}

}
