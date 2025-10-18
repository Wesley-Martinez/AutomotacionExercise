package runner;

import data.ExcelReader;
import io.qameta.allure.Step;
import modelos.SignUpLoginModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;
import utilities.BaseTest;
import utilities.CommonFlows;

import java.util.List;

public class ShoppingCartTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingCartPage();
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
