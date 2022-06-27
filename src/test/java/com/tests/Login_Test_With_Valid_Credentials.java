package com.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.pages.Home_Page;
import com.pages.Login_Page;

import Utilities.TestBase;
import Utilities.XL;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Test_With_Valid_Credentials extends TestBase {
	
	public static Login_Page loginpage;
	public static Home_Page homepage;
	
	
	@BeforeMethod
	@Parameters	({"browser","url" })
    public static void LauchAppliucation(@Optional ("chrome") String browser , @Optional ("https://www.yatra.com") String url) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		
		}else if(browser.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.get(url);
	}
	
	@DataProvider(name = "Login Credentials")
	public String [] [] Login_Data() throws IOException{
	String logindetails [][] = {
				{"chandrahasareddy945@gmail.com", "Venkata@123"},
			};
	
		return logindetails;
	}
	
	@Test  (  dataProvider = "Login Credentials",groups = "Login Verification")
	 public static void Login_Test_With_Valid_Credentials(String user, String psd){
		
			
		loginpage.ClickOnMyAccountButton();
		loginpage.ClickOnLoginButton();
		loginpage.EnterUsername(user);
		loginpage.ClickOnContinueButton();
		loginpage.Enterpassword(psd);
		loginpage.ClickOnSubmitButton();
		homepage.VerifyUserTitleIsDisplayed();
		
	
		}
	
	@AfterMethod
	 public static void Close_Browser() {
			
		 driver.quit();
		}}
