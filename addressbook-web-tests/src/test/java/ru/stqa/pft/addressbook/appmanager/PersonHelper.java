package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.PersonData;

/**
 * Created by Summoner on 27.02.2017.
 */
public class PersonHelper extends HelperBase{
    //private FirefoxDriver wd;

    public PersonHelper(WebDriver wd) {
        super(wd);
    }

    public void savePersonData() {
        //wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillPersonForm(PersonData personData, boolean insert) {
        type(By.name("firstname"),personData.getFirstname());
        /*wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(personData.getFirstname());
        */
        type(By.name("middlename"),personData.getMiddlename());
        /*
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(personData.getMiddlename());
        */
        type(By.name("lastname"),personData.getLastname());
        /*
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).sendKeys(personData.getLastname());
        */
        type(By.name("nickname"),personData.getNickname());
        /*
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(personData.getNickname());
        */
        type(By.name("title"),personData.getTitle());
        /*
        wd.findElement(By.name("title")).click();
        wd.findElement(By.name("title")).sendKeys(personData.getTitle());
        */
        type(By.name("company"),personData.getCompany());
        /*
        wd.findElement(By.name("company")).click();
        wd.findElement(By.name("company")).sendKeys(personData.getCompany());
        */
        type(By.name("address"),personData.getAddress());
        /*
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(personData.getAddress());
        */
        type(By.name("home"),personData.getHome());
        /*
        wd.findElement(By.name("home")).click();
        wd.findElement(By.name("home")).sendKeys(personData.getHome());
        */
        type(By.name("mobile"),personData.getMobilephone());
        /*
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(personData.getMobilephone());
        */
        type(By.name("email"),personData.getEmail());
        /*
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(personData.getEmail());
        */
        type(By.name("email2"),personData.getEmail2());
        /*
        wd.findElement(By.name("email2")).click();
        wd.findElement(By.name("email2")).sendKeys(personData.getEmail2());
        */
        type(By.name("email3"),personData.getEmail3());
        /*
        wd.findElement(By.name("email3")).click();
        wd.findElement(By.name("email3")).sendKeys(personData.getEmail3());
        */
        type(By.name("homepage"),personData.getHomepage());
        /*
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).sendKeys(personData.getHomepage());
        */
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[3]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[12]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[13]")).click();
        }
        wd.findElement(By.name("byear")).click();
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[7]")).click();
        }
        type(By.name("byear"),personData.getByear());
        /*
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(personData.getByear());
        */
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[1]")).click();
        }
        if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[1]")).click();
        }
        type(By.name("ayear"),personData.getAyear());
        /*
        wd.findElement(By.name("ayear")).click();
        wd.findElement(By.name("ayear")).sendKeys(personData.getAyear());
        */
       /* if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).isSelected()) {
            wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[1]")).click();
        }*/
        if(insert){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personData.getGroup());
        }else{
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"),personData.getAddress2());
        /*
        wd.findElement(By.name("address2")).click();
        wd.findElement(By.name("address2")).sendKeys(personData.getAddress2());
        */
        type(By.name("phone2"),personData.getPhone2());
        /*
        wd.findElement(By.name("phone2")).click();
        wd.findElement(By.name("phone2")).sendKeys(personData.getPhone2());
        */

    }

    public void selectPerson() {
        //wd.findElement(By.name("selected[]")).click();
        click(By.name("selected[]"));
    }

    public void deleteSelectedPerson() {
        //wd.findElement(By.xpath("//div[@id='content']/form[2]/div[2]/input")).click();
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertWindowOk() {
        wd.switchTo().alert().accept();
    }

    public void initPersonModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitPersonModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
        //click(By.xpath("//div/div[4]/form[1]/input[22]"));
    }
}
