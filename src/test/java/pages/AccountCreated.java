package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class AccountCreated extends BasePage {
    public AccountCreated(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    @Override
    public void waitPageToLoad() {
        waitPages(continueButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    public void clickingOnContinueButton(){
        find(continueButton).click();
    }
}
