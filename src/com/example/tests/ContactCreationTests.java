package com.example.tests;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
   @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
	app.getContactHelper().initContactCreation();
	ContactData contact=new ContactData();
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
	app.getContactHelper().fillContactCreationForm(contact);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactCreation();
		app.getContactHelper().fillContactCreationForm(new ContactData("", "","", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToHomePage();
  }

}
