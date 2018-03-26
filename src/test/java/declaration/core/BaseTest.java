package declaration.core;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    protected static Properties data;
    protected static final String URL = "https://public.nazk.gov.ua";
    protected WebDriver webDriver;
    protected String path = "src/test/java/declaration/core/packageForFile";
    protected final String specificName = "Земельна ділянка";

    @BeforeTest
    public void initialize(){
        data = new Properties();
        try(FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/data.properties")) {
        data.load(fis);
        }
        catch (Exception ex){
            throw new RuntimeException("Exception during the IO operation: " + ex.getLocalizedMessage());
        }
    }

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        HashMap <String, Object> chromeOptionsMap = new HashMap <>();
        chromeOptionsMap.put("plugins.plugins_disabled", new String[]{
                "Chrome PDF Viewer"
        });
        chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
        options.setExperimentalOption("prefs", chromeOptionsMap);
        chromeOptionsMap.put("download.default_directory", path);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(ChromeOptions.CAPABILITY, cap);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(URL);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    protected String getName1(){
        return data.getProperty("NAME_1");
    }

    protected String getName2(){
        return data.getProperty("NAME_2");
    }

    protected String getTypeFilter1(){
        return data.getProperty("TYPE_FILTER_1");
    }

    protected String getTypeFilter2() {
        return data.getProperty("TYPE_FILTER_2");
    }

    protected String getType(){
        return data.getProperty("TYPE");
    }

    protected String getYear(){
        return data.getProperty("YEAR");
    }
}

