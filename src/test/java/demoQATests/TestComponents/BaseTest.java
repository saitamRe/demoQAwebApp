package demoQATests.TestComponents;


import demoQA.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public LandingPage lp;

    public WebDriver initDriver() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\demoQA\\resources\\GlobalData.properties");
        props.load(fis);


        String browserName = props.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            //use firefox
        }

        driver.manage().window().maximize();
        return driver;
    }


    @BeforeMethod
    public void launchApp() throws IOException {
        driver = initDriver();
        lp = new LandingPage(driver);
        lp.goTo();
        //return lp;

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public String takeScreenshot(String tcName, WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/Reports/" + tcName + ".png";
        FileUtils.copyFile(src, new File(path));
        return path;
    }
}
