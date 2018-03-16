package declaration.core.pages;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BaseTest {

    public FilterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

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

    public WebElement getResultSearch() {
        return resultSearch;
    }

    public void openTypeMenu(String typeFilter) {
        int listMenu = listFilterButton.size();
        for (int i = 0; i < listMenu; i++) {
            WebElement el = listFilterButton.get(i);
            String text = el.getText();
            if (text.equalsIgnoreCase(typeFilter)) {
                el.click();
                break;
            }
        }
    }

    public void choiceFilter(String type) {
        int list = listFilter.size();
        for (int i = 0; i < list; i++) {
            WebElement el = listFilter.get(i);
            String text = el.getText();
            if (text.equalsIgnoreCase(type)) {
                el.click();
                break;
            }
        }
    }

    public boolean getDropdownMenu(String type) {
        int list = listFilter.size();
        String text;
        for (int i = 0; i < list; i++) {
            WebElement el = listFilter.get(i);
            text = el.getText();
            if (text.equals(type))
                return true;
        }
        return false;
    }


    public boolean getSelectedFilter(String type) {
        int list = searchedFilter.size();
        String text;
        for (int i = 0; i < list; i++) {
            WebElement el = searchedFilter.get(i);
            text = el.getText();
            if (text.equals(type))
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
