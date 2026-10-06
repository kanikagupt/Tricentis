package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(id = "small-searchterms")
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@value='Add to cart']")
    WebElement addToCartBtn;
    
    @FindBy(css = "p.content")
    WebElement successMessage;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchKeyword(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
    }

    public void clickSearch() {
        searchBtn.click();
    }

    public void clickAddToCart() {
        addToCartBtn.click();
    }
    
    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
