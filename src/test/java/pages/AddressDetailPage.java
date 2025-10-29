package pages;

import data.ExcelReader;
import modelos.AccountInfoModel;
import modelos.ContactUsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

import java.util.List;

public class AddressDetailPage extends BasePage {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    public AddressDetailPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By addressDetailText = By.xpath("//h2[text()='Address Details']");
    private final By reviewYourOrderText = By.xpath("//h2[text()='Review Your Order']");
    private final By messageTextarea = By.cssSelector("textarea[name='message']");
    private final By placerOrderButton = By.xpath("//a[text()='Place Order']");
    @Override
    public void waitPageToLoad() {
        waitPages(addressDetailText, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(addressDetailText).isDisplayed());
        softAssert.assertTrue(find(reviewYourOrderText).isDisplayed());
        softAssert.assertTrue(find(messageTextarea).isDisplayed());
        softAssert.assertTrue(find(placerOrderButton).isDisplayed());
        softAssert.assertAll();
    }

    public void fillingCommentAndPlacingOrder(String message){

        find(messageTextarea).sendKeys(message);
        find(placerOrderButton).click();
    }
}
