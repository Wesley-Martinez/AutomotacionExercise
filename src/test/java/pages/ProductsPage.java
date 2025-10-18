package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BasePage;

import java.time.Duration;

public class ProductsPage extends BasePage {
    private final By allProductsTitle = By.xpath("//h2[text()='All Products']");
    private final By productsList = By.className("features_items");
    private final By viewFirstProductLink = By.xpath("//a[contains(text(),'View Product')][1]");
    private final By searchProductInput = By.id("search_product");
    private final By submitButton = By.id("submit_search");
    private final By blueTopText = By.xpath("//p[text()='Blue Top'][1]");
    private final By manTshirtText = By.xpath("//p[text()='Men Tshirt'][1]");
    private final By continueShoppingButton = By.xpath("//button[text()='Continue Shopping']");
    private final By shoppingCartButton1 = By.xpath("//a[text()='Add to cart']");
    private final By viewCartLink = By.xpath("//u[text()='View Cart']");
    private final By proceedToCheckOutButton = By.xpath("//a[text()='Proceed To Checkout']");
    private final By priceText = By.xpath("//td[text()='Price']");
    private final By quantityInput = By.id("quantity");
    private final By resultQuantity = By.xpath("//button[text()='4']");
    private final By quantityAddToCartButton = By.cssSelector("button[type='button']");
    private final By cartPageLink = By.xpath("//a[text()=' Cart']");
    private final By registerCartPageLink = By.xpath("//u[text()='Register / Login']");
    private final By cartIsEmptyText = By.xpath("//b[text()='Cart is empty!']");
    private final By quantityDeleteButton1 = By.xpath(
            "//tr[@id='product-1']//a[@class='cart_quantity_delete']");
    private final By quantityDeleteButton2 = By.xpath(
            "//tr[@id='product-2']//a[@class='cart_quantity_delete']");
    private final By brandsText = By.xpath("//h2[normalize-space()='Brands']");
    private final By poloBrandLink = By.xpath("//a[@href='/brand_products/Polo']");
    private final By hmBrandLink = By.xpath("//a[@href='/brand_products/H&M']");
    private final By brandPoloProductsTitle = By.xpath("//h2[@class='title text-center']");
    private final By brandHMProducts = By.xpath("//h2[@class='title text-center']");

    @Override
    public void waitPageToLoad() {
        waitPages(allProductsTitle, this.getClass().getSimpleName());
    }

    @Override
    public void verifyPage() {
        softAssert.assertTrue(find(allProductsTitle).isDisplayed());
        softAssert.assertTrue(find(productsList).isDisplayed());
        softAssert.assertTrue(find(viewFirstProductLink).isDisplayed());
        softAssert.assertTrue(find(searchProductInput).isDisplayed());
        softAssert.assertTrue(find(submitButton).isDisplayed());
        softAssert.assertTrue(find(blueTopText).isDisplayed());
        softAssert.assertAll();

    }

    public void clickingFirstViewProduct(){
        find(viewFirstProductLink).click();
    }

    public void searchingProducts(String product){
        find(searchProductInput).sendKeys(product);
        find(submitButton).click();
    }

    @Step("Agregando productos al carrito")
    public void addProductsToShoppingCart(){
        final var shoppingCart1 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(blueTopText);

        final var shoppingCart2 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(manTshirtText);

        final var cart1 = find(shoppingCart1);
        new Actions(getDriver())
                .moveToElement(cart1)
                .pause(1000)
                .click()
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        find(shoppingCart2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));

        softAssert.assertTrue(find(viewCartLink).isDisplayed());
        softAssert.assertAll();

        find(viewCartLink).click();

        softAssert.assertTrue(find(proceedToCheckOutButton).isDisplayed());
        softAssert.assertTrue(find(priceText).isDisplayed());
        softAssert.assertAll();
    }

    @Step("Agregamos cantidades al producto y lo verificamos en la pagina del carrito")
    public void addingQuantityToCart(){
        find(viewFirstProductLink).click();

        find(quantityInput).clear();
        find(quantityInput).sendKeys("4");

        find(quantityAddToCartButton).click();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));

        find(viewCartLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(resultQuantity));

        softAssert.assertTrue(find(resultQuantity).isDisplayed());
    }

    public void registerWhileCheckout(){
        final var shoppingCart1 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(blueTopText);

        final var shoppingCart2 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(manTshirtText);

        final var cart1 = find(shoppingCart1);
        new Actions(getDriver())
                .moveToElement(cart1)
                .pause(1000)
                .click()
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        find(shoppingCart2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        final var pageCart = find(cartPageLink);
        new Actions(getDriver())
                .moveToElement(pageCart)
                .pause(1000)
                .click()
                .perform();


        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));

        softAssert.assertTrue(find(proceedToCheckOutButton).isDisplayed());

        find(proceedToCheckOutButton).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(registerCartPageLink));

        find(registerCartPageLink).click();

    }

    public void adding2ProductsToShoppingCart(){
        final var shoppingCart1 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(blueTopText);

        final var shoppingCart2 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(manTshirtText);

        final var cart1 = find(shoppingCart1);
        new Actions(getDriver())
                .moveToElement(cart1)
                .pause(1000)
                .click()
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        find(shoppingCart2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        final var pageCart = find(cartPageLink);
        new Actions(getDriver())
                .moveToElement(pageCart)
                .pause(1000)
                .click()
                .perform();


        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckOutButton));

        softAssert.assertTrue(find(proceedToCheckOutButton).isDisplayed());

        find(proceedToCheckOutButton).click();
    }

    public void deletingProducts(){

        final var shoppingCart1 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(blueTopText);

        final var shoppingCart2 = (By) RelativeLocator
                .with(shoppingCartButton1)
                .below(manTshirtText);

        final var cart1 = find(shoppingCart1);
        new Actions(getDriver())
                .moveToElement(cart1)
                .pause(1000)
                .click()
                .perform();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShoppingButton));

        softAssert.assertTrue(find(continueShoppingButton).isDisplayed());
        softAssert.assertAll();

        find(continueShoppingButton).click();

        find(shoppingCart2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(viewCartLink));

        softAssert.assertTrue(find(viewCartLink).isDisplayed());
        softAssert.assertAll();

        find(viewCartLink).click();

        softAssert.assertTrue(find(quantityDeleteButton1).isDisplayed());
        softAssert.assertTrue(find(quantityDeleteButton2).isDisplayed());
        softAssert.assertAll();

        new Actions(getDriver())
                .moveToElement(find(quantityDeleteButton1))
                .pause(1000)
                .click()
                .perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityDeleteButton1));

        find(quantityDeleteButton1).click();

        getDriver().switchTo().defaultContent();

        wait.until(ExpectedConditions.elementToBeClickable(quantityDeleteButton2));

        find(quantityDeleteButton2).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(cartIsEmptyText));

        softAssert.assertTrue(find(cartIsEmptyText).isDisplayed());
    }


    public void viewBrandProducts(){
        find(poloBrandLink).click();

        final var wait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(brandPoloProductsTitle));

        softAssert.assertTrue(find(brandPoloProductsTitle).isDisplayed());

        find(hmBrandLink).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(brandHMProducts));

        softAssert.assertTrue(find(brandHMProducts).isDisplayed());

    }
}

