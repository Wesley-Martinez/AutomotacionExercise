package runner;

import data.ExcelReader;
import modelos.AccountInfoModel;
import modelos.SignUpLoginModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountDelete;
import pages.HomePage;
import pages.SignUpLoginPage;
import utilities.BaseTest;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

import java.util.List;

public class SignUpLoginTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final SignUpLoginPage signUpLoginPage = new SignUpLoginPage(driver,softAssert);
    private final AccountDelete accountDelete = new AccountDelete(driver,softAssert);
    private final HomePage homePage = new HomePage(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToSignUpLoginPage();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingSingUpLoginTest() {
        signUpLoginPage.verifyPage();
    }

    @Test
    public void deletingAccountLogInTest() {
        commonFlows.goToLoginToYourAccount();

        accountDelete.clickContinueButton();
        homePage.waitPageToLoad();
        homePage.verifyPage();
    }

    @Test
    public void userIncorrectTest() {
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        signUpLoginPage.verifyingErrorMessage(
                signUpLoginModels.getFirst().getEmail(),
                accountInfoModels.getFirst().getPassword(),
                signUpLoginModels.getFirst().getErrorMessage()
        );
    }

    //4Test case
    @Test
    public void loginOutUserTest() {
        commonFlows.goToLogOutUser();
        signUpLoginPage.verifyPage();
    }

    //5to Test Case
    @Test
    public void errorMessageSignUpTest() {
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        signUpLoginPage.verifyingErrorMessageSignUp(
                signUpLoginModels.getFirst().getNombre(),
                signUpLoginModels.getFirst().getEmail(),
                signUpLoginModels.getFirst().getErrorMessageSignUp());
    }
}
