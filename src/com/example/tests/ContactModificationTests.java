package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase{
	
@Test(dataProvider="randomValidContactGenerator")
	public void ModifySomeContactAllFields(ContactData contact) {
		 app.getNavigationHelper().openMainPage();
		//save old list
			List<ContactData>oldContactList=app.getContactHelper().getContacts();
			 Random rnd=new Random();
			 int index=rnd.nextInt(oldContactList.size()-1);
			
			//actions
		 app.getContactHelper().selectContact(index);	
		 app.getContactHelper().fillContactCreationForm(contact);
		 app.getContactHelper().submitContactModification();
		 app.getContactHelper().returnToHomePage();
		 //change group for this contact
		 app.getContactHelper().randomChangeGroup(rnd, index);
		 contact.group_name=app.getContactHelper().randomChangeGroup(rnd, index);
		 app.getContactHelper().submitGroupChange();
		 app.getContactHelper().goToSubmittedGroupPage();
		 app.getNavigationHelper().openMainPage();
		 //save new list
			List<ContactData>newContactList=app.getContactHelper().getContacts();
			//compare
				oldContactList.remove(index);
				oldContactList.add(contact);
				Collections.sort(oldContactList);
				Collections.sort(newContactList);
				assertEquals(newContactList, oldContactList);
	}


}


/*@Test
public void ChangeGroupforContact() {
	 app.getNavigationHelper().openMainPage();
	 List<WebElement> groupNamesList=app.getContactHelper().getGroupsName(); 
	 Random rnd=new Random();
	 int index=rnd.nextInt(groupNamesList.size()-1);
	 app.getContactHelper().checkContact(1);
	 app.getContactHelper().selectGroupForChange(index);
	 app.getContactHelper().submitGroupChange();
	 app.getContactHelper().goToSubmittedGroupPage();
}
*/
