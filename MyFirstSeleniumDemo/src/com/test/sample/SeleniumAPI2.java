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
	 * ʹ��JavaScriptExecutor����Ԫ��
	 */
	@Test(enabled = false)
	public void testHandleiFrame() {
		Global.driver.get("http://www.sogou.com");
		// ����sogou��ҳ�����������
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		WebElement serachButton = Global.driver.findElement(By.id("stb"));

		searchInputBox.sendKeys("ʹ��JavaScript������ҳ��Ԫ�صĵ���");
		JavaScriptClick(serachButton);
	}

	/**
	 * ��Ajax��ʽ�����ĸ������У�����ѡ�����ĳ���ؼ��ֵ�ѡ��
	 */
	@Test
	public void testAjaxDivOption() {

		Global.driver.get("http://www.sogou.com");
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		searchInputBox.click();

		List<WebElement> suggetionOptions = Global.driver.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
		System.out.println("����:"+suggetionOptions);
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
	 * �����¼���װ����
	 * 
	 * @param element
	 */
	public void JavaScriptClick(WebElement element) {

		try {
			// �жϴ����elementԪ���Ƿ��ڿɵ���״̬���Լ��Ƿ���ʾ��ҳ����
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("ʹ��JavaScript����ҳ��Ԫ�صĵ���");
				// ִ��JavaScript���arguments[0].click();
				((JavascriptExecutor) Global.driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("ҳ���ϵ�Ԫ��Ԫ�����е�������");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("ҳ��Ԫ��û�и�����ҳ����" + e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("��ҳ����û���ҵ�Ҫ������ҳ��Ԫ��" + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("�޷���ɵ�������" + e.getStackTrace());
		}
	}
	
	
	
}
