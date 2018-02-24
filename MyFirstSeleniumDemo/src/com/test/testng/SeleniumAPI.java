package com.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumAPI {
	public WebDriver driver;
	//String baseUlr = "https://www.sogou.com/";
	String baseUlr = "file:///C:/Users/windows/Desktop/seleniumtestweb/select.html";
	// @Test
	// public void testSearch() throws InterruptedException {
	// driver.get(baseUlr);
	// Thread.sleep(2000);
	// // baseUlr = "http://www.baidu.com";
	// // driver.navigate().to(baseUlr); //切换页面
	// // Thread.sleep(2000);
	// // driver.navigate().back(); //页面后退
	// // Thread.sleep(2000);
	// // driver.navigate().forward(); //页面前进
	// // Thread.sleep(2000);
	// driver.navigate().refresh(); // 刷新页面
	// }
//
//	@Test
//	public void operateBrowser() throws InterruptedException {
//
////		/*
////		 * 声明一个Point对象，两个150表示浏览器位置相对于屏幕的左上角（0，0）的横坐标和纵坐标距离
////		 */
////		Point point = new Point(150, 150);
////		// 声明 Dimension对象，两个500表示浏览器窗口的长度和宽度
////		Dimension dimension = new Dimension(500, 500);
////		// 设置浏览器在屏幕中的位置，在某些版本器下此方法失效
////
////		driver.manage().window().setPosition(point);
////		// 设置浏览器窗口的大小
////		driver.manage().window().setSize(dimension);
////		Thread.sleep(2000);
////		System.out.println(driver.manage().window().getPosition());
////		System.out.println(driver.manage().window().getSize());
////
////		driver.manage().window().maximize();
////		
//		driver.get(baseUlr);
//		
//		//调用driver的getTitle方法获取页面的Title属性
//		//String webTitle=driver.getTitle();
//		
//		//获取页面源代码
//		//System.out.println(driver.getPageSource());
//		
//		//获取当前页面的ＵＲＬ地址
//		System.out.println(driver.getCurrentUrl());
//		
//		WebElement input=driver.findElement(By.id("query"));
//		//在输入框中输入指定内容
//		input.sendKeys("hello");
//		Thread.sleep(2000);
//		//在输入框中清除原有的文字内容
////		input.clear();
//		
//		//单击按钮
//		driver.findElement(By.id("stb")).click();
//		Thread.sleep(2000);
//	}

//	@Test
//	public void test2() throws InterruptedException {
//		driver.get(baseUlr);
//		WebElement input=driver.findElement(By.id("inputBox"));
//		System.out.println("1");
//		input.sendKeys("hello");
//		System.out.println("2");
//		Actions builder=new Actions(driver);
//		builder.doubleClick(input).build().perform();
//		System.out.println("3");
//		Thread.sleep(2000);
//		System.out.println("4");
//	}
	
	@Test
	public void operationDropList() throws InterruptedException {
		driver.get(baseUlr);
		Thread.sleep(5000);
		Select dropList=new Select(driver.findElement(By.name("fruit")));
		System.out.println(dropList.isMultiple());
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.gecko.driver", "C:/bin/geckodriver/geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		
		
//		 System.setProperty("webdriver.ie.driver", "E:\\selectDriver\\IEDriverServer.exe");
//		// System.setProperty("webdriver.ie.driver", "D:\\soft\\360\\360se6\\Application\\360se.exe");
//		 driver = new InternetExplorerDriver();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("关闭浏览器");
		//driver.close();
	}
}
