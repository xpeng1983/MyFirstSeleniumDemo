package com.test.uimap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.test.sample.Global;

public class TestSohuMailLoginByObjectMap {

	@Test
	public void testSohuMailLogin() throws Exception {

		Global.driver.get("http://mail.sohu.com");
		Thread.sleep(2000);
		Global.driver.manage().window().maximize();
		ObjectMap objectMap = new ObjectMap("D:\\git\\MyFirstSeleniumDemo\\src\\com\\test\\uimap\\ObjectMap.properties");
		Thread.sleep(5000);
		
		Global.driver.findElement(By.xpath("//*[@placeholder='«Î ‰»Îƒ˙µƒ” œ‰']")).sendKeys("asdff_px");;
		
//		Global.driver.findElement(objectMap.getLocator("SohuMai.HomePage.username")).sendKeys("asdff_px");
//		Global.driver.findElement(objectMap.getLocator("SohuMai.HomePage.password")).sendKeys("hjnpx831003");
//		Global.driver.findElement(objectMap.getLocator("SohuMai.homePage.submitButton")).click();
		
		// 
		
	}
}
