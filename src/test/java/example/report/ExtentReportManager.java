package example.report;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import example.context.Constants;

/**
 * The Class handles the report activities.
 *
 * @author Bharathish
 */
public class ExtentReportManager {

	/** The extent reports. */
	private static ExtentReports extentReports;

	/** The map. */
	private static Map<Long, ExtentTest> map = new HashMap<>();

	/**
	 * Gets the extent reports.
	 *
	 * @return the extent reports
	 */
	public static ExtentReports getExtentReports() {
		if (extentReports == null) {
			extentReports = new ExtentReports();
			ExtentHtmlReporter html = new ExtentHtmlReporter(Constants.REPORT_DIRECTORY);
			extentReports.attachReporter(html);
			extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
		}
		return extentReports;
	}

	/**
	 * Start test.
	 *
	 * @param testName the test name
	 * @param desc     the desc
	 */
	public synchronized static void startTest(String testName, String desc) {
		ExtentTest test = getExtentReports().createTest(testName).createNode(testName, desc);
		map.put(Thread.currentThread().getId(), test);
	}

	/**
	 * Gets the current test.
	 *
	 * @return the current test
	 */
	public synchronized static ExtentTest getCurrentTest() {
		return map.get(Thread.currentThread().getId());
	}

}
