package example.listeners;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SpringListener extends AbstractTestExecutionListener {
	@Override
	public void beforeTestClass(TestContext testContext) throws Exception {
	}

	@Override
	public void afterTestClass(TestContext testContext) throws Exception {
		testContext.getApplicationContext().getBeansOfType(WebDriver.class).get("webdriver").close();
		testContext.getApplicationContext().getBeansOfType(WebDriver.class).get("webdriver").quit();
	}
}
