package com.test.sample;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SeleniumAPI2 {

	/**
	 * 使用JavaScriptExecutor单击元素
	 */
	@Test(enabled = false)
	public void testHandleiFrame() {
		Global.driver.get("http://www.sogou.com");
		// 查找sogou首页的搜索输入框
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		WebElement serachButton = Global.driver.findElement(By.id("stb"));

		searchInputBox.sendKeys("使用JavaScript语句进行页面元素的单击");
		JavaScriptClick(serachButton);
	}

	/**
	 * 在Ajax方式产生的浮动框中，单击选择包含某个关键字的选项
	 * @throws InterruptedException 
	 */
	@Test(enabled=false)
	public void testAjaxDivOption() throws InterruptedException {

		Global.driver.get("http://www.sogou.com");
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		searchInputBox.click();
		System.out.println("-------------------------------");
		System.out.println(Global.driver.getPageSource());
		System.out.println("-------------------------------");
		//Thread.sleep(2000);
		
		//List<WebElement> suggetionOptions = Global.driver.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
		
		List<WebElement> suggetionOptions=(new WebDriverWait(Global.driver, 20)).until(new ExpectedCondition<List<WebElement>>(){

			@Override
			public List<WebElement> apply(WebDriver arg0) {
				return arg0.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
			}
		});
		System.out.println("长度:"+suggetionOptions.size());
		for (WebElement element : suggetionOptions) {
			System.out.println(element.getText());
			if (element.getText().contains("中国"
					+ "")) {
				//element.click();
				System.out.println(element.getText());
				element.click();
				break;
			}
		}
	}

	/**
	 * 单击事件封装方法
	 * 
	 * @param element
	 */
	@Test(enabled=false)
	public void JavaScriptClick(WebElement element) {

		try {
			// 判断传入的element元素是否处于可单击状态，以及是否显示在页面上
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("使用JavaScript进行页面元素的单击");
				// 执行JavaScript语句arguments[0].click();
				((JavascriptExecutor) Global.driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("页面上的元素元法进行单击操作");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("页面元素没有附加在页面中" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("在页面中没有找到要操作的页面元素" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("无法完成单击动作" + e.getStackTrace());
		}
	}
	
	/**
	 *   在日期选择器上进行日期选择
	 */
	@Test(enabled=false)
	public void testdataPicker() {
		Global.driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		//查找到日期输入框，直接输入日期，就可以变相模拟在日期控件上进行选择
		Global.driver.findElement(By.id("datepicker")).sendKeys("12/13/2015");
		
	}
	
	/**
	 * 操作Web页面的滚动条
	 * 1、滑动滚动条到页面最下方
	 * @throws InterruptedException 
	 */
	@Test(priority=1)
	public void scrollingToBottonmofApage() throws InterruptedException {
		Global.driver.get("http://v.sogou.com/");
		//使用JavaScript的scrollTo函数和documet.body.scrollHeight参数
		 //将页面的滚动条滑动到页面的最下方
		((JavascriptExecutor)Global.driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		//停顿3秒，用于人工验证滚动条是否滑动到指定的位置，根据测试需求，可注释下面的停顿代码
		Thread.sleep(3000);
	}
	
	/**
	 * 操作Web页面的滚动条
	 * 2、滑动滚动条找到指定的元素
	 * @throws InterruptedException 
	 */
	@Test(priority=2)
	public void scrollingToElementofPage() throws InterruptedException {
		WebElement element=Global.driver.findElement(By.xpath("//a[text()='美国']"));
		//使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的指定元素位置
		((JavascriptExecutor)Global.driver).executeScript("arguments[0].scrollIntoView();",element);
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void scrollingByCoordinatesofAPage() throws InterruptedException {
		//使用JavaScript的scrollTo函数，使用0和800的横纵坐标参数
		//将页面的滚动条纵向下滑800个像素
		((JavascriptExecutor)Global.driver).executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
	}
}

