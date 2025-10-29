package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class OrderPlacedPage extends BasePage {

    public OrderPlacedPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

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
