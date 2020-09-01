package SeleniumLatest.LatestSelenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SelectTest {
	
	public WebDriver driver;
		
	@Test
	public void setup() throws IOException, InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/upload/");
		Thread.sleep(5000);
//		dropDown("INDIA");
		Actions a = new Actions(driver);
	//	a.moveToElement(driver.findElement(By.xpath("//a[text()='Flights']"))).keyDown(Keys.CONTROL).click().build().perform();
	//	a.moveToElement(driver.findElement(By.xpath("//a[text()='Flights']"))).sendKeys(Keys.CONTROL + "T").build().perform();
		
		WebElement element = driver.findElement(By.cssSelector(".upload_txt"));
		element.sendKeys("C:\\Users\\bgraj\\Desktop\\i983guide.pdf");
		driver.findElement(By.cssSelector("#terms")).click();
		driver.findElement(By.cssSelector("#submitbutton")).click();
		Thread.sleep(3000);
		String str = driver.findElement(By.xpath("//h3[@id='res']/center")).getText();
		Assert.assertEquals(str, "1 file"+"\n"+"has been successfully uploaded.");
		
	}
	public void dropDown(String country) {
		Select s = new Select(driver.findElement(By.name("country")));
/*		List<WebElement> li = driver.findElements(By.xpath("//select[@name='country']/option"));
		for(int i=0; i<li.size(); i++) {
			if(li.get(i).getText().equalsIgnoreCase(country)) {
				li.get(i).click();
			}
			if(i==li.size()-1) {
				System.out.println("Country not found");
			}

		}*/
		s.selectByVisibleText(country);
	}
}
