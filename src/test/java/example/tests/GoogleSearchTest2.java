package example.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import example.pages.GooglePage;

/**
 * The Class GoogleSearchTest.
 *
 * @author Bharathish
 */
@Test(testName = "Google search test", description = "Test description")
public class GoogleSearchTest2 extends BaseTest {

	/**
	 * Google search test.
	 */

	@Autowired
	GooglePage googlePage;
	@Autowired
	WebDriver driver;

	@Test
	public void googleSearchTest() {
		driver.get("https://www.google.co.in/");
		googlePage.searchText("xyz");
		Assert.assertTrue(driver.getTitle().contains("xyz"), "Title doesn't contain abc : Test Failed");
	}
}
