package org.abhi;

import java.time.Duration;

import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientSearch {
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@Test(priority = 1)
	public void Patientsearchwithmail() throws InterruptedException {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

		// Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();


		// Patient Quick Search with mail

		driver.findElement(By.xpath(
				"//a [@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
				.click();

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace with
																										// actual frame
																										// locator
		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("selvasaravana2020@gmail.com");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();
		
		

	}

	@Test(priority = 2)
	public void Patientsearchwithid() {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

//Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

//Patient Quick Search 

		driver.findElement(By.xpath(
				"//a[@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
				.click();

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace with
		// actual frame
		// locator
		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("329");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

	}

	@Test(priority = 3)
	public void Patientadvancedsearch() {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

//Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

//Patient Advanced Search 

		driver.findElement(By.xpath(
				"//a[@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
				.click();

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace with
		// actual frame
		// locator
		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-advanced']")).click();

		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("saravana");

		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("saravana");

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("04", "16", "1998");

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

	}

	@Test(priority = 4)
	public void fieldsBlankLoginTest() {
		try {
			driver.get("https://srv701482.hstgr.cloud/doctor/login");

			driver.manage().window().maximize();

			driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

			// Click the Login button

			driver.findElement(By.xpath("//button[@type='submit']")).click();

			driver.findElement(By.xpath(
					"//a [@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
					.click();

			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace
																											// with
																											// actual
																											// frame
																											// locator
			driver.switchTo().frame(frameElement);

			WebElement emailField = driver.findElement(By.xpath("//input[@id='patient_id_email']"));

			// Leave fields empty and click login

			driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

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

	@Test(priority = 5)
	public void advancefieldsBlankLoginTest() {
		try {
			driver.get("https://srv701482.hstgr.cloud/doctor/login");

			driver.manage().window().maximize();

			driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

			// Click the Login button

			driver.findElement(By.xpath("//button[@type='submit']")).click();

			driver.findElement(By.xpath(
					"//a [@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
					.click();

			WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace
																											// with
																											// actual
																											// frame
																											// locator
			driver.switchTo().frame(frameElement);

			driver.findElement(By.xpath("//button[@id='tab-advanced']")).click();

			WebElement emailField = driver.findElement(By.xpath("//input[@id='patient_id_email']"));

			// Leave fields empty and click login

			driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();

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

	@Test(priority = 6)
	public void Patientsearchwithinvalidid() {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

//Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

//Patient Quick Search 

		driver.findElement(By.xpath(
				"//a[@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
				.click();

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']")); // Replace with
		// actual frame
		// locator
		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("1000");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

	}

	@Test(priority = 7)
	public void Patientselect() throws InterruptedException {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

		// Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Assert-1
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement successTxt = wait1
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Dr. vani test']")));

		Assert.assertEquals(successTxt.getText(), "Dr. vani test", "Msg verification failed");
		System.out.println("Text found: " + successTxt.getText());

		// Patient Quick Search with mail

		driver.findElement(By.xpath(
				"//a [@class='flex items-center space-x-2 text-gray-300 hover:bg-[#3a3f4b] px-4 py-2 rounded-lg'][4]"))
				.click();

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		// Assert-2
		WebElement msg2 = driver.findElement(By.xpath("//h1[@class=\"text-xl font-semibold\"]"));
		Assert.assertEquals(msg2.getText(), "Patient Search", "Msg verification failed");
		System.out.println("Text found: " + msg2.getText());

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("selvasaravana2020@gmail.com");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Assert-3
		WebElement msg3 = driver.findElement(By.xpath("//span[@class=\"text-sm text-gray-400\"]"));
		Assert.assertEquals(msg3.getText(), "ID - 329", "Msg verification failed");
		System.out.println("Text found: " + msg3.getText());

	}

	@AfterClass
	public void tearDown() {

		// Close the browser
		driver.quit();
	}
}
