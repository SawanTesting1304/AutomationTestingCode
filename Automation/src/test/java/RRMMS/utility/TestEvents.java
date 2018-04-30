package RRMMS.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

public class TestEvents implements ITestListener{
	@Override
	public void onFinish(ITestContext arg0) {}

	@Override
	public void onStart(ITestContext arg0) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ReportUtil.getTest().log(LogStatus.FAIL, result.getThrowable());
		String testClassName=result.getTestClass().getRealClass().getSimpleName();
		Log.info("Test Case Failed: "+testClassName);

		String filePath =System.getProperty("user.dir")+File.separator+"ExecutionReports" + File.separator + "HtmlReport" + File.separator + "Screenshots" + File.separator + Common.GetTimeStamp()+result.getName();
		String relativePath ="Screenshots" + File.separator + Common.CaptureScreenForReport(filePath);
		ReportUtil.getTest().log(LogStatus.INFO, "Snapshot below: " + ReportUtil.getTest().addScreenCapture(relativePath));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ReportUtil.getTest().log(LogStatus.SKIP, "Test Case Skipped " + result.getThrowable());
	}

	@Override
	 public void onTestStart(ITestResult test) {
	  String testClassName=test.getTestClass().getRealClass().getSimpleName();
	  Log.info("Test Case Started: "+testClassName);
	  ReportUtil.startTest(testClassName,test.getMethod().getDescription(),test.getMethod().getGroups());
	 }

	@Override
	public void onTestSuccess(ITestResult result) {
		Log.info("Test Case Passed - " +result.getTestClass().getRealClass().getSimpleName());
		ReportUtil.getTest().log(LogStatus.PASS, "Test Case Passed");
	}

}
