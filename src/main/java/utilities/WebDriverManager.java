package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {
    private static final String GRID_URL = "http://localhost:4444/wd/hub";

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        switch (browser.toLowerCase()) {
            case "chrome":
                capabilities.setBrowserName("chrome");
                break;
            case "firefox":
                capabilities.setBrowserName("firefox");
                break;
            case "edge":
                capabilities.setBrowserName("MicrosoftEdge");
                break;
            default:
                throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        return new RemoteWebDriver(new URL(GRID_URL), capabilities);
    }
}
