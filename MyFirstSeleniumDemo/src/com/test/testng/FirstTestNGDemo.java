package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTestNGDemo {

	public WebDriver driver;
	String baseUlr = "https://www.sogou.com/";

	@Test
	public void testSearch() {
		driver.get(baseUlr);
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		driver.findElement(By.id("stb")).click();

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
		driver.close();
	}
}
