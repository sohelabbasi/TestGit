package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;

public class DashboardSteps extends CommonMethods {
    @Then("user is able to verify dashboard options")
    public void user_is_able_to_verify_dashboard_options() {
        System.out.println("This is demo step");
    }

    @When("user selects welcome admin dropdown")
    public void user_selects_welcome_admin_dropdown() {
        WebElement dropdownAdmin = driver.findElement(By.cssSelector("a#welcome"));
        click(dropdownAdmin);
    }

@When("user clicks on logout button")
public void user_clicks_on_logout_button() {
       WebElement logOutOption = driver.findElement(By.xpath("//*[text()='Logout']"));
       click(logOutOption);
        }
@Then("user should redirect back to login page")
public void user_should_redirect_back_to_login_page() {
    System.out.println("test");
        }
}