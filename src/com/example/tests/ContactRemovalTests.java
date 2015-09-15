package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact() {
		 app.getNavigationHelper().openMainPage();
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
		 Random rnd=new Random();
		 int index=rnd.nextInt(oldContactList.size()-1);
		
		//actions
		 app.getContactHelper().selectContact(index);
		 app.getContactHelper().deleteContact();
		 app.getContactHelper().returnToHomePage();
		 //save new list
			List<ContactData>newContactList=app.getContactHelper().getContacts();
		  //compare
			oldContactList.remove(index);
			Collections.sort(oldContactList);
			Collections.sort(newContactList);
			assertEquals(newContactList, oldContactList); 
		 
		
		
	 }
}
