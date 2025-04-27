package demoQA.pageObjects;

import demoQA.abstractComponents.AbstractComponent;
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
    private WebElement userEmail;

    @FindBy(id = "userEmail")
    private WebElement userPassword;

    @FindBy(id = "login")
    private WebElement submitBtn;

    public CataloguePage login(String email, String password)
    {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        submitBtn.click();
        return new CataloguePage(driver);
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
