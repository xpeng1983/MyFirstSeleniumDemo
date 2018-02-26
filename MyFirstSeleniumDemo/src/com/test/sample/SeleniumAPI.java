package com.test.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumAPI {

	@Test(enabled = false)
	public void testSearch() throws InterruptedException {
		Global.driver.get(Global.url);
		Thread.sleep(2000);
		Global.url = "http://www.baidu.com";
		Global.driver.navigate().to(Global.url); // �л�ҳ��
		Thread.sleep(2000);
		Global.driver.navigate().back(); // ҳ�����
		Thread.sleep(2000);
		Global.driver.navigate().forward(); // ҳ��ǰ��
		Thread.sleep(2000);
		Global.driver.navigate().refresh(); // ˢ��ҳ��
	}

	@Test(enabled = false)
	public void operateBrowser() throws InterruptedException {
		/*
		 * ����һ��Point��������150��ʾ�����λ���������Ļ�����Ͻǣ�0��0���ĺ���������������
		 */
		Point point = new Point(150, 150);
		// ���� Dimension��������500��ʾ��������ڵĳ��ȺͿ���
		Dimension dimension = new Dimension(500, 500);
		// �������������Ļ�е�λ�ã���ĳЩ�汾���´˷���ʧЧ

		Global.driver.manage().window().setPosition(point);
		// ������������ڵĴ�С
		Global.driver.manage().window().setSize(dimension);
		Thread.sleep(2000);
		System.out.println(Global.driver.manage().window().getPosition());
		System.out.println(Global.driver.manage().window().getSize());

		Global.driver.manage().window().maximize();

		Global.driver.get(Global.url);

		// ����Global.driver��getTitle������ȡҳ���Title����
		Global.driver.getTitle();

		// ��ȡҳ��Դ����
		System.out.println(Global.driver.getPageSource());

		// ��ȡ��ǰҳ��ģգң̵�ַ
		System.out.println(Global.driver.getCurrentUrl());

		WebElement input = Global.driver.findElement(By.id("query"));
		// �������������ָ������
		input.sendKeys("hello");
		Thread.sleep(2000);
		// ������������ԭ�е���������
		input.clear();

		// ������ť
		Global.driver.findElement(By.id("stb")).click();
		Thread.sleep(2000);
	}

	@Test(enabled = false)
	public void test2() throws InterruptedException {
		Global.driver.get(Global.url);
		WebElement input = Global.driver.findElement(By.id("inputBox"));
		System.out.println("1");
		input.sendKeys("hello");
		System.out.println("2");
		Actions builder = new Actions(Global.driver);
		builder.doubleClick(input).build().perform();
		System.out.println("3");
		Thread.sleep(2000);
		System.out.println("4");
	}

	/**
	 * ��ѡ�б�����
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void operationDropList() throws InterruptedException {
		Global.driver.get(Global.url);
		Thread.sleep(5000);
		Select dropList = new Select(Global.driver.findElement(By.name("fruit"))); // ���������б�
		System.out.println(dropList.isMultiple()); // �ж������б��Ƿ����ж�ѡ

		System.out.println(dropList.getFirstSelectedOption().getText()); // ��ȡ�����б��ı�

		dropList.selectByIndex(2); // ѡ�������б��ڼ���Ԫ��
		Thread.sleep(2000);

		dropList.selectByValue("xigua"); // ͨ��value����ֵ����ѡ��
		Thread.sleep(2000);

		dropList.selectByVisibleText("��");

		List<String> expect_options = Arrays.asList(new String[] { "��", "����", "����" });
		List<String> actual_options = new ArrayList<String>();
		for (WebElement option : dropList.getOptions()) {
			actual_options.add(option.getText());
		}
		Assert.assertEquals(expect_options.toArray(), actual_options.toArray());
	}

	/**
	 * ��ѡ�б�����
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void operateMultipleOptionDropList() throws InterruptedException {

		Global.driver.get(Global.url);
		Thread.sleep(5000);
		Select dropList = new Select(Global.driver.findElement(By.name("fruit"))); // ���������б�

		System.out.println("�б��Ƿ�֧�ֶ�ѡ��" + dropList.isMultiple());

		dropList.selectByIndex(1); // ѡ��Ԫ��
		dropList.selectByValue("lizhi");
		dropList.selectByVisibleText("��");

		Thread.sleep(2000);

		dropList.deselectByIndex(1);
		dropList.deselectByValue("lizhi");
		dropList.deselectByVisibleText("��");

		Thread.sleep(2000);

		dropList.selectByIndex(1); // ѡ��Ԫ��
		dropList.selectByValue("lizhi");
		dropList.selectByVisibleText("��");

		Thread.sleep(2000);
		dropList.deselectAll(); // ȡ������ѡ���ѡ��״̬
	}

	/**
	 * ������ѡ��ť
	 */
	@Test(enabled = false)
	public void operateRadio() {

		Global.driver.get(Global.url);
		WebElement radioOption = Global.driver.findElement(By.xpath("//input[@value='berry']"));

		if (!radioOption.isSelected()) {
			radioOption.click();
		}
		Assert.assertTrue(radioOption.isSelected());

		List<WebElement> radioOptions = Global.driver.findElements(By.xpath("//input"));
		System.out.println("�б����ȣ�" + radioOptions.size());
		for (WebElement we : radioOptions) {
			if (we.getAttribute("value").equals("watermelon")) {

				if (!we.isSelected()) {
					we.click();
				}
				break;
			}
		}
	}

	@Test
	public void operateCheckBox() throws InterruptedException {

		Global.driver.get(Global.url);
		WebElement checkBoxOption = Global.driver.findElement(By.xpath("//input[@value='berry']"));

		if (!checkBoxOption.isSelected()) {
			checkBoxOption.click();
		}

		Thread.sleep(2000);

		if (checkBoxOption.isSelected()) {
			checkBoxOption.click();
		}
	}
}