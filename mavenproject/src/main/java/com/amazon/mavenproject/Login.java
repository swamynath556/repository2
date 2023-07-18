package com.amazon.mavenproject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class Login {

	WebDriver driver;
	Actions action;
	WebDriverWait wait;
	@FindBy(xpath = "//span[contains(.,'Hello, sign in')]")
	WebElement signin;
	
	@FindBy(xpath = "(//span[contains(.,'Sign in')])[1]")
	WebElement signinButton;
	
	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement mobileNumber;
	
	@FindBy(xpath = "//input[contains(@type,'password')]")
	WebElement passWord;
	
	@FindBy(xpath = "//span[contains(.,'Sign Out')]")
	WebElement signoutBtn;
	
	@FindBy(xpath = "//span[contains(.,'Account & Lists')]")
	WebElement account;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickSignIn()
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(signin));
		action= new Actions(driver);
		action.moveToElement(signin).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(signinButton));
		signinButton.click();
		
	}
	public void loginAmazon(String number,String password)
	{
		wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(mobileNumber));
		mobileNumber.sendKeys(number,Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(passWord));
		passWord.sendKeys(password);
	
	}
	public void signOut1()
	{
		action.moveToElement(account).build().perform();
		signoutBtn.click();
	}
}
