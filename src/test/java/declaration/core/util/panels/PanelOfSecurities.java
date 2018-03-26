package declaration.core.util.panels;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PanelOfSecurities extends BaseTest {

    @FindBy(xpath = "//div[5]/div[2]//tr/td[3]")
    private List <WebElement> quantityOfSecurities;

    @FindBy(xpath = "//div[2]/table/tbody/tr/td[4]")
    private List <WebElement> costSecurities;

    public PanelOfSecurities(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void totalQuantityOfSecurities() {
        ArrayList <Integer> list = new ArrayList <>();
        for (int i = 0; i < quantityOfSecurities.size(); i++) {
            WebElement el = quantityOfSecurities.get(i);
            String text = el.getText();
            int sum = Integer.parseInt(text);
            list.add(sum);
        }
        int totalQuantity = 0;

        for (int quantity : list)
            totalQuantity += quantity;

        System.out.println("\n" +
                "Total quantity of securities = " + totalQuantity);
    }

    public int totalCostOfSecurities() {
        ArrayList <Integer> list = new ArrayList <>();
        int totalCost = costSecurities.size();
        for (int i = 0; i < totalCost; i++) {
            WebElement el = costSecurities.get(i);
            String text = el.getText();
            int sum = Integer.parseInt(text);
            list.add(sum);
        }
        int totalCostSecurities = 0;

        for (int costOfSecurities : list)
            totalCostSecurities += costOfSecurities;

        System.out.println("\n" +
                "Total cost of securities = " + totalCostSecurities);
        return totalCostSecurities;
    }
}


