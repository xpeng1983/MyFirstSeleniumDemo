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
		Global.driver.navigate().to(Global.url); // 切换页面
		Thread.sleep(2000);
		Global.driver.navigate().back(); // 页面后退
		Thread.sleep(2000);
		Global.driver.navigate().forward(); // 页面前进
		Thread.sleep(2000);
		Global.driver.navigate().refresh(); // 刷新页面
	}

	@Test(enabled = false)
	public void operateBrowser() throws InterruptedException {
		/*
		 * 声明一个Point对象，两个150表示浏览器位置相对于屏幕的左上角（0，0）的横坐标和纵坐标距离
		 */
		Point point = new Point(150, 150);
		// 声明 Dimension对象，两个500表示浏览器窗口的长度和宽度
		Dimension dimension = new Dimension(500, 500);
		// 设置浏览器在屏幕中的位置，在某些版本器下此方法失效

		Global.driver.manage().window().setPosition(point);
		// 设置浏览器窗口的大小
		Global.driver.manage().window().setSize(dimension);
		Thread.sleep(2000);
		System.out.println(Global.driver.manage().window().getPosition());
		System.out.println(Global.driver.manage().window().getSize());

		Global.driver.manage().window().maximize();

		Global.driver.get(Global.url);

		// 调用Global.driver的getTitle方法获取页面的Title属性
		Global.driver.getTitle();

		// 获取页面源代码
		System.out.println(Global.driver.getPageSource());

		// 获取当前页面的ＵＲＬ地址
		System.out.println(Global.driver.getCurrentUrl());

		WebElement input = Global.driver.findElement(By.id("query"));
		// 在输入框中输入指定内容
		input.sendKeys("hello");
		Thread.sleep(2000);
		// 在输入框中清除原有的文字内容
		input.clear();

		// 单击按钮
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
	 * 单选列表操作
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void operationDropList() throws InterruptedException {
		Global.driver.get(Global.url);
		Thread.sleep(5000);
		Select dropList = new Select(Global.driver.findElement(By.name("fruit"))); // 创建下拉列表
		System.out.println(dropList.isMultiple()); // 判断下拉列表是否允行多选

		System.out.println(dropList.getFirstSelectedOption().getText()); // 获取下拉列表文本

		dropList.selectByIndex(2); // 选择下拉列表第几个元素
		Thread.sleep(2000);

		dropList.selectByValue("xigua"); // 通过value属性值进行选择
		Thread.sleep(2000);

		dropList.selectByVisibleText("桃");

		List<String> expect_options = Arrays.asList(new String[] { "桃", "西瓜", "桔子" });
		List<String> actual_options = new ArrayList<String>();
		for (WebElement option : dropList.getOptions()) {
			actual_options.add(option.getText());
		}
		Assert.assertEquals(expect_options.toArray(), actual_options.toArray());
	}

	/**
	 * 多选列表操作
	 * 
	 * @throws InterruptedException
	 */
	@Test(enabled = false)
	public void operateMultipleOptionDropList() throws InterruptedException {

		Global.driver.get(Global.url);
		Thread.sleep(5000);
		Select dropList = new Select(Global.driver.findElement(By.name("fruit"))); // 创建下拉列表

		System.out.println("列表是否支持多选：" + dropList.isMultiple());

		dropList.selectByIndex(1); // 选中元素
		dropList.selectByValue("lizhi");
		dropList.selectByVisibleText("桃");

		Thread.sleep(2000);

		dropList.deselectByIndex(1);
		dropList.deselectByValue("lizhi");
		dropList.deselectByVisibleText("桃");

		Thread.sleep(2000);

		dropList.selectByIndex(1); // 选中元素
		dropList.selectByValue("lizhi");
		dropList.selectByVisibleText("桃");

		Thread.sleep(2000);
		dropList.deselectAll(); // 取消所有选项的选中状态
	}

	/**
	 * 操作单选按钮
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
		System.out.println("列表长度：" + radioOptions.size());
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
	 * 复选框
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
	 * 杀掉进程
	 */
	@Test(enabled = false)
	public void operateEindowsProcess() {
		WindowsUtils.killByName("firefox.exe"); // 杀掉Windows进程中的Firefox浏览器进程，关闭所有Firefox浏览器
		WindowsUtils.killByName("iexplore.exe");
		WindowsUtils.killByName("chrome.exe");
	}

	/**
	 * 截屏
	 * 
	 * @throws IOException
	 */
	@Test(enabled = false)
	public void captureScreenInCurrentWindow() throws IOException {
		Global.driver.get(Global.url);
		// 把当前浏览器打开的页面进行截图，保存到一个File对象中
		File scrFile = ((TakesScreenshot) Global.driver).getScreenshotAs(OutputType.FILE);
		// 把File对象转换为一个保存在C磁盘下testing目录中名为test.png的图片文件
		FileUtils.copyFile(scrFile, new File("c:\\testing\\test.png"));
	}

	/**
	 * 检查页面元素的文本内容是否出现
	 */
	@Test(enabled = false)
	public void isElementTextPresent() {
		Global.driver.get(Global.url);
		WebElement text = Global.driver.findElement(By.xpath("//p[1]"));
		String contentText = text.getText();// 获取P元素标签的文本内容
		Assert.assertEquals(contentText, "《光荣之路》这个电影真的不错");
		Assert.assertTrue(contentText.contains("电影")); // 是否包含电影
		Assert.assertTrue(contentText.startsWith("《"));
		Assert.assertTrue(contentText.endsWith("错"));
	}

	/**
	 * 执行javaScript脚本
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
	 * 拖拽页面元素
	 */
	@Test(enabled = false)
	public void dragPageElement() {
		Global.driver.get(Global.url);
		WebElement draggable = Global.driver.findElement(By.id("draggable"));
		// 拖拽移动，下方表示向下移动100个像素，0表示元素的横坐标不变
		new Actions(Global.driver).dragAndDropBy(draggable, 0, 100).build().perform();
	}

	/**
	 * 模拟键盘操作
	 */
	@Test(enabled=false)
	public void clickKeys() {
		Global.driver.get(Global.url);
		Actions action = new Actions(Global.driver);
		action.keyDown(Keys.CONTROL); // 按下Ctrl键
		action.keyDown(Keys.ALT); // 按下Atl键
		action.keyDown(Keys.SHIFT);
		action.keyUp(Keys.CONTROL); // 释放Control键
		action.keyUp(Keys.ALT); //
		action.keyUp(Keys.SHIFT);
		//模拟键盘在搜索输入框中输入大写的字符“ABCDEFG”
		action.keyDown(Keys.SHIFT).sendKeys("abcdedf").perform(); 
	}
	
	
	/**
	 * 模拟鼠标右键事件
	 */
	@Test(enabled=false)
	public void rightClickMouse() {
		Global.driver.get(Global.url);
		Actions action = new Actions(Global.driver);
		//模拟鼠标右键单击操作
		action.contextClick(Global.driver.findElement(By.id("stb"))).perform();
	}
	
	/**
	 * 移动鼠标操作 
	 * 在指定元素上方进行鼠标悬浮
	 */
	@Test(enabled=false)
	public void roverOnElement() {
		Global.driver.get(Global.url);
//		Actions action = new Actions(Global.driver);
		//action.moveToElement(wb).perform;
	}
	
	/**
	 * 鼠标长时间被按下，并释放操作
	 * 在指定元素上进行鼠标单击左键和释放的操作
	 */
	@Test(enabled=false)
	public void mouseClickAndRelease() {
		
		Global.driver.get(Global.url);
		WebElement div=Global.driver.findElement(By.xpath("//div[@id='div1']"));
		Actions action = new Actions(Global.driver);
		action.clickAndHold(div).perform(); //鼠标被按下
		action.release(div).perform(); //鼠标被释放
		
	}	
	
	
	/**
	 * 获取页面元素的CSS属性值
	 */
	@Test(enabled=false)
	public void getWebElementCssValue() {
		Global.driver.get(Global.url);
		WebElement input=Global.driver.findElement(By.id("query"));
		System.out.println(input.getCssValue("vertical-align"));
		
	}	
	
	/**
	 * 隐式等待
	 */
	@Test(enabled=false)
	public void testImplictWait() {
		Global.driver.get(Global.url);
		Global.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	/**
	 * 显式等待
	 */
	@Test
	public void testExplicitWait() {
		
		Global.driver.get(Global.url);
		WebDriverWait wait=new WebDriverWait(Global.driver,10);
		//判断页面标题是否包含水果字样
		wait.until(ExpectedConditions.titleContains("水果"));
		System.out.println("标题包含 水果");
		
		//获得下前提下列表中的元素
		WebElement select=Global.driver.findElement(By.id("peach"));
		//判断元素是否处理选中状态
		wait.until(ExpectedConditions.elementToBeSelected(select));
		System.out.println("下拉列晴的选项'桃子'目前处理选中状态");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[1]")));
		System.out.println("页面复选框处于显示和可被单击状态");
		
		//判断P标签对象是否在页面中
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p")));
		System.out.println("页面P标签元素已显示");
		
		WebElement p=Global.driver.findElement(By.xpath("//P"));
		wait.until(ExpectedConditions.textToBePresentInElement(p, "爱吃的水果"));
		System.out.println("页面的p标签元素包含文本\"爱吃的水果\"");
		
	;
	;
	}	
}
