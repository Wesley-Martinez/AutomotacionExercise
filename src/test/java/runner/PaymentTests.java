package runner;

import org.testng.annotations.BeforeMethod;
import pages.PaymentPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class PaymentTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final PaymentPage paymentPage = new PaymentPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToPaymentPage();
    }


}
