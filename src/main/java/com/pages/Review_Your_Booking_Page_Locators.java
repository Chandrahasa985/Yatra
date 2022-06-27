package com.pages;

public interface Review_Your_Booking_Page_Locators {

	String Email_Field_Xpath = "(//input[@placeholder='Email ID'])[2]";
	String Phone_Number_Field_Xpath = "(//input[@placeholder='Mobile Number'])[2]";
	String Traveller_Title_Dropdown_Xpath = "//select[@required='required']";
	String Traveller_Firstname_Field_Xpath = "//input[@id='travellerf0']";
	String Traveller_Lastname_Field_Xpath = "//input[@id='travellerl0']";
	String Send_Boking_Detls_On_Whtsap_Checkbox_Xpath = "(//i[@class='ytfi-checker'])[1]";
	String Join_Yatra_For_Busins_Checkbox_Xpath = "(//i[@class='ytfi-checker'])[3]";
	String Add_Travel_Insurance_Checkbox_Xpath = "(//i[@class='ytfi-checker'])[5]";
	String Add_Ons_Checkbox1_Xpath = "(//i[@class='ytfi-checker'])[7]";
	String Add_Ons_Checkbox2_Xpath ="(//i[@class='ytfi-checker'])[8]";
	String Proceed_To_Payment_Button_Xpath = "//button[@yatratrackable='Flights|Flights Review|Continue|Payment']";
}
