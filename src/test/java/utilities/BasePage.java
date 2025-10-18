package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;

public abstract class BasePage{
    private final static int defaultTime = 5;
    protected final SoftAssert softAssert;
    private final int timeOut;

    public BasePage(int timeOut) {
        softAssert = new SoftAssert();
        this.timeOut = timeOut;
    }

    public BasePage() {
        this(defaultTime); //llamo el constructor de arriba con el default timeOut
    }

    protected WebDriver getDriver(){
        return new WebdriverProvider().get();
    }

    protected void waitPages(By locator, String pageName){
        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(this.timeOut));

        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    protected List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }

    public abstract void waitPageToLoad(); //espera que cargue la pagina
    public abstract void verifyPage(); //verificar la UI de las paginas

}