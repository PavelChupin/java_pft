package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Summoner on 27.02.2017.
 */
public class NavigationHelper extends HelperBase {
    //private FirefoxDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if(isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void gotoAddNewPage() {
        if (isElementPresent(By.tagName("h1")) //Если на странице есть элемент заголовок (тег)
                && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry") //Если значение элемента заголовок равно проверяемому значению
                && isElementPresent(By.name("submit"))) { /*Если на странице есть кнопка с именем*/
            return;
        }
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }
}
