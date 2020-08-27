package example.pages;

import java.time.Duration;

import javax.annotation.PostConstruct;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class BasePage every Page should extend this class.
 *
 * @author Bharathish
 */
@Component
public class BasePage {

	/** The driver. */
	@Autowired
	protected WebDriver driver;

	/** The waiter. */
	protected FluentWait<WebDriver> waiter;

	@PostConstruct
	public void setUp() {
		PageFactory.initElements(driver, this);
		waiter = new FluentWait<WebDriver>(driver).ignoring(NoSuchElementException.class, WebDriverException.class)
				.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2));
	}

}
