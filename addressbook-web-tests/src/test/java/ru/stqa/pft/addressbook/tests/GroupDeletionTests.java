package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {
/*
    public GroupDeletionTests(){
        super(BrowserType.IE);
    }
*/

    @BeforeMethod //Вынесли в отдельный метод для подготовки площадки для теста
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if (app.group().list().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        //int before = app.group().getGroupCount();
        List<GroupData> before = app.group().list();
        int index = before.size() - 1;
        app.group().delete(index);
        //int after = app.group().getGroupCount();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        /*before.remove(before.size() - 1);
        for(int i = 0;i < after.size();i++){
            Assert.assertEquals(before.get(i),after.get(i));
        }*/
        before.remove(index);
        Assert.assertEquals(before,after);
    }




}
