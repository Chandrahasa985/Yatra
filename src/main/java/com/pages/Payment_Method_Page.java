package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Payment_Method_Page extends TestBase implements Payment_Method_Page_locators{

	public static Reusable_Functions RF;
	
	public static void Verify_Payment_Mathod_Page () {
		String expected = "Payment Method";
		WebElement payment = driver.findElement(By.xpath(Payment_Method_Xpath));
		String actual = payment.getText();
		if(actual.equalsIgnoreCase(expected)) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		
	}
}
