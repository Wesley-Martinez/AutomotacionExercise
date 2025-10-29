package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountCreated;
import pages.AccountInformation;
import pages.HomePage;
import utilities.BaseTest;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class AccountCreatedTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final AccountCreated accountCreated = new AccountCreated(driver,softAssert);
    private final HomePage homePage = new HomePage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Crear/inicializar driver a través de la fábrica
        driver = WebDriverFactory.getDriver();
        commonFlows.goToAccountCreated();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingPageTest() {
        accountCreated.verifyPage();
    }

    @Test
    public void goToHomePageTest() {
        accountCreated.clickingOnContinueButton();

        homePage.waitPageToLoad();

        homePage.verifyPage();
    }
}
