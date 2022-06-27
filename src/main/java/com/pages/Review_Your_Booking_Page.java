package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Review_Your_Booking_Page extends TestBase implements Review_Your_Booking_Page_Locators{

	public static Reusable_Functions RF;
	
	public static void Provide_EmailID (String EmailID) {
		driver.findElement(By.xpath(Email_Field_Xpath)).sendKeys(EmailID);
	}
	public static void Provide_Phone_Number (String Phone_Number) {
		driver.findElement(By.xpath(Phone_Number_Field_Xpath)).sendKeys(Phone_Number);
	}
	public static void Choose_Title_Of_Traveller (String Traveller_Title) {
		select = new Select (driver.findElement(By.xpath(Traveller_Title_Dropdown_Xpath)));
		select.selectByValue(Traveller_Title);
	}
	public static void Provide_First_Name (String FirstName) {
		driver.findElement(By.xpath(Traveller_Firstname_Field_Xpath)).sendKeys(FirstName);
	}
	public static void Provide_Last_Name (String LastName) {
		driver.findElement(By.xpath(Traveller_Lastname_Field_Xpath)).sendKeys(LastName);
	}
/*	public static void Click_On_Send_Booking_Details_On_Whatsapp_Checkbox () {
		driver.findElement(By.xpath(Send_Boking_Detls_On_Whtsap_Checkbox_Xpath)).click();
	}
	public static void Click_On_Join_Business_Checkbox () {
		driver.findElement(By.xpath(Join_Yatra_For_Busins_Checkbox_Xpath)).click();
	}
	public static void Click_On_Travel_Insurance_Checkbox () {
		driver.findElement(By.xpath(Add_Travel_Insurance_Checkbox_Xpath)).click();
	}
	public static void Click_On_Add_On_Checkbox1 () {
		driver.findElement(By.xpath(Add_Ons_Checkbox1_Xpath)).click();
	}
	public static void Click_On_Add_On_Checkbox2 () {
		driver.findElement(By.xpath(Add_Ons_Checkbox2_Xpath)).click();
	}*/
	public static void Click_On_Proceed_To_Payment_Button () {
		driver.findElement(By.xpath(Proceed_To_Payment_Button_Xpath)).click();
	}
}
