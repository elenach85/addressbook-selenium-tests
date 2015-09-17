package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
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

	protected String randomGroupSelectionForContactCreation() {
		List<WebElement> groupNamesList=app.getContactHelper().getGroupsNameInContactCreationForm(); 
		 Random rnd=new Random();
		 int index=rnd.nextInt(groupNamesList.size());
		 app.getContactHelper().selectGroupForContactCreation(index);
		 String groupName;
		 groupName=groupNamesList.get(index).getText();
		return groupName;
	}
}
