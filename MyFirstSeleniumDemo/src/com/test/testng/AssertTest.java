package com.test.testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssertTest {
	
	public WebDriver driver;
	String baseUlr = "https://www.sogou.com/";
	
	@Test
	public void testSogouSearch() {
		driver.get(baseUlr);
		List<WebElement> tests=driver.findElements(By.partialLinkText("¹ØÓÚ"));
		
	}
	
	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver", "C:/bin/geckodriver/geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Users\\windows\\Desktop\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println(driver);
//		driver.close();
	}
}
