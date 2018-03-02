package declaration.tests;


import declaration.core.BaseTest;
import declaration.core.pages.DeclarationPage;
import declaration.core.pages.FilterPage;
import declaration.core.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DeclarationFirstPersonTest extends BaseTest {
    private final String name1 = "Порошенко Петро Олексійович";
    private final String type = "Декларація";
    private final String year = "2016";


    @Test
    public void search() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        FilterPage filterPage = mainPage.searchOfPerson(name1);
        assertTrue(filterPage.getResultSearch().isDisplayed());
        filterPage.openTypeMenu();
        assertTrue(filterPage.getDropdownMenu().isDisplayed());
        filterPage.choiceFilter(type);
        assertTrue(filterPage.getSelectedType(type));
        filterPage.openYearMenu();
        assertTrue(filterPage.getPanelSelectionOfYear().isDisplayed());
        filterPage.choiceFilter(year);
        assertTrue(filterPage.getSelectedYear(year));
        filterPage.runFilter();
        assertTrue(filterPage.getResultFilter().isDisplayed());
        DeclarationPage declarationPage = filterPage.openDocument();
        assertTrue(declarationPage.getDocument().isDisplayed());
        declarationPage.totalCost();
    }
}
