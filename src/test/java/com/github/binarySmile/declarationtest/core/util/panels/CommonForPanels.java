package com.github.binarySmile.declarationtest.core.util.panels;

import com.github.binarySmile.declarationtest.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CommonForPanels extends BaseTest {

    @FindBy(xpath = "//td[1]/span[2]")
    private List <WebElement> typeOfObject;
    @FindBy(xpath = "//div/table/tbody/tr/td[3]/b")
    private List <WebElement> listCost;
    @FindBy(xpath = "//tr/td[1]/span[6]")
    private List <WebElement> dateOfPurchase;
    @FindBy(xpath = "//div[1]//tr/td[2]/span[2]")
    private List <WebElement> brandOfAuto;

    public CommonForPanels(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public int filterBySpecifiedValue(String value) {
        int quantity = 0;
        for (int i = 0; i < typeOfObject.size(); i++) {
            WebElement el = typeOfObject.get(i);
            String text = el.getText();
            if (text.equals(value)) {
                quantity++;
                System.out.println(text);
            }
        }
        return quantity;
    }

    public int totalCostOfPossessions() {
        ArrayList <Integer> list = new ArrayList <>();
        for (int i = 0; i < listCost.size(); i++) {
            WebElement el = listCost.get(i);
            String text = el.getText();
            if (text.equals(getValueInsteadOfEmptyCell()))
                text.equalsIgnoreCase(null);
            else {
                int sum = Integer.parseInt(text);
                list.add(sum);
            }
        }
        int totalCostPossessions = 0;
        for (int cost : list)
            totalCostPossessions += cost;
        return totalCostPossessions;
    }
}





