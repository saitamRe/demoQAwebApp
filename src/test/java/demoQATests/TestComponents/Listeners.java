package demoQATests.TestComponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import demoQA.Reports.ExtentReporterNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {


    private ExtentReports extent = ExtentReporterNG.getReportObject();
    private String testName;
    ThreadLocal<ExtentTest> extentThreadLocalTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getMethod().getMethodName();
        ExtentTest test = extent.createTest(testName);
        extentThreadLocalTest.set(test);
    }


    @Override
    public void onTestFailure(ITestResult result) {

        extentThreadLocalTest.get().fail(result.getThrowable());

        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTest) testInstance).driver;

        String filePath = null;

        try {
            filePath = takeScreenshot(testName, driver);

        } catch (IOException e) {
            extentThreadLocalTest.get().warning("Failed to take screenshot" + e.getMessage());

        }
        extentThreadLocalTest.get().addScreenCaptureFromPath(filePath);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
