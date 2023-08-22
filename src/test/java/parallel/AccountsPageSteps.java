package parallel;

import com.pages.AccountsPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountsPageSteps {

   private LoginPage loginPage=new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;


    @Given("User has already logged in to application")
    public void user_has_already_logged_in_to_application(DataTable dataTable) {
        List<Map< String,String >> cred=dataTable.asMaps();
        String email=cred.get(0).get("UserName");
        String pwd=cred.get(0).get("Password");

        DriverFactory.getDriver().get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        accountsPage =loginPage.doLogin(email,pwd);

    }
    @Given("Users on accounts page")
    public void users_on_accounts_page() {
        String text=accountsPage.getTitles();
        System.out.println(text);

    }
    @When("user gets the title")
    public void user_gets_the_title() {

    }
    @Then("page title should be {string}")
    public void page_title_should_be(String string) {

    }


    @Then("user get accounts section")
    public void user_get_accounts_section(DataTable section) {
        List<String> expectedList=section.asList();
        ArrayList<String> aList=new ArrayList<String>();
        for(String k:expectedList){
            aList.add(k.toUpperCase());
        }
        System.out.println("Expected Lists: "+aList);



        List actualList=accountsPage.getAccountsLists();
        System.out.println("Actual List :"+actualList);

        System.out.println(aList.containsAll(actualList));
    }

    @Then("account selection count is {int}")
    public void account_selection_count_is(int expected) {
        int actualCount=accountsPage.getAccountOptionsCount();
        Assert.assertEquals(expected, actualCount);


    }
}
