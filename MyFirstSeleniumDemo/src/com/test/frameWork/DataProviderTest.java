package com.test.frameWork;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.test.sample.Global;

public class DataProviderTest {
	
	@DataProvider(name="searchWords")
	public static Object[][] words(){
		return new Object[][] {{"������","����","���˶�"},{"����","����","����"},{"����Σ��","���","����ɭ"}};		
	}
	
	/**
	 * ʹ��TestNG����������
	 * @param searchWord1
	 * @param searchWord2
	 * @param searchResult
	 * @throws InterruptedException
	 */
	@Test(dataProvider="searchWords",enabled=false)
	public void test(String searchWord1,String searchWord2,String searchResult) throws InterruptedException {
		System.out.println("�������");
		Global.driver.get("http://www.sogou.com");
		Global.driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
		Global.driver.findElement(By.id("stb")).click();
		Thread.sleep(3000);
		;
		Assert.assertTrue(Global.driver.getPageSource().contains(searchResult) );
		Global.driver.quit();
	}
}
