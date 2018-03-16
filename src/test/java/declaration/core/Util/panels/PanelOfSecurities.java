package declaration.core.Util.panels;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PanelOfSecurities extends BaseTest {

    public PanelOfSecurities(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//div[5]/div[2]//tr/td[3]")
    private WebElement quantityObject;

    @FindBy(xpath = "//div[2]/table/tbody/tr/td[4]")
    private WebElement costSecurities;

}
