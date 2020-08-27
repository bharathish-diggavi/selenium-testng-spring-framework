package example.util;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import example.context.WebDriverContext;
import example.report.ExtentReportManager;

/**
 * The Class is responsible for Reporting
 *
 * @author Bharathish
 */
public class ReportUtil {

	/**
	 * Adds the screen shot.
	 *
	 * @param message the message
	 * @throws IOException
	 */
	public static void addScreenShot(String message) throws IOException {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(Status.INFO, message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
	}

	/**
	 * Adds the screen shot.
	 *
	 * @param status  the status
	 * @param message the message
	 * @throws IOException
	 */
	public static void addScreenShot(Status status, String message) throws IOException {
		String base64Image = "data:image/png;base64,"
				+ ((TakesScreenshot) WebDriverContext.getDriver()).getScreenshotAs(OutputType.BASE64);
		ExtentReportManager.getCurrentTest().log(status, message,
				MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
	}

	public static void logInfo(String details) {
		ExtentReportManager.getCurrentTest().log(Status.INFO, details);
	}

	public static void logMessage(Status status, String details) {
		ExtentReportManager.getCurrentTest().log(status, details);
	}
}
