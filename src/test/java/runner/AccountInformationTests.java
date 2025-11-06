package runner;

import data.ExcelReader;
import modelos.AccountInfoModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AccountInformation;
import pages.SignUpLoginPage;
import utilities.BaseTest;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

import java.util.List;

public class AccountInformationTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final AccountInformation accountInformation = new AccountInformation(driver,softAssert);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToAccountingInformation();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void VerifyingAccountInfTest() {
        accountInformation.verifyPage();
    }

    @Test
    public void fillInformationTest() {
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        accountInformation.fillAccountInformation(
                accountInfoModels.getFirst().getPassword(),
                accountInfoModels.getFirst().getName(),
                accountInfoModels.getFirst().getLastname(),
                accountInfoModels.getFirst().getCompany(),
                accountInfoModels.getFirst().getAddress(),
                accountInfoModels.getFirst().getState(),
                accountInfoModels.getFirst().getCity(),
                accountInfoModels.getFirst().getZipcode(),
                accountInfoModels.getFirst().getMobilenumber()
        );
    }
}
