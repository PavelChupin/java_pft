package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    public GroupCreationTests(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().createGroup(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
/*
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupToPage();
*/
    }

}
