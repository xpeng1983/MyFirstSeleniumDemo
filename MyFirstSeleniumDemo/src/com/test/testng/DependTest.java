package com.test.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependTest {
	
	@Test(priority=3)
	public void SignIn() {
		System.out.println("SingIn方法被调用");
		Reporter.log("注册");
	}
	
	@Test(priority=2)
	public void OpenBrowser() {
		System.out.println("OpenBrowser方法被调用");
		Reporter.log("打开浏览器");
	}
	
	@Test(priority=0,enabled=false)
	public void LogOut() {
		System.out.println("LogOut方法被调用");
		Reporter.log("登出");
	}	
	
} 
