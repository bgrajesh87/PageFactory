package SeleniumLatest.LatestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	
	@Test
	public void alert() {
	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/delete_customer.php");
	
	driver.findElement(By.name("cusid")).sendKeys("123456");
	driver.findElement(By.name("submit")).click();
	
	Alert a = driver.switchTo().alert();
	System.out.println(a.getText());
	a.dismiss();
	
	}
}
