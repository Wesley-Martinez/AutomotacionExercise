package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.DetailProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class DetailProductsTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final CommonFlows commonFlows = new CommonFlows();
    private final DetailProductsPage detailProductsPage = new DetailProductsPage(driver, softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToDetailProduct();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingDetailProductsTest() {
        detailProductsPage.verifyPage();
    }
}
