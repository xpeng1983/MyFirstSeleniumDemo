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
	 * ʹ��TestNG����������
	 * 
	 * @param searchWord1
	 * @param searchWord2
	 * @param searchResult
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "testData")
	public void testSearch(String searchWord1, String searchWord2, String searchResult) throws InterruptedException {
		System.out.println("�������");
		driver.get("http://www.sogou.com");
		driver.findElement(By.id("query")).sendKeys(searchWord1 + " " + searchWord2);
		driver.findElement(By.id("stb")).click();

		// ʹ����ʾ�ȴ���ʽ��ȷ��ҳ���Ѿ�������ɣ�ҳ��ײ��Ĺؼ��� �������������Ѿ���ʾ��ҳ����
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.id("sogou_mianze")).getText().contains("����");
			}
		});
		
		Assert.assertTrue(driver.getPageSource().contains(searchResult));
		
	}

	/**
	 * ��ȡCSV�ļ���̬������ʹ��CSV�ļ��ľ����ļ�·����Ϊ��������
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Object[][] getTestData(String fileName) throws IOException {

		List<Object[]> records = new ArrayList<Object[]>();
		String record;
		// �趨UTF-8�ַ�����ʹ�ô����������ַ�������BufferedReader��ȡ�ļ�����
		BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
		// ���Զ�ȡCSV�ļ������У���һ�У�
		file.readLine();
		/*
		 * ������ȡ�ļ��г���һ������������������ݲ��洢����Ϊrecords��ArrayList�У�ÿһ��recods�д洢�Ķ���Ϊһ��String����
		 */
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		// ���庯������ֵ����object[][]

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
