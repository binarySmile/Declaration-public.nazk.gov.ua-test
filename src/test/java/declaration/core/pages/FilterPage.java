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

    @FindBy(className = "break-words")
    private WebElement nameResultSearch;

    @FindBy(xpath = "//div[3]/button")
    private WebElement buttonType;

    @FindBy(xpath = "//div[3]/button/span[@class='ng-binding']")
    private WebElement selectedType;

    @FindBy(className = "documentType")
    private WebElement dropdownMenuButton;

    @FindBy(xpath = "//div[2]/button")
    private WebElement dropdownYearMenuButton;

    @FindBy(xpath = "//div[2]/button/span[@class='ng-binding']")
    private WebElement selectedYear;

    @FindBy(xpath = "//*[@class ='declarationYear']")
    private WebElement panelSelectionOfYear;

    @FindBy(id = "declaration-search-submit")
    private WebElement searchButton;

    @FindBy(className = "break-words")
    private WebElement goToDocumentLink;

    @FindBy(xpath = "//*[@id='main-container']//div/article")
    private WebElement resultFilter;

    @FindBy(xpath = "//*[@id='portal-search-form-filters']//div/ul/li/a/span")
    private List <WebElement> list;

    public WebElement getResultSearch() {
        return resultSearch;
    }

    public void openTypeMenu() {
        buttonType.click();
    }

    public WebElement getDropdownMenu() {
        return dropdownMenuButton;
    }

    public void choiceFilter(String filter) {
        int total = list.size();
        for (int i = 0; i < total; i++) {
            WebElement el = list.get(i);
            String text = el.getText();
            if (text.equalsIgnoreCase(filter)) {
                el.click();
                break;
            }
        }
    }

    public WebElement getPanelSelectionOfYear() {
        return panelSelectionOfYear;
    }

    public void openYearMenu() {
        dropdownYearMenuButton.click();
    }

    public void runFilter() {
        searchButton.click();
    }

    public boolean getSelectedType(String type) {
        return selectedType.getText().equals(type);
    }

    public boolean getSelectedYear(String year) {
        return selectedYear.getText().equals(year);
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
