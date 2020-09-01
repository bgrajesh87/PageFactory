package com.org.base;

import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.beust.jcommander.Parameter;

import jdk.internal.org.objectweb.asm.commons.Method;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop = new Properties();
	File f= new File("C:\\Users\\bgraj\\workspace\\LatestSelenium\\config.properties");
	public ExtentReports htmlreport;
	public ExtentTest testlog;
		
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void setup(String browser) throws IOException, InterruptedException {
		System.out.println("BeforeTest");
		htmlreport = new ExtentReports();
		
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver", "Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
//		else if(browser.equals("ie")) {
//		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/login.html");
		Thread.sleep(2000);
	}
	@AfterMethod
	public void failImage(ITestResult result) throws IOException {
		//Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                String mtdName = result.getName();
                File DestFile=new File("C:\\Users\\bgraj\\workspace\\LatestSelenium\\TestData\\"+mtdName+".png");

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
	}
	
	@AfterTest(alwaysRun=true)
	public void teardown() {
		driver.quit();
	}
}
