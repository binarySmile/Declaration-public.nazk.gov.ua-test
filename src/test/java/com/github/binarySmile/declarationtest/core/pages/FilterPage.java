package com.github.binarySmile.declarationtest.core.pages;

import com.github.binarySmile.declarationtest.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BaseTest {

    @FindBy(xpath = "//*[@class='result']")
    private WebElement resultSearch;

    @FindBy(xpath = "//div/button")
    private List <WebElement> listFilterButton;

    @FindBy(xpath = "//div/button/span[@class = 'ng-binding']")
    private List <WebElement> searchedFilter;

    @FindBy(xpath = "//div/ul/li/a/span")
    private List <WebElement> listFilter;

    @FindBy(xpath = "//*[@class ='declarationYear']")
    private WebElement panelSelectionOfYear;

    @FindBy(id = "declaration-search-submit")
    private WebElement searchButton;

    @FindBy(className = "break-words")
    private WebElement goToDocumentLink;

    @FindBy(xpath = "//*[@id='main-container']//div/article")
    private WebElement resultFilter;

    public FilterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void choiceOfElement(String type, List <WebElement> list) {
        for (int i = 0; i < list.size(); i++) {
            WebElement el = list.get(i);
            String text = el.getText();
            if (text.equalsIgnoreCase(type)) {
                el.click();
                break;
            }
        }
    }

    public void openTypeMenu(String filterButtonName) {
        choiceOfElement(filterButtonName, listFilterButton);
    }

    public WebElement getResultSearch() {
        return resultSearch;
    }

    public boolean getDropdownMenu(String typeFilter) {
        String text;
        for (int i = 0; i < listFilter.size(); i++) {
            WebElement el = listFilter.get(i);
            text = el.getText();
            if (text.equals(typeFilter))
                return true;
        }
        return false;
    }

    public void choiceFilter(String typeFilter) {
        choiceOfElement(typeFilter, listFilter);
    }

    public boolean getSelectedFilter(String typeFilter) {
        String text;
        for (int i = 0; i < searchedFilter.size(); i++) {
            WebElement el = searchedFilter.get(i);
            text = el.getText();
            if (text.equals(typeFilter))
                return true;
        }
        return false;
    }

    public WebElement getPanelSelectionOfYear() {
        return panelSelectionOfYear;
    }

    public void runFilter() {
        searchButton.click();
    }

    public WebElement getResultFilter() {
        return resultFilter;
    }

    public DeclarationPage openDocument() {
        goToDocumentLink.click();
        ArrayList tabs2 = new ArrayList(webDriver.getWindowHandles());
        webDriver.switchTo().window(String.valueOf(tabs2.get(1)));
        return new DeclarationPage(webDriver);
    }
}
