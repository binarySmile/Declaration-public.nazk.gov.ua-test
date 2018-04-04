package com.github.binarySmile.declarationtest.core.pages;

import com.github.binarySmile.declarationtest.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeclarationPage extends BaseTest {

    @FindBy(xpath = "//div/header/h2/span")
    private WebElement document;

    public DeclarationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public WebElement getDocument() {
        return document;
    }
}

