package org.abhi;

import java.sql.Driver;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PatientRegister {
	WebDriver driver;

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://srv701482.hstgr.cloud/");

		driver.manage().window().maximize();

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));

		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("aro");

		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("raj");

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("01", "20", "1997");

		driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("9999999991");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("omg@gmail.com");

		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("chennai");

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("arav@123");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
}
