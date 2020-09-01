package SeleniumLatest.LatestSelenium;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DynamicTables {
	WebDriver driver;
	
	@Test
	public void webTable() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
		List<WebElement> cols = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr[1]/td"));
		
		List<String> li = new ArrayList<String>();
		for(int i=1; i<=rows.size(); i++) {
			for(int j=1; j<=cols.size(); j++) {
				String str = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				li.add(str);
			}
		} 
		int j=0;
		for(int i=0; i<li.size(); i++) {
			j++;
			System.out.println(li.get(i));
			if(j==5) {
				System.out.println("\n");
				j=0;				
			}
			
		}
		
	}
}
