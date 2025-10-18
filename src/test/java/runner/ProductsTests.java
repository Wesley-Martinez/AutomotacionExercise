package runner;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class ProductsTests extends BaseTest {
    private final ProductsPage productsPage = new ProductsPage();
    private final CommonFlows commonFlows = new CommonFlows();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToProductsPage();
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

