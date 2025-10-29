package runner;

import data.ExcelReader;
import modelos.ContactUsModel;
import modelos.SignUpLoginModel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ContactUs;
import pages.SignUpLoginPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

import java.util.List;

public class ContactUsTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final ContactUs contactUs = new ContactUs(driver,softAssert);
    private final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Crear/inicializar driver a través de la fábrica
        driver = WebDriverFactory.getDriver();
        // Navegar a página
        commonFlows.goToContactUsPage();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.removeDriver();
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
        contactUs.clickingSubmitButton();
        contactUs.verifyingSuccessFullText();
    }
}
