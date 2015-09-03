package com.example.fw;

import org.openqa.selenium.By;
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
	click(By.xpath("//tr[@name='entry'][" + index + "]/td/a/img[@title='Edit']"));
	}

	public void deleteContact() {
	click(By.xpath("//input[@value='Delete']"));
	}

	  public void submitContactModification() {
		  click(By.xpath("//input[@value='Update']"));
		
	}

	public void checkContact(int index) {
    click(By.xpath("(//input[@type='checkbox'])[" + index + "]"));
		
	}

	  public void selectGroupForChange(int index) {
      click(By.xpath("(//select[@name='to_group']/option)[" + index + "]"));
				  
	}

	
	public void submitGroupChange() {
	click(By.xpath("//input[@name='add']"));
		
	}

	public void goToSubmittedGroupPage() {
		click(By.xpath("//*[@id='content']/div/i/a"));

	}
		
	}


