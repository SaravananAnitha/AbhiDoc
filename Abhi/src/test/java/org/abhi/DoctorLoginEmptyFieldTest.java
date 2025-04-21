package org.abhi;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class DoctorLoginEmptyFieldTest {
	    public static void main(String[] args) {
	       

	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

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

	            // Get the native browser validation message (HTML5 required field message)
	            String validationMessage = emailField.getAttribute("validationMessage");

	            // Print validation result
	            if (validationMessage != null && !validationMessage.isEmpty()) {
	                System.out.println("Test Passed: Validation Message - " + validationMessage);
	            } else {
	                System.out.println("Test Failed: No validation message displayed.");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }
	}



