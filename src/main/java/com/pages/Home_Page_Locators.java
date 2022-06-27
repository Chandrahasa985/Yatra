package com.pages;

public interface Home_Page_Locators {

	String User_Title_cssSelector = "a[title='Chandrahasa']";
	String Buses_button_cssSelector = "span[class='demo-icon icon-buses']";
	String From_Station_Input_Xpath = "//input[@name='bus_leaving']";
	String To_Station_Input_cssSelector = "#BE_bus_to_station";
	String Open_Calendar_cssSelector = "#BE_bus_depart_date";
	String Bus_Search_Button_cssSelector = "#BE_bus_search_btn";
	String Flight_Search_Button_Xpath	= "//span[text()='Flights']";
	String Flight_Origin_City_Field_Xpath = "//input[@id='BE_flight_origin_city']";
	String Flight_Arrival_City_Field_Xpath = "//input[@id='BE_flight_arrival_city']";
	String Flight_Class_Arrow_Xpath = "//i[@class='icon icon-angle-right arrowpassengerBox']";
	String Business_Class_Radio_Button_Xpath = "(//li[@class='enabled _msddli_'])[2]";
	String Non_Stop_Flights_Chechbox_Xpath = "(//i[@class='ico ico-checkbox'])[2]";
	String Search_Flight_Button_Xpath = "//input[@value='Search Flights']";
	
}
