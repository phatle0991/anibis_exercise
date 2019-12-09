package stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UserDefaultPage;

public class UserDefaultStepDefs {
    UserDefaultPage userDefaultPage;

    @Then("I verify User Default Page loaded successfully")
    public void iVerifyUserDefaultPageLoad() throws Exception{
        userDefaultPage.verifyMyAccountPageLoaded();
    }

    @When("I navigate to User Account Page from User Default Page")
    public void iNavigateToUserAccountPage() throws Exception{
        userDefaultPage.navigateToMyAccountPage();
    }
}
