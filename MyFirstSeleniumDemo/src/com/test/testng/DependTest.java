package com.test.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependTest {
	
	@Test(priority=3)
	public void SignIn() {
		System.out.println("SingIn����������");
		Reporter.log("ע��");
	}
	
	@Test(priority=2)
	public void OpenBrowser() {
		System.out.println("OpenBrowser����������");
		Reporter.log("�������");
	}
	
	@Test(priority=0,enabled=false)
	public void LogOut() {
		System.out.println("LogOut����������");
		Reporter.log("�ǳ�");
	}	
	
} 
