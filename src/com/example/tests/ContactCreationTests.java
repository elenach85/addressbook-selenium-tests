package com.example.tests;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	@Test(dataProvider="randomValidContactGenerator")
public void testContactCreationWithValidData(ContactData contact) throws Exception{ 
		app.getNavigationHelper().openMainPage();	
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
		//actions
		app.getContactHelper().initContactCreation();
		//.randomGroupSelectionForContactCreation();
		//contact.group_name=app.getContactHelper().randomGroupSelectionForContactCreation();
		//generateRandomDate(contact);
		app.getContactHelper().fillContactCreationForm(contact);
		
	    app.getContactHelper().submitContactCreation();
		app.getContactHelper().returnToHomePage();
		//save new list
		List<ContactData>newContactList=app.getContactHelper().getContacts();
	  //compare
		//assertEquals(newContactList.size(), oldContactList.size()+1);
		oldContactList.add(contact);
		Collections.sort(oldContactList);
		Collections.sort(newContactList);
		assertEquals(newContactList, oldContactList);
}

	
}
/*	public String generateRandomDay(){
		Random rnd=new Random();
		String day;
		String year;
		year=generateRandomYear();
		int yearInt;
		yearInt=Integer.valueOf(year);
		String month;
		 if (year=="") {
				month="-";
				} else {
					month=generateRandomMonth();
					}
		if (month=="-"|year.equals("")) {
			return "-";	
		} else {if (month=="April"|month=="June"|month=="September"|month=="November") {
			day=String.valueOf(1+rnd.nextInt(29));	
		} else {if (month!="February") {
			day=String.valueOf(1+rnd.nextInt(30));	
		} else 
			
		{if (yearInt%4==0 && yearInt%100>0) {
			day=String.valueOf(1+rnd.nextInt(28));
		} else {if (yearInt%100==0 && yearInt%400==0) {
			day=String.valueOf(1+rnd.nextInt(28));
		} else {
			day=String.valueOf(1+rnd.nextInt(27));
		}

		}

		}

		}

		}
		return day;		
	}
*/

		
	
		
	
	



