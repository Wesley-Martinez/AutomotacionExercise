package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;
import utilities.Logs;

import java.io.File;
import java.time.Duration;

public class ContactUs extends BasePage {
    private final By getInTouchLabel = By.xpath("//h2[text()='Get In Touch']");
    private final By nameInput = By.cssSelector("input[data-qa='name']");
    private final By emailInput = By.cssSelector("input[data-qa='email']");
    private final By subjectInput = By.cssSelector("input[data-qa='subject']");
    private final By yourMessageTexTarea = By.id("message");
    private final By selectFile= By.cssSelector("input[type='file']");
    private final By submitButton= By.cssSelector("input[data-qa='submit-button']");
    private final By successfulLabel= By.cssSelector("status alert alert-success");
    private final By homeButton= By.id("//span[text()=' Home']");

    @Override
    public void waitPageToLoad() {
        waitPages(nameInput, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(getInTouchLabel).isDisplayed());
        softAssert.assertTrue(find(nameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(subjectInput).isDisplayed());
        softAssert.assertTrue(find(yourMessageTexTarea).isDisplayed());
        softAssert.assertTrue(find(selectFile).isDisplayed());
        softAssert.assertTrue(find(submitButton).isDisplayed());
        softAssert.assertAll();
    }

    public void fillContactUs(String name, String email, String subject, String yourMessage){
        find(nameInput).sendKeys(name);
        find(emailInput).sendKeys(email);
        find(subjectInput).sendKeys(subject);
        find(yourMessageTexTarea).sendKeys(yourMessage);

        final var file =new File("src/test/resources/imagenes/certificadoSelenium.jpg");

        Logs.info("Uploading the images");
        find(selectFile).sendKeys(file.getAbsolutePath());

        find(submitButton).click();

//        String contactUsWindow = getDriver().getWindowHandle();
//
//        getDriver().switchTo().alert().accept();
//
//        getDriver().switchTo().window(contactUsWindow);
//
//        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(successfulLabel));
//
//        softAssert.assertTrue(find(successfulLabel).isDisplayed());
//        softAssert.assertAll();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        final var alert = (Alert) wait.until(ExpectedConditions.alertIsPresent());

        alert.accept();

        wait.until(ExpectedConditions.elementToBeClickable(homeButton));

        softAssert.assertTrue(find(successfulLabel).isDisplayed());
        softAssert.assertEquals(find(successfulLabel).getText(), "Success! Your details have been submitted successfully.");
        //softAssert.assertTrue(find(homeButton).isDisplayed());
        softAssert.assertAll();

        //find(homeButton).click();
    }
}
