package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact() {
		 app.getNavigationHelper().openMainPage();
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
		//int index;
		//actions
		 app.getContactHelper().selectContact(0);
		 app.getContactHelper().deleteContact();
		 app.getContactHelper().returnToHomePage();
		 //save new list
			List<ContactData>newContactList=app.getContactHelper().getContacts();
		  //compare
			oldContactList.remove(0);
			Collections.sort(oldContactList);
			assertEquals(newContactList, oldContactList); 
		 
		
		
	 }
}
