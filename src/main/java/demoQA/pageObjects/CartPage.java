package demoQA.pageObjects;

import demoQA.abstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(css = ".totalRow button")
    private WebElement checkoutElem;

    @FindBy(css = ".crtSection h3")
    private List<WebElement> productTitles;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public Boolean VerifyProductDisplay(String productName)
    {
        return productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    }

    public void goToCheckout()
    {
        checkoutElem.click();
    }


}
