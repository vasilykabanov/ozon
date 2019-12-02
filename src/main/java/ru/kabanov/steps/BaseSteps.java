package ru.kabanov.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.kabanov.pages.BasePage;
import ru.kabanov.util.TestProperties;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.Properties;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by yasup on 27.11.2019.
 */
public class BaseSteps {
    protected static WebDriver driver;
    public static WebDriverWait driverWait;
    protected static String baseURL;
    private static BasePage currentPage;
    private static TreeMap<String, String> selectedProducts = new TreeMap<>();

    public String getMaxPrice() {
        return selectedProducts.lastEntry().toString();
    }

    public static TreeMap<String, String> getSelectedProducts() {
        return selectedProducts;
    }

    public String toString() {
        return selectedProducts.keySet()
                .stream()
                .map(key -> key + " рублей - " + selectedProducts.get(key))
                .collect(Collectors.joining(";\n ", "{", "}"));
    }

    public static Properties properties = TestProperties.getINSTANCE().getProperties();

    public static WebDriver getDriver() {
        return driver;
    }

    public static BasePage getCurrentPage() {
        return currentPage;
    }

    public static WebDriverWait getWebDriverWait() {
        return driverWait;
    }


    @Before
    public static void setUp() throws Exception {
        switch (properties.getProperty("browser")) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", properties.getProperty("webdriver.gecko.driver"));
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
                driver = new ChromeDriver();
        }

        baseURL = properties.getProperty("firstUrl");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseURL);
        driverWait = new WebDriverWait(driver, 10, 1000);
    }

    @After
    public static void tearDown() throws Exception {
        selectedProducts.clear();
        driver.quit();
    }

    @Attachment(type = "image/png", value = "Screenshot")
    public static byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveText(String attachmentName, String message) {
        return message;
    }
}
