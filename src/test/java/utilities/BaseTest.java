package utilities;

import listeners.SuiteListeners;
import listeners.TestListeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

@Listeners({TestListeners.class, SuiteListeners.class})
public class BaseTest {
    protected SoftAssert softAssert;
    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        softAssert = new SoftAssert();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920x1080");
        

        Logs.debug("Inicializando el Driver");
        driver = new ChromeDriver(options);

        Logs.debug("Maximizando la pantalla");
        driver.manage().window().maximize();

        Logs.debug("Borrando Cookies");
        driver.manage().deleteAllCookies();
        
        Logs.debug("Asignando driver al WebDriver Provider");
        new WebDriverProvider().set(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.debug("Matando el padre");
        driver.close();
    }

    protected void sleep(int timeMs){
        try {
            Thread.sleep(timeMs);
        } catch (InterruptedException interruptedException) {
            Logs.error("Error al esperar: %s", interruptedException.getLocalizedMessage());
        }
    }
}
