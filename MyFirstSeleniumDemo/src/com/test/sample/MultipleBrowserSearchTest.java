package com.test.sample;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class MultipleBrowserSearchTest {

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", "/XPENG/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--test-type", "--ignore-certificate-errors");
			Global.driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("safari")) {
			Global.driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/bin/geckodriver/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			Global.driver = new FirefoxDriver();
		}
	}
	// @Test
	// public void testSogouSearch() throws InterruptedException {
	// Global.driver.get(url);
	// Global.driver.findElement(By.id("query")).sendKeys("菲凡");
	// Global.driver.findElement(By.id("stb")).click();
	// Thread.sleep(2000);
	//
	// }

	// @AfterTest
	// public void afterTest() {
	// System.out.println("开始退出浏览器");
	// Global.driver.close();
	// System.out.println("完成退出浏览器");
	// }
}
