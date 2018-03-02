package declaration.core.pages;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeclarationPage extends BaseTest {

    public DeclarationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(xpath = "//div/header/h2/span")
    private WebElement document;

    public WebElement getDocument() {
        return document;
    }
}
