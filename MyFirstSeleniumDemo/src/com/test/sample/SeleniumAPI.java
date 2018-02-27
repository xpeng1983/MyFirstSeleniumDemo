package com.test.sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		// ���� Dimension��������500��ʾ��������ڵĳ��ȺͿ��
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
	 * ��ѡ�б����
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

		dropList.selectByIndex(2); // ѡ�������б�ڼ���Ԫ��
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
	 * ��ѡ�б����
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
		System.out.println("�б��ȣ�" + radioOptions.size());
		for (WebElement we : radioOptions) {
			if (we.getAttribute("value").equals("watermelon")) {

				if (!we.isSelected()) {
					we.click();
				}
				break;
			}
		}
	}

	/**
	 * ��ѡ��
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
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

	/**
	 * ɱ������
	 */
	@Test(enabled = false)
	public void operateEindowsProcess() {
		WindowsUtils.killByName("firefox.exe"); // ɱ��Windows�����е�Firefox��������̣��ر�����Firefox�����
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("chrome.exe");
	}

	/**
	 * ����
	 * 
	 * @throws IOException
	 */
	@Test(enabled = false)
	public void captureScreenInCurrentWindow() throws IOException {
		Global.driver.get(Global.url);
		// �ѵ�ǰ������򿪵�ҳ����н�ͼ�����浽һ��File������
		File scrFile = ((TakesScreenshot) Global.driver).getScreenshotAs(OutputType.FILE);
		// ��File����ת��Ϊһ��������C������testingĿ¼����Ϊtest.png��ͼƬ�ļ�
		FileUtils.copyFile(scrFile, new File("c:\\testing\\test.png"));
	}

	/**
	 * ���ҳ��Ԫ�ص��ı������Ƿ����
	 */
	@Test(enabled = false)
	public void isElementTextPresent() {
		Global.driver.get(Global.url);
		WebElement text = Global.driver.findElement(By.xpath("//p[1]"));
		String contentText = text.getText();// ��ȡPԪ�ر�ǩ���ı�����
		Assert.assertEquals(contentText, "������֮·�������Ӱ��Ĳ���");
		Assert.assertTrue(contentText.contains("��Ӱ")); // �Ƿ������Ӱ
		Assert.assertTrue(contentText.startsWith("��"));
		Assert.assertTrue(contentText.endsWith("��"));
	}

	/**
	 * ִ��javaScript�ű�
	 */
	@Test(enabled = false)
	public void executeJavaScript() {
		Global.driver.get(Global.url);
		JavascriptExecutor js = (JavascriptExecutor) Global.driver;
		String title = (String) js.executeScript("return document.title");
		System.out.println(title);

		String serachButtonText = (String) js
				.executeScript("var button=document.getElementById('stb');return button.value");

		System.out.println(serachButtonText);
	}

	/**
	 * ��קҳ��Ԫ��
	 */
	@Test(enabled = false)
	public void dragPageElement() {
		Global.driver.get(Global.url);
		WebElement draggable = Global.driver.findElement(By.id("draggable"));
		// ��ק�ƶ����·���ʾ�����ƶ�100�����أ�0��ʾԪ�صĺ����겻��
		new Actions(Global.driver).dragAndDropBy(draggable, 0, 100).build().perform();
	}

	/**
	 * ģ����̲���
	 */
	@Test(enabled=false)
	public void clickKeys() {
		Global.driver.get(Global.url);
		Actions action = new Actions(Global.driver);
		action.keyDown(Keys.CONTROL); // ����Ctrl��
		action.keyDown(Keys.ALT); // ����Atl��
		action.keyDown(Keys.SHIFT);
		action.keyUp(Keys.CONTROL); // �ͷ�Control��
		action.keyUp(Keys.ALT); //
		action.keyUp(Keys.SHIFT);
		//ģ�����������������������д���ַ���ABCDEFG��
		action.keyDown(Keys.SHIFT).sendKeys("abcdedf").perform(); 
	}
	
	
	/**
	 * ģ������Ҽ��¼�
	 */
	@Test(enabled=false)
	public void rightClickMouse() {
		Global.driver.get(Global.url);
		Actions action = new Actions(Global.driver);
		//ģ������Ҽ���������
		action.contextClick(Global.driver.findElement(By.id("stb"))).perform();
	}
	
	/**
	 * �ƶ������� 
	 * ��ָ��Ԫ���Ϸ������������
	 */
	@Test(enabled=false)
	public void roverOnElement() {
		Global.driver.get(Global.url);
//		Actions action = new Actions(Global.driver);
		//action.moveToElement(wb).perform;
	}
	
	/**
	 * ��곤ʱ�䱻���£����ͷŲ���
	 * ��ָ��Ԫ���Ͻ�����굥��������ͷŵĲ���
	 */
	@Test(enabled=false)
	public void mouseClickAndRelease() {
		
		Global.driver.get(Global.url);
		WebElement div=Global.driver.findElement(By.xpath("//div[@id='div1']"));
		Actions action = new Actions(Global.driver);
		action.clickAndHold(div).perform(); //��걻����
		action.release(div).perform(); //��걻�ͷ�
		
	}	
	
	
	/**
	 * ��ȡҳ��Ԫ�ص�CSS����ֵ
	 */
	@Test(enabled=false)
	public void getWebElementCssValue() {
		Global.driver.get(Global.url);
		WebElement input=Global.driver.findElement(By.id("query"));
		System.out.println(input.getCssValue("vertical-align"));
		
	}	
	
	/**
	 * ��ʽ�ȴ�
	 */
	@Test(enabled=false)
	public void testImplictWait() {
		Global.driver.get(Global.url);
		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	/**
	 * ��ʽ�ȴ�
	 */
	@Test
	public void testExplicitWait() {
		
		Global.driver.get(Global.url);
		WebDriverWait wait=new WebDriverWait(Global.driver,10);
		//�ж�ҳ������Ƿ����ˮ������
		wait.until(ExpectedConditions.titleContains("ˮ��"));
		System.out.println("������� ˮ��");
		
		//�����ǰ�����б��е�Ԫ��
		WebElement select=Global.driver.findElement(By.id("peach"));
		//�ж�Ԫ���Ƿ���ѡ��״̬
		wait.until(ExpectedConditions.elementToBeSelected(select));
		System.out.println("���������ѡ��'����'Ŀǰ����ѡ��״̬");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[1]")));
		System.out.println("ҳ�渴ѡ������ʾ�Ϳɱ�����״̬");
		
		//�ж�P��ǩ�����Ƿ���ҳ����
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p")));
		System.out.println("ҳ��P��ǩԪ������ʾ");
		
		WebElement p=Global.driver.findElement(By.xpath("//P"));
		wait.until(ExpectedConditions.textToBePresentInElement(p, "���Ե�ˮ��"));
		System.out.println("ҳ���p��ǩԪ�ذ����ı�\"���Ե�ˮ��\"");
		
	;
	;
	}	
}
