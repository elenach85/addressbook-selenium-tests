package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.thoughtworks.selenium.webdriven.commands.GetText;

public class TestBase {
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
		for (int i = 0; i <5; i++) {
	GroupData group=new GroupData();
	group.name=generateRandomString();
	group.header=generateRandomString();
	group.footer=generateRandomString();
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

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
	List<Object[]>contactList=new ArrayList<Object[]>();
		for (int i = 0; i <1; i++) {
	ContactData contact=new ContactData();
	contact.first_name=generateRandomString();
	contact.last_name=generateRandomString();
	contact.email=generateRandomString();
	contact.email2=generateRandomString();
	contact.home_tel=generateRandomString();
	contact.address_1=generateRandomString();
	contact.address_2=generateRandomString();
	contact.phone_2=generateRandomString();
	contact.work_tel=generateRandomString(); 
	contactList.add(new Object[]{contact});
	}
	return contactList.iterator();
	}

	
	private void generateRandomData(ContactData contact) {
			contact.birth_year=generateRandomYear();
			Random rnd=new Random();
			String year;
			String month;
			month=contact.birth_month;
			 year=contact.birth_year;
			 if (year=="") {
			month="-";
			} else {
				contact.birth_month=generateRandomMonth();
				}
	
			String day;
			//contact.birth_day=generateRandomDay();
			if (month=="-"|year==""){
			day="-";
			contact.birth_day=day;
	} 
			else 
			{
				if (month=="April"|month=="June"|month=="September"|month=="November") {
				day=String.valueOf(1+rnd.nextInt(29));
				contact.birth_day=day;
			} else {if (month!="February") {
				day=String.valueOf(1+rnd.nextInt(30));	
				contact.birth_day=day;
			} else	
			{int yearInt;
			yearInt=Integer.valueOf(year);
				if (yearInt%4==0 && yearInt%100>0) {
				day=String.valueOf(1+rnd.nextInt(28));
				contact.birth_day=day;
			} else {if (yearInt%100==0 && yearInt%400==0) {
				day=String.valueOf(1+rnd.nextInt(28));
				contact.birth_day=day;
			} else {
				day=String.valueOf(1+rnd.nextInt(27));
				contact.birth_day=day;
			}
	
			}
	
			}
	
			}
	
			}
		
	
	
}

}


