import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class Chrome {
	@Test
	public void testGoogleSearch() throws InterruptedException {
		// Optional, if not specified, WebDriver will search your path for chromedriver.
		//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/XPENG/chromedriver");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver=new SafariDriver();
		driver.get("https://www.baidu.com/");
//		Thread.sleep(5000); // Let the user actually see something!
//		WebElement searchBox = driver.findElement(By.name("q"));
//		searchBox.sendKeys("ChromeDriver");
//		searchBox.submit();
//		Thread.sleep(5000); // Let the user actually see something!
//		driver.quit();
		System.out.println("test git");
		;
		;
		System.out.println("hello");
	}
}
