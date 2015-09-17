package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.ContactData;
import com.example.tests.TestBase;

public class ContactHelper extends HelperBase {
	 

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	/**
	 * 
	 */
	public void submitContactCreation() {
		driver.findElement(By.name("submit")).click();
	}

	public void initContactCreation() {
		driver.findElement(By.linkText("add new")).click();
	}

	/**
		 * @param applicationManager TODO
	 * @param testBase TODO
	 * @param contact TODO
		 */
	public void fillContactCreationForm(ContactData contact) {
		type(By.name("firstname"),contact.first_name);
		type(By.name("lastname"),contact.last_name);
	  	type(By.name("address"),contact.address_1);
		type(By.name("home"),contact.home_tel);
	  	type(By.name("mobile"),contact.mobile_tel);
	    type(By.name("work"),contact.work_tel);
		type(By.name("email"),contact.email);
		type(By.name("email2"),contact.email2);
	   	selectByText(By.name("bday"), contact.birth_day);
	   	selectByText(By.name("bmonth"), contact.birth_month);
		type(By.name("byear"),contact.birth_year);
		selectByText(By.name("new_group"),contact.group_name);
	    type(By.name("address2"),contact.address_2);
	    type(By.name("phone2"),contact.phone_2);
	}

	
	public void returnToHomePage() {
		click(By.linkText("home page"));
		}

	public void selectContact(int index) {
	click(By.xpath("//tr[@name='entry'][" + (index+1) + "]/td/a/img[@title='Edit']"));
	}

	public void deleteContact() {
	click(By.xpath("//input[@value='Delete']"));
	}

	  public void submitContactModification() {
		  click(By.xpath("//input[@value='Update']"));
		
	}

	public void checkContact(int index) {
    click(By.xpath("(//input[@type='checkbox'])[" + (index+1) + "]"));
		
	}

	  public void selectGroupForChange(int index2) {
      click(By.xpath("(//select[@name='to_group']/option)[" + (index2+1) + "]"));
				  
	}
	
	  
	  public void selectGroupForContactCreation(int index) {
		
	     click(By.xpath("(//select[@name='new_group']/option)[" + (index+1) + "]"));
					  
		}
	 	
	public void submitGroupChange() {
	click(By.xpath("//input[@name='add']"));
		
	}

	public void goToSubmittedGroupPage() { 
		click(By.xpath("//*[@id='content']/div/i/a"));

	}
	
	public List<ContactData> getContacts() {
	List<ContactData>contacts=new ArrayList<ContactData>();
	List<WebElement> rows = findElements();
	for (WebElement row : rows) {
		List<WebElement>columns =row.findElements(By.tagName("td"));
	//for (WebElement column : columns) {
		ContactData contact=new ContactData();
		//String lName=lastName.getText();
		//String title=checkbox.getAttribute("title");
		//contact.first_name=title.substring("Select (".length(),title.length()-lName.length());
		contact.last_name=columns.get(1).getText();
		contact.first_name=columns.get(2).getText();
		contact.email=columns.get(3).getText();
		contact.home_tel=columns.get(4).getText();
		contacts.add(contact);
	}
		
		
		return contacts;
	}

	private List<WebElement> findElements() {
		return driver.findElements(By.name("entry"));
	}

	public List<WebElement> getGroupsName() {
	List<WebElement>groupNames=driver.findElements(By.xpath("//select[@name='to_group']/option"));
	return groupNames;
	}
	public List<WebElement> getGroupsNameInContactCreationForm() {
		List<WebElement>groupNames=driver.findElements(By.xpath("//select[@name='new_group']/option"));
		return groupNames;
		}
	public String randomGroupSelectionForContactCreation() {
		List<WebElement> groupNamesList=getGroupsNameInContactCreationForm(); 
		 Random rnd=new Random();
		 int index=rnd.nextInt(groupNamesList.size());
		selectGroupForContactCreation(index);
		 String groupName;
		 groupName=groupNamesList.get(index).getText();
		return groupName;
	}
	public String randomChangeGroup(Random rnd, int index) {
		List<WebElement> groupNamesList=getGroupsName(); 
		 int index2=rnd.nextInt(groupNamesList.size());
		 checkContact(index);
		selectGroupForChange(index2);
		 String groupName;
		 groupName=groupNamesList.get(index2).getText();
		 return groupName;
}
}
