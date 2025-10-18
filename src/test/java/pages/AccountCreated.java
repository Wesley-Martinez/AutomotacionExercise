package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class AccountCreated extends BasePage {
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
