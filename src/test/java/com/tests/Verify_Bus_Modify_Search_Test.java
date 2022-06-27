package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.pages.Available_Bus_List_Page;
import com.pages.Home_Page;

import Utilities.Reusable_Functions;
import Utilities.TestBase;
import Utilities.XL;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Bus_Modify_Search_Test extends TestBase {
	
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
	
	@DataProvider(name = "Modify Source City")
	public String [] [] Modify_Source_City() throws IOException{
	//String Modify_Source_Station [][] = {
			//{/*"chandrahasareddy945@gmail.com", "Venkata@123",*/ "Hyderabad", "Jammalamadugu", "17/05/2022", "AR And BCVR Travels", "Moosapet", "Jammalamadugu"}};
			
			
		//	{"Hyderabad", "jammalamadugu", "17/05/2022", "Proddutur","Veera and Sri Kaleswari Travel"}};
	
			String path = ".\\Data_Files\\Modify_Bus_Search.xlsx";
			XL xcl = new XL(path);
			int totalrows = xcl.getrowcount("Sheet1");
			int totalcolmns = xcl.getcolcount("Sheet1", 1);
			
			String Modify_Bus_Search [][] = new String [totalrows][totalcolmns];
			
			for(int i=1; i<=totalrows;i++) {
				for(int j=0; j<totalcolmns; j++) {
					Modify_Bus_Search[i-1][j] = xcl.getCellData("Sheet1", i, j);
				}}
			
	return Modify_Bus_Search;
	}
	
	
	@Test  (groups = "Modification of arrival City", dataProvider = "Modify Source City")
	public void Modify_To_Station_And_Verify_The_OperatorList(String from, String to, String date, String destination, String operatorname) throws InterruptedException {
		//To create the test case in the report
		test = extent.createTest("Verify Modify Search Test Case");
		homepage.ClickOnBusesButton();
		homepage.ProvideFromStation(from);
		homepage.ProvideToStation(to);
		homepage.ClickOnDateField();
		homepage.SelectDate(date);
		homepage.ClickOnSearchBusesButton();
		BLpage.Modify_To_Station(destination);
		BLpage.Click_On_Find_Buses_Buttom();
		BLpage.Verify_Bus_Operator_Name(operatorname);
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
	  extent.flush();
	 }
}
