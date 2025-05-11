package demoQATests.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import demoQA.pageObjects.LandingPage;
import demoQATests.TestComponents.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class DemoTest extends BaseTest {
    public ExtentReports extent;

    @BeforeTest
    public void reportConfig() {
        String path = System.getProperty("user.dir") + "//Reports" + "index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Demo AT Report");
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("DemoQA", "Roman Fed");
    }

    @Test(dataProvider = "getData")
    public void someTest(HashMap<String, String> data) {
//         ExtentTest test = extent.createTest("demoTest1");


        //lp.login();
        System.out.println("HEY");
        Assert.fail("This is intentional fail");
//        LandingPage p = new LandingPage(driver);
//        p.login("a", "b");
//        test.fail("pizdec");
//        extent.flush();
    }



    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email", "r@.com");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("email", "f@.com");
        return new Object[][]{{map1}, {map2}};
    }

}
