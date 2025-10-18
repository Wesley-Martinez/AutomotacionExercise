package runner;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TestCasesPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class TestCasesTests extends BaseTest {
    private final CommonFlows commonFlows = new CommonFlows();
    private final TestCasesPage testCasesPage = new TestCasesPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToTestCasesPage();
    }

    @Test
    public void verifyingTestCasesTest() {
        testCasesPage.verifyPage();
    }
}
