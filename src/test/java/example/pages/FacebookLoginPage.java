package example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * The Class represents FacebookLoginPage.
 *
 * @author Bharathish
 */
@Component
public class FacebookLoginPage extends BasePage {

	/** The email input. */
	@FindBy(id = "email")
	private WebElement emailInput;

	/** The pass. */
	@FindBy(id = "pass")
	private WebElement pass;

	/**
	 * Enter email.
	 *
	 * @param email the email
	 * @return the facebook login page
	 */
	public FacebookLoginPage enterEmail(String email) {
		emailInput.sendKeys(email);
		return this;
	}

	/**
	 * Enter password.
	 *
	 * @param password the password
	 * @return the facebook login page
	 */
	public FacebookLoginPage enterPassword(String password) {
		pass.sendKeys(password);
		return this;
	}

	/**
	 * Click sign in.
	 */
	public void clickSignIn() {
		pass.submit();
	}
}
