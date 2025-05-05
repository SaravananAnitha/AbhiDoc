package org.abhi;

import java.time.Duration;
import org.junit.AfterClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PatientInformation {
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void Healthsummary() throws InterruptedException {

		driver.get("https://srv701482.hstgr.cloud/doctor/login");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@id='username_or_email']")).sendKeys("anitha123test@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sana@123");

		// Click the Login button

		driver.findElement(By.xpath("//button[@type='submit']")).click();

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

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Assert-3
		WebElement msg3 = driver.findElement(By.xpath("//span[@class=\"text-sm text-gray-400\"]"));
		Assert.assertEquals(msg3.getText(), "ID - 327", "Msg verification failed");
		System.out.println("Text found: " + msg3.getText());

		// driver.findElement(By.xpath("//button[@id='mobile-menu-toggle']")).click();

		// Health Summary
		WebElement clk1 = driver.findElement(By.xpath("//span[text()='Health Summary']"));
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk1);

		Thread.sleep(2000);
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));

		driver.switchTo().frame(frameElement1);
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='search-input']"));
		searchBox.sendKeys("hemorrhage" + Keys.ENTER);

		WebElement hemorrhage = driver.findElement(By.xpath("//*[contains(text(),'hemorrhage')]"));
		String actualTextForHemorrhage = hemorrhage.getText();
		String expectedTextForHemorrhage = "hemorrhage";
		Assert.assertTrue(actualTextForHemorrhage.contains(expectedTextForHemorrhage), "hemorrhage is available");
		System.out.println(actualTextForHemorrhage);

		driver.findElement(By.xpath("//*[contains(@class,'view-button px-4 py-2 bg-blue-600')]")).click();

	}

	@Test(priority = 2)
	public void Medications() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Medications

		WebElement clk1 = driver.findElement(By.xpath("//*[contains(text(),'Medications')]"));
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk1);

		Thread.sleep(2000);

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));
		driver.switchTo().frame(frameElement1);

		WebElement document = driver.findElement(By.xpath("//*[contains(@type,'submit')]"));
		js.executeScript("arguments[0].click()", document);

	}

	@Test(priority = 3)
	public void Labreports() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// driver.findElement(By.xpath("//button[@id='mobile-menu-toggle']")).click();

		// Labreports
		WebElement clk1 = driver.findElement(By.xpath("//*[contains(text(),'Lab Reports')]"));
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk1);

		Thread.sleep(2000);
		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));

		driver.switchTo().frame(frameElement1);

		driver.findElement(By.xpath("//*[contains(@type,'search')]")).sendKeys("Abdominal Situs");
		driver.findElement(By.xpath("//*[contains(@type,'submit')]")).click();

	}

	@Test(priority = 4)
	public void Alldocuments() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// All Documents
		WebElement clk1 = driver.findElement(By.xpath("//span[text()='All Documents']"));
		js.executeScript("arguments[0].click()", clk1);

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));
		driver.switchTo().frame(frameElement1);

		WebElement clk2 = driver.findElement(By.xpath("//*[contains(@data-id,'1L74BliAxuSmlKjHwhPo0kLnjICtTgnA6')]"));
		js.executeScript("arguments[0].click()", clk2);

	}

	@Test(priority = 5)
	public void Uploadjpegdocument() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Upload Documents

// Upload Documents

		WebElement clk1 = driver.findElement(By.xpath("//*[contains(text(),'Upload Document')]"));
		js.executeScript("arguments[0].click()", clk1);

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));
		driver.switchTo().frame(frameElement1);

		WebElement fileInput = driver.findElement(By.xpath("//div[@id='file-upload']//input[@type='file']"));
		js.executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys("C:\\Users\\Saravana\\Abhi\\Report\\download.jpeg");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

	}

	@Test(priority = 6)
	public void Uploadpdf() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Upload Documents

// Upload Documents

		WebElement clk1 = driver.findElement(By.xpath("//*[contains(text(),'Upload Document')]"));
		js.executeScript("arguments[0].click()", clk1);

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));
		driver.switchTo().frame(frameElement1);

		WebElement fileInput = driver.findElement(By.xpath("//div[@id='file-upload']//input[@type='file']"));
		js.executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys("C:\\Users\\Saravana\\Abhi\\Report\\Sanareport.pdf");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

	}

	@Test(priority = 7)
	public void Uploadinvaliddocument() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		// Upload Documents

// Upload Documents

		WebElement clk1 = driver.findElement(By.xpath("//*[contains(text(),'Upload Document')]"));
		js.executeScript("arguments[0].click()", clk1);

		WebElement frameElement1 = driver.findElement(By.xpath("//iframe[@id='content-frame']"));
		driver.switchTo().frame(frameElement1);

		WebElement fileInput = driver.findElement(By.xpath("//div[@id='file-upload']//input[@type='file']"));
		js.executeScript("arguments[0].style.display = 'block';", fileInput);
		fileInput.sendKeys("C:\\Users\\Saravana\\Abhi\\Report\\sample1.txt");
		Thread.sleep(2500);

		driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

	}

	@Test(priority = 8)
	public void backbtn() throws InterruptedException {

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

		WebElement frameElement = driver.findElement(By.xpath("//iframe[@id='content-frame-home']"));

		driver.switchTo().frame(frameElement);

		driver.findElement(By.xpath("//button[@id='tab-quick']")).click();

		driver.findElement(By.xpath("//input[@id='patient_id_email']")).sendKeys("327");

		driver.findElement(By.xpath("//button[@type='submit'][1]")).click();

		WebElement clk = driver.findElement(By.xpath(
				"//a[@class='inline-block bg-green-500 hover:bg-green-600 text-white font-medium py-1 px-3 rounded transition duration-150']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", clk);

		driver.findElement(By.xpath("//button[@id='home-btn']")).click();

		driver.findElement(By.xpath("//*[contains(@id,'back-btn')]")).click();

	}

	@AfterClass
	public void tearDown() {

		// Close the browser
		driver.quit();
	}

}
