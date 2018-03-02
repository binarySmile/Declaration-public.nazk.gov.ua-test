package declaration.core.pages;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DeclarationPage extends BaseTest {

    public DeclarationPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(xpath = "//div/header/h2/span")
    private WebElement document;

    @FindBy(xpath = "//div/table/tbody/tr/td[3]/b")
    private List <WebElement> listCost;

    @FindBy(xpath = "//div/table/tbody/tr/td[1]/span[2]")
    private List <WebElement> listType;

    @FindBy(xpath = "//div/table/tbody/tr/td[1]/span[6]")
    private List <WebElement> listData;

    public WebElement getDocument() {
        return document;
    }

    public List <WebElement> getListCost() {
        return listCost;
    }

    public void totalCost() {
        ArrayList <Integer> ar = new ArrayList <>();
        int totalCost = listCost.size();
        for (int i = 0; i < totalCost; i++) {
            WebElement el = listCost.get(i);
            String text = el.getText();
            if (text.equals("[Не відомо]"))
                text.equalsIgnoreCase(null);
            else {
                int sum = Integer.parseInt(text);
                ar.add(sum);
            }
        }
        int g = 0;

        for (int h : ar)
            g += h;

        System.out.println("\n" +
                "Total cost of property = " + g);
    }
}

