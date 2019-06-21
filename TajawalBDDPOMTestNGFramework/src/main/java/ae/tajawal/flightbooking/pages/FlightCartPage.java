
package ae.tajawal.flightbooking.pages;

import java.text.NumberFormat;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ae.tajawal.flightbooking.common.TestBase;
import ae.tajawal.flightbooking.pages.responses.FlightCartPageDTO;

/**
 * @author Renuka Devi G
 *
 */
public class FlightCartPage extends TestBase {
	static final Logger logger = Logger.getLogger(FlightCartPage.class);

	@FindBy(xpath = "//div[contains(text(),'Service Fee')]/parent::div/div[2]/span[1]")
	WebElement serviceFeeCurrency;

	@FindBy(xpath = "//div[contains(text(),'Service Fee')]/parent::div/div[2]/span[2]")
	WebElement serviceFeeAmount;

	@FindBy(xpath = "//div/span[@data-testid='FlightPAX__FareDetails__TotalCurrencyLabel'][1]")
	WebElement fareCurrency;

	@FindBy(xpath = "//div/span[@data-testid='FlightPAX__FareDetails__TotalCurrencyLabel'][2]")
	WebElement fareAmount;

	@FindBy(xpath = "//select[@name='travellers.0.title']/parent::div")
	WebElement travellerTitle;

	@FindBy(xpath = "//ul/li[contains(text(),'Mr.')]")
	WebElement travellerTitlelist;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult1__FirstNameInput']")
	WebElement adult1FirstName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult1__MiddleNameInput']")
	WebElement adult1MiddleName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult1__LastNameInput']")
	WebElement adult1LastName;

	@FindBy(xpath = "//select[@name='travellers.1.title']/parent::div")
	WebElement travellerTitle2;

	@FindBy(xpath = "//ul/li[contains(text(),'Mrs.')]")
	WebElement travellerTitlelist2;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult2__FirstNameInput']")
	WebElement adult2FirstName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult2__MiddleNameInput']")
	WebElement adult2MiddleName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__Adult2__LastNameInput']")
	WebElement adult2LastName;

	@FindBy(xpath = "//select[@name='contact.title']/parent::div")
	WebElement travellerTitle3;

	@FindBy(xpath = "//ul/li[contains(text(),'Mrs.')]")
	WebElement travellerTitlelist3;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__ContactDetails__FirstNameInput']")
	WebElement contactFirstName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__ContactDetails__LastNameInput']")
	WebElement contactLastName;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__ContactDetails__EmailInput']")
	WebElement contactEmail;

	@FindBy(xpath = "//input[@data-testid='FlightPAX__ContactDetails__MobileNumberInput']")
	WebElement contactMobileNumber;

	@FindBy(xpath = "//div[contains(text(),'Select the contact person')]/following-sibling::div/div[2]")
	WebElement popup;

	// Initializing the Page Objects:
	public FlightCartPage() {
		PageFactory.initElements(driver, this);
	}

	WebDriverWait wait = new WebDriverWait(driver, 30);

	/**
	 * @return
	 */
	public FlightCartPageDTO.CartFeeData fetchCartDetails() {
		FlightCartPageDTO flightCartPageDTO = new FlightCartPageDTO();
		FlightCartPageDTO.CartFeeData cartFeeData = flightCartPageDTO.new CartFeeData();

		WebElement serviceFeeCurrency1 = wait.until(ExpectedConditions.visibilityOf(serviceFeeCurrency));
		String serviceFeeCurrencyStr = serviceFeeCurrency1.getText();
		String fareCurrencyStr = fareCurrency.getText();

		Number serviceFeeAmtNum = null;
		Number fareAmtNum = null;
		try {
			serviceFeeAmtNum = NumberFormat.getNumberInstance(java.util.Locale.US).parse(serviceFeeAmount.getText());
			WebElement fareAmount1 = wait.until(ExpectedConditions.visibilityOf(fareAmount));
			fareAmtNum = NumberFormat.getNumberInstance(java.util.Locale.US).parse(fareAmount1.getText());

		} catch (ParseException e) {
			logger.error("Error in flightcartpage", e);
		}

		if (serviceFeeAmtNum == null || fareAmtNum == null) {
			logger.info("Error. serviceFeeAmtNum & fareAmtNum incompactible");
			return null;
		}

		cartFeeData.serviceFeeCurrencyCd = serviceFeeCurrencyStr;
		cartFeeData.serviceFee = serviceFeeAmtNum.doubleValue();
		cartFeeData.fareFeeCurrencyCd = fareCurrencyStr;
		cartFeeData.fareFee = fareAmtNum.doubleValue();
		cartFeeData.orginalFareCurrenctCd = cartFeeData.fareFeeCurrencyCd;
		cartFeeData.orginalFare = cartFeeData.fareFee - cartFeeData.serviceFee;

		return cartFeeData;
	}

	/**
	 * 
	 */
	public void enterTravellerDetails() {

		WebElement travellerTitle_1 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitle));
		travellerTitle_1.click();

		WebElement travellerTitlelist_1 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitlelist));
		travellerTitlelist_1.click();

		adult1FirstName.sendKeys("Karthik");
		adult1MiddleName.sendKeys("Mani");
		adult1LastName.sendKeys("Sambath");

		WebElement travellerTitle_2 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitle2));
		travellerTitle_2.click();

		WebElement travellerTitlelist_2 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitlelist2));
		travellerTitlelist_2.click();

		adult2FirstName.sendKeys("Renuka");
		adult2MiddleName.sendKeys("Devi");
		adult2LastName.sendKeys("Gopal");

		WebElement travellerTitle_3 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitle3));
		travellerTitle_3.click();

		WebElement travellerTitlelist_3 = wait.until(ExpectedConditions.elementToBeClickable(travellerTitlelist3));
		travellerTitlelist_3.click();

		contactFirstName.click();
		WebElement popupname = wait.until(ExpectedConditions.elementToBeClickable(popup));
		popupname.click();

		contactEmail.sendKeys("rk@gmail.com");
		contactMobileNumber.sendKeys("555555555");

	}

}
