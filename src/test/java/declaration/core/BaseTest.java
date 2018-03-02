package declaration.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
    protected static final String URL = "https://public.nazk.gov.ua";
    protected WebDriver webDriver;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}
