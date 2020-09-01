package SeleniumLatest.LatestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TooltipCode {
WebDriver driver;
	
	@Test
	public void webTable() {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://accounts.google.com/SignUp?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ltmpl=default");
		 
		 // Click on username textbox
		driver.findElement(By.xpath(".//*[@id='GmailAddress']")).click();
		 
		 // Create action class object
		Actions builder=new Actions(driver);
		 
		// find the tooltip xpath
		 WebElement username_tooltip=driver.findElement(By.xpath("html/body/div[2]/div[1]"));
		 
		// Mouse hover to that text message
		builder.moveToElement(username_tooltip).perform();
		 
		// Extract text from tooltip
		 String tooltip_msg=username_tooltip.getText();
		 
		// Print the tooltip message just for our refrences
		 System.out.println("Tooltip/ Help message is "+tooltip_msg);
		 
		 }
}
