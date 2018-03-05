package com.test.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
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
		
		(new WebDriverWait(Global.driver, 10)).until(new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return arg0.findElement(By.xpath("s_footer")).getText().contains("��������");
			}
        });
		
		Assert.assertTrue(Global.driver.getPageSource().contains(searchResult) );
		Global.driver.quit();
	}
}
