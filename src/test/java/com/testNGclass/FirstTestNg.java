package com.testNGclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTestNg {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
	
	WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@Test(priority = 1,description = "Opening browser and site" )
	public void Test1()
	{
		driver.get("https://opensource-demo.orangehrmlive.com");
		String ExpectedTitle ="OrangeHRM";
		String actualtitle=driver.getTitle();
		Assert.assertEquals(ExpectedTitle, actualtitle);
	}
	
	@Test(priority = 2,description = "loggin in using username and Password" ,dependsOnMethods = "Test1" )
	public void login() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String actualUrl=driver.getCurrentUrl();
		String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(expectedURL, actualUrl);
		
	}
	
}
