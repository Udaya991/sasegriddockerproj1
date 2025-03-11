package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
		logger.info("Search Product in amazon test with browser: "+browser);

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-gpu"); // Prevent crashes
            options.addArguments("--no-sandbox");  // Required for running in Docker
            options.addArguments("--disable-dev-shm-usage"); // Prevents memory crashes
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
            EdgeOptions options = new EdgeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
    }
}
