package parallel;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginpg=new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
     driver =DriverFactory.getDriver();
     driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    @Given("I verify title should be {string}")
    public void i_verify_title_should_be(String expectedTitle) {
        String actualTitle=loginpg.getLoginPageTitle();
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }



    @Given("I enter the emailid {string}")
    public void i_enter_the_emailid(String string) {
        loginpg.enterUserName(string);

    }
    @Then("I enter Password {string}")
    public void i_enter_password(String string) {
        loginpg.enterPwd(string);

    }

    @Then("I click on submit")
    public void i_click_on_submit() {
        loginpg.clickSubmit();
    }

}
