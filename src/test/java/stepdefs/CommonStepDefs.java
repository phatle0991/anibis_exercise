package stepdefs;

import cucumber.api.java.en.Given;
import pages.HomePage;
import util.SetUp;

public class CommonStepDefs extends SetUp{
    HomePage homePage;
    @Given("^I open browser = \"([^\"]*)\"$")
    public void iOpenBrowser(String browser) throws Exception {
        initDriver(browser);
    }
}
