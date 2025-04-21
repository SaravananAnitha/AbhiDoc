package com.abhi.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.abhi.testcomponenets.Basetest;

public class LoginPage extends Basetest {
	WebDriver driver;
	
	public LoginPage (WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

    // Web elements on the page
    @FindBy(xpath = "//a[text()='Register']")
    WebElement Register;

    @FindBy(xpath = "//input[@id='first_name']")
    WebElement Firstname;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement Lastname;
    
    @FindBy(xpath = "//input[@id='dob']")
    WebElement dob;
    
    @FindBy(xpath = "//input[@id='phone_number']")
    WebElement Phonenumber;

    @FindBy(xpath = "//input[@id='email']")
    WebElement Email;

    @FindBy(xpath = "//input[@id='address']")
    WebElement Address;
    
    @FindBy(xpath = "//input[@id='password']")
    WebElement Password;
    
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Submit;
    
    @FindBy(xpath = "//a[text()='Back to Main Page']")
    WebElement Mainpage;
    
    @FindBy(xpath = "//a[text()='Patient Login']")
    WebElement Login;
    
    @FindBy(xpath = "//input[@id='username_or_email']")
    WebElement Username;
    
    @FindBy(xpath = "//input[@id='password']")
    WebElement Pass;
    
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Submit1;
    
    @FindBy(xpath = "//div[@class='flex flex-col lg:flex-row items-start lg:items-center justify-between px-4 lg:px-8 py-4']")
    WebElement Welcometext;
    
 // Methods to interact with the Register page elements
    public void clickRegister() {
        Register.click();
    }

    public void enterFirstName(String firstName) {
        Firstname.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        Lastname.sendKeys(lastName);
    }

    public void enterDOB(String dateOfBirth) {
        dob.sendKeys(dateOfBirth);
    }

    public void enterPhoneNumber(String phoneNumber) {
        Phonenumber.sendKeys(phoneNumber);
    }

    public void enterEmail(String email) {
        Email.sendKeys(email);
    }

    public void enterAddress(String address) {
        Address.sendKeys(address);
    }

    public void enterPassword(String password) {
        Password.sendKeys(password);
    }

    public void clickSubmit() {
        Submit.click();
    }

    public void clickMainPage() {
        Mainpage.click();
    }

    // Methods to interact with the Login page elements
    public void clickLogin() {
        Login.click();
    }

    public void enterUsername(String username) {
        Username.sendKeys(username);
    }

    public void enterPasswordForLogin(String password) {
        Pass.sendKeys(password);
    }

    public void clickSubmitLogin() {
        Submit1.click();
    }

	public void goToUrl() {
		// TODO Auto-generated method stub
		
	}

	// 3.Get Error Message
//		public String getLoginErrorMsgText() {
//			String elementGetText = elementGetText(txtLoginErrormsg);
//			return elementGetText;
//		}
    
}
    
    

    
    