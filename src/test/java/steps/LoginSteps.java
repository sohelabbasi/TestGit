package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class LoginSteps extends CommonMethods {


    @Given("user is able to launch the HRMS application in the browser")
    public void user_is_able_to_launch_the_hrms_application_in_the_browser() {
       openBrowserAndLaunchApplication();
    }

    @When("user enters username in the username textfield")
    public void user_enters_username_in_the_username_textfield() {
        sendText(loginPage.usernameTextField, ConfigReader.getPropertyValue("username"));
    }

    @When("enters password in the passowrd textfield")
    public void enters_password_in_the_passowrd_textfield() {
        sendText(loginPage.passwordTextField, ConfigReader.getPropertyValue("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user should be able to see dashboard page")
    public void user_should_be_able_to_see_dashboard_page() {
        String title = driver.getTitle();
        String actual = "Human Management Systm";
        Assert.assertEquals(title, actual);
        //framnework added for batch 1
    }
}
