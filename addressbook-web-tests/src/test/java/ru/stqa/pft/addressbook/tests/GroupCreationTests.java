package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;
import java.util.jar.Manifest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
/*
    public GroupCreationTests(){
        super(BrowserType.FIREFOX);
    }
*/


    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        //List<GroupData> before = app.group().list();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().create(group);
        //List<GroupData> after = app.group().list();
        Groups after = app.group().all();
        //int after = app.group().getGroupCount();
        //assertEquals(after.size(), before.size() + 1);
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
        //group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        //before.add(group);
        //Сортировка списков
/*
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
*/
        //assertEquals(before,after);
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));


        //Assert.assertEquals(before,after);
/*
        app.group().initGroupCreation();
        app.group().fillGroupForm(new GroupData("HomeGroup", "HomeGroup1", "HomeGroup2"));
        app.group().submitGroupCreation();
        app.group().returnGroupToPage();
*/
    }

}
