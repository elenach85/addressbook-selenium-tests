package com.example.tests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import  org.testng.annotations.Test;

import com.google.common.collect.Lists;
public class GroupCreationTests extends TestBase {

  @Test(dataProvider="randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    // save old state
    List<GroupData> oldList=app.getGroupHelper().getGroups();
       //actions
    app.getGroupHelper()
    .initGroupCreation()
  	.fillGroupForm(group)
    .submitGroupCreation()
    .returnGroupsPage();
    //save new state
    List<GroupData> newList=app.getGroupHelper().getGroups();
    //compare states
oldList.add(group);
Collections.sort(oldList);
assertEquals(newList, oldList);
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
