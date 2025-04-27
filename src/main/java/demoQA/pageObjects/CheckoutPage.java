package demoQA.pageObjects;

import demoQA.abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[placeholder='Select Country']")
    private WebElement country;

    @FindBy(css = ".action__submit")
    private WebElement submitBtn;

    @FindBy(css = "//button[contains(@class, 'ta-item')])[2]")
    private WebElement countrySelector;

    private final By results = By.cssSelector(".ta-results");

    public void selectCountry(String countryName) {
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
        waitForElementToAppear(results);
        countrySelector.click();
    }

    public ConfirmationPage submitOrder() {
        submitBtn.click();
        return new ConfirmationPage(driver);
    }
}
