package com.test.sample;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
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
	 */
	@Test
	public void testAjaxDivOption() {

		Global.driver.get("http://www.sogou.com");
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		searchInputBox.click();

		List<WebElement> suggetionOptions = Global.driver.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
		System.out.println("长度:"+suggetionOptions);
		for (WebElement element : suggetionOptions) {
			System.out.println(element.getText());
			if (element.getText().contains("h")) {
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
	
	
	
}
