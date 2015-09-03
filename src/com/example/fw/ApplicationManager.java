package com.example.fw;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public static WebDriver driver;
	public  String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	public NavigationHelper navigationHelper;
	public GroupHelper groupHelper;
	public ContactHelper contactHelper;
	public  ApplicationManager(){
		driver = new FirefoxDriver();
	    baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    //navigationHelper=new NavigationHelper(this);
	    //groupHelper=new GroupHelper(this);
	    //contactHelper=new ContactHelper(this);
	}
		public void stop() {
		driver.quit();
	   		
	}
public NavigationHelper getNavigationHelper(){
	if (navigationHelper==null) {
	navigationHelper=new NavigationHelper(this);	
	}
	return navigationHelper;
}
public GroupHelper getGroupHelper(){
if (groupHelper==null) {
	groupHelper=new GroupHelper(this);
}
return groupHelper;
}
public ContactHelper getContactHelper(){
	if (contactHelper==null) {
	contactHelper=new ContactHelper(this);	
	}
	return contactHelper;
}
}

