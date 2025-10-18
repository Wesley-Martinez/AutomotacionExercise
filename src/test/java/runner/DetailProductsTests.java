package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class DetailProductsTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final DetailProductsPage detailProductsPage = new DetailProductsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToDetailProduct();
    }

    @Test
    public void verifyingDetailProductsTest() {
        detailProductsPage.verifyPage();
    }
}
