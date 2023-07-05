package com.amazon.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Login l;
    @BeforeTest
    public void setUp()
    {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Swamynath\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
      //ChromeOptions options = new ChromeOptions();
      //options.addArguments("--remote-allow-origins=*");
      driver = new ChromeDriver();
      driver.get("http://www.amazon.com/");
      System.out.println("Title of the webpage is "+driver.getTitle());
      l= new Login(driver);
      l.clickSignIn();
      
    }
    @Test(dataProvider = "excelData", dataProviderClass = Utility.ExcelReader.class)
    public void loginToAmazon(String number,String password)
    {
    	l.loginAmazon(number,password);
    	System.out.println(number+" "+password);
    	l.signOut();
    }
    @AfterTest
    public void closure()
    {
    	driver.quit();
    }
    public void sampleMethod()
    {
    	//Just checking whether Sample branch is working or not
    	
    }
    
}
