package demoQATests.Tests;

import demoQATests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;


public class DemoTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void someTest() {
        //lp.login();
        System.out.println("HEY");
    }

    public void takeScreenshot(String tcName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File input = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//Reports"+tcName+"//.png");
        FileUtils.copyFile(input, file);
    }

    @DataProvider
    public Object[][] getData()
    {
        HashMap<String, String> map1 = new HashMap<>();
        map1.put("email","r@.com");

        HashMap<String, String> map2 = new HashMap<>();
        map2.put("email","f@.com");
        return new Object[][]{{map1},{map2}};
    }

}
