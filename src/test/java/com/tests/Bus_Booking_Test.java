package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import com.pages.Available_Bus_List_Page;
import com.pages.Home_Page;
import com.pages.Login_Page;

import Utilities.Reusable_Functions;
import Utilities.TestBase;
import Utilities.XL;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Bus_Booking_Test extends TestBase {

	public static Login_Page loginpage;
	public static Home_Page homepage;
	public static Available_Bus_List_Page BLpage;

	
	@BeforeMethod
	@Parameters	({"browser","url" })
	 public static void LauchAppliucation(@Optional ("chrome") String browser , @Optional ("https://www.yatra.com") String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		}else if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.get(url);
		}

	@DataProvider(name = "Bus_Booking_Details")
	public String[][] Booking_details() throws IOException {
		String path = ".\\Data_Files\\Bus_Booking_Details.xlsx";
		XL xcl = new XL(path);
		int totalrows = xcl.getrowcount("Sheet1");
		int totalcolmns = xcl.getcolcount("Sheet1", 1);
		String Bus_Booking_Details[][] = new String[totalrows][totalcolmns];
		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcolmns; j++) {
				Bus_Booking_Details[i - 1][j] = xcl.getCellData("Sheet1", i, j);
			}
		}
		return Bus_Booking_Details;
	}

	@Test(groups = "One Way Booking Verification", dataProvider = "Bus_Booking_Details")
	// public static void BookTickets(String username, String pass, String
	// from,String to,String date,String busoperator,String boardingpoint,String
	// destinationpoint) throws InterruptedException {
	public void BookTickets(String from, String to, String date, String busoperator, String boardingpoint,
			String destinationpoint) throws InterruptedException {
		test = extent.createTest("Book BUs Tickets");
		homepage.ClickOnBusesButton();
		homepage.ProvideFromStation(from);
		homepage.ProvideToStation(to);
		homepage.ClickOnDateField();
		homepage.SelectDate(date);
		homepage.ClickOnSearchBusesButton();
		BLpage.BookTicket(busoperator, boardingpoint, destinationpoint);
	}
	

	@AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus() == ITestResult.FAILURE) {
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
	   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
	   String screenshotPath = Reusable_Functions.getScreenshot(driver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  } else if (result.getStatus() == ITestResult.SKIP) {
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	   String screenshotPath = Reusable_Functions.getScreenshot(driver, result.getName());
	   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
	  }
	  driver.close();
	 }
	
	 @AfterTest
	 public void endReport() {
	  //extent.flush();
	 }

}
