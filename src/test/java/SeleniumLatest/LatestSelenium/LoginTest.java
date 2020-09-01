package SeleniumLatest.LatestSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.org.base.BaseClass;
import com.org.pages.LoginPage;

@Listeners(com.org.base.ListenersCode.class)

public class LoginTest extends BaseClass{
	
	@Test
	public void verifyLogin() {
		String user = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(user, pwd);
		
	}
	@Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}	
	
		
/*	@Test(groups= {"smoke"})
	public void verifyLogin1() {
		String user = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(user, pwd);
		
	}
	@Test(groups="smoke")
	public void verifyLogin2() {
		String user = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(user, pwd);
		
	}
	@Test(groups={"smoke"}, enabled=false, priority=1)
	public void verifyLogin3() {
		String user = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.login(user, pwd);
		
	}*/

}
