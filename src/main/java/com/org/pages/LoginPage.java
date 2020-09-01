package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.objects.LoginPageObjects;

public class LoginPage extends LoginPageObjects{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
	this.driver=driver;		
	}
	
	public void login(String login, String passwd) {
		driver.findElement(email).sendKeys(login);
		driver.findElement(pswd).sendKeys(passwd);
		driver.findElement(signIn).click();
	}
}
