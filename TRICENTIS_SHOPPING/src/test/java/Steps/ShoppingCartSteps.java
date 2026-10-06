package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;

import java.time.Duration;

public class ShoppingCartSteps {

    WebDriver driver;
    HomePage homePage;

    @Given("the user navigates to the Tricentis homepage")
    public void the_user_navigates_to_the_tricentis_homepage() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("http://demowebshop.tricentis.com/");

        homePage = new HomePage(driver);
    }

    @When("the user enters the product {string} in the search bar")
    public void the_user_enters_the_product_in_the_search_bar(String productName) {

        homePage.enterSearchKeyword(productName);
    }

    @When("clicks on the search button")
    public void clicks_on_the_search_button() {

        homePage.clickSearch();
    }

    @When("clicks the Add to Cart button for the product")
    public void clicks_the_add_to_cart_button_for_the_product() {

        homePage.clickAddToCart();
    }

    @Then("a success message should be displayed")
    public void a_success_message_should_be_displayed() {

        String msg = homePage.getSuccessMessage();

        Assert.assertTrue(msg.contains("The product has been added"));

        driver.quit();
    }
}