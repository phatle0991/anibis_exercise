package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.HomePage;
import util.Config;

public class HomeStepDefs {
    @Steps
    HomePage homePage;

    @Given("I open Home Page")
    public void iNavigateToHomePage() throws Exception {
        homePage.navToHomePage();
    }

    @Then("I verify Home Page loaded successfully")
    public void iVerifyHomePageLoad() throws Exception{
        String currentTitle = homePage.getTitle();
        String EXPECTED_TITLE = Config.getProperty("homeTitle");
        //Util.softAssertions.assertThat(currentTitle).isEqualTo(expectedTitle);
        Assert.assertEquals(EXPECTED_TITLE,currentTitle);
    }

    @When("I click on Login Link")
    public void iNavigateToLoginPage() throws Exception {
        homePage.navigateToLoginPage();
    }

    @When("I click on Search Button from Home Page")
    public void iClickOnSearchBtnFromHomePage() throws Exception{
        homePage.clickBtnSearch();
    }

    @When("I navigate to User Default Page from Home Page")
    public void iNavigateToUserDefaultPage() throws Exception{
        homePage.navigateToUserDefaultPage();
    }
}
