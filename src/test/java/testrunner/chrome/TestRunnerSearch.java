package testrunner.chrome;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import util.SetUp;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Home.feature",  glue = {"src/test/stepdefs"})
public class TestRunnerSearch {
    @Before
    public void setup() throws Exception{
        SetUp.setup("Chrome");
    }
    @After
    public void teardown(){
        SetUp.driver.quit();
    }
}


