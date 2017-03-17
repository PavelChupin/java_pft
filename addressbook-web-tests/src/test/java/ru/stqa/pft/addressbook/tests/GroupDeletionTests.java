package ru.stqa.pft.addressbook.tests;

import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
/*
    public GroupDeletionTests(){
        super(BrowserType.IE);
    }
*/

    @BeforeMethod //Вынесли в отдельный метод для подготовки площадки для теста
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        //int before = app.group().count();
        //List<GroupData> before = app.group().list();
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next(); //Выбираем группу
        //int index = before.size() - 1;
        //app.group().delete(index);
        app.group().delete(deletedGroup);
        //int after = app.group().count();
        //List<GroupData> after = app.group().list();
        assertEquals(app.group().count(), before.size() - 1);
        Groups after = app.group().all();
        //assertEquals(after.size(), before.size() - 1);

        /*before.remove(before.size() - 1);
        for(int i = 0;i < after.size();i++){
            Assert.assertEquals(before.get(i),after.get(i));
        }*/
        //before.remove(index);
        //before.remove(deletedGroup);
        assertThat(after, equalTo(before.without(deletedGroup)));
        //Assert.assertEquals(before,after);
    }




}
