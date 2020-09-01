package SeleniumLatest.LatestSelenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandlesTest {
	
	WebDriver driver;
	
/*	@Test
	public void windowhanles() {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/popup.php");
		String parent = driver.getWindowHandle();
		System.out.println("parent: " +parent);
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> s = driver.getWindowHandles();
		for(String s1: s) {
			System.out.println(s1);
		}*/
//	}
	
	@Test
	public void webTable() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/newtours/");
		
		System.out.println(driver.findElement(By.xpath(String.format("//table/tbody/tr/td/font[contains(text(),'%s')]/parent::td/following-sibling::td//b", "Phoenix"))).getText());
	}	
}
