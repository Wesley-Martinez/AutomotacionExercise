package runner;

import data.ExcelReader;
import modelos.AccountInfoModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountInformation;
import pages.SignUpLoginPage;
import utilities.BaseTest;

import java.util.List;

public class AccountInformationTests extends BaseTest {
    private final AccountInformation accountInformation = new AccountInformation();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToAccountingInformation();
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
