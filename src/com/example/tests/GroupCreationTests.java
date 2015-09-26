package com.example.tests;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import  org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matcher.*;

import com.example.utils.ListOf;
import com.example.utils.SortedListOf;
import com.google.common.collect.Lists;
public class GroupCreationTests extends TestBase {

  @Test(dataProvider="randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {

    // save old state
	  SortedListOf<GroupData> oldList=app.getGroupHelper().getGroups();
	//ListOf<GroupData> oldList=app.getGroupHelper().getGroups();
       //actions
    app.getGroupHelper().createGroup(group);
  
    //save new state
    SortedListOf<GroupData> newList=app.getGroupHelper().getGroups();
   // ListOf<GroupData> newList=app.getGroupHelper().getGroups();
    //compare states
//oldList.add(group);
//Collections.sort(oldList);
//assertEquals(newList, oldList);
assertThat(newList,equalTo(oldList.withAdded(group)));
//assertThat(newList, equalTo);
  }

  
 
}
