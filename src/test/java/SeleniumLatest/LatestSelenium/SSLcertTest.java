package SeleniumLatest.LatestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.ExpectedExceptions;
import org.testng.annotations.Test;

public class SSLcertTest {
	
		WebDriver driver;
		public By email=By.cssSelector("#email");
		public By pswd=By.cssSelector("#passwd");
		public By signIn=By.cssSelector("#SubmitLogin");
		
		@Test
		public void sslTest() throws InterruptedException {
		DesiredCapabilities ds = new DesiredCapabilities();
		ds.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/login.html");
		
		waitTime(20, email);
	}
		public void waitTime(int time, By locator) {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
}
