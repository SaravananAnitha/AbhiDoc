package com.abhi.testcomponenets;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.abhi.pages.LoginPage;

public class Basetest {
	
	public WebDriver driver;
	public LoginPage loginpage;
	
	public WebDriver initializeDriver() throws IOException{
		
		driver =new ChromeDriver();

		driver.get("https://srv701482.hstgr.cloud/");

		driver.manage().window().maximize();
		
		
		return driver;
		
		
	}
	
	@BeforeMethod
	public LoginPage launchApplication() throws IOException{
	driver=initializeDriver();
	loginpage= new LoginPage(driver);
	loginpage.goToUrl();
	return loginpage;
	}

	@AfterMethod
	public void teardown(){ driver.close();}
	
	
	}