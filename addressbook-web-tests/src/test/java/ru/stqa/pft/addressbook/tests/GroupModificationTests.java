package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.*;

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
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {

        //int before = app.group().getGroupCount();
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("test1").withFooter("test2").withHeader("test3");
        app.group().modify(index, group);
        //int after = app.group().getGroupCount();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size());

        before.remove(index);
        before.add(group);
        //Сортировка списков
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }


}
