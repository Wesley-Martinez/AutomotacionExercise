package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountCreated;
import pages.AccountInformation;
import pages.HomePage;
import utilities.BaseTest;

public class AccountCreatedTests extends BaseTest {
    private final AccountCreated accountCreated = new AccountCreated();
    private final HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToAccountCreated();
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
