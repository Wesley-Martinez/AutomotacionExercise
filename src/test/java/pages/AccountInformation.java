package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import utilities.BasePage;
import utilities.WebdriverProvider;

public class AccountInformation extends BasePage {

    public AccountInformation(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    private final By accountInfText = By.xpath("//b[text()='Enter Account Information']");
    private final By mrRadio = By.id("id_gender1");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By daySelect = By.id("days");
    private final By monthSelect = By.id("months");
    private final By yearSelect = By.id("years");
    private final By newsletterCheckBox = By.id("newsletter");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By countrySelect = By.id("country");
    private final By addressInput = By.id("address1");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipCodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.cssSelector("button[data-qa='create-account']");


    @Override
    public void waitPageToLoad() {
        waitPages(accountInfText, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(accountInfText).isDisplayed());
        softAssert.assertTrue(find(nameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(passwordInput).isDisplayed());
        softAssert.assertTrue(find(mrRadio).isDisplayed());
        softAssert.assertAll();
    }

    public void fillAccountInformation(
            String password,
            String firstname,
            String lastname,
            String company,
            String address,
            String state,
            String city,
            String zipCode,
            String mobileNumber
    ){
        find(mrRadio).click(); //fill Radio
        find(passwordInput).sendKeys(password);

        //Fill Date of BirthDay
        final var day = find(daySelect);
        final var month = find(monthSelect);
        final var year = find(yearSelect);

        final var selectDay = new Select(day);
        final var selectMonth = new Select(month);
        final var selectYear = new Select(year);

        selectDay.selectByValue("14");
        selectMonth.selectByValue("9");
        selectYear.selectByValue("1996");

        find(newsletterCheckBox).click();

        find(firstNameInput).sendKeys(firstname);
        find(lastNameInput).sendKeys(lastname);
        find(companyInput).sendKeys(company);
        find(addressInput).sendKeys(address);
        find(stateInput).sendKeys(state);
        find(cityInput).sendKeys(city);
        find(zipCodeInput).sendKeys(zipCode);
        find(mobileNumberInput).sendKeys(mobileNumber);

        final var country = find(countrySelect);
        final var selectCompany = new Select(country);
        selectCompany.selectByValue("United States");

        find(createAccountButton).click();
    }

}
