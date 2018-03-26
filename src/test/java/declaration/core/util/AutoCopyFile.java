package declaration.core.util;


import declaration.core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

public class AutoCopyFile extends BaseTest {

    @FindBy(xpath = "//*[@id='main-container']//article//div[2]/div/a/img")
    private WebElement pdfFileIcon;

    public AutoCopyFile(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(this.webDriver, this);
    }

    public void copyPdfFile() throws InterruptedException {
        pdfFileIcon.click();
        Util.pause(3000);
    }

    public void deleteAllFilesFromFolder(String path) {
        for (File myFile : new File(path).listFiles())
            if (myFile.isFile()) myFile.delete();
    }

    public boolean searchFile(String filepath) {
        File file = new File(filepath);
        if (file.isDirectory()) {
            if (file.list().length > 0) {
                System.out.println("Directory is not empty!");
            } else {
                System.out.println("Directory is empty!");
            }
            return true;
        } else {
            System.out.println("This is not a directory");
        }
        return false;
    }
}
