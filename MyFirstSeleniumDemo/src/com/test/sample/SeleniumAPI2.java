package com.test.sample;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.glass.events.KeyEvent;

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
		System.out.println("长度:" + suggetionOptions.size());
		for (WebElement element : suggetionOptions) {
			System.out.println(element.getText());
			if (element.getText().contains("中国" + "")) {
				// element.click();
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
	@Test(enabled = false)
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
	 * 在日期选择器上进行日期选择
	 */
	@Test(enabled = false)
	public void testdataPicker() {
		Global.driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		// 查找到日期输入框，直接输入日期，就可以变相模拟在日期控件上进行选择
		Global.driver.findElement(By.id("datepicker")).sendKeys("12/13/2015");

	}

	/**
	 * 操作Web页面的滚动条 1、滑动滚动条到页面最下方
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, enabled = false)
	public void scrollingToBottonmofApage() throws InterruptedException {
		Global.driver.get("http://v.sogou.com/");
		// 使用JavaScript的scrollTo函数和documet.body.scrollHeight参数
		// 将页面的滚动条滑动到页面的最下方
		((JavascriptExecutor) Global.driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		// 停顿3秒，用于人工验证滚动条是否滑动到指定的位置，根据测试需求，可注释下面的停顿代码
		Thread.sleep(3000);
	}

	/**
	 * 操作Web页面的滚动条 2、滑动滚动条找到指定的元素
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, enabled = false)
	public void scrollingToElementofPage() throws InterruptedException {
		WebElement element = Global.driver.findElement(By.xpath("//a[text()='美国']"));
		// 使用JavaScript的scrollIntoView()函数将滚动条滑动到页面的指定元素位置
		((JavascriptExecutor) Global.driver).executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(3000);
	}

	@Test(priority = 3, enabled = false)
	public void scrollingByCoordinatesofAPage() throws InterruptedException {
		// 使用JavaScript的scrollTo函数，使用0和800的横纵坐标参数
		// 将页面的滚动条纵向下滑800个像素
		((JavascriptExecutor) Global.driver).executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
	}

	/**
	 * 模拟键盘操作，将文本从粘贴板中复制出来
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void testRobotOperateKeyboard() throws InterruptedException {

		Global.driver.get("https://www.sogou.com/");
		WebDriverWait wait = new WebDriverWait(Global.driver, 10);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("query")));
		System.out.println("将文本放入至粘贴版本");
		setAndctrlVClipboardData("光荣之路自动化测试");
		System.out.println("按Tab键");
		pressTabKey();
		System.out.println("按enter键");
		pressEnterKey();
		Thread.sleep(3000);
	}

	/**
	 * 封装的粘贴函数，可以将函数的string参数值加入到剪贴板中，然后再使用Robot
	 * 对象的keyPress和KeyRelease函数来模拟ctrl+v组合键完成粘贴操作
	 * 
	 * @param string
	 */
	public void setAndctrlVClipboardData(String string) {

		// 声明StringSelection对象，并使用函数的string参数完成实例化
		StringSelection stringSelection = new StringSelection(string);
		// 使用Toolkit对象的setContents方法将字符串放到剪切板中
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		// 声明Robot对象
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 调用keyPress方法来实现按下Ctrl键
		robot.keyPress(KeyEvent.VK_CONTROL);
		// 调用keyPress方法来实现按下V键
		robot.keyPress(KeyEvent.VK_V);
		// 调用keyRelease方法来实现释放V键
		robot.keyRelease(KeyEvent.VK_V);
		// 调用 KeyRelease方法来实现释放Ctrl键
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}

	public void pressTabKey() {
		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		// 调用按下Tab键
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void pressEnterKey() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * 操作富文本框
	 */
	@Test(enabled = false)
	public void testSohuMailWriteEMail() {
		// 切换到富文本框所在的Frame对象中
		Global.driver.switchTo().frame("htmlEditor");
		// 声明JavascriptExecutor对象来执行JavaScript脚本
		JavascriptExecutor js = (JavascriptExecutor) Global.driver;
		// document.getElementByTagName('body')[0]可以获取富文本框的编辑区域对象
		// 使用编辑区域对象的.innerHTML属性可以设定任意HTML格式的文字内容、
		js.executeScript("document.getElementsByTagName('body')[0].innerHTML='<b>邮件要发送的内容<b>'");
		// 从富文本框的Frame返回到默认的页面区域
		Global.driver.switchTo().defaultContent();
	}

	/**
	 * 精确比较网页截图图片
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(enabled=false)
	public void testImageComparison() throws InterruptedException, IOException {
		Global.driver.get("http://www.baidu.com/");
		Thread.sleep(3000);
		Global.driver.manage().window().maximize();
		Thread.sleep(3000);
		File screenshot = ((TakesScreenshot) Global.driver).getScreenshotAs(OutputType.FILE);
		Thread.sleep(3000);
		FileUtils.copyFile(screenshot, new File("d:\\20.jpg"));

		File fileInput = new File("d:\\1.jpg");
		File fileOutput = new File("d:\\1.jpg");

		BufferedImage bufileInput = ImageIO.read(fileInput);
		DataBuffer dafileInput = bufileInput.getData().getDataBuffer();
		int sizefileInput = dafileInput.getSize();

		BufferedImage bufileOutPut = ImageIO.read(fileOutput);
		DataBuffer dafileOutput = bufileOutPut.getData().getDataBuffer();
		int sizefileOutPut = dafileOutput.getSize();

		Boolean matchFlag = true;
		if (sizefileInput == sizefileOutPut) {
			for (int j = 0; j < sizefileInput; j++) {
				if (dafileInput.getElem(j) != dafileOutput.getElem(j)) {
					matchFlag = false;
					// Assert.assertTrue(matchFlag, "测试过程中的截图和期望的截图并不一致");
					System.out.println("载图不一致");
					break;
				}
			}
			// Assert.assertTrue(matchFlag, "测试过程中的截图和期望的截图一致");
		} else {
			matchFlag = false;
			System.out.println("截图不一致");
			// Assert.assertTrue(matchFlag, "测试过程中的截图和期望的截图并不一致");
		}
	}
	
	/**
	 * 高亮显示正在被操作的页面元素
	 * @throws InterruptedException
	 */
	@Test(enabled=false)
	public void testHightLightWebElement() throws InterruptedException {
		Global.driver.navigate().to("http://www.sogou.com");
		WebElement searchInputBox=Global.driver.findElement(By.id("query"));
		WebElement submitButton=Global.driver.findElement(By.id("stb"));
		// 设置高亮显示元素的封装函数，将搜索输入框进行高亮显示
		highlightElement(searchInputBox);
		searchInputBox.sendKeys("光荣之路自动化测试");
		Thread.sleep(3000);
		highlightElement(submitButton);
		Thread.sleep(3000);
		submitButton.click();
	}
	
	public void highlightElement(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)Global.driver;
		//使用JavaScript语句将传入参数的页面元素对象的背景颜色和边框颜色分别设置成为黄色和红色
		js.executeScript("arguments[0].setAttribute('style',arguments[1]);",element,"background:yellow;border:2px solid red;");
	}
	
	@Test(enabled=false)
	public void testLog4j() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("搜索功能测试开始");
		Global.driver.navigate().to("http://www.sogou.com");
		Log.info("打开sogou首页");
		WebElement searchInputBox=Global.driver.findElement(By.id("query"));
		WebElement submitButton=Global.driver.findElement(By.id("stb"));
		// 设置高亮显示元素的封装函数，将搜索输入框进行高亮显示
		highlightElement(searchInputBox);
		searchInputBox.sendKeys("光荣之路自动化测试");
		Thread.sleep(3000);
		highlightElement(submitButton);
		Thread.sleep(3000);
		submitButton.click();
		Log.endTestCase("搜索功能测试结束");
	}
	
	/**
	 * 调用表格元素
	 */
	@Test
	public void testHandleiFrame2() {
		Global.driver.get("file:///D:/git/MyFirstSeleniumDemo/TestWebs/table.html");
		WebElement webTable=Global.driver.findElement(By.xpath("//table"));
		Table table=new Table(webTable);
		System.out.println(table.getCell(1, 1).getText());
		table.getWebElementInCell(1, 1,By.tagName("input")).sendKeys("第一行第一列表格被找到");
	}
	
}
