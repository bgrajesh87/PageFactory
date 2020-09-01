package SeleniumLatest.LatestSelenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.base.BaseClass;
import com.org.pages.LoginPage;

public class DataProviderTest extends BaseClass{
	
	
	@Test(dataProvider="Logindata")
	public void verifyLogin(String s1, String s2) {
		LoginPage lp = new LoginPage(driver);
		lp.login(s1, s2);
		System.out.println(s1+" "+s2);
		
	}
	
	@DataProvider(name="Logindata")
	public Object[][] getData() {
		return new Object[][] {
		{"Rajesh", "pass1"},
		{"Anil", "Pass2"},
		{"Harish", "Pass3"}
		};
	
	}
}
