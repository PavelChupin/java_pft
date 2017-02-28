package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupModificationHome extends TestBase {

    public GroupModificationHome(){
        super(BrowserType.CHROME);
    }

    @Test
    public void homeGroupModification (){
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("HomeGroup3", "HomeGroup4", "HomeGroup5"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupToPage();
    }
}
