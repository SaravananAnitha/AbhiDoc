package org.abhi;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DoctorLogin{
    WebDriver driver;

    @BeforeClass
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize(); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
    }

    @Test(priority = 1)
    public void positiveLoginTest() {
        // Navigate to the login page
        driver.get("https://srv701482.hstgr.cloud/doctor/login");
        //driver.findElement(By.xpath("//a[text()='Patient Login']")).click();

        // Enter valid credentials
        driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");
       

        // Click the Login button
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
       WebElement Successfultxt = driver.findElement(By.xpath("//p[text()='Dr. vani test']"));
       String text = Successfultxt.getText();
		System.out.println(text);
		System.out.println(".....................................");
       
       
       
       

    }

   
    @Test(priority = 2)
    public void fieldsBlankLoginTest() {
    	 try {
	            // Navigate to the login page
	            driver.get("https://srv701482.hstgr.cloud/doctor/login");
	            driver.manage().window().maximize();

	            // Wait for the page to load (simple sleep for demo purposes)
	            Thread.sleep(2000);

	            // Locate the email and password fields
	            WebElement emailField = driver.findElement(By.id("username_or_email")); // Update locator if needed
	            WebElement passwordField = driver.findElement(By.id("password"));

	            // Leave fields empty and click login
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	            loginButton.click();

	            // Wait for the browser's native validation to kick in
	            Thread.sleep(2000);

	            // Get the native browser validation message
	            String validationMessage = emailField.getAttribute("validationMessage");

	            // Print validation result
	            if (validationMessage != null && !validationMessage.isEmpty()) {
	                System.out.println("Test Passed: Validation Message - " + validationMessage);
	                System.out.println(".....................................");
	            } else {
	                System.out.println("Test Failed: No validation message displayed.");
	                
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            
	        }
	    }
	

    @Test(priority = 3)
    public void negativeLoginTest() {
    	
    	try {
        // Navigate to the login page
    	 driver.get("https://srv701482.hstgr.cloud/doctor/login");
    	 
    	 Thread.sleep(2000);
       
        // Enter invalid credentials
        driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("selva@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sarava@123");

        // Click the Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        Alert alert = driver.switchTo().alert();
        
        String alertText = alert.getText();
        
        if (alertText.contains("Invalid username or password or both!")) {
            System.out.println("Test Passed: Invalid username or password or both! error message displayed.");
            System.out.println(".....................................");
        } else {
            System.out.println("Test Failed: Unexpected alert message - " + alertText);
          
        }
        alert.accept();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
        }
    }

    
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}





