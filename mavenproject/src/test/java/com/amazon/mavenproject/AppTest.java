package com.amazon.mavenproject;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest 
{
	WebDriver driver;
	Search sh;
	CountryChange CC;
    @BeforeTest
    public void setUp()
    {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Swamynath\\git\\repository2\\mavenproject\\chromedriver_win32 (3)\\chromedriver.exe");
      //ChromeOptions options = new ChromeOptions();
      //options.addArguments("--remote-allow-origins=*");
      ChromeOptions options = new ChromeOptions();
      options.addArguments("headless");
      // Must maximize Chrome by `start-maximized`
      options.addArguments("start-maximized");
      driver = new ChromeDriver();
      driver.get("http://www.amazon.com/");
      System.out.println("Title of the webpage is "+driver.getTitle());
      
    }
    @Test(priority=1)
    public void searchFunction()
    {
    	sh= new Search(driver);
    	String value= sh.sendTexttoSearchBox("IQOO 9t");
    	Assert.assertEquals(value, "IQOO 9t"); 
    	System.out.println(value);
    }
    @Test(priority=2)
    public void changeCountryMethod() throws InterruptedException
    {
    	CC= new CountryChange(driver);
    	CC.moveCursorToIcon();
    	CC.clickChangeCountry();
    	String countryValue=CC.selectCountry();
    	Assert.assertEquals(countryValue,"EN");
    	CC.goBackToParentWindow();
    	
    }
    @AfterTest
    public void closure()
    {
    	driver.quit();
    }
    
}
