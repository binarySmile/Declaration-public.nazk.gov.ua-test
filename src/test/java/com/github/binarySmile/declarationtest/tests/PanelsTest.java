package com.github.binarySmile.declarationtest.tests;

import com.github.binarySmile.declarationtest.core.BaseTest;
import com.github.binarySmile.declarationtest.core.pages.DeclarationPage;
import com.github.binarySmile.declarationtest.core.pages.FilterPage;
import com.github.binarySmile.declarationtest.core.pages.MainPage;
import com.github.binarySmile.declarationtest.core.util.panels.CommonForPanels;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PanelsTest extends BaseTest {

    @Test
    public void filterAndTestDeclaration() {
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
        System.out.println("Total quantity : "
                + commonForPanels.filterBySpecifiedValue(getSpecificName()));
    }
}