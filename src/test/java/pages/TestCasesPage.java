package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class TestCasesPage extends BasePage {

    public TestCasesPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By testCasesLabel = By.xpath("//b[text()='Test Cases']");
    @Override
    public void waitPageToLoad() {
        waitPages(testCasesLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(testCasesLabel).isDisplayed());
        softAssert.assertAll();
    }
}
