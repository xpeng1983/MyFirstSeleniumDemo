package com.test.uimap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;


public class ObjectMap {
	
	Properties properties;
	//��ȡ�����ļ�
	public ObjectMap(String propFile) {
		FileInputStream in;
		try {
			in = new FileInputStream(propFile);
			properties.load(in);
		} catch (FileNotFoundException e) {
			System.out.println("�ļ�������");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��ȡ�����ļ�����");
			e.printStackTrace();
		}	
	}
	
	public By getLocator(String elementNameInproFile) throws Exception {
		
		//���ݱ���elementNameInproFile�������������ļ��ж�ȡ��Ӧ�����ö���
		String locator=properties.getProperty(elementNameInproFile);
		
		/**
		 * �����ö����еĶ�λ���ʹ洢��locatorType����������λ���ʽ��ֵ�洢��locatorValue������
		 */
		String locatorType=locator.split(":")[0].toLowerCase();
		String locatorValue=locator.split(":")[1];
		
		System.out.println("��ȡ�Ķ�λ���ͣ�"+locatorType+"\t ��ȡ�Ķ�λ���ʽ"+locatorValue);
		
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
			throw new Exception("����� locator type δ�ڳ����б�����"+locatorType);
		}
		
	}
	
	
}
