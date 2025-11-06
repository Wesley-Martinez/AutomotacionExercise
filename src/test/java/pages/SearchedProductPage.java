package pages;

import data.ExcelReader;
import modelos.AccountInfoModel;
import modelos.SignUpLoginModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;

import java.time.Duration;
import java.util.List;

public class SearchedProductPage extends BasePage {

    public SearchedProductPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By searchedProductLabel = By.xpath("//h2[text()='Searched Products']");
    private final By categoryLabel = By.xpath("//h2[text()='Category']");
    private final By addToCartButton =
            By.xpath("//a[text()='Add to cart'][1]");
    private final By viewCartLink = By.xpath("//u[text()='View Cart']");
    private final By proceedToCheckOutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private final By signUpLoginLink = By.xpath("//a[text()=' Signup / Login']");
    private final By emailAddressInput = By.cssSelector("input[data-qa='login-email']");
    private final By passwordInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By logoImgHome = By.xpath("//img[@alt='Website for automation practice']");
    private final By shoppingCartLink = By.xpath("//a[text()=' Cart']");

    @Override
    public void waitPageToLoad() {
        waitPages(searchedProductLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(searchedProductLabel).isDisplayed());
        softAssert.assertTrue(find(categoryLabel).isDisplayed());
        softAssert.assertTrue(find(addToCartButton).isDisplayed());
        softAssert.assertAll();
    }

    public void addingCartProducts(){
        new Actions(getDriver())
                .moveToElement(find(addToCartButton))
                .pause(1000)
                .click()
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));

        softAssert.assertTrue(find(viewCartLink).isDisplayed());
        softAssert.assertAll();

        find(viewCartLink).click();

        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));

        softAssert.assertTrue(find(proceedToCheckOutButton).isDisplayed());

        find(signUpLoginLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressInput));

        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();

        find(emailAddressInput).sendKeys(signUpLoginModels.get(1).getEmail());
        find(passwordInput).sendKeys(accountInfoModels.getFirst().getPassword());
        find(loginButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(logoImgHome));

        find(shoppingCartLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOutButton));

        softAssert.assertTrue(find(proceedToCheckOutButton).isDisplayed());
        softAssert.assertAll();

    }
}
