package com.test.uimap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;


public class ObjectMap {
	
	Properties properties;
	//读取配置文件
	public ObjectMap(String propFile) {
		FileInputStream in;
		try {
			in = new FileInputStream(propFile);
			properties.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("读取对象文件出错");
			e.printStackTrace();
		}	
	}
	
	public By getLocator(String elementNameInproFile) throws Exception {
		
		//根据变量elementNameInproFile，从属性配置文件中读取相应的配置对象
		String locator=properties.getProperty(elementNameInproFile);
		
		/**
		 * 将配置对象中的定位类型存储到locatorType变量，将定位表达式的值存储到locatorValue变量中
		 */
		String locatorType=locator.split(":")[0].toLowerCase();
		String locatorValue=locator.split(":")[1];
		
		System.out.println("获取的定位类型："+locatorType+"\t 获取的定位表达式"+locatorValue);
		
		switch (locatorType.toLowerCase()) {
		case "id":
			return By.id(locatorType);
		case "name":
			return By.name(locatorType);
		case "class":
			return By.className(locatorType);
		case "tag":
			return By.tagName(locatorType);
		case "link":
			return By.linkText(locatorType);
		case "partiallinktext":
			return By.partialLinkText(locatorType);
		case "css":
			return By.cssSelector(locatorType);
		case "xpath":
			return By.xpath(locatorType);
		default:
			throw new Exception("输入的 locator type 未在程序中被定义"+locatorType);
		}
		
	}
	
	
}
