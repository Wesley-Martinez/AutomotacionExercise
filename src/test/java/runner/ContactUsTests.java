package runner;

import data.ExcelReader;
import modelos.ContactUsModel;
import modelos.SignUpLoginModel;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactUs;
import pages.SignUpLoginPage;
import utilities.BaseTest;
import utilities.CommonFlows;

import java.util.List;

public class ContactUsTests extends BaseTest {
    private final ContactUs contactUs = new ContactUs();
    private final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToContactUsPage();
    }

    @Test
    public void verifyingPageTest() {
        contactUs.verifyPage();
    }

    @Test
    public void registerContactUsTest() {
        List<ContactUsModel> contactUsModels =  ExcelReader.readListContactUsExcel();
        contactUs.fillContactUs(
                contactUsModels.getFirst().getName(),
                contactUsModels.getFirst().getEmail(),
                contactUsModels.getFirst().getSubject(),
                contactUsModels.getFirst().getYourMessageHere()
        );
    }
}
