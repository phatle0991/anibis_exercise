package stepdefs;

import cucumber.api.java.en.Given;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;

public class HomeStepDefs {
    @Steps
    HomePage homePage;

    @Given("I navigate to Login Page")
    public void iNavigateToLoginPage(){
        homePage.navigateToLoginPage();
    }
}
