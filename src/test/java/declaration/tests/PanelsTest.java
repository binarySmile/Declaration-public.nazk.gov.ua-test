package declaration.tests;


import declaration.core.BaseTest;
import declaration.core.util.panels.CommonForPanels;
import declaration.core.pages.DeclarationPage;
import declaration.core.pages.FilterPage;
import declaration.core.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PanelsTest extends BaseTest {

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
        assertTrue(declarationPage.getDocument().isDisplayed());
        CommonForPanels commonForPanels = new CommonForPanels(webDriver);
        commonForPanels.filterBySpecifiedValue(specificName);
    }
}