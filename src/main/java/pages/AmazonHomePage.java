package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class AmazonHomePage {
	private WebDriver driver;

	public AmazonHomePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleOfThePage() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15)); 

		return driver.getTitle();

	}
}