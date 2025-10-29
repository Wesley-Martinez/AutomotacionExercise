package utilities;

//import data.DataGiver;
import data.ExcelReader;
import modelos.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

import java.util.List;

import static utilities.BasePage.driver;

//import pages.*;

public class CommonFlows {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();

    private WebDriver getDriver(){
        return new WebdriverProvider().get();
    }

    public void goToHomePage(){
        Logs.info("Navigating to the url");
        getDriver().get("https://automationexercise.com/");

        new HomePage(driver,softAssert).waitPageToLoad(); //wait for the page to load
    }

    public void goToSignUpLoginPage(){
        goToHomePage();

        new HomePage(driver,softAssert).clickSignUpLogin();
        new SignUpLoginPage(driver,softAssert).waitPageToLoad();
    }

    public void goToAccountingInformation(){
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        String name = signUpLoginModels.getFirst().getNombre();
        String email = signUpLoginModels.getFirst().getEmail();

        goToSignUpLoginPage();

        new SignUpLoginPage(driver,softAssert).fillNewUserSignUp(name, email);
        new AccountInformation(driver,softAssert).waitPageToLoad();
    }

    public void goToAccountingInformation2(){
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        String name = signUpLoginModels.getFirst().getNombre();
        String email = signUpLoginModels.getFirst().getEmail();

        new SignUpLoginPage(driver,softAssert).fillNewUserSignUp(name, email);
        new AccountInformation(driver,softAssert).waitPageToLoad();
    }

    public void goToAccountCreated(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();

        goToAccountingInformation();
        new AccountInformation(driver,softAssert).fillAccountInformation(
                accountInfoModels.getFirst().getPassword(),
                accountInfoModels.getFirst().getName(),
                accountInfoModels.getFirst().getLastname(),
                accountInfoModels.getFirst().getCompany(),
                accountInfoModels.getFirst().getAddress(),
                accountInfoModels.getFirst().getState(),
                accountInfoModels.getFirst().getCity(),
                accountInfoModels.getFirst().getZipcode(),
                accountInfoModels.getFirst().getMobilenumber());
        new AccountCreated(driver,softAssert).waitPageToLoad();
    }
    public void goToAccountCreated2(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();

        new AccountInformation(driver,softAssert).fillAccountInformation(
                accountInfoModels.getFirst().getPassword(),
                accountInfoModels.getFirst().getName(),
                accountInfoModels.getFirst().getLastname(),
                accountInfoModels.getFirst().getCompany(),
                accountInfoModels.getFirst().getAddress(),
                accountInfoModels.getFirst().getState(),
                accountInfoModels.getFirst().getCity(),
                accountInfoModels.getFirst().getZipcode(),
                accountInfoModels.getFirst().getMobilenumber());
        new AccountCreated(driver,softAssert).waitPageToLoad();
    }

    public void goToDeleteAccount(){
        goToAccountCreated();

        new AccountCreated(driver,softAssert).clickingOnContinueButton();
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).clickDeleteAccount();
        new AccountDelete(driver,softAssert).waitPageToLoad();
    }

    public void goToLoginToYourAccount(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage(driver,softAssert).fillLoginToYourAccount(
                signUpLoginModels.get(1).getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).verifyDeleteAccountAndLogOut();
        new HomePage(driver,softAssert).clickDeleteAccount();
        new AccountDelete(driver,softAssert).waitPageToLoad();
    }

    public void goToLogOutUser(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage(driver,softAssert).fillLoginToYourAccount(
                signUpLoginModels.getFirst().getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).clickingLoginOut();
        new SignUpLoginPage(driver,softAssert).waitPageToLoad();
    }

    public void goToContactUsPage(){
        goToHomePage();

        new HomePage(driver,softAssert).clickingContactUs();
        new ContactUs(driver,softAssert).waitPageToLoad();
    }

    public void goToTestCasesPage(){
        goToHomePage();

        new HomePage(driver,softAssert).clickingTestCases();
        new TestCasesPage(driver,softAssert).waitPageToLoad();
    }

    public void goToProductsPage(){
        goToHomePage();

        new HomePage(driver,softAssert).clickingProducts();
        new ProductsPage(driver,softAssert).waitPageToLoad();
    }

    public void goToDetailProduct(){
        goToProductsPage();

        new ProductsPage(driver,softAssert).clickingFirstViewProduct();
        new DetailProductsPage(driver, softAssert).waitPageToLoad();
    }

    public void goToSearchedProduct(){
        List<SearchedProductModel> searchedProductModels =  ExcelReader.readListSearchedProductExcel();
        goToProductsPage();

        new ProductsPage(driver,softAssert).searchingProducts(searchedProductModels.getFirst().getProducts());
        new SearchedProductPage(driver,softAssert).waitPageToLoad();
    }

    public void goToShoppingCartPage(){
        goToHomePage();

        new HomePage(driver,softAssert).clickingCartLink();
        new ShoppingCartPage(driver,softAssert).waitPageToLoad();
    }

    public void goToDetailAddress(){
        goToProductsPage();

        new ProductsPage(driver,softAssert).registerWhileCheckout();
        new SignUpLoginPage(driver,softAssert).waitPageToLoad();
        goToAccountingInformation2();
        new AccountInformation(driver,softAssert).waitPageToLoad();
        goToAccountCreated2();
        new AccountCreated(driver,softAssert).clickingOnContinueButton();
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).verifyingLoggedInAs();
        new HomePage(driver,softAssert).clickingCartLink();
        new ShoppingCartPage(driver,softAssert).clickingProceedToCheckout();
        new AddressDetailPage(driver,softAssert).waitPageToLoad();
        //recuerda que tienes que eliminar la cuenta weslinmartinez37 antes de ejecutar
    }

    public void goToPaymentPage(){
        List<ContactUsModel> contactUsModels =  ExcelReader.readListContactUsExcel();
        goToDetailAddress();

        new AddressDetailPage(driver,softAssert).fillingCommentAndPlacingOrder(contactUsModels.getFirst().getYourMessageHere());
        new PaymentPage(driver,softAssert).waitPageToLoad();
    }
    public void goToPaymentPage2(){
        List<ContactUsModel> contactUsModels =  ExcelReader.readListContactUsExcel();

        new AddressDetailPage(driver,softAssert).fillingCommentAndPlacingOrder(contactUsModels.getFirst().getYourMessageHere());
        new PaymentPage(driver,softAssert).waitPageToLoad();
    }

    public void goToOrderPlaced(){
        List<PaymentModel> paymentModels =  ExcelReader.readListPaymentExcel();

        goToPaymentPage();

        new PaymentPage(driver,softAssert).FillPlaceOrder(
                paymentModels.getFirst().getName(),
                paymentModels.getFirst().getCardNumber(),
                paymentModels.getFirst().getCvc(),
                paymentModels.getFirst().getExpMonth(),
                paymentModels.getFirst().getExpYear());

        new OrderPlacedPage(driver, softAssert).waitPageToLoad();
    }

    public void goToOrderPlaced2(){
        List<PaymentModel> paymentModels =  ExcelReader.readListPaymentExcel();

        new PaymentPage(driver,softAssert).FillPlaceOrder(
                paymentModels.getFirst().getName(),
                paymentModels.getFirst().getCardNumber(),
                paymentModels.getFirst().getCvc(),
                paymentModels.getFirst().getExpMonth(),
                paymentModels.getFirst().getExpYear());

        new OrderPlacedPage(driver, softAssert).waitPageToLoad();
    }

    public void registerBeforeCheckout(){
        goToAccountCreated();
        new AccountCreated(driver,softAssert).clickingOnContinueButton();
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).verifyingLoggedInAs();
        new HomePage(driver,softAssert).clickingProducts();
        new ProductsPage(driver,softAssert).waitPageToLoad();
        new ProductsPage(driver,softAssert).adding2ProductsToShoppingCart();
        goToPaymentPage2();
        goToOrderPlaced2();
        new OrderPlacedPage(driver, softAssert).confirmPaymentAndDeleteAccount();
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).clickDeleteAccount();
        new AccountCreated(driver,softAssert).waitPageToLoad();
        new AccountDelete(driver,softAssert).clickContinueButton();
        new HomePage(driver,softAssert).waitPageToLoad();
    }

    public void loginBeforeCheckout(){
        new HomePage(driver,softAssert).clickSignUpLogin();
        new SignUpLoginPage(driver,softAssert).waitPageToLoad();

        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage(driver,softAssert).fillLoginToYourAccount(
                signUpLoginModels.getFirst().getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage(driver,softAssert).waitPageToLoad();

        new HomePage(driver,softAssert).clickingProducts();
        new ProductsPage(driver,softAssert).waitPageToLoad();
        new ProductsPage(driver,softAssert).adding2ProductsToShoppingCart();
        goToPaymentPage2();
        goToOrderPlaced2();
        new OrderPlacedPage(driver, softAssert).confirmPaymentAndDeleteAccount();
        new HomePage(driver,softAssert).waitPageToLoad();
        new HomePage(driver,softAssert).clickDeleteAccount();
        new AccountCreated(driver,softAssert).waitPageToLoad();
        new AccountDelete(driver,softAssert).clickContinueButton();
        new HomePage(driver,softAssert).waitPageToLoad();

    }

}