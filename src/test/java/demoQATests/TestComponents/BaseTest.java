package demoQATests.TestComponents;


import demoQA.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
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

        } else if (browserName == "firefox") {
            //use firefox
        }

        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public LandingPage launchApp() throws IOException {
        driver = initDriver();
        lp = new LandingPage(driver);
        lp.goTo();
        return lp;

    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
