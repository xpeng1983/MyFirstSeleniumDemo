package com.test.frameWork;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataDriverncsvFile {

	public WebDriver driver;
	String baseUlr = "http://www.sogou.com";

	@DataProvider(name = "testData")
	public static Object[][] words() throws IOException {
		;
		;
		return getTestData("SeleniumTestData\\CSV.csv");
	}

	/**
	 * 使用TestNG做数据驱动
	 * 
	 * @param searchWord1
	 * @param searchWord2
	 * @param searchResult
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2, String searchResult) throws InterruptedException {
		System.out.println("打开浏览器");
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(searchWord1 + " " + searchWord2);
		driver.findElement(By.id("stb")).click();

		// 使用显示等待方式，确定页面已经加载完成，页面底部的关键字 “搜索帮助”已经显示在页面上
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.id("sogou_mianze")).getText().contains("免责");
			}
		});
		
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
		
	}

	/**
	 * 读取CSV文件静态方法，使用CSV文件的绝对文件路径作为函数参数
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Object[][] getTestData(String fileName) throws IOException {

		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		// 设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		// 忽略读取CSV文件标题行（第一行）
		file.readLine();
		/*
		 * 遍历读取文件中除第一行外的其它所有行内容并存储在名为records的ArrayList中，每一个recods中存储的对象为一个String数组
		 */
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		// 定义函数返回值，即object[][]

		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		return results;
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "/XPENG/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--ignore-certificate-errors");
		driver = new ChromeDriver(options);
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
