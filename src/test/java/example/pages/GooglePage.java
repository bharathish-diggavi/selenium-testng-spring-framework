package example.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

/**
 * The Class represents GooglePage.
 *
 * @author Bharathish
 */
@Component
public class GooglePage extends BasePage {

	/** The searchinput. */
	@FindBy(name = "q")
	private WebElement searchinput;

	/**
	 * Searches the given text.
	 *
	 * @param key the key
	 */
	public void searchText(String key) {
		searchinput.sendKeys(key + Keys.ENTER);
	}

}
