package SeleniumLatest.LatestSelenium;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendertTest {
	
	public void getDate() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		Calendar c = Calendar.getInstance(TimeZone.getDefault());
		int day = c.get(Calendar.DAY_OF_MONTH);
		String s = Integer.toString(day);
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
			
		driver.findElement(By.xpath("//span[@class='k-link k-link-date']")).click();;
		
	}
}
