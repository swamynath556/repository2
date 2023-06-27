package com.amazon.mavenproject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class Login {

	WebDriver driver;
	Actions action;
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
		action= new Actions(driver);
		action.moveToElement(signin).build().perform();
		signinButton.click();
		
	}
	public void loginAmazon(String number,String password)
	{
		mobileNumber.sendKeys(number,Keys.ENTER);
		passWord.sendKeys(password,Keys.ENTER);
	
	}
	public void signOut()
	{
		action.moveToElement(account).build().perform();
		signoutBtn.click();
	}
}
