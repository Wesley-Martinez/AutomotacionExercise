package runner;

import data.ExcelReader;
import modelos.AccountInfoModel;
import modelos.SignUpLoginModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountDelete;
import pages.HomePage;
import pages.SignUpLoginPage;
import utilities.BaseTest;

import java.util.List;

public class SignUpLoginTests extends BaseTest {
    private final SignUpLoginPage signUpLoginPage = new SignUpLoginPage();
    private final AccountDelete accountDelete = new AccountDelete();
    private final HomePage homePage = new HomePage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignUpLoginPage();

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
