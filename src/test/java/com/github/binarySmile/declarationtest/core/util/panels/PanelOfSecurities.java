package com.github.binarySmile.declarationtest.core.util.panels;

import com.github.binarySmile.declarationtest.core.BaseTest;
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

    public int totalQuantityOfSecurities() {
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
        return totalQuantity;
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
        return totalCostSecurities;
    }
}


