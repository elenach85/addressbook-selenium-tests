package com.example.tests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator(){
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
	contact.birth_day="19";
	contact.birth_month="November";
	contact.birth_year="1980";
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
	  */
}  


