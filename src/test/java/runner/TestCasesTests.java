package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestCasesPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class TestCasesTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final CommonFlows commonFlows = new CommonFlows();
    private final TestCasesPage testCasesPage = new TestCasesPage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Crear/inicializar driver a través de la fábrica
        driver = WebDriverFactory.getDriver();
        // Navegar a página
        commonFlows.goToTestCasesPage();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingTestCasesTest() {
        testCasesPage.verifyPage();
    }
}
