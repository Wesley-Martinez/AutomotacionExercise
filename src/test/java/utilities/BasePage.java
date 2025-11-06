package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

/**
 * Base class for all page objects.
 */
public abstract class BasePage {

    protected final SoftAssert softAssert;
    private final int timeOut;
    public static WebDriver driver;
    private final String baseUrl;

    /**
     * Injecting Webdriver, softAssert, and Timeout
     */
    public BasePage(WebDriver driver, SoftAssert softAssert, int timeOut) {
        this.driver = driver;
        this.softAssert = softAssert;
        this.timeOut = timeOut;
        this.baseUrl = ConfigReader.getProperty("base.url"); // ✅ Added base URL
    }

    /**
     * Constructor with configurable timeout and WebDriver.
     */
    public BasePage(WebDriver driver, SoftAssert softAssert) {
        this(driver, softAssert,
                Integer.parseInt(ConfigReader.getProperty("basepage.default.timeout.seconds")));
    }

    /**
     * Getting Webdriver when it is not null
     */
    protected WebDriver getDriver() {
        if (driver == null) {
            driver = new WebdriverProvider().get();
        }
        return driver;
    }

    /**
     * Waits for the visibility of the element located by the specified locator.
     */
    protected void waitPages(By locator, String pageName) {
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Finding a unique element
     */
    protected WebElement find(By locator) {
        return getDriver().findElement(locator);
    }

    /**
     * Finding a list of elements
     */
    protected List<WebElement> findAll(By locator) {
        return getDriver().findElements(locator);
    }

    /**
     * Navigates to the base URL defined in config.properties.
     */
    public void navigateToBaseUrl() {
        //String baseUrl = ConfigReader.getProperty("base.url");
        getDriver().get(baseUrl);
    }

    /**
     * Waits until this page is fully loaded and ready for interactions.
     * The implementation should include any waits or checks required
     * to verify that the page elements are visible and the page is usable.
     */
    public abstract void waitPageToLoad();

    /**
     * Verifies that the UI of this page meets expected criteria:
     * all key elements are displayed, enabled, etc.
     * The sub-class should perform soft assertions (with softAssert) and call assertAll().
     */
    public abstract void verifyPage();
}