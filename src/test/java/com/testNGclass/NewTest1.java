package com.testNGclass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class NewTest1 {
	
	WebDriver driver;
  @Test
  public void f() {
	  driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
  }
  @BeforeTest
  public void beforeTest() {
	  WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
		 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
