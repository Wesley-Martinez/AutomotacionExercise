package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class TestCasesPage extends BasePage {
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
