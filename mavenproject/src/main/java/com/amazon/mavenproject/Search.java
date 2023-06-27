package com.amazon.mavenproject;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * @author Swamynath
 *
 */
public class Search 
{
	WebDriver driver;
	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	WebElement search_xpath;
	
	public Search(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String sendTexttoSearchBox(String text)
	{
		String search_text;
		search_xpath.sendKeys(text,Keys.ENTER);
		//search_xpath.sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		search_text= search_xpath.getAttribute("value");
		return search_text;
	}
	
}
