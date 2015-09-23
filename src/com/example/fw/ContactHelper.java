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
	public ContactHelper submitContactCreation() {
		driver.findElement(By.name("submit")).click();
		return this;
	}

	public ContactHelper initContactCreation() {
		driver.findElement(By.linkText("add new")).click();
		return this;
	}

	/**
		 * @param applicationManager TODO
	 * @param testBase TODO
	 * @param contact TODO
		 */
	public ContactHelper fillContactCreationForm(ContactData contact) {
		type(By.name("firstname"),contact.getFirst_name());
		type(By.name("lastname"),contact.getLast_name());
	  	type(By.name("address"),contact.getAddress_1());
		type(By.name("home"),contact.getHome_tel());
	  	type(By.name("mobile"),contact.getMobile_tel());
	    type(By.name("work"),contact.getWork_tel());
		type(By.name("email"),contact.getEmail());
		type(By.name("email2"),contact.getEmail2());
		type(By.name("byear"),contact.getBirth_year());
	   	selectByText(By.name("bmonth"), contact.getBirth_month());
	   	selectByText(By.name("bday"), contact.getBirth_day());
		//selectByText(By.name("new_group"),contact.getGroup_name());
	    type(By.name("address2"),contact.getAddress_2());
	    type(By.name("phone2"),contact.getPhone_2());
	    return this;
	}

	
	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this;
		}

	public ContactHelper selectContact(int index) {
	click(By.xpath("//tr[@name='entry'][" + (index+1) + "]/td/a/img[@title='Edit']"));
	return this;
	}

	public ContactHelper deleteContact() {
	click(By.xpath("//input[@value='Delete']"));
	return this;
	}

	  public ContactHelper submitContactModification() {
		  click(By.xpath("//input[@value='Update']"));
		  return this;
	}

	public ContactHelper checkContact(int index) {
    click(By.xpath("(//input[@type='checkbox'])[" + (index+1) + "]"));
    return this;	
	}

	  public ContactHelper selectGroupForChange(int index2) {
      click(By.xpath("(//select[@name='to_group']/option)[" + (index2+1) + "]"));
      return this;			  
	}
	
	  
	  public ContactHelper selectGroupForContactCreation(int index) {
		
	     click(By.xpath("(//select[@name='new_group']/option)[" + (index+1) + "]"));
	     return this;			  
		}
	 	
	public ContactHelper submitGroupChange() {
	click(By.xpath("//input[@name='add']"));
	return this;	
	}

	public ContactHelper goToSubmittedGroupPage() { 
		click(By.xpath("//*[@id='content']/div/i/a"));
		return this;
	}
	
	public List<ContactData> getContacts() {
	List<ContactData>contacts=new ArrayList<ContactData>();
	List<WebElement> rows = findElements();
	for (WebElement row : rows) {
		List<WebElement>columns =row.findElements(By.tagName("td"));
	//for (WebElement column : columns) {
		ContactData contact=new ContactData();
		String last_name_title=columns.get(1).getText();
		String first_name_title=columns.get(2).getText();
		//contact.last_name=columns.get(1).getText();
		//contact.first_name=columns.get(2).getText();
		String email=columns.get(3).getText();
		//contact.email=columns.get(3).getText();
		String home_tel=columns.get(4).getText();
		//contact.home_tel=columns.get(4).getText();
		contacts.add(new ContactData().withFirstname(first_name_title).withLastname(last_name_title).withEmail(email).withHomeTel(home_tel));
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
		 int index=rnd.nextInt(groupNamesList.size()-1);
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
