package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonHomePage;

public class AmazonTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(AmazonTest.class);

	@Test
	public void testSearchProduct() {
		logger.info("Search Product in amazon test starts");
		driver.get("https://www.amazon.com/");
		AmazonHomePage homePage = new AmazonHomePage(driver);
		String str = homePage.getTitleOfThePage();
		System.out.println(str);

		Assert.assertEquals(str, "Amazon.com. Spend less. Smile more.");
		logger.info("Search Product in amazon test ends");

	}
}
