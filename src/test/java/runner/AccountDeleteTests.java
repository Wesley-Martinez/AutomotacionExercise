package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountDelete;
import pages.HomePage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;


public class AccountDeleteTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final AccountDelete accountDelete = new AccountDelete(driver,softAssert);
    private final CommonFlows commonFlows = new CommonFlows();
    private final HomePage homePage = new HomePage(driver,softAssert);

    @BeforeMethod
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToDeleteAccount();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void VerifyingAccountDeleteTest() {
        accountDelete.verifyPage();
    }

    @Test
    public void VerifyingDeleteAccountTest() {
//        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
//        String pj = signUpLoginModels.getFirst().getNombre();
//        System.out.print(signUpLoginModels + pj);
        accountDelete.clickContinueButton();

        homePage.waitPageToLoad();
        homePage.verifyPage();
    }
}
