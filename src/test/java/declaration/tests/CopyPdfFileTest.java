package declaration.tests;


import declaration.core.BaseTest;
import declaration.core.Util.AutoCopyFile;
import declaration.core.pages.FilterPage;
import declaration.core.pages.MainPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CopyPdfFileTest extends BaseTest{
    private final String name1 = "Порошенко Петро Олексійович";
    private final String typeFilter = "Тип документу:";
    private final String type = "Декларація";
    private final String typeFilter2 = "Рік:";
    private final String year = "2016";
    private final String path = "C:/Users/Anna/AutoTests/TestDeclaration/src/test/java/declaration/core/PackageForFile";

@Test
    public void copyFile() throws InterruptedException {
        MainPage mainPage = new MainPage(webDriver);
        FilterPage filterPage = mainPage.searchOfPerson(name1);
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
        AutoCopyFile autoCopyFile = new AutoCopyFile(webDriver);
        autoCopyFile.copyPdfFile();
        assertTrue(autoCopyFile.searchFile(path));
        autoCopyFile.deleteAllFilesFolder(path);
        assertTrue(autoCopyFile.searchFile(path));
    }
}

