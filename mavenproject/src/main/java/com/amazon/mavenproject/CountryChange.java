package com.amazon.mavenproject;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class CountryChange {
	
	WebDriver driver;

	@FindBy(xpath = "//span[contains(@class,'icp-nav-flag icp-nav-flag-us icp-nav-flag-lop')]")
	WebElement changeLanguageIcon;
	
	@FindBy(xpath = "(//div[@class='icp-mkt-change-lnk'])[1]")
	WebElement changeCountry;
	
	@FindBy(id="icp-dropdown")
	WebElement dropdown;
	
	@FindBy(xpath = "//input[@class='a-button-input']")
	WebElement goToWebsite;
	
	@FindBy(xpath="//span[@class='nav-line-2']//div")
	WebElement countryName;
	
	String parentWindowHandle;
	
	public CountryChange(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void moveCursorToIcon()
	{
		Actions action= new Actions(driver);
		action.moveToElement(changeLanguageIcon).build().perform();
	}
	public void clickChangeCountry()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		changeCountry.click();
		System.out.println("Clicked on Change Country");
		
	}
	public String selectCountry()
	{
		parentWindowHandle=driver.getWindowHandle();
		Select drpCountry=new Select(dropdown);
		drpCountry.selectByVisibleText("India");
		System.out.println("Clicked on India succesfully");
		goToWebsite.click();
		String countryValue=countryName.getText();
		System.out.println(countryValue);
		return countryValue;
	}
	public void goBackToParentWindow() throws InterruptedException
	{
		Set<String>s= driver.getWindowHandles();
		driver.switchTo().window(parentWindowHandle);
		System.out.println("Title of parent webpage is "+driver.getTitle()+" "+s.size());
		Thread.sleep(5000);
		Iterator<String> I1= s.iterator();
		while(I1.hasNext())
		{
			String child=I1.next();
			if(!parentWindowHandle.equals(child))
			{
			driver.switchTo().window(child);
			System.out.println("Title of child webpage is"+driver.getTitle());
			}
		
		}
		
	}
	
}
