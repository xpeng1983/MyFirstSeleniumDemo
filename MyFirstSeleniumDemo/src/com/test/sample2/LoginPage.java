package com.test.sample2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import com.test.sample.Global;

public class LoginPage extends LoadableComponent<LoginPage>{
	
	
	//ʹ��FindByע�ͣ���λ����Ҫ������ҳ��Ԫ��
	@FindBy(xpath="//*[@data-loginname='loginEmail']")
	public WebElement userName;
	
	@FindBy(xpath="//*[@name='password']")
	public WebElement password;
	
	@FindBy(id="dologin")
	public WebElement loginButton;
	
	@FindBy(xpath="//*[@data-action='myphonegoon']")
	public WebElement loginButton2;
	
	public  WebDriver driver;
	private String baseUlr = "http://www.email.126.com/";
	//private String title="��ǰ��ȫ�ֻ�";

		
	//���幹�캯��������������ֵ�����Ա����driver����ʼ��PageFactory
	public LoginPage() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", "/XPENG/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type", "--ignore-certificate-errors");
		driver = new ChromeDriver(options);
		PageFactory.initElements(driver, this);
	}


	@Override
	protected void load() {
		driver.get(baseUlr);
	}
	
	public void login() throws InterruptedException {
		Thread.sleep(5000);
		WebElement iframe=driver.findElement(By.id("x-URS-iframe"));
		driver.switchTo().frame(iframe);
		userName.sendKeys("***********x");
		password.sendKeys("************");
		loginButton.click();
		Thread.sleep(1000);
		loginButton2.click();
		driver.switchTo().defaultContent();
	}

	public WebDriver getDriver() {
		return this.driver;
	}
	public void close() {
		this.driver.close();
	}

	@Override
	protected void isLoaded() throws Error {
		Assert.assertTrue(driver.getTitle().contains("���������"));
	}
}

