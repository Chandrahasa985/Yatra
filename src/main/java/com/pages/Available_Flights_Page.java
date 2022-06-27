package com.pages;

import org.openqa.selenium.By;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Available_Flights_Page extends TestBase implements Available_Flights_Page_Locators {

	public static Reusable_Functions RF;
	
	public static void Click_On_More_Filters_Button () {
		driver.findElement(By.xpath(More_Filters_Arrow_Button_Xpath)).click();
	}
	public static void Search_Airlines ( String Airlane_Name) {
	    driver.findElement(By.xpath(Search_Airlines_Searchbar_Xpath)).sendKeys(Airlane_Name);
	}
	public static void Select_Airlines () {
		driver.findElement(By.xpath(Select_Airlines_Xpath)).click();
	}
	public static void Search_Aircrafts ( String Aircraft_Name) {
	    driver.findElement(By.xpath(Search_Aircraft_Searchbar_Xpath)).sendKeys(Aircraft_Name);
	}
	public static void Select_Aircraft () {
		driver.findElement(By.xpath(Select_Aircraft_Xpath)).click();
	}
	public static void Click_On_Apply_Filters_Button () {
		driver.findElement(By.xpath(Apply_Filters_Button_Xpath)).click();
	}
	
	public static void Click_On_Book_Now_Button () {
		driver.findElement(By.xpath(Book_Now_Button_Xpath));
	}
		
}
