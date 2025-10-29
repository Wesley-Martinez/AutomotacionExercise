package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.PaymentPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class PaymentTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final CommonFlows commonFlows = new CommonFlows();
    private final PaymentPage paymentPage = new PaymentPage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Crear/inicializar driver a través de la fábrica
        driver = WebDriverFactory.getDriver();
        // Navegar a página
        commonFlows.goToPaymentPage();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.removeDriver();
    }


}
