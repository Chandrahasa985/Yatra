package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Reusable_Functions;
import Utilities.TestBase;

public class Login_Page extends TestBase implements Login_Page_Locators,  Home_Page_Locators{

public static Reusable_Functions RF;
	
	public static void ClickOnMyAccountButton() {
		RF.waitforelementbyXpath(My_Account_Button_Xpath, 7);
		driver.findElement(By.xpath(My_Account_Button_Xpath)).click();
	}
	
	public static  void ClickOnLoginButton() {
		RF.waitforelementbyCSS_Selector(Login_Button_CssSelector, 7);
		
		driver.findElement(By.cssSelector(Login_Button_CssSelector)).click();
	}
	
	public  static void EnterUsername(String username) {
		
		driver.findElement(By.cssSelector(Username_Input_CssSelector)).sendKeys(username);
	}
	
public  static  void ClickOnContinueButton() {
		
		driver.findElement(By.cssSelector(Continue_Button_CssSelector)).click();
	}



  public static void Enterpassword(String password) {
	   
	  boolean passwordfield =  driver.findElement(By.cssSelector(Password_Input_CssSelector)).isEnabled();
	  driver.navigate().refresh();
	  try {
		Thread.sleep(6000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  if(passwordfield) {
		  WebElement passwsord = driver.findElement(By.cssSelector(Password_Input_CssSelector));
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  js.executeScript("arguments[0].value='Venkata@123';", passwsord);
		 }
	  try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  }

public  static  void ClickOnSubmitButton() {
	
	boolean submitbutton = driver.findElement(By.cssSelector(Submit_Button_CssSelector)).isEnabled();
	
	if(submitbutton) {
		driver.findElement(By.cssSelector(Submit_Button_CssSelector)).click();
		
	}
	
	   
}		

}
