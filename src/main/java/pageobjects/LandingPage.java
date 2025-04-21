package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //WebElement userEmail = driver.findElement(By.id("userEmail"));

    //Page factory pattern

    @FindBy(id = "userPassword")
    WebElement userEmail;

    @FindBy(id = "userEmail")
    WebElement userPassword;

    @FindBy(id = "login")
    WebElement submitBtn;

    public void login(String email, String password)
    {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitBtn.click();
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
