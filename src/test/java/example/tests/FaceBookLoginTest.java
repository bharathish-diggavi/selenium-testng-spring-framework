package example.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import example.pages.FacebookLoginPage;

/**
 * The Class FaceBookLoginTest.
 *
 * @author Bharathish
 */
@Test(testName = "Facebook login test", description = "Facebook login test")
public class FaceBookLoginTest extends BaseTest {

	@Autowired
	FacebookLoginPage facebookLoginPage;
	
	@Autowired
	WebDriver driver;
	@Test
	public void facebookLoginTest() {
		driver.get("https://www.facebook.com/");
		facebookLoginPage.enterEmail("abc").enterPassword("abc").clickSignIn();
		Assert.assertTrue(false, "Login failed : Test failed");
	}
}
