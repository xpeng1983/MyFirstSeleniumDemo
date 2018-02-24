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
	// // driver.navigate().to(baseUlr); //�л�ҳ��
	// // Thread.sleep(2000);
	// // driver.navigate().back(); //ҳ�����
	// // Thread.sleep(2000);
	// // driver.navigate().forward(); //ҳ��ǰ��
	// // Thread.sleep(2000);
	// driver.navigate().refresh(); // ˢ��ҳ��
	// }
//
//	@Test
//	public void operateBrowser() throws InterruptedException {
//
////		/*
////		 * ����һ��Point��������150��ʾ�����λ���������Ļ�����Ͻǣ�0��0���ĺ���������������
////		 */
////		Point point = new Point(150, 150);
////		// ���� Dimension��������500��ʾ��������ڵĳ��ȺͿ��
////		Dimension dimension = new Dimension(500, 500);
////		// �������������Ļ�е�λ�ã���ĳЩ�汾���´˷���ʧЧ
////
////		driver.manage().window().setPosition(point);
////		// ������������ڵĴ�С
////		driver.manage().window().setSize(dimension);
////		Thread.sleep(2000);
////		System.out.println(driver.manage().window().getPosition());
////		System.out.println(driver.manage().window().getSize());
////
////		driver.manage().window().maximize();
////		
//		driver.get(baseUlr);
//		
//		//����driver��getTitle������ȡҳ���Title����
//		//String webTitle=driver.getTitle();
//		
//		//��ȡҳ��Դ����
//		//System.out.println(driver.getPageSource());
//		
//		//��ȡ��ǰҳ��ģգң̵�ַ
//		System.out.println(driver.getCurrentUrl());
//		
//		WebElement input=driver.findElement(By.id("query"));
//		//�������������ָ������
//		input.sendKeys("hello");
//		Thread.sleep(2000);
//		//������������ԭ�е���������
////		input.clear();
//		
//		//������ť
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
		System.out.println("�ر������");
		//driver.close();
	}
}
