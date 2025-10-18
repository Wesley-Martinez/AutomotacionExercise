package utilities;

//import data.DataGiver;
import data.ExcelReader;
import modelos.*;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.*;

import java.util.List;
//import pages.*;

public class CommonFlows {

    private WebDriver getDriver(){
        return new WebdriverProvider().get();
    }

    public void goToHomePage(){
        Logs.info("Navigating to the url");
        getDriver().get("https://automationexercise.com/");

        new HomePage().waitPageToLoad(); //wait for the page to load
    }

    public void goToSignUpLoginPage(){
        goToHomePage();

        new HomePage().clickSignUpLogin();
        new SignUpLoginPage().waitPageToLoad();
    }

    public void goToAccountingInformation(){
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        String name = signUpLoginModels.getFirst().getNombre();
        String email = signUpLoginModels.getFirst().getEmail();

        goToSignUpLoginPage();

        new SignUpLoginPage().fillNewUserSignUp(name, email);
        new AccountInformation().waitPageToLoad();
    }

    public void goToAccountingInformation2(){
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();
        String name = signUpLoginModels.getFirst().getNombre();
        String email = signUpLoginModels.getFirst().getEmail();

        new SignUpLoginPage().fillNewUserSignUp(name, email);
        new AccountInformation().waitPageToLoad();
    }

    public void goToAccountCreated(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();

        goToAccountingInformation();
        new AccountInformation().fillAccountInformation(
                accountInfoModels.getFirst().getPassword(),
                accountInfoModels.getFirst().getName(),
                accountInfoModels.getFirst().getLastname(),
                accountInfoModels.getFirst().getCompany(),
                accountInfoModels.getFirst().getAddress(),
                accountInfoModels.getFirst().getState(),
                accountInfoModels.getFirst().getCity(),
                accountInfoModels.getFirst().getZipcode(),
                accountInfoModels.getFirst().getMobilenumber());
        new AccountCreated().waitPageToLoad();
    }
    public void goToAccountCreated2(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();

        new AccountInformation().fillAccountInformation(
                accountInfoModels.getFirst().getPassword(),
                accountInfoModels.getFirst().getName(),
                accountInfoModels.getFirst().getLastname(),
                accountInfoModels.getFirst().getCompany(),
                accountInfoModels.getFirst().getAddress(),
                accountInfoModels.getFirst().getState(),
                accountInfoModels.getFirst().getCity(),
                accountInfoModels.getFirst().getZipcode(),
                accountInfoModels.getFirst().getMobilenumber());
        new AccountCreated().waitPageToLoad();
    }

    public void goToDeleteAccount(){
        goToAccountCreated();

        new AccountCreated().clickingOnContinueButton();
        new HomePage().waitPageToLoad();
        new HomePage().clickDeleteAccount();
        new AccountDelete().waitPageToLoad();
    }

    public void goToLoginToYourAccount(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage().fillLoginToYourAccount(
                signUpLoginModels.get(1).getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage().waitPageToLoad();
        new HomePage().verifyDeleteAccountAndLogOut();
        new HomePage().clickDeleteAccount();
        new AccountDelete().waitPageToLoad();
    }

    public void goToLogOutUser(){
        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage().fillLoginToYourAccount(
                signUpLoginModels.getFirst().getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage().waitPageToLoad();
        new HomePage().clickingLoginOut();
        new SignUpLoginPage().waitPageToLoad();
    }

    public void goToContactUsPage(){
        goToHomePage();

        new HomePage().clickingContactUs();
        new ContactUs().waitPageToLoad();
    }

    public void goToTestCasesPage(){
        goToHomePage();

        new HomePage().clickingTestCases();
        new TestCasesPage().waitPageToLoad();
    }

    public void goToProductsPage(){
        goToHomePage();

        new HomePage().clickingProducts();
        new ProductsPage().waitPageToLoad();
    }

    public void goToDetailProduct(){
        goToProductsPage();

        new ProductsPage().clickingFirstViewProduct();
        new DetailProductsPage().waitPageToLoad();
    }

    public void goToSearchedProduct(){
        List<SearchedProductModel> searchedProductModels =  ExcelReader.readListSearchedProductExcel();
        goToProductsPage();

        new ProductsPage().searchingProducts(searchedProductModels.getFirst().getProducts());
        new SearchedProductPage().waitPageToLoad();
    }

    public void goToShoppingCartPage(){
        goToHomePage();

        new HomePage().clickingCartLink();
        new ShoppingCartPage().waitPageToLoad();
    }

    public void goToDetailAddress(){
        goToProductsPage();

        new ProductsPage().registerWhileCheckout();
        new SignUpLoginPage().waitPageToLoad();
        goToAccountingInformation2();
        new AccountInformation().waitPageToLoad();
        goToAccountCreated2();
        new AccountCreated().clickingOnContinueButton();
        new HomePage().waitPageToLoad();
        new HomePage().verifyingLoggedInAs();
        new HomePage().clickingCartLink();
        new ShoppingCartPage().clickingProceedToCheckout();
        new AddressDetailPage().waitPageToLoad();
        //recuerda que tienes que eliminar la cuenta weslinmartinez37 antes de ejecutar
    }

    public void goToPaymentPage(){
        List<ContactUsModel> contactUsModels =  ExcelReader.readListContactUsExcel();
        goToDetailAddress();

        new AddressDetailPage().fillingCommentAndPlacingOrder(contactUsModels.getFirst().getYourMessageHere());
        new PaymentPage().waitPageToLoad();
    }
    public void goToPaymentPage2(){
        List<ContactUsModel> contactUsModels =  ExcelReader.readListContactUsExcel();

        new AddressDetailPage().fillingCommentAndPlacingOrder(contactUsModels.getFirst().getYourMessageHere());
        new PaymentPage().waitPageToLoad();
    }

    public void goToOrderPlaced(){
        List<PaymentModel> paymentModels =  ExcelReader.readListPaymentExcel();

        goToPaymentPage();

        new PaymentPage().FillPlaceOrder(
                paymentModels.getFirst().getName(),
                paymentModels.getFirst().getCardNumber(),
                paymentModels.getFirst().getCvc(),
                paymentModels.getFirst().getExpMonth(),
                paymentModels.getFirst().getExpYear());

        new OrderPlacedPage().waitPageToLoad();
    }

    public void goToOrderPlaced2(){
        List<PaymentModel> paymentModels =  ExcelReader.readListPaymentExcel();

        new PaymentPage().FillPlaceOrder(
                paymentModels.getFirst().getName(),
                paymentModels.getFirst().getCardNumber(),
                paymentModels.getFirst().getCvc(),
                paymentModels.getFirst().getExpMonth(),
                paymentModels.getFirst().getExpYear());

        new OrderPlacedPage().waitPageToLoad();
    }

    public void registerBeforeCheckout(){
        goToAccountCreated();
        new AccountCreated().clickingOnContinueButton();
        new HomePage().waitPageToLoad();
        new HomePage().verifyingLoggedInAs();
        new HomePage().clickingProducts();
        new ProductsPage().waitPageToLoad();
        new ProductsPage().adding2ProductsToShoppingCart();
        goToPaymentPage2();
        goToOrderPlaced2();
        new OrderPlacedPage().confirmPaymentAndDeleteAccount();
        new HomePage().waitPageToLoad();
        new HomePage().clickDeleteAccount();
        new AccountCreated().waitPageToLoad();
        new AccountDelete().clickContinueButton();
        new HomePage().waitPageToLoad();
    }

    public void loginBeforeCheckout(){
        new HomePage().clickSignUpLogin();
        new SignUpLoginPage().waitPageToLoad();

        List<AccountInfoModel> accountInfoModels =  ExcelReader.readListAccountInfoExcel();
        List<SignUpLoginModel> signUpLoginModels =  ExcelReader.readListSignUpLoginExcel();

        new SignUpLoginPage().fillLoginToYourAccount(
                signUpLoginModels.getFirst().getEmail(), accountInfoModels.getFirst().getPassword());
        new HomePage().waitPageToLoad();

        new HomePage().clickingProducts();
        new ProductsPage().waitPageToLoad();
        new ProductsPage().adding2ProductsToShoppingCart();
        goToPaymentPage2();
        goToOrderPlaced2();
        new OrderPlacedPage().confirmPaymentAndDeleteAccount();
        new HomePage().waitPageToLoad();
        new HomePage().clickDeleteAccount();
        new AccountCreated().waitPageToLoad();
        new AccountDelete().clickContinueButton();
        new HomePage().waitPageToLoad();

    }

}