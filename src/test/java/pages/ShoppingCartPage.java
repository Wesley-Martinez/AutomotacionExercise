package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successfulSubscribe = By.xpath(
            "//div[text()='You have been successfully subscribed!']");
    private final By cartLink = By.xpath("//a[text()=' Cart']");
    private final By proceedToCheckoutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private final By priceText = By.xpath("//td[text()='Price']");

    @Override
    public void waitPageToLoad() {
        waitPages(proceedToCheckoutButton, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(subscriptionText).isDisplayed());
        softAssert.assertAll();
    }

    public void fillingSubscriptions(String email){
        final var inputEmail = find(emailInput);
        new Actions(getDriver())
                .scrollToElement(inputEmail)
                .pause(1000)
                .perform();

        inputEmail.sendKeys(email);
        find(subscribeButton).click();

        softAssert.assertTrue(find(successfulSubscribe).isDisplayed());
        softAssert.assertAll();

    }

    public void clickingProceedToCheckout(){
        find(proceedToCheckoutButton).click();
    }

}
