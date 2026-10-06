package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(id = "Email")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCredentials(String email, String password) {

        emailField.clear();
        emailField.sendKeys(email);

        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        loginBtn.click();
    }

    public boolean isErrorMessageDisplayed() {

        try {
            return driver.findElement(
                    By.cssSelector(".validation-summary-errors, .field-validation-error"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoggedIn(String expectedEmail) {

        try {

            String actualEmail = driver.findElement(
                    By.cssSelector(".account"))
                    .getText();

            System.out.println("Expected Email = " + expectedEmail);
            System.out.println("Actual Email = " + actualEmail);

            return actualEmail.equalsIgnoreCase(expectedEmail);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}