package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.asserts.SoftAssert;

public class DriverManager {
    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver(){
        if(runServer){
            buildRemoteDriver();
        }else{
            buildLocalDriver();
        }
    }

    private void buildLocalDriver(){
        //softAssert = new SoftAssert();

        final var headlessMode = System.getProperty("headless") !=null;



        var browserProperty = System.getProperty("browser");

        if(browserProperty == null){
            Logs.debug("Assigning default driver to Chrome");
            browserProperty = "CHROME";
        }

        final var browser = Browser.valueOf(browserProperty.toUpperCase());

        Logs.debug("Initializing driver: %s", browser);
        Logs.debug("headless mode?: %s", headlessMode);

        final var driver = switch (browser){
            case CHROME -> {
                final var chromeOptions = new ChromeOptions();
                if(headlessMode){
                    chromeOptions.addArguments("--headless=new");
                }
                yield new ChromeDriver(chromeOptions);
            }
            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if(headlessMode){
                    edgeOptions.addArguments("--headless=new");
                }
                yield new EdgeDriver(edgeOptions);
            }
            case FIREFOX -> {
                final var fireFoxOptions = new FirefoxOptions();
                if(headlessMode){
                    fireFoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver(fireFoxOptions);
            }
            case SAFARI -> new SafariDriver();
        };

        Logs.debug("Maximizando pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando cookies");
        driver.manage().deleteAllCookies();

        Logs.debug("Asignando el driver a WebdriverProvider");
        new WebdriverProvider().set(driver);

    }

    public void killDriver(){
        Logs.info("Finalizando el driver");
        new WebdriverProvider().get().quit();
    }

    private void buildRemoteDriver(){

    }

    private enum Browser{
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI
    }
}