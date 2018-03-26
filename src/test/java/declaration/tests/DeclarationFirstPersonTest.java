package declaration.tests;


import declaration.core.BaseTest;
import declaration.core.util.panels.CommonForPanels;
import declaration.core.util.panels.PanelOfSecurities;
import declaration.core.pages.DeclarationPage;
import declaration.core.pages.FilterPage;
import declaration.core.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DeclarationFirstPersonTest extends BaseTest {

    @Test
    public void filterAndTestDeclaration(){
        MainPage mainPage = new MainPage(webDriver);
        FilterPage filterPage = mainPage.searchOfPerson(getName1());
        assertTrue(filterPage.getResultSearch().isDisplayed());
        filterPage.openTypeMenu(getTypeFilter1());
        assertTrue(filterPage.getDropdownMenu(getType()));
        filterPage.choiceFilter(getType());
        assertTrue(filterPage.getSelectedFilter(getType()));
        filterPage.openTypeMenu(getTypeFilter2());
        assertTrue(filterPage.getPanelSelectionOfYear().isDisplayed());
        filterPage.choiceFilter(getYear());
        assertTrue(filterPage.getSelectedFilter(getYear()));
        filterPage.runFilter();
        assertTrue(filterPage.getResultFilter().isDisplayed());
        DeclarationPage declarationPage = filterPage.openDocument();
        CommonForPanels commonForPanels = new CommonForPanels(webDriver);
        System.out.println("\n" + "Total cost of possessions = " +
                commonForPanels.totalCostOfPossessions());
        assertTrue(declarationPage.getDocument().isDisplayed());
        PanelOfSecurities panelOfSecurities = new PanelOfSecurities(webDriver);
        panelOfSecurities.totalQuantityOfSecurities();
        panelOfSecurities.totalCostOfSecurities();
    }
}
