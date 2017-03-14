package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

public class PersonDelete extends TestBase {
/*
    public PersonDelete(){
        super(BrowserType.IE);
    }
*/
    @Test(enabled = false)
    public void deletePerson() {
        app.getNavigationHelper().gotoHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().deleteSelectedPerson();
        app.getPersonHelper().alertWindowOk();
    }

}
