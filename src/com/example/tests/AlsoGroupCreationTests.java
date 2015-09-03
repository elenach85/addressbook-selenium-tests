package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.example.fw.*; 
public class AlsoGroupCreationTests extends TestBase {
 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
   app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name="group name 1";
    group.header="header 1";
    group.footer="footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
  }
  @Test
  public void testEmptyGroupCreation() throws Exception {
	 app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
   app.getGroupHelper().initGroupCreation();
    app.getGroupHelper().fillGroupForm(new GroupData("", "", " "));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnGroupsPage();
  }

     
}
