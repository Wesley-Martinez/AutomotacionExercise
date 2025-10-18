package runner;

import data.ExcelReader;
import io.qameta.allure.Step;
import modelos.SignUpLoginModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BaseTest;

import java.util.List;

public class HomeTests extends BaseTest {
    private final HomePage homePage = new HomePage();
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToHomePage();
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
