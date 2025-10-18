package runner;

import data.ExcelReader;
import modelos.SignUpLoginModel;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountCreated;
import pages.AccountDelete;
import pages.HomePage;
import utilities.BaseTest;
import utilities.CommonFlows;

import java.util.List;

public class AccountDeleteTests extends BaseTest {
    private final AccountDelete accountDelete = new AccountDelete();
    private final CommonFlows commonFlows = new CommonFlows();
    private final HomePage homePage = new HomePage();

    @BeforeMethod
    public void setUp() {
        commonFlows.goToDeleteAccount();
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
