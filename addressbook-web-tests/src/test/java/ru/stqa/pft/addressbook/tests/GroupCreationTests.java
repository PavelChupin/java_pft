package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    public GroupCreationTests(){
        super(BrowserType.FIREFOX);
    }

    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        //int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after.size(), before.size() + 1);
/*
        int max = 0;
        for (GroupData g : after){
            if (g.getId() > max){
                max = g.getId();
            }
        }
*/
        //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());

        //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        //group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        //Сортировка списков

        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);

        //Assert.assertEquals(before,after);
/*
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupToPage();
*/
    }

}
