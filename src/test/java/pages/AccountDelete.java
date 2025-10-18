package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class AccountDelete extends BasePage {
    private final By accountDeleteTitle = By.cssSelector("h2[data-qa='account-deleted']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    @Override
    public void waitPageToLoad() {
        waitPages(continueButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(accountDeleteTitle).isDisplayed());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    public void clickContinueButton(){
        find(continueButton).click();
    }


}
