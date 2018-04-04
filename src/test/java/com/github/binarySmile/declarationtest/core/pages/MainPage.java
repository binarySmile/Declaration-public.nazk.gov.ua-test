package com.github.binarySmile.declarationtest.core.pages;

import com.github.binarySmile.declarationtest.core.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseTest {

    @FindBy(xpath = "//div/input[@name='q']")
    private WebElement searchInput;

    public MainPage(WebDriver driver) {
        webDriver = driver;
        PageFactory.initElements(this.webDriver, this);
    }

    public FilterPage searchOfPerson(String namePerson) {
        searchInput.clear();
        searchInput.sendKeys(namePerson);
        searchInput.sendKeys(Keys.RETURN);
        return new FilterPage(webDriver);
    }
}



