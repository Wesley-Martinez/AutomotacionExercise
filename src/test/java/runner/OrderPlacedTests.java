package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountDelete;
import pages.HomePage;
import pages.OrderPlacedPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class OrderPlacedTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final OrderPlacedPage orderPlacedPage = new OrderPlacedPage();
    private final HomePage homePage = new HomePage();
    private final AccountDelete accountDelete = new AccountDelete();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToOrderPlaced();
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

    @Test
    public void registerBeforeCheckoutTest() {

    }
}
