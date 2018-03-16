package declaration.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected static final String URL = "https://public.nazk.gov.ua";
    protected WebDriver webDriver;
    protected String path = "C:/Users/Anna/AutoTests/TestDeclaration/src/test/java/declaration/core/PackageForFile";

    @BeforeMethod
    public void setUp() {

            System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
            chromeOptionsMap.put("plugins.plugins_disabled", new String[] {
                    "Chrome PDF Viewer"
            });
            chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
            options.setExperimentalOption("prefs", chromeOptionsMap);
            String downloadFilepath = path;
            chromeOptionsMap.put("download.default_directory", downloadFilepath);
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            webDriver = new ChromeDriver(cap);
            webDriver.manage().window().maximize();
            webDriver.navigate().to(URL);
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }
}