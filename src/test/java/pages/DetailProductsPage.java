package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class DetailProductsPage extends BasePage {

    public DetailProductsPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By productNameLabel = By.xpath("//h2[text()='Blue Top']");
    private final By categoryLabel = By.xpath("//h2[text()='Category']");
    private final By price = By.xpath("//span[text()='Rs. 500']");
    private final By availabilityDetails = By.xpath("//b[text()='Availability:']");
    private final By conditionDetails = By.xpath("//b[normalize-space()='Condition:']");
    private final By brandDetails = By.xpath("//b[normalize-space()='Brand:']");

    @Override
    public void waitPageToLoad() {
        waitPages(productNameLabel, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(productNameLabel).isDisplayed());
        softAssert.assertTrue(find(categoryLabel).isDisplayed());
        softAssert.assertTrue(find(price).isDisplayed());
        softAssert.assertTrue(find(availabilityDetails).isDisplayed());
        softAssert.assertTrue(find(conditionDetails).isDisplayed());
        softAssert.assertTrue(find(brandDetails).isDisplayed());
        softAssert.assertAll();
    }
}

