package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.Available_Flights_Page;
import com.pages.Home_Page;
import com.pages.Payment_Method_Page;
import com.pages.Review_Your_Booking_Page;

import Utilities.Reusable_Functions;
import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Flight_Booking_Test extends TestBase {

	public static Home_Page homepage;
	public static Available_Flights_Page AF;
	public static Review_Your_Booking_Page rb;
	public static Payment_Method_Page pm;

	@BeforeClass
	@Parameters({ "browser", "url" })
	public static void LauchAppliucation(@Optional("chrome") String browser,
			@Optional("https://www.yatra.com") String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.get(url);

	}

	@DataProvider(name = "Search_Flights")
	public String[][] Flights_Between_Cities() throws IOException {
		String Flights_Between_Cities[][] = { { "Hyderabad", "Mumbai", "17/05/2022", "Air India Business",
				"Airbus A320 Neo", "chandrahasareddy945@gmail.com", "9666870136", "Mr", "Chandrahasa", "Reddy" } };
		return Flights_Between_Cities;
	}

	@Test(dataProvider = "Search_Flights")
	public void Search_Flights_And_Book_Tickets(String origincity, String arrivalcity, String date, String airline,
			String aircraft, String emailid, String phonenumber, String travelertitle, String firstname,
			String lastname) {
		test = extent.createTest("Search flights and Book");
		homepage.Click_On_Flight_Search_button();
		homepage.Provide_Flight_Origin_City(origincity);
		homepage.Provide_Flight_Arrival_City(arrivalcity);
		homepage.Provide_Date_Of_Travel(date);
		// homepage.Click_On_Flight_Class_Arrow_Button();
		// homepage.Click_On_Business_Class_Radio_Button();
		// homepage.Click_On_Non_Stop_Checkbox();
		homepage.Click_On_Search_Flights_Button();
		AF.Click_On_More_Filters_Button();
		AF.Search_Airlines(airline);
		AF.Select_Airlines();
		AF.Search_Aircrafts(aircraft);
		AF.Select_Aircraft();
		AF.Click_On_Apply_Filters_Button();
		AF.Click_On_Book_Now_Button();
		rb.Provide_EmailID(emailid);
		rb.Provide_Phone_Number(phonenumber);
		rb.Choose_Title_Of_Traveller(travelertitle);
		rb.Provide_First_Name(firstname);
		rb.Provide_Last_Name(lastname);
		rb.Click_On_Proceed_To_Payment_Button();
		pm.Verify_Payment_Mathod_Page();
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
			test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent
																					// report
			String screenshotPath = Reusable_Functions.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
			String screenshotPath = Reusable_Functions.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		}
		
		driver.close();
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
