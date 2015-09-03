package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	@Test
	public void ModifySomeContact() {
		 app.getNavigationHelper().openMainPage();
		 app.getContactHelper().selectContact(1);
		ContactData contact=new ContactData();
		 contact.last_name="new super name";
		 contact.birth_day="25";
		 app.getContactHelper().fillContactCreationForm(contact);
		 app.getContactHelper().submitContactModification();
		 app.getContactHelper().returnToHomePage();
	}
	@Test
	public void ModifySomeContactAllFields() {
		 app.getNavigationHelper().openMainPage();
		 app.getContactHelper().selectContact(1);
		ContactData contact=new ContactData();
		contact.first_name="good first name";
		contact.last_name=" good last name";
		contact.address_1="good Address1";
		contact.home_tel="9111111";
		contact.mobile_tel="8917222299999";
		contact.work_tel="66222222";
		contact.email="goodtest@gmail.com";
		contact.email2="goodtest2@mail.ru";
		contact.birth_day="27";
		contact.birth_month="September";
		contact.birth_year="1975";
	    contact.address_2="good Address2";
		contact.phone_2="993333";			
		 app.getContactHelper().fillContactCreationForm(contact);
		 app.getContactHelper().submitContactModification();
		 app.getContactHelper().returnToHomePage();
	}
@Test
public void ChangeGroupforContact() {
	 app.getNavigationHelper().openMainPage();
	 app.getContactHelper().checkContact(1);
	 app.getContactHelper().selectGroupForChange(3);
	 app.getContactHelper().submitGroupChange();
	 app.getContactHelper().goToSubmittedGroupPage();
}
}