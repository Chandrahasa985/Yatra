package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static WebDriver driver;
	public static Actions act;
	public static Select select;
	
	//Extent report classes
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void setExtent() {
		// specify location of the report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReport/YatraTestAutomationReport.html");

		htmlReporter.config().setDocumentTitle("Yatra Automation Report"); // Tile of report
		htmlReporter.config().setReportName("Regression Testing"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// Passing General information
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Chandra.");
	}

	@AfterSuite
	public void endReport() {
		//extent.flush();
		driver.quit();
	}

}
