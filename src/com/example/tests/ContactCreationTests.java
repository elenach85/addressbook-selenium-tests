package com.example.tests;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matcher.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.utils.ListOf;
import com.example.utils.SortedListOf;

public class ContactCreationTests extends TestBase {
	@Test(dataProvider="randomValidContactGeneratorWithGroupName")
public void testContactCreationWithValidData(ContactData contact) throws Exception{ 
		app.navigateTo().mainPage();	
		//save old list
		SortedListOf<ContactData>oldContactList=app.getContactHelper().getContacts();
	//List<ContactData>oldContactList=app.getContactHelper().getContacts();
//ListOf<ContactData>oldContactList=app.getContactHelper().getContacts();
		//actions
	app.getContactHelper().createContact(contact);	
	//app.navigateTo().mainPage();
		//save new list
	  SortedListOf<ContactData>newContactList=app.getContactHelper().getContacts();
	// List<ContactData>newContactList=app.getContactHelper().getContacts();
	//ListOf<ContactData>newContactList=app.getContactHelper().getContacts();
	  //compare
		//assertEquals(newContactList.size(), oldContactList.size()+1);
	//oldContactList.add(contact);
		//Collections.sort(oldContactList);
		//Collections.sort(newContactList);
		//assertEquals(newContactList, oldContactList);
		assertThat(newContactList,equalTo(oldContactList.withAdded(contact)));
}

	
}


		
	
		
	
	



