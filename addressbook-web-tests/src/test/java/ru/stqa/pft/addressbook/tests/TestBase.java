package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

//import sun.plugin2.util.BrowserType;
/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase  {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

   /* public TestBase (String browserType){
        app = new ApplicationManager(browserType);
    }
*/
    @BeforeSuite  //Что бы запускать браузер один раз и выполнять все тесты в данной сесии браузера
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

}
