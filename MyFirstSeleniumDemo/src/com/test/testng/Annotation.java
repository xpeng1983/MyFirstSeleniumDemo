package com.test.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotation {
	
	@Test
	public void testCase1() {
		System.out.println("testCase1����������1��ִ��");
	}
	
	@Test
	public void testCase2() {
		System.out.println("testCase2����������2��ִ��");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod����ÿ�����Է�����ʼ����ǰִ��");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod����ÿ�����Է������н�����ִ��");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass���ڵ�ǰ������ĵ�һ�����Է�����ʼ����ǰִ��");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass����ǰ����������һ�����Է���������ִ��");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest���ڲ������е�Test��ʼ����ǰִ��");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest���ڲ������е�Test���н�����ִ��");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite���ڵ�ǰ���Լ���(Suite)�е����в��Գ���ʼ����֮ǰִ��");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite���ڵ�ǰ���Լ���(Suite)�е����в��Գ������֮��ִ��");
	}
	
}
