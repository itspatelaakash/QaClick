package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import uiComponents.Screens.QaHome;
import utilities.ExcelReader;
import utilities.ExtentManager;

public class Base {
	public static WebDriver driver;
	Properties prop = new Properties();
	FileInputStream fis;
	
	//Creating object of ExcelReader utility in base and giving file path
	//excel is stored in following path as eclips is crashing on storing excel inside project.
	public static ExcelReader excel = new ExcelReader("C:\\Study\\QaClick_DataProvider.xlsx");
	
	//ExtentReport intances
	public static ExtentReports rep = ExtentManager.getInstance(); // geting instance from utility ExtentManager
	public static ExtentTest elogger;
	

	@BeforeMethod
	public WebDriver setUp() throws IOException {

		fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\project.properties");
		prop.load(fis);

		if (prop.getProperty("browser").contains("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (prop.getProperty("browser").contains("FireFox")) {
			System.out.println("FireFox");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//BasicConfigurator.configure();
		driver.get(prop.getProperty("url"));
		return driver;

	}
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null)
			{
			
			driver.quit();
			driver=null; //to nullyfy driver after each test to save memory.
			
			}
		 
	}

	public static void closePopup() {

		if (QaHome.getpopup().isDisplayed()) {
			QaHome.getNoThanksButton().click();
		}
	}

}
