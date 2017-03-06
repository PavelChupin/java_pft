package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    public GroupCreationTests(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().createGroup(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);
/*
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupToPage();
*/
    }

}
