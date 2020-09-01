package SeleniumLatest.LatestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

public class HeadlessTest {
	WebDriver driver;
	public By email=By.cssSelector("#email");
	public By pswd=By.cssSelector("#passwd");
	public By signIn=By.cssSelector("#SubmitLogin");
	
	@Test
	public void headless() throws InterruptedException {
	driver = new HtmlUnitDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.get("http://demo.guru99.com/test/upload/");
	Thread.sleep(5000);
	driver.findElement(email).sendKeys("test");
	driver.findElement(pswd).sendKeys("passwd");
	driver.findElement(signIn).click();
}
}