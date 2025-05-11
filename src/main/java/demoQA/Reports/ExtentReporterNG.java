package demoQA.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {


    public static ExtentReports getReportObject()
    {
        String path = System.getProperty("user.dir") + "//Reports" + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Demo AT Report");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("DemoQA", "Roman Fed");
        return extent;
    }
}