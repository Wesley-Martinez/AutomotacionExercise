package pages;

import org.openqa.selenium.By;
import utilities.BasePage;

public class OrderPlacedPage extends BasePage {
    private final By orderPlacedText = By.xpath("//b[text()='Order Placed!']");
    private final By continueButton = By.xpath("//a[text()='Continue']");


    @Override
    public void waitPageToLoad() {
        waitPages(continueButton,this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(orderPlacedText).isDisplayed());
        softAssert.assertTrue(find(continueButton).isDisplayed());
        softAssert.assertAll();
    }

    public void confirmPaymentAndDeleteAccount(){
        find(continueButton).click();
    }
}
