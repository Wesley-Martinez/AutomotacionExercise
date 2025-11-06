package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;


@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final String regression = "regression";
    protected final String smoke = "smoke";
    protected final CommonFlows commonFlows = new CommonFlows();
    protected final DriverManager driverManager = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    public void mastersetUp() {
        driverManager.buildDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void mastertearDown() {
        driverManager.killDriver();
    }

    protected void sleep(int timeMs){
        try{
            Thread.sleep(timeMs);
        }catch (InterruptedException interruptedException){
            Logs.error("Error al esperar: %s", interruptedException.getLocalizedMessage());
        }
    }
}