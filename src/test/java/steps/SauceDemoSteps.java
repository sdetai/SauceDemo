package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SauceDemoLoginPage;
import utilities.Driver;

public class SauceDemoSteps {
    WebDriver driver = Driver.getDriver();
    SauceDemoLoginPage sauceDemoLoginPage=new SauceDemoLoginPage();




    @When("I fill the account information for account StandardUser into the Username field {string} and the Password field {string}")
    public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field(String username, String password) {
        sauceDemoLoginPage.usernameInput.sendKeys(username);
        sauceDemoLoginPage.passwordInput.sendKeys(password);


    }
    @When("I click the Login Button")
    public void i_click_the_login_button() {
        sauceDemoLoginPage.loginBtn.click();
    }
    @Then("I am redirected to the Sauce Demo Main Page and I verify the App Logo exists")
    public void i_am_redirected_to_the_sauce_demo_main_page_i_verify_the_app_logo_exists() {
        String expectedAppLogo="Swag Labs";
        String actualAppLogo= driver.getTitle();
        Assert.assertEquals(expectedAppLogo,actualAppLogo);
    }

    @When("I fill the account information for account LockedOutUser into the Username field {string} and the Password field {string}")
    public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field(String username, String password) {
        sauceDemoLoginPage.usernameInput.sendKeys(username);
        sauceDemoLoginPage.passwordInput.sendKeys(password);

    }
    @Then("I verify the Error Message contains the text {string}")
    public void i_verify_the_error_message_contains_the_text(String expectedErrorMsg) {
        String actualErrorMsg=sauceDemoLoginPage.errorMsg.getText();
        Assert.assertEquals(expectedErrorMsg,actualErrorMsg);
    }

}
