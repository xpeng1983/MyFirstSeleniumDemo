package com.test.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;



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
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void testAjaxDivOption() throws InterruptedException {

		Global.driver.get("http://www.sogou.com");
		WebElement searchInputBox = Global.driver.findElement(By.id("query"));
		searchInputBox.click();
		System.out.println("-------------------------------");
		System.out.println(Global.driver.getPageSource());
		System.out.println("-------------------------------");
		// Thread.sleep(2000);

		// List<WebElement> suggetionOptions =
		// Global.driver.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));

		List<WebElement> suggetionOptions = (new WebDriverWait(Global.driver, 20))
				.until(new ExpectedCondition<List<WebElement>>() {

					@Override
					public List<WebElement> apply(WebDriver arg0) {
						return arg0.findElements(By.xpath("//*[@id='vl']/div[1]/ul/li"));
					}
				});
		System.out.println("����:" + suggetionOptions.size());
		for (WebElement element : suggetionOptions) {
			System.out.println(element.getText());
			if (element.getText().contains("�й�" + "")) {
				// element.click();
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
	@Test(enabled = false)
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

	/**
	 * ������ѡ�����Ͻ�������ѡ��
	 */
	@Test(enabled = false)
	public void testdataPicker() {
		Global.driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		// ���ҵ����������ֱ���������ڣ��Ϳ��Ա���ģ�������ڿؼ��Ͻ���ѡ��
		Global.driver.findElement(By.id("datepicker")).sendKeys("12/13/2015");

	}

	/**
	 * ����Webҳ��Ĺ����� 1��������������ҳ�����·�
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, enabled = false)
	public void scrollingToBottonmofApage() throws InterruptedException {
		Global.driver.get("http://v.sogou.com/");
		// ʹ��JavaScript��scrollTo������documet.body.scrollHeight����
		// ��ҳ��Ĺ�����������ҳ������·�
		((JavascriptExecutor) Global.driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		// ͣ��3�룬�����˹���֤�������Ƿ񻬶���ָ����λ�ã����ݲ������󣬿�ע�������ͣ�ٴ���
		Thread.sleep(3000);
	}

	/**
	 * ����Webҳ��Ĺ����� 2�������������ҵ�ָ����Ԫ��
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, enabled = false)
	public void scrollingToElementofPage() throws InterruptedException {
		WebElement element = Global.driver.findElement(By.xpath("//a[text()='����']"));
		// ʹ��JavaScript��scrollIntoView()������������������ҳ���ָ��Ԫ��λ��
		((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = false)
	public void scrollingByCoordinatesofAPage() throws InterruptedException {
		// ʹ��JavaScript��scrollTo������ʹ��0��800�ĺ����������
		// ��ҳ��Ĺ����������»�800������
		((JavascriptExecutor) Global.driver).executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
	}
	
	/**
	 * ģ����̲��������ı���ճ�����и��Ƴ���
	 * @throws InterruptedException
	 */
	@Test(enabled=false)
	public void testRobotOperateKeyboard() throws InterruptedException {

		Global.driver.get("https://www.sogou.com/");
		WebDriverWait wait = new WebDriverWait(Global.driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
		System.out.println("���ı�������ճ���汾");
		setAndctrlVClipboardData("����֮·�Զ�������");
		System.out.println("��Tab��");
		pressTabKey();
		System.out.println("��enter��");
		pressEnterKey();
		Thread.sleep(3000);
	}
	
	/**
	 *  ��װ��ճ�����������Խ�������string����ֵ���뵽�������У�Ȼ����ʹ��Robot
	 *  �����keyPress��KeyRelease������ģ��ctrl+v��ϼ����ճ������
	 * @param string
	 */
	public void setAndctrlVClipboardData(String string) {

		// ����StringSelection���󣬲�ʹ�ú�����string�������ʵ����
		StringSelection stringSelection = new StringSelection(string);
		// ʹ��Toolkit�����setContents�������ַ����ŵ����а���
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		//����Robot����
		Robot robot=null;
		
		try {
			robot=new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����keyPress������ʵ�ְ���Ctrl�� 
		robot.keyPress(KeyEvent.VK_CONTROL);
		//����keyPress������ʵ�ְ���V�� 
		robot.keyPress(KeyEvent.VK_V);
		//����keyRelease������ʵ���ͷ�V��
		robot.keyRelease(KeyEvent.VK_V);
		//���� KeyRelease������ʵ���ͷ�Ctrl��
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	
	public void pressTabKey() {
		Robot robot=null;
		
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		//���ð���Tab��
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void pressEnterKey() {
		Robot robot=null;
		try {
			robot=new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
}
