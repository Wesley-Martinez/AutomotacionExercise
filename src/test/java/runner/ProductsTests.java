package runner;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.WebDriverFactory;
import utilities.WebdriverProvider;

public class ProductsTests extends BaseTest {
    WebDriver driver = new WebdriverProvider().get();
    SoftAssert softAssert = new SoftAssert();
    private final ProductsPage productsPage = new ProductsPage(driver, softAssert);
    private final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        // Initialize driver through factory
        driver = WebDriverFactory.getDriver();
        // Navigate to the page
        commonFlows.goToProductsPage();
    }

    @AfterMethod
    public void tearDown() {
        //removing the driver
        WebDriverFactory.removeDriver();
    }

    @Test
    public void verifyingProductsPageTest() {
        productsPage.verifyPage();
    }

    @Test
    public void verifyingButtonTest() {
        productsPage.clickingFirstViewProduct();
    }

    @Test
    public void addingProductToCartTest() {
        productsPage.addProductsToShoppingCart();
    }

    @Step("13 caso de prueba")
    @Test
    public void tryOfQuantityTest() {
        productsPage.addingQuantityToCart();
    }

    @Test
    public void registerWhileCheckingTest() {
        productsPage.registerWhileCheckout();
    }

    @Step("Test 17")
    @Test
    public void deletingProductsTest() {
        productsPage.deletingProducts();
    }

    @Step("Test 19")
    @Test
    public void viewBrandProductsTest() {
        productsPage.viewBrandProducts();
    }
}

