package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test
	public void deleteSomeContact() {
		 app.getNavigationHelper().openMainPage();
		 app.getContactHelper().selectContact(1);
		 app.getContactHelper().deleteContact();
		 app.getContactHelper().returnToHomePage();
		  
		 
		
		
	 }
}
