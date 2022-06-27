package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Available_Bus_List_Page extends TestBase implements Available_Bus_List_Page_Locators {
	
	public static Reusable_Functions RF;
	
	public static void BookTicket( String BusOperatorName, String BoardingPoint, String DroppingPoint)	{
		List<WebElement> noofbuses = driver.findElements(By.xpath("//div[text()='"+BusOperatorName+"']"));
		int countofbuses =noofbuses.size();
		for(int i=1; i<=countofbuses; i++) {
			RF.WaitForSomeTime(2000);
			String selectseatxpath = "(//div[text()='"+BusOperatorName+"'])["+i+"]//following::div[14]";
			WebElement ele = driver.findElement(By.xpath(selectseatxpath));
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
	
			WebElement boarding_point = driver.findElement(By.xpath("//option[text()='"+BoardingPoint+" ']"));
			boarding_point.click();
			WebElement dropping_point = driver.findElement(By.xpath("//option[text()='"+DroppingPoint+" ']"));
			dropping_point.click();
			List<WebElement> selectseat = driver.findElements(By.xpath(Available_Seats_Xpath));
			int seatcount = selectseat.size();
			for(int j=0; j<=seatcount; j++) {
				if(selectseat.get(j).isEnabled()) {
					selectseat.get(j).click();
					break;
					}else {
					System.out.println("No Seats are available in first operator and going to next operator");
				}
			 }
			}
		
			
			boolean confirmseat = driver.findElement(By.xpath(Confirm_Seat_Xpath)).isEnabled();
			if(confirmseat) {
				System.out.println("Available Seat Selected");
			}
			
		}
	
	public static void Modify_From_Station (String from) {
		
		WebElement fromstation = driver.findElement(By.xpath(Modify_From_Station_Xpath));
		fromstation.clear();
		fromstation.sendKeys(from);
	}
	
   public static void Modify_To_Station (String to) throws InterruptedException {
		
		WebElement tostation = driver.findElement(By.xpath(Modify_To_Station_Xpath));
		tostation.click();
		act = new Actions(driver);
		//act.doubleClick(tostation);
		//tostation.clear();
		//tostation.clear();
		tostation.sendKeys(Keys.CONTROL, "a");
		tostation.sendKeys(Keys.DELETE);
		tostation.sendKeys(to);
		Thread.sleep(5000);
		WebElement destination = driver.findElement(By.xpath("//ul[@class='left-text outosugg']/li/span"));
		act.moveToElement(destination).click().build().perform();
		RF.WaitForSomeTime(5000);
	//	tostation.sendKeys(Keys.TAB);
	}
	
   public static void Click_On_Find_Buses_Buttom () {
		
		driver.findElement(By.xpath(Find_Buses__Xpath)).click();
	}
	
  /* public static void Verify_To_Station_Name (String tostation) throws InterruptedException {
		
	   WebElement destination = driver.findElement(By.xpath(Modify_To_Station_Xpath));
	   String actual = destination.getText();
	   System.out.println("The actual destination is "+actual);
	   System.out.println("The Expected destination is "+tostation);
	   Thread.sleep(10000);
	   if(actual.equalsIgnoreCase(tostation)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	   
	}*/
	
   public static void Verify_Bus_Operator_Name (String operatorname) throws InterruptedException {
		
	 /*  WebElement destination = driver.findElement(By.xpath(Modify_To_Station_Xpath));
	   String actual = destination.getText(); */
	   
	   String busoperatorxpath = "//div[text()='"+operatorname+"']";
	   WebElement busoperatorname = driver.findElement(By.xpath(busoperatorxpath));
	   String actual = busoperatorname.getText();
	   
	   System.out.println("The actual destination is "+actual);
	   System.out.println("The Expected destination is "+operatorname);
	   Thread.sleep(10000);
	   if(actual.equalsIgnoreCase(operatorname)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	  }
   
   
   
   
   
   
	}
