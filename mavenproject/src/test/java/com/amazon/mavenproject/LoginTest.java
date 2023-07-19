package com.amazon.mavenproject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Login l;
    @BeforeTest(groups= {"sample"})
    @Parameters("browser")
    public void setUp(@Optional("chrome")String browser) throws InterruptedException
    {
    	String dir = System.getProperty("user.dir");
    	System.out.println(dir+browser);
    	if(browser.equals("chrome"))
    	{
	      System.setProperty("webdriver.chrome.driver",dir+"\\chromedriver_win32 (3)\\chromedriver.exe");
	      driver = new ChromeDriver();
    	}
    	else if(browser.equals("firefox"))
    	{
    		 System.setProperty("webdriver.gecko.driver",dir+"\\geckodriver-v0.33.0-win32\\geckodriver.exe");
    		FirefoxOptions option= new FirefoxOptions();
    		option.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
    		 driver = new FirefoxDriver(option);
    	}
      driver.get("http://www.amazon.com/");
      System.out.println("Title of the webpage is "+driver.getTitle());
      Thread.sleep(5000);
      l= new Login(driver);
      l.clickSignIn();
      
    }
    @Test(dataProvider = "excelData", dataProviderClass = Utility.ExcelReader.class,groups= {"sample"})
    public void loginToAmazon(String number,String password)
    {
    	l.loginAmazon(number,password);
    	System.out.println(number+" "+password);
    	//l.signOut1();
    }
    @AfterTest
    public void closure()
    {
    	driver.quit();
    }
 
    
}
