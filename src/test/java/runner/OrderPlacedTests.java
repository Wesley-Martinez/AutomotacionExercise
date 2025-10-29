package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountDelete;
import pages.HomePage;
import pages.OrderPlacedPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class OrderPlacedTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final CommonFlows commonFlows = new CommonFlows();
    private final OrderPlacedPage orderPlacedPage = new OrderPlacedPage(driver, softAssert);
    private final HomePage homePage = new HomePage(driver,softAssert);
    private final AccountDelete accountDelete = new AccountDelete(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Crear/inicializar driver a través de la fábrica
        driver = WebDriverFactory.getDriver();
        // Navegar a página
        commonFlows.goToOrderPlaced();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.removeDriver();
    }

    @Test
    public void deletingAccountTest() {
        orderPlacedPage.confirmPaymentAndDeleteAccount();
        homePage.waitPageToLoad();
        homePage.clickDeleteAccount();
        accountDelete.waitPageToLoad();
        accountDelete.clickContinueButton();
        homePage.waitPageToLoad();
    }

}
