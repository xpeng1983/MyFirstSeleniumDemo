package com.test.testng;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LocalTable {
	public WebDriver driver;
	//String baseUlr = "file:///C:/Users/windows/Desktop/test.html";
	String baseUlr = "https://www.baidu.com/";
	
	@Test
	public void testSogouSearch() {

		 driver.get(baseUlr);
		//
		// WebElement table = driver.findElement(By.xpath("//table"));
		//
		// List<WebElement> rows = table.findElements(By.xpath("//tr"));
		// for (WebElement row : rows) {
		// List<WebElement> cols = row.findElements(By.xpath("td"));
		// for (WebElement col : cols) {
		// System.out.print(col.getText() + " ");
		//
		// }
		// System.out.println();
		// }

	}

	@BeforeMethod
	public void beforeMethod() {

		// System.setProperty("webdriver.gecko.driver",
		// "C:/bin/geckodriver/geckodriver.exe");
		// System.setProperty("webdriver.firefox.bin",
		// "C:\\Users\\windows\\Desktop\\Mozilla Firefox\\firefox.exe");
		// driver = new FirefoxDriver();

		// System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
		//
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

		driver = new ChromeDriver();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println(driver);
		// driver.close();
	}
}
