package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;

public class SignUpLoginPage extends BasePage {
    private final By nameInput = By.xpath("//input[@data-qa='signup-name']");
    private final By emailInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    private final By loginToYourAccountLabel = By.xpath("//h2[text()='Login to your account']");
    private final By loginEmailInput= By.cssSelector("input[data-qa='login-email']");
    private final By loginPasswordInput= By.cssSelector("input[data-qa='login-password']");
    private final By loginButton= By.cssSelector("button[data-qa='login-button']");
    private final By errorMessageLabel= By.xpath("//p[text()='Your email or password is incorrect!']");
    private final By errorMessageSignUp= By.xpath("//p[text()='Email Address already exist!']");

    @Override
    public void waitPageToLoad() {
        waitPages(nameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(nameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(signUpButton).isDisplayed());
        softAssert.assertTrue(find(loginToYourAccountLabel).isDisplayed());
        softAssert.assertTrue(find(loginEmailInput).isDisplayed());
        softAssert.assertTrue(find(loginPasswordInput).isDisplayed());
        softAssert.assertTrue(find(loginButton).isDisplayed());
        softAssert.assertAll();
    }

    public void fillNewUserSignUp(String name, String emailAddress){
        find(nameInput).sendKeys(name);
        find(emailInput).sendKeys(emailAddress);
        find(signUpButton).click();
    }

    public void fillLoginToYourAccount(String email, String password){
        find(loginEmailInput).sendKeys(email);
        find(loginPasswordInput).sendKeys(password);
        find(loginButton).click();
    }
    //3er caso de prueba
    public void verifyingErrorMessage(String email, String password, String errorMessage){
        find(loginEmailInput).sendKeys(email);
        find(loginPasswordInput).sendKeys(password);
        find(loginButton).click();

        softAssert.assertTrue(find(errorMessageLabel).isDisplayed());
        softAssert.assertEquals(find(errorMessageLabel).getText(), errorMessage);
        softAssert.assertAll();
    }

    public void verifyingErrorMessageSignUp(String name, String email, String errorMessage){
        find(nameInput).sendKeys(name);
        find(emailInput).sendKeys(email);
        find(signUpButton).click();

        softAssert.assertTrue(find(errorMessageSignUp).isDisplayed());
        softAssert.assertEquals(find(errorMessageSignUp).getText(), errorMessage);
        softAssert.assertAll();
    }
}
