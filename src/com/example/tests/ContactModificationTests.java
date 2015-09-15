package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	/*@Test
	public void ModifySomeContact() {
		 app.getNavigationHelper().openMainPage();
		//save old list
		List<ContactData>oldContactList=app.getContactHelper().getContacts();
		//actions
		 app.getContactHelper().selectContact(0);
		ContactData contact=new ContactData();
		 contact.first_name="1109new super fir name";
		 contact.birth_day="25";
		 app.getContactHelper().fillContactCreationForm(contact);
		 app.getContactHelper().submitContactModification();
		 app.getContactHelper().returnToHomePage();
		 //save new list
		List<ContactData>newContactList=app.getContactHelper().getContacts();
		//compare
			oldContactList.remove(0);
			oldContactList.add(contact);
			Collections.sort(oldContactList);
			assertEquals(newContactList, oldContactList);
	}
	*/
	@Test(dataProvider="randomValidContactGenerator")
	public void ModifySomeContactAllFields(ContactData contact) {
		 app.getNavigationHelper().openMainPage();
		//save old list
			List<ContactData>oldContactList=app.getContactHelper().getContacts();
			 Random rnd=new Random();
			 int index=rnd.nextInt(oldContactList.size()-1);
			
			//actions
		 app.getContactHelper().selectContact(index);
			 
		/*ContactData contact=new ContactData();
		contact.first_name="good first name";
		contact.last_name=" good last name";
		contact.address_1="good Address1";
		contact.home_tel="9111111";
		contact.mobile_tel="8917222299999";
		contact.work_tel="66222222";
		contact.email="goodtest@gmail.com";
		contact.email2="goodtest2@mail.ru";
		//contact.birth_day=;
		contact.birth_month="September";
		contact.birth_year="1975";
	    contact.address_2="good Address2";
		contact.phone_2="993333";
		*/		
		 app.getContactHelper().fillContactCreationForm(contact);
		 app.getContactHelper().submitContactModification();
		 app.getContactHelper().returnToHomePage();
		 //save new list
			List<ContactData>newContactList=app.getContactHelper().getContacts();
			//compare
				oldContactList.remove(index);
				oldContactList.add(contact);
				Collections.sort(oldContactList);
				Collections.sort(newContactList);
				assertEquals(newContactList, oldContactList);
	}
/*@Test
public void ChangeGroupforContact() {
	 app.getNavigationHelper().openMainPage();
	 app.getContactHelper().checkContact(1);
	 app.getContactHelper().selectGroupForChange(3);
	 app.getContactHelper().submitGroupChange();
	 app.getContactHelper().goToSubmittedGroupPage();
}
*/
}