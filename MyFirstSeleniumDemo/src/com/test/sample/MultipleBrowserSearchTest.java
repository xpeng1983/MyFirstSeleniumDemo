package com.test.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleBrowserSearchTest {
	
	WebDriver driver;
	String url="http://www.sogou.com/";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) {
		//public void beforeTest() {
		//String browser="safari";
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/XPENG/chromedriver");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
	}
	@Test
	public void testSogouSearch() throws InterruptedException {
		driver.get(url);
		driver.findElement(By.id("query")).sendKeys("·Æ·²");
		driver.findElement(By.id("stb")).click();
		Thread.sleep(2000);
		
	}
	
	@AfterClass
	public void afterTest() {
		driver.close();
	}
}
