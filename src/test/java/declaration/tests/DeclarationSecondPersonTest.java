package declaration.tests;


import declaration.core.BaseTest;
import declaration.core.Util.panels.CommonForPanels;
import declaration.core.pages.DeclarationPage;
import declaration.core.pages.FilterPage;
import declaration.core.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DeclarationSecondPersonTest extends BaseTest {
    private final String name2 = "Тарута Сергій Олексійович";
    private final String typeFilter = "Тип документу:";
    private final String type = "Декларація";
    private final String typeFilter2 = "Рік:";
    private final String year = "2016";


    @Test
    public void filterAndTestDeclaration(){
        MainPage mainPage = new MainPage(webDriver);
        FilterPage filterPage = mainPage.searchOfPerson(name2);
        assertTrue(filterPage.getResultSearch().isDisplayed());
        filterPage.openTypeMenu(typeFilter);
        assertTrue(filterPage.getDropdownMenu(type));
        filterPage.choiceFilter(type);
        assertTrue(filterPage.getSelectedFilter(type));
        filterPage.openTypeMenu(typeFilter2);
        assertTrue(filterPage.getPanelSelectionOfYear().isDisplayed());
        filterPage.choiceFilter(year);
        assertTrue(filterPage.getSelectedFilter(year));
        filterPage.runFilter();
        assertTrue(filterPage.getResultFilter().isDisplayed());
        DeclarationPage declarationPage = filterPage.openDocument();
        CommonForPanels commonForPanels = new CommonForPanels(webDriver);
        commonForPanels.totalCost();
        assertTrue(declarationPage.getDocument().isDisplayed());
    }
}
