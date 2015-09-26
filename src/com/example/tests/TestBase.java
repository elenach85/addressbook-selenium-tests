package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.thoughtworks.selenium.webdriven.commands.GetText;
import java.util.Calendar;
public class TestBase {
	//private static final String year = null;
	protected static ApplicationManager app;
	

		@BeforeTest
	public void setUp() throws Exception {
			app=new ApplicationManager();
			
	   
	  }

	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	    
	  }
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator(){
	List<Object[]>list=new ArrayList<Object[]>();
		for (int i = 0; i <1; i++) {
	GroupData group=new GroupData()
	.withName(generateRandomString())
	.withHeader(generateRandomString())
	.withFooter(generateRandomString());
	list.add(new Object[]{group});
	
	}
	return list.iterator();
	}
	public String generateRandomString(){
		Random rnd=new Random(); 
		if (rnd.nextInt(3)==0) {
			return " ";	
			} else {
			return "test"+ rnd.nextInt();
			}	
	}

	public String generateRandomYear() {
		Random rnd=new Random(); 
		if (rnd.nextInt(7)==0) {
			return " ";	
			} else {
				String year;
				year=String.valueOf(1920+rnd.nextInt(95));
			return year;
			}	
	}
	
public String generateRandomMonth() {
		Random rnd=new Random(); 
		if (rnd.nextInt(7)==0) {
			return "-";	
			} else
			{
				int number;
				String[] monthName = {
						"January", 
						"February",
						"March",
						"April",
						"May",
						"June",	
						"July",
						"August",
						"September",
						"October",
						"November",
						"December",
						};
				number=rnd.nextInt(12);
				String month=monthName[number];	
			return month;
			}	
	}
protected String generateRandomDay(){
	String day;
	Random rnd=new Random(); 
	  Calendar cal = Calendar.getInstance();
	  int dayInt = cal.get(Calendar.DATE);
	
	  if (rnd.nextInt(7)==0) {
		  return day="-";		
	} else {
		 dayInt=rnd.nextInt(30);
		  day=String.valueOf(dayInt);
return day;
	}		
		}
	 
	@DataProvider
	public Iterator<Object[]> randomValidContactGeneratorWithGroupName() {
app.navigateTo().mainPage();
app.getContactHelper().initContactCreation();
app.getContactHelper().getGroupsNameList();
	List<Object[]>contactList=new ArrayList<Object[]>();
		for (int i = 0; i <1; i++) {
			ContactData contact=new ContactData()
		.withFirstname(generateRandomString())
		.withLastname(generateRandomString())
		.withEmail(generateRandomString())
		.withEmail2(generateRandomString())
		.withHomeTel(generateRandomString())
		.withAddress1(generateRandomString())
		.withPhone2(generateRandomString())
		.withWorktel(generateRandomString())
		.withBirthYear(generateRandomYear())
		.withBirthMonth(generateRandomMonth())
		.withBirthDay(generateRandomDay())
		.withGroupName(app.getContactHelper().randomGroupSelection());
	contactList.add(new Object[]{contact});
	}
	return contactList.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGeneratorWithoutGroupName() {
	List<Object[]>contactList=new ArrayList<Object[]>();
		for (int i = 0; i <1; i++) {
			ContactData contact=new ContactData()
		.withFirstname(generateRandomString())
		.withLastname(generateRandomString())
		.withEmail(generateRandomString())
		.withEmail2(generateRandomString())
		.withHomeTel(generateRandomString())
		.withAddress1(generateRandomString())
		.withPhone2(generateRandomString())
		.withWorktel(generateRandomString())
		.withBirthYear(generateRandomYear())
		.withBirthMonth(generateRandomMonth())
		.withBirthDay(generateRandomDay());
	contactList.add(new Object[]{contact});
	}
	return contactList.iterator();
	}

	
	
}

	
