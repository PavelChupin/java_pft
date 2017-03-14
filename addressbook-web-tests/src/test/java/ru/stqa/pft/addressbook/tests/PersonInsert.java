package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

public class PersonInsert extends TestBase {
/*
    public PersonInsert(){
        super(BrowserType.FIREFOX);
    }
*/
    @Test(enabled = false)
    public void insertPerson() {
        //wd.findElement(By.id("nav")).click();
        app.goTo().gotoAddNewPage();
        app.getPersonHelper().fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "","test1"),true);
        app.getPersonHelper().savePersonData();
    }

}
