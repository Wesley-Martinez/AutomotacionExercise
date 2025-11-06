package runner;

import data.ExcelReader;
import io.qameta.allure.Step;
import modelos.SignUpLoginModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import utilities.BaseTest;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

import java.util.List;

public class HomeTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final HomePage homePage = new HomePage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToHomePage();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingHomePageTest() {
        homePage.verifyPage();
        
    }

    @Test
    public void verifyingSubscriptionTest() {
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        homePage.fillingSubscriptions(signUpLoginModels.getFirst().getEmail());
    }

    @Step("Ejercicio 15 hecho")
    @Test
    public void registerBeforeCheckout(){
        commonFlows.registerBeforeCheckout();
    }

    @Step("Ejercicio 16 hecho")
    @Test
    public void loginBeforeCheckoutTest() {
        commonFlows.loginBeforeCheckout();
    }

    @Step("Test 18")
    @Test
    public void viewCategoryProductsTest() {
        homePage.viewCategoryProducts();
    }
}
