package com.github.binarySmile.declarationtest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static final String path = System.getProperty("user.dir")
            + "\\src\\test\\java\\com\\github\\binarySmile\\declarationtest\\core\\packageForFile";
    protected static Properties data;
    protected WebDriver webDriver;

    @BeforeTest
    public void initialize() {
        data = new Properties();
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/data.properties")) {
            data.load(new InputStreamReader(fis, Charset.forName("UTF-8")));
        } catch (Exception ex) {
            throw new RuntimeException("Exception during the IO operation: "
                    + ex.getLocalizedMessage());
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
        chromeOptionsMap.put("download.prompt_for_download", "false");
        chromeOptionsMap.put("download.default_directory", path);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        options.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(ChromeOptions.CAPABILITY, cap);
        webDriver = new ChromeDriver(options);
        webDriver.manage().window().maximize();
        webDriver.navigate().to(getURL());
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null)
            webDriver.quit();
    }

    protected String getURL() {
        return data.getProperty("url");
    }

    protected String getName1() {
        return data.getProperty("name_1");
    }

    protected String getName2() {
        return data.getProperty("name_2");
    }

    protected String getTypeFilter1() {
        return data.getProperty("type_filter_1");
    }

    protected String getTypeFilter2() {
        return data.getProperty("type_filter_2");
    }

    protected String getType() {
        return data.getProperty("type");
    }

    protected String getYear() {
        return data.getProperty("year");
    }

    protected String getSpecificName() {
        return data.getProperty("specific_name");
    }

    protected String getValueInsteadOfEmptyCell() {
        return data.getProperty("value_instead_of_empty_cell");
    }
}

