package pageobjects;

import abstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CataloguePage extends AbstractComponent {

    WebDriver driver;

    //Locators
    private static final By productsLocator = By.cssSelector(".mb-3");
    private static final By addToCart = By.cssSelector(".card-body button:last:of-type");

    public CataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

    //Page factory pattern

    @FindBy(css = ".mb-3")
    List<WebElement> products;


    public void goTo() {
        driver.get("");
    }

    public List<WebElement> getProducts() {
        waitForElement(productsLocator);
        return products;
    }

    public WebElement getProductByName(String productName) {
        return getProducts().stream().filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName))
                .findFirst()
                .orElse(null);
    }

    public void addProductToCart(String productName) {
        getProductByName(productName)
                .findElement(addToCart)
                .click();
    }
}
