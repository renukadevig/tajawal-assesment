package ae.tajawal.flightbooking.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Renuka devi G
 *
 */
public class TestBase {
	static final Logger logger = Logger.getLogger(TestBase.class);

	public static WebDriver driver;
	public static Properties prop;

	/**
	 * 
	 */
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/ae/tajawal/flightbooking/config/" + "config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param browser
	 */
	public static void initialization(String browser) {

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:\\Eclipse workspace\\TajawalBDDPOMFramework123\\lib\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			logger.info("initialization of chrome definition");
			System.setProperty("webdriver.gecko.driver",
					"E:\\Eclipse workspace\\TajawalBDDPOMTestNGFramework\\lib\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			logger.error("Unsupported browser --> " + browser);
		}
		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		}

	}

}
