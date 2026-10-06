package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.LoginPage;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the Login page")
    public void the_user_is_on_the_login_page() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://demowebshop.tricentis.com/login");

        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid email {string} and password {string}")
    public void the_user_enters_valid_email_and_password(String email, String pass) {

        loginPage.enterCredentials(email, pass);
    }

    @When("the user enters invalid email {string} and password {string}")
    public void the_user_enters_invalid_email_and_password(String email, String pass) {

        loginPage.enterCredentials(email, pass);
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {

        loginPage.clickLogin();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {

        Assert.assertTrue(loginPage.isLoggedIn("kanikagupta4245@gmail.com"));

        driver.quit();
    }

    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {

        Assert.assertTrue(loginPage.isErrorMessageDisplayed());

        driver.quit();
    }
}
    