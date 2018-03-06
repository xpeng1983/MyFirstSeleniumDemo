package com.test.uimap;

import org.testng.annotations.Test;

import com.test.sample.Global;

public class TestSohuMailLoginByObjectMap {
	
	@Test
	public void testSohuMailLogin() {
		
		Global.driver.get("http://mail.sohu.com");
		ObjectMap objectMap=new ObjectMap("ObjectMap.properties");
		//Global.driver.findElement(objectMap.getLocator("SohuMai.HomePage.username")).sendKeys("asdff_px");
		
		
	}
}
