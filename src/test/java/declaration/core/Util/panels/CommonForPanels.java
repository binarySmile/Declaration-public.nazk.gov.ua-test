package declaration.core.Util.panels;

import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CommonForPanels extends BaseTest {

    private final String txt ="[Не відомо]";

    public CommonForPanels(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    @FindBy(xpath = "//td[1]/span[2]")
    private List <WebElement> typeOfObject;

    @FindBy(xpath = "//div/table/tbody/tr/td[3]/b")
    private List <WebElement> listCost;

    @FindBy(xpath = "//tr/td[1]/span[6]")
    private List <WebElement> dateOfPurchase;

    @FindBy(xpath = "//div[1]//tr/td[2]/span[2]")
    private List <WebElement> brandOfAuto;

    public void filterBySpecifiedValue(String txt) {
        int element = typeOfObject.size();
        int n = 0;
        for (int i = 0; i < element; i++) {
            WebElement el = typeOfObject.get(i);
            String text = el.getText();
            if (text.equals(txt)) {
                n++;
                System.out.println(text);
            }
        }
        System.out.println("Total quantity : " + n);
    }

    public int totalCost() {
        ArrayList<Integer> ar = new ArrayList <>();
        int totalCost = listCost.size();
        for (int i = 0; i < totalCost; i++) {
            WebElement el = listCost.get(i);
            String text = el.getText();
            if (text.equals(txt))
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
                "Total cost of possessions = " + g);
        return g;
    }
}





