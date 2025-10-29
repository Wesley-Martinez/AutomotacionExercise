package utilities;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        threadDriver.set(driver);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static void removeDriver() {
        WebDriver driver = threadDriver.get();
        if (driver != null) {
            driver.quit();
            threadDriver.remove();
        }
    }
}
