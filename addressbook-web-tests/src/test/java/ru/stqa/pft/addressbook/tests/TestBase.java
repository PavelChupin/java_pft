package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;
//import sun.plugin2.util.BrowserType;
import org.openqa.selenium.remote.BrowserType;
/**
 * Created by Summoner on 26.02.2017.
 */
public class TestBase  {

    protected final ApplicationManager app /*= new ApplicationManager(BrowserType.CHROME)*/;

    public TestBase (String browserType){
        app = new ApplicationManager(browserType);
    }

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }

    public ApplicationManager getApp() {
        return app;
    }

}
