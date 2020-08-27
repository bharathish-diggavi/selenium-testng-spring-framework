package example.context;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

import example.util.LoggerUtil;

@Configuration
@ComponentScan(basePackages = "example")
@PropertySources({ @PropertySource("classpath:config/test.properties") })
public class SpringTestConfiguration {


	@Bean
	public CustomScopeConfigurer customScopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		configurer.addScope("thread", new SimpleThreadScope());
		return configurer;
	}

	@Bean(name = "webdriver")
	@Scope("thread")
	public WebDriver driver(@Value("${browser:chrome}") String browser) {
		LoggerUtil.log("Got browsername from propertyfile : " + browser);
		WebDriver driver = null;
		if("Chrome".equalsIgnoreCase(browser)) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("disable-infobars");
			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		WebDriverContext.setDriver(driver);
		return driver;
	}
}
