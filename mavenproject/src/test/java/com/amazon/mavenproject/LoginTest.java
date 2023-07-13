package com.amazon.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

	WebDriver driver;
	Login l;
    @BeforeTest
    public void setUp()
    {
    	String dir = System.getProperty("user.dir");
System.out.println(dir);
      System.setProperty("webdriver.chrome.driver",dir+"\\chromedriver_win32 (3)\\chromedriver.exe");
      //ChromeOptions options = new ChromeOptions();
      //options.addArguments("--remote-allow-origins=*");
      ChromeOptions options = new ChromeOptions();
      ChromeOptions chromeOptions= new ChromeOptions();
      chromeOptions.setBinary("C:\\Users\\Swamynath\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
 
      driver = new ChromeDriver(options);
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
    	//l.signOut1();
    }
    @AfterTest
    public void closure()
    {
    	driver.quit();
    }
 
    public void sampleMethod1()
    {
    	
    	//Just checking whether Sample branch is working or not
    	//Added a comment
    	//2ND 
    	//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
    	
    	//Password
    	
    }
    
}
