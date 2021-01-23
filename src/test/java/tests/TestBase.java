package tests;

import config.ApplicationConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver driver;

    protected String url = ApplicationConfiguration.instance.getStringNotNull("URL");

    static void setUpBeforeTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", ApplicationConfiguration.instance.getStringNotNull("CHROME_DRIVER"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        chromeOptions.addArguments("disable-notifications");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    static void tearDownAfterMethod() throws Exception {
        driver.quit();
    }

    @BeforeMethod
    void setUp() throws Exception {
        setUpBeforeTest();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }


}
