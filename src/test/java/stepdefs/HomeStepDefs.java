package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.HomePage;
import util.Config;
import util.Util;

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

    @Then("I verify User Name displayed correctly at Home Page")
    public void iVerifySigedName() throws Exception{
        String singedName = homePage.verifySingedIn();
        String EXPECTED_SIGED_NAME = Config.getProperty("signedName");
        Assert.assertEquals(EXPECTED_SIGED_NAME,singedName);
        Util.printLog("[INFO] Login successfully with Name = " + singedName);
    }
}
