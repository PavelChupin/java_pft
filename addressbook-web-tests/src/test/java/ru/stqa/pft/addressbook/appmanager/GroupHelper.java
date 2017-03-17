package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Summoner on 27.02.2017.
 */
public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnGroupToPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        /*if (!wd.findElement(By.xpath("//div[@id='content']/form/select//option[1]")).isSelected()) {
            click(By.xpath("//div[@id='content']/form/select//option[1]"));
        }*/
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }
/*
    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
        //click(By.name("selected[]"));
    }
*/
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
        //click(By.name("selected[]"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        //Сбрасываем кешь, после добавления группы так как новый список будет уже другим
        groupCache = null;
        returnGroupToPage();
    }

    public void modify(GroupData group) {
        selectGroupById(group.getId());
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        //Сбрасываем кешь, после модификации группы так как новый список будет уже другим
        groupCache = null;
        returnGroupToPage();
    }
/*
    public void delete(int index) {
        selectGroup(index);
        deleteSelectedGroups();
        returnGroupToPage();
    }
*/
    public void delete(GroupData group) {
        selectGroupById(group.getId());
        deleteSelectedGroups();
        //Сбрасываем кешь, после удаления группы так как новый список будет уже другим
        groupCache = null;
        returnGroupToPage();
    }

    public boolean isThereGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }
/*
    public List<GroupData> list() {
        List<GroupData> groups = new ArrayList<GroupData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupData group = new GroupData().withId(id).withName(name);
            groups.add( new GroupData().withId(id).withName(name));
        }
        return groups;
    }
*/
    //Переменная для хранения кеш набора списка
    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null){
            //Вернем копию кеша
            return new Groups(groupCache);
        }

        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupData group = new GroupData().withId(id).withName(name);
            groupCache.add( new GroupData().withId(id).withName(name));
        }
        return new Groups(groupCache);
    }

}
