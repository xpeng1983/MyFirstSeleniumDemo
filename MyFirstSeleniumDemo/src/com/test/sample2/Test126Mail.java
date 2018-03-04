package com.test.sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test126Mail {
	public WebDriver driver;
	String baseUlr = "http://www.email.126.com/";
	

	
	@Test
	public void testLogin() throws InterruptedException {

		LoginPage loginPage=new LoginPage();
		loginPage.get();
		loginPage.login();
		Thread.sleep(5000);
		Assert.assertTrue(loginPage.getDriver().getPageSource().contains("当前安全手机"));
	}
	
}
