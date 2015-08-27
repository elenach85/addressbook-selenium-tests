package com.example.tests;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {
 
   @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
	initContactCreation();
	ContactData contact=new ContactData();
	contact.first_name="first name";
	contact.last_name="Last name";
	contact.address_1="Address1";
	contact.home_tel="111111";
	contact.mobile_tel="891722221111";
	contact.work_tel="222222";
	contact.email="test@mail.ru";
	contact.birth_day="19";
	contact.birth_month="November";
	contact.birth_year="1970";
	contact.group_name="group1";
	contact.address_2="Address2";
	contact.phone_2="333333";			
	fillContactCreationForm(contact);
    submitContactCreation();
    returnToHomePage();
  
  }

  @Test
  public void testEmptyContactCreation() throws Exception {
		openMainPage();
		initContactCreation();
		fillContactCreationForm(new ContactData("", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
	    submitContactCreation();
	    returnToHomePage();
  }

}
