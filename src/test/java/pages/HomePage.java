package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.time.Duration;

public class HomePage extends BasePage {
    private final By homelink = By.xpath("//a[text()=' Home']");
    private final By signUpLoginLink = By.xpath("//a[text()=' Signup / Login']");
    private final By logOutLink = By.xpath("//a[text()=' Logout']");
    private final By deleteAccountLink = By.xpath("//a[text()=' Delete Account']");
    private final By contactUsLink = By.xpath("//a[text()=' Contact us']");
    private final By testCasesLink = By.xpath("//a[text()=' Test Cases']");
    private final By productsLink = By.xpath("//a[text()=' Products']");
    private final By subscriptionText = By.xpath("//h2[text()='Subscription']");
    private final By emailInput = By.id("susbscribe_email");
    private final By subscribeButton = By.id("subscribe");
    private final By successfulSubscribe = By.xpath(
            "//div[text()='You have been successfully subscribed!']");
    private final By cartLink = By.xpath("//a[text()=' Cart']");
    private final By loggedInAs = By.xpath("//a[text()=' Logged in as ']");
    private final By categoryText = By.xpath("//h2[text()='Category']");
    private final By womenCategory = By.xpath("//a[normalize-space()='Women']");
    private final By dressCategoryLink = By.xpath(
            "//div[@id='Women']//a[contains(text(),'Dress')]");
    private final By womenDressProductsTitle = By.xpath(
            "//h2[text()='Women - Dress Products']");
    private final By menCategory = By.xpath("//a[normalize-space()='Men']");
    private final By tShirtCategoryLink = By.xpath("//a[normalize-space()='Tshirts']");
    private final By menTshirtProductsTitle = By.xpath("//h2[text()='Men - Tshirts Products']");




    @Override
    public void waitPageToLoad() {
        waitPages(homelink, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(homelink).isDisplayed());
        softAssert.assertTrue(find(signUpLoginLink).isDisplayed());
        softAssert.assertTrue(find(contactUsLink).isDisplayed());
        softAssert.assertTrue(find(testCasesLink).isDisplayed());
        softAssert.assertTrue(find(productsLink).isDisplayed());
        softAssert.assertTrue(find(subscriptionText).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(subscribeButton).isDisplayed());
        softAssert.assertTrue(find(cartLink).isDisplayed());
        softAssert.assertTrue(find(categoryText).isDisplayed());
        softAssert.assertAll();
    }

    public void verifyDeleteAccountAndLogOut(){
        softAssert.assertTrue(find(logOutLink).isDisplayed());
        softAssert.assertTrue(find(deleteAccountLink).isDisplayed());
        softAssert.assertAll();
    }


    @Step("clicking on SignUpLogin")
    public void clickSignUpLogin(){
        find(signUpLoginLink).click();
    }

    public void clickDeleteAccount(){
        find(deleteAccountLink).click();
    }

    public void clickingLoginOut(){
        find(logOutLink).click();
    }

    public void clickingContactUs(){
        find(contactUsLink).click();
    }

    public void clickingTestCases(){
        find(testCasesLink).click();
    }

    public void clickingProducts(){
        find(productsLink).click();
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

    public void clickingCartLink(){
        find(cartLink).click();
    }

    public void verifyingLoggedInAs(){
        softAssert.assertTrue(find(loggedInAs).isDisplayed());
    }

    public void viewCategoryProducts(){
        new Actions(getDriver())
                .scrollToElement(find(womenCategory))
                .pause(1000)
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(womenCategory));

        find(womenCategory).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(dressCategoryLink));

        find(dressCategoryLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(womenDressProductsTitle));

        find(menCategory).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(tShirtCategoryLink));

        find(tShirtCategoryLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(menTshirtProductsTitle));

        softAssert.assertTrue(find(menTshirtProductsTitle).isDisplayed());

    }

}
