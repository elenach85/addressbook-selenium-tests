package com.example.tests;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
	List<Object[]>contactList=new ArrayList<Object[]>();
		for (int i = 0; i <9; i++) {
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
	//contact.birth_year="";
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
	
	/*if (month=="April"|month=="June"|month=="September"|month=="November") {
		String day=String.valueOf(1+rnd.nextInt(29));
		contact.birth_day=day;		
	} else {if (month!="February") {
		String day=String.valueOf(1+rnd.nextInt(30));
		contact.birth_day=day;	
	} else {if (year%4==0 && year%100>0) {
		String day=String.valueOf(1+rnd.nextInt(28));
		contact.birth_day=day;	
	} else {if (year%100==0 && year%400==0) {
		String day=String.valueOf(1+rnd.nextInt(28));
		contact.birth_day=day;	
	} else {
		String day=String.valueOf(1+rnd.nextInt(27));
		contact.birth_day=day;
	}

	}

	}

	}
	*/
	contactList.add(new Object[]{contact});
	}
	return contactList.iterator();
	}

	@Test(dataProvider="randomValidContactGenerator")
public void testContactCreationWithValid2(ContactData contact) throws Exception{ 
		app.getNavigationHelper().openMainPage();	
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
		//actions
		app.getContactHelper().initContactCreation();
		/*ContactData contact=new ContactData();
		contact.first_name="super first name";
		contact.last_name="super Last name";
		contact.address_1="Address1";
		contact.home_tel="111111";
		contact.mobile_tel="891722221111";
		contact.work_tel="222222";
		contact.email="test@mail.ru";
		contact.email2="test2@mail.ru";
		contact.birth_day="19"; 
		contact.birth_month="November";
		contact.birth_year="1970";
		contact.group_name="group1";
		contact.address_2="Address2";
		contact.phone_2="333333";
		*/
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
	/*@DataProvider 
	public Iterator<Object[]> randomValidContactGenerator(){
		List<Object[]>contactList=new ArrayList<Object[]>();
	for (int i = 0; i < 3; i++) {
	ContactData contact=new ContactData();
	contact.first_name=generateRandomString();
	contact.last_name=generateRandomString();
	//contact.address_1=generateRandomString();
	//contact.home_tel=generateRandomString();
	contact.home_tel="567889";
	//contact.mobile_tel=generateRandomString();
	//contact.work_tel=generateRandomString();
	contact.email="t@mail.ru";
	//contact.email=generateRandomString();
	//contact.email2=generateRandomString();
	contact.birth_day="19"; 
	contact.birth_month="November";
	contact.birth_year="1970";
	//contact.group_name="group1";
	//contact.address_2=generateRandomString();
	//contact.phone_2=generateRandomString();	
	contactList.add(new Object[]{contact});
	}
	return contactList.iterator();
	}
   @Test(dataProvider="randomValidContactGenerator")
  public void testContactCreationWithValid(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	//save old list
	List<ContactData>oldContactList=app.getContactHelper().getContacts();
		//actions
	app.getContactHelper().initContactCreation();
	/*ContactData contact=new ContactData();
	contact.first_name="super first name";
	contact.last_name="super Last name";
	contact.address_1="Address1";
	contact.home_tel="111111";
	contact.mobile_tel="891722221111";
	contact.work_tel="222222";
	contact.email="test@mail.ru";
	contact.email2="test2@mail.ru";
	contact.birth_day="19"; 
	contact.birth_month="November";
	contact.birth_year="1970";
	//contact.group_name="group1";
	contact.address_2="Address2";
	contact.phone_2="333333";	
	*/	
	//app.getContactHelper().fillContactCreationForm(contact);
   // app.getContactHelper().submitContactCreation();
    //app.getContactHelper().returnToHomePage();
    //save new list
	//List<ContactData>newContactList=app.getContactHelper().getContacts();
  //compare
	//assertEquals(newContactList.size(), oldContactList.size()+1);
	//oldContactList.add(contact);
	//Collections.sort(oldContactList);
	//assertEquals(newContactList, oldContactList);
 // }
/*  @Test
  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
			//actions
		ContactData contact=new ContactData(" ", " "," ", " ", " ", " ", " ", " ", "-", "-", " ", "[none]", "", "");
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactCreationForm(contact);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToHomePage();
	    //save new list
		List<ContactData>newContactList=app.getContactHelper().getContacts();
	  //compare
		assertEquals(newContactList.size(), oldContactList.size()+1);
		oldContactList.add(contact);
		Collections.sort(oldContactList);
		assertEquals(newContactList, oldContactList);
	  }
	  
	}
	  */
	
/*	public int generateRandomYearInt(){
		Random rnd=new Random(); 
				int yearInt;
				yearInt=1920+rnd.nextInt(95);	
			return yearInt;
			}	
	*/
	public String generateRandomYear(){
		Random rnd=new Random(); 
		if (rnd.nextInt(7)==0) {
			return " ";	
			} else {
				String year;
				year=String.valueOf(1920+rnd.nextInt(95));
			return year;
			}	
	}	

	public String generateRandomMonth(){
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
	/*public String generateRandomDay(year,month){
		Random rnd=new Random();
		String day;
		int yearInt;
		String year;
		yearInt=generateRandomYearInt();
		year=generateRandomYear();
		String month;
		month=generateRandomMonth();
		if (month=="-"|year==" ") {
			return "-";	
		} else {if (month=="April"|month=="June"|month=="September"|month=="November") {
			day=String.valueOf(1+rnd.nextInt(29));	
		} else {if (month!="February") {
			day=String.valueOf(1+rnd.nextInt(30));	
		} else {if (yearInt%4==0 && yearInt%100>0) {
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
		
	*/}

	
		
		
		
		/*if (rnd.nextInt(3)==0|month=="-"|year=="") {
			return "-";	
			}
		else {
			if (month=="April"|month=="June"|month=="September"|month=="November") {
				day=String.valueOf(1+rnd.nextInt(29));	
			} else {if (month!="February") {
				day=String.valueOf(1+rnd.nextInt(30));	
			} else {if (yearInt%4==0 && yearInt%100>0) {
				day=String.valueOf(1+rnd.nextInt(28));	
			} else {if (yearInt%100==0 && yearInt%400==0) {
				day=String.valueOf(1+rnd.nextInt(28));
			} else {
			day=String.valueOf(1+rnd.nextInt(27));
			}

			}

			
			
			return day;
			}	
		}
	}	
*/
	
	



