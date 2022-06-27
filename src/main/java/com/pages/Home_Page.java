package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;
import org.testng.Assert;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Home_Page extends TestBase implements Home_Page_Locators{
	
	public static Reusable_Functions RF;
	
	public  static  void VerifyUserTitleIsDisplayed() {
		
		RF.waitforelementbyCSS_Selector(User_Title_cssSelector, 7);
	boolean usertitle = driver.findElement(By.cssSelector(User_Title_cssSelector)).isDisplayed();
		RF.softassert(usertitle);
		
	}
	
	public static void ClickOnBusesButton()	{
		RF.waitforelementbyCSS_Selector(Buses_button_cssSelector, 7);
		
		driver.findElement(By.cssSelector(Buses_button_cssSelector)).click();		
	}
	
	public static void ProvideFromStation(String StartingPoint) throws InterruptedException	{
		RF.waitforelementbyXpath(From_Station_Input_Xpath, 7);
		WebElement FromStation = driver.findElement(By.xpath(From_Station_Input_Xpath));	
		FromStation.click();
		//FromStation.clear();
		RF.WaitForSomeTime(2000);
		FromStation.sendKeys(StartingPoint);
		RF.WaitForSomeTime(2000);
		FromStation.sendKeys(Keys.ARROW_DOWN);
		FromStation.sendKeys(Keys.ENTER);
		RF.WaitForSomeTime(2000);
		
	}
	
	public  static  void ProvideToStation(String DestinationPoint) throws InterruptedException	{
		
		RF.waitforelementbyCSS_Selector(To_Station_Input_cssSelector, 7);
		WebElement ToStation = driver.findElement(By.cssSelector(To_Station_Input_cssSelector));
		ToStation.click();
		ToStation.clear();
		ToStation.sendKeys(DestinationPoint);
		Thread.sleep(2000);
		ToStation.sendKeys(Keys.ARROW_DOWN);
		ToStation.sendKeys(Keys.ENTER);
	}
	
	public static void ClickOnDateField()	{
		
		driver.findElement(By.cssSelector(Open_Calendar_cssSelector)).click();		
	}
	
	public static void SelectDate(String date)	{
		
		driver.findElement(By.xpath("//td[@data-date='"+date+"']")).click();		
	}
	
    public static void ClickOnSearchBusesButton()	{
		
		driver.findElement(By.cssSelector(Bus_Search_Button_cssSelector)).click();		
	}
    public static void Click_On_Flight_Search_button () {
    	driver.findElement(By.xpath(Flight_Search_Button_Xpath)).click();
    }
    public static void Provide_Flight_Origin_City (String OriginCity) {
    	driver.findElement(By.xpath(Flight_Origin_City_Field_Xpath)).click();
    	driver.findElement(By.xpath("//p[text()='"+OriginCity+" ']")).click();
    }
    public static void Provide_Flight_Arrival_City (String ArrivalCity) {
    	driver.findElement(By.xpath(Flight_Arrival_City_Field_Xpath)).click();
    	driver.findElement(By.xpath("//p[text()='"+ArrivalCity+" ']")).click();
    }	
    public static void Provide_Date_Of_Travel (String date) {
    	driver.findElement(By.xpath("//input[@name='flight_origin_date']")).click();
    	driver.findElement(By.xpath("//td[@data-date='"+date+"']")).click();
    }
    public static void Click_On_Flight_Class_Arrow_Button () {
    	driver.findElement(By.xpath(Flight_Class_Arrow_Xpath)).click();
    }
    public static void Click_On_Business_Class_Radio_Button () {
    	driver.findElement(By.xpath(Business_Class_Radio_Button_Xpath)).click();
    }
    public static void Click_On_Non_Stop_Checkbox () {
    	driver.findElement(By.xpath(Non_Stop_Flights_Chechbox_Xpath)).click();
    }
    public static void Click_On_Search_Flights_Button () {
    	driver.findElement(By.xpath(Search_Flight_Button_Xpath)).click();
    }
    
	
	

}

