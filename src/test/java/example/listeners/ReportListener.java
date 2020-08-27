package example.listeners;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import example.report.ExtentReportManager;
import example.util.ReportUtil;

/**
 * The listener interface for receiving report events. The class that is
 * interested in processing a report event implements this interface, and the
 * object created with that class is registered with a component using the
 * component's <code>addReportListener<code> method. When the report event
 * occurs, that object's appropriate method is invoked.
 *
 * @see ReportEvent
 */
public class ReportListener implements ITestListener {

	@Autowired
	ReportUtil reportUtil;

	/**
	 * Gets the test name.
	 *
	 * @param result the result
	 * @return the test name
	 */
	public String getTestName(ITestResult result) {
		return result.getTestName() != null ? result.getTestName()
				: result.getMethod().getConstructorOrMethod().getName();
	}

	/**
	 * Gets the test description.
	 *
	 * @param result the result
	 * @return the test description
	 */
	public String getTestDescription(ITestResult result) {
		return result.getMethod().getDescription() != null ? result.getMethod().getDescription() : getTestName(result);
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportManager.startTest(getTestName(result), getTestDescription(result));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			ReportUtil.addScreenShot(Status.PASS, "Test Passed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Throwable t = result.getThrowable();
		String cause = "";
		if (t != null)
			cause = t.getMessage();
		try {
			ReportUtil.addScreenShot(Status.FAIL, "Test Failed : " + cause);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReportManager.getExtentReports().flush();
	}

}
