package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By nameOnCartInput = By.cssSelector("input[data-qa='name-on-card']");
    private final By cartNumberInput = By.cssSelector("input[data-qa='card-number']");
    private final By cvcInput = By.cssSelector("input[data-qa='cvc']");
    private final By expireMonthInput = By.cssSelector("input[data-qa='expiry-month']");
    private final By expireYearInput = By.cssSelector("input[data-qa='expiry-year']");
    private final By payAndConfirmOrderButton = By.cssSelector("button[data-qa='pay-button']");
    @Override
    public void waitPageToLoad() {
        waitPages(nameOnCartInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(nameOnCartInput).isDisplayed());
        softAssert.assertTrue(find(cartNumberInput).isDisplayed());
        softAssert.assertTrue(find(cvcInput).isDisplayed());
        softAssert.assertTrue(find(expireMonthInput).isDisplayed());
        softAssert.assertTrue(find(expireYearInput).isDisplayed());
        softAssert.assertTrue(find(payAndConfirmOrderButton).isDisplayed());
        softAssert.assertAll();
    }

    public void FillPlaceOrder(String name, String cartNumber, String cvc, String expMonth, String expYear){
        find(nameOnCartInput).sendKeys(name);
        find(cartNumberInput).sendKeys(cartNumber);
        find(cvcInput).sendKeys(cvc);
        find(expireMonthInput).sendKeys(expMonth);
        find(expireYearInput).sendKeys(expYear);

        find(payAndConfirmOrderButton).click();
    }
}
