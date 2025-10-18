package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchedProductPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class SearchedProductTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final SearchedProductPage searchedProductPage = new SearchedProductPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSearchedProduct();
    }

    @Test
    public void verifyingSearchedProductTest() {
        searchedProductPage.verifyPage();
    }

    @Test
    public void searchProductAndLoginTest() {
        searchedProductPage.addingCartProducts();
    }
}
