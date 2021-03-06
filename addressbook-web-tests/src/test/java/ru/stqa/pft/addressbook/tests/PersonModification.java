package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.PersonData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonModification extends TestBase {

   /* public PersonModification(){
        super(BrowserType.CHROME);
    }
*/
    @Test(enabled = false)
    public void modificationPerson(){
        app.goTo().gotoHomePage();
        app.getPersonHelper().selectPerson();
        app.getPersonHelper().initPersonModification();
        app.getPersonHelper().fillPersonForm(new PersonData("Pavel", "", "Chupin", "PavelChupin", "", "", "630089, Novosibirsk, B.Bogatkova 185", "", "+79137382899", "pavel.chupin@gmail.com", "", "", "", "1984", "", "", "", null),false);
        app.getPersonHelper().submitPersonModification();
        //app.getPersonHelper().alertWindowOk();
        //app.goTo().gotoHomePage();
    }
}
