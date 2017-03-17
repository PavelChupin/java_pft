package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupModificationTests extends TestBase {
/*
    public GroupModificationTests() {
        super(BrowserType.CHROME);
    }
*/
    @BeforeMethod   //Вынесли в отдельный метод для подготовки площадки для теста
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {

        //int before = app.group().count();
        //List<GroupData> before = app.group().list();
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        //int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test1").withFooter("test2").withHeader("test3");
        app.group().modify(group);
        //int after = app.group().count();
        //List<GroupData> after = app.group().list();
        assertEquals(app.group().count(), before.size());
        Groups after = app.group().all();
        //assertEquals(after.size(), before.size());

       // before.remove(modifiedGroup);
       // before.add(group);
        //Сортировка списков
/*        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        */
       // Assert.assertEquals(before,after);

        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}
