package runner;

import data.ExcelReader;
import modelos.SignUpLoginModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ShoppingCartPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

import java.util.List;

public class ShoppingCartTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToShoppingCartPage();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingShoppingCartPageTest() {
        shoppingCartPage.verifyPage();
    }

    @Test
    public void verifyingSubscriptionTest() {
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        shoppingCartPage.fillingSubscriptions(signUpLoginModels.getFirst().getEmail());
    }

}
