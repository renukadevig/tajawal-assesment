package ae.tajawal.flightbooking.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			//ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			//classLoader.getResourceAsStream("src/main/java/ae/tajawal/flightbooking/config/")
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/ae/tajawal/flightbooking/config/"
					+ "config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(String browser){

		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\Eclipse workspace\\TajawalBDDPOMFramework123\\lib\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Eclipse workspace\\Cucumber-TestNG-master\\Cucumber-TestNG-master\\lib\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
