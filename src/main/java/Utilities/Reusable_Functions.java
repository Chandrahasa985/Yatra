package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Reusable_Functions extends TestBase {

	public static void waitforelementbyXpath(String Xpath, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));

	}

	public static void waitforelementbyCSS_Selector(String CSSSelector, int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(CSSSelector)));

	}

	public static void softassert(boolean targetelement) {
		SoftAssert asrt = new SoftAssert();
		asrt.assertTrue(targetelement);

	}

	public static void WaitForSomeTime(int time) {

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
	
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		  TakesScreenshot ts = (TakesScreenshot) driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  
		  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
		  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		  File finalDestination = new File(destination);
		  FileUtils.copyFile(source, finalDestination);
		  return destination;
		 }

}
